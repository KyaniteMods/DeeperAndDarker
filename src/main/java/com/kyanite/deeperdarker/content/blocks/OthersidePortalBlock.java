package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.otherside.OthersideTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("NullableProblems")
public class OthersidePortalBlock extends Block implements Portal {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0, 0, 6, 16, 16, 10);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6, 0, 0, 10, 16, 16);

    public OthersidePortalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AXIS);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if(pState.getValue(AXIS) == Direction.Axis.X) return X_AXIS_AABB;
        return Z_AXIS_AABB;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        Direction.Axis facingAxis = pDirection.getAxis();
        Direction.Axis axis = pState.getValue(AXIS);
        boolean flag = axis != facingAxis && facingAxis.isHorizontal();
        return !flag && !pNeighborState.is(this) && !(new OthersidePortalShape(pLevel, pPos, axis)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextFloat() < 0.0007) {
            pLevel.playLocalSound(pPos.getX() + 0.5d, pPos.getY() + 0.5d, pPos.getZ() + 0.5d, DDSounds.PORTAL_GROAN.get(), SoundSource.BLOCKS, 0.2f, pRandom.nextFloat() * 0.2f + 0.9f, false);
        }
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(pEntity.canUsePortal(false)) pEntity.setAsInsidePortal(this, pPos);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return switch (direction) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
                case Z -> state.setValue(AXIS, Direction.Axis.X);
                case X -> state.setValue(AXIS, Direction.Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return ItemStack.EMPTY;
    }

    public boolean spawnPortal(LevelAccessor worldIn, BlockPos pos) {
        OthersidePortalShape portal = this.isPortal(worldIn, pos);
        if(portal != null && !trySpawningPortal(worldIn, pos, portal)) {
            portal.createPortalBlocks();
            return true;
        } else return false;
    }

    public static boolean trySpawningPortal(LevelAccessor world, BlockPos pos, OthersidePortalShape portal) {
        return NeoForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), portal)).isCanceled();
    }

    public OthersidePortalShape isPortal(LevelAccessor level, BlockPos pos) {
        OthersidePortalShape portalX = new OthersidePortalShape(level, pos, Direction.Axis.X);
        if(portalX.isValid() && portalX.numPortalBlocks == 0) {
            return portalX;
        } else {
            OthersidePortalShape portalZ = new OthersidePortalShape(level, pos, Direction.Axis.Z);
            return portalZ.isValid() && portalZ.numPortalBlocks == 0 ? portalZ : null;
        }
    }

    @Nullable
    @Override
    public DimensionTransition getPortalDestination(ServerLevel pLevel, Entity pEntity, BlockPos pPos) {
        ResourceKey<Level> level = pLevel.dimension() == Level.OVERWORLD ? OthersideDimension.OTHERSIDE_LEVEL : Level.OVERWORLD;
        ServerLevel destLevel = pLevel.getServer().getLevel(level);
        if(destLevel == null) {
            return null;
        } else {
            boolean isOtherside = destLevel.dimension() == OthersideDimension.OTHERSIDE_LEVEL;
            WorldBorder worldBorder = destLevel.getWorldBorder();
            double scale = DimensionType.getTeleportationScale(pLevel.dimensionType(), destLevel.dimensionType());
            BlockPos blockpos = worldBorder.clampToBounds(pEntity.getX() * scale, pEntity.getY(), pEntity.getZ() * scale);
            return OthersideTeleporter.getExitPortal(destLevel, pEntity, pPos, blockpos, isOtherside, worldBorder);
        }
    }

    public static class PortalSpawnEvent extends BlockEvent implements ICancellableEvent {
        private final OthersidePortalShape size;

        public PortalSpawnEvent(LevelAccessor level, BlockPos pos, BlockState state, OthersidePortalShape size) {
            super(level, pos, state);
            this.size = size;
        }

        public OthersidePortalShape getSize() {
            return size;
        }
    }

    public static class OthersidePortalShape {
        public static final int MIN_WIDTH = 2;
        public static final int MIN_HEIGHT = 2;
        public static final int MAX_WIDTH = 21;
        public static final int MAX_HEIGHT = 21;

        private final LevelAccessor level;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private BlockPos bottomLeft;
        private int numPortalBlocks;
        private int height;
        private final int width;

        public OthersidePortalShape(LevelAccessor level, BlockPos bottomLeft, Direction.Axis axis) {
            this.level = level;
            this.axis = axis;
            this.rightDir = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
            this.bottomLeft = this.calculateBottomLeft(bottomLeft);

            if(this.bottomLeft == null) {
                this.bottomLeft = bottomLeft;
                this.width = 1;
                this.height = 1;
            } else {
                this.width = this.calculateWidth();
                if(this.width > 0) {
                    this.height = this.calculateHeight();
                }
            }
        }

        private BlockPos calculateBottomLeft(BlockPos pos) {
            int height = Math.max(this.level.getMinBuildHeight(), pos.getY() - 21);
            while(pos.getY() > height && isEmpty(this.level.getBlockState(pos.below()))) pos = pos.below();

            Direction direction = this.rightDir.getOpposite();
            int j = this.getFrameWidth(pos, direction) - 1;
            return j < 0 ? null : pos.relative(direction, j);
        }

        private int calculateHeight() {
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();
            int i = this.getFrameHeight(blockPos);
            return i >= MIN_HEIGHT && i <= MAX_HEIGHT && this.hasTopFrame(blockPos, i) ? i : 0;
        }

        private int calculateWidth() {
            int i = this.getFrameWidth(this.bottomLeft, this.rightDir);
            return i >= MIN_WIDTH && i <= MAX_WIDTH ? i : 0;
        }

        private int getFrameHeight(BlockPos.MutableBlockPos pos) {
            for(int i = 0; i < MAX_HEIGHT; i++) {
                pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
                if(!this.level.getBlockState(pos).is(Blocks.REINFORCED_DEEPSLATE)) return i;

                pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
                if(!this.level.getBlockState(pos).is(Blocks.REINFORCED_DEEPSLATE)) return i;

                for(int j = 0; j < this.width; j++) {
                    pos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                    BlockState blockState = this.level.getBlockState(pos);
                    if(!isEmpty(blockState)) return i;

                    if(blockState.is(DDBlocks.OTHERSIDE_PORTAL.get())) this.numPortalBlocks++;
                }
            }

            return MAX_HEIGHT;
        }

        private int getFrameWidth(BlockPos pos, Direction direction) {
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for(int i = 0; i <= MAX_HEIGHT; i++) {
                blockPos.set(pos).move(direction, i);
                BlockState blockState = this.level.getBlockState(blockPos);
                if(!isEmpty(blockState)) {
                    if(blockState.is(Blocks.REINFORCED_DEEPSLATE)) return i;
                    break;
                }

                BlockState blockStateDown = this.level.getBlockState(blockPos.move(Direction.DOWN));
                if(!blockStateDown.is(Blocks.REINFORCED_DEEPSLATE)) break;
            }

            return 0;
        }

        private boolean hasTopFrame(BlockPos.MutableBlockPos pos, int n) {
            for(int i = 0; i < this.width; i++) {
                BlockPos.MutableBlockPos blockPos = pos.set(this.bottomLeft).move(Direction.UP, n).move(this.rightDir, i);
                if(!this.level.getBlockState(blockPos).is(Blocks.REINFORCED_DEEPSLATE)) {
                    return false;
                }
            }

            return true;
        }

        public void createPortalBlocks() {
            BlockState blockstate = DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState().setValue(OthersidePortalBlock.AXIS, this.axis);
            BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach((blockPos) -> this.level.setBlock(blockPos, blockstate, 18));
        }

        public boolean isComplete() {
            return this.isValid() && this.numPortalBlocks == this.width * this.height;
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= MIN_WIDTH && this.width <= MAX_WIDTH && this.height >= MIN_HEIGHT && this.height <= MAX_HEIGHT;
        }

        private static boolean isEmpty(BlockState state) {
            return state.isAir() || state.is(DDBlocks.OTHERSIDE_PORTAL.get());
        }
    }
}
