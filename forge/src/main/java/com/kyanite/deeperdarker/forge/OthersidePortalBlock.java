package com.kyanite.deeperdarker.forge;

import com.kyanite.deeperdarker.forge.world.OthersideTeleporter;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class OthersidePortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0, 0, 6, 16, 16, 10);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6, 0, 0, 10, 16, 16);

    public OthersidePortalBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if(pState.getValue(AXIS) == Direction.Axis.X) return X_AXIS_AABB;
        return Z_AXIS_AABB;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        Direction.Axis facingAxis = pDirection.getAxis();
        Direction.Axis axis = pState.getValue(AXIS);
        boolean flag = axis != facingAxis && facingAxis.isHorizontal();
        return !flag && !pNeighborState.is(this) && !(new OthersidePortalShape(pLevel, pCurrentPos, axis)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pEntity.isPassenger() && !pEntity.isVehicle() && pEntity.canChangeDimensions()) {
            if(pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
            } else {
                if(!pEntity.level.isClientSide && !pPos.equals(pEntity.portalEntrancePos)) pEntity.portalEntrancePos = pPos.immutable();

                Level entityWorld = pEntity.level;
                if(entityWorld != null) {
                    MinecraftServer minecraftserver = entityWorld.getServer();
                    ResourceKey<Level> destination = pEntity.level.dimension() == DDDimensions.OTHERSIDE_LEVEL ? Level.OVERWORLD : DDDimensions.OTHERSIDE_LEVEL;

                    if(minecraftserver != null) {
                        ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                        if(destinationWorld != null && minecraftserver.isNetherEnabled() && !pEntity.isPassenger()) {
                            pEntity.level.getProfiler().push("OTHERSIDE_PORTAL");
                            pEntity.setPortalCooldown();
                            pEntity.changeDimension(destinationWorld, new OthersideTeleporter(destinationWorld));
                            pEntity.level.getProfiler().pop();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextFloat() < 0.0007) {
            pLevel.playLocalSound(pPos.getX() + 0.5d, pPos.getY() + 0.5d, pPos.getZ() + 0.5d, DDSounds.PORTAL_GROAN.get(), SoundSource.BLOCKS, 0.2f, pRandom.nextFloat() * 0.2f + 0.9f, false);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return switch (pRotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (pState.getValue(AXIS)) {
                case Z -> pState.setValue(AXIS, Direction.Axis.X);
                case X -> pState.setValue(AXIS, Direction.Axis.Z);
                default -> pState;
            };
            default -> pState;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AXIS);
    }

    public boolean spawnPortal(LevelAccessor worldIn, BlockPos pos) {
        OthersidePortalShape portal = this.isPortal(worldIn, pos);
        if(portal != null && !trySpawningPortal(worldIn, pos, portal)) {
            portal.createPortalBlocks();
            return true;
        } else return false;
    }

    public static boolean trySpawningPortal(LevelAccessor world, BlockPos pos, OthersidePortalShape portal) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), portal));
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

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final OthersidePortalShape size;

        public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, OthersidePortalShape size) {
            super(world, pos, state);
            this.size = size;
        }

        public OthersidePortalShape getPortalSize() {
            return size;
        }
    }

    /**
     * because PortalShape hard-codes nether portal stuff
     */
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

        public OthersidePortalShape(LevelAccessor pLevel, BlockPos pBottomLeft, Direction.Axis pAxis) {
            this.level = pLevel;
            this.axis = pAxis;
            this.rightDir = pAxis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
            this.bottomLeft = this.calculateBottomLeft(pBottomLeft);

            if(this.bottomLeft == null) {
                this.bottomLeft = pBottomLeft;
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
            for(int i = Math.max(this.level.getMinBuildHeight(), pos.getY() - 21); pos.getY() > i && isEmpty(this.level.getBlockState(pos.below())); pos = pos.below()) { }

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

        private int getFrameHeight(BlockPos.MutableBlockPos pPos) {
            for(int i = 0; i < MAX_HEIGHT; i++) {
                pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);
                if(!this.level.getBlockState(pPos).is(Blocks.REINFORCED_DEEPSLATE)) return i;

                pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
                if(!this.level.getBlockState(pPos).is(Blocks.REINFORCED_DEEPSLATE)) return i;

                for(int j = 0; j < this.width; j++) {
                    pPos.set(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                    BlockState blockState = this.level.getBlockState(pPos);
                    if(!isEmpty(blockState)) return i;

                    if(blockState.is(DDBlocks.OTHERSIDE_PORTAL.get())) this.numPortalBlocks++;
                }
            }

            return MAX_HEIGHT;
        }

        private int getFrameWidth(BlockPos pPos, Direction pDirection) {
            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for(int i = 0; i <= MAX_HEIGHT; i++) {
                blockPos.set(pPos).move(pDirection, i);
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

        private boolean hasTopFrame(BlockPos.MutableBlockPos pPos, int pN) {
            for(int i = 0; i < this.width; i++) {
                BlockPos.MutableBlockPos blockPos = pPos.set(this.bottomLeft).move(Direction.UP, pN).move(this.rightDir, i);
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

        private static boolean isEmpty(BlockState pState) {
            return pState.isAir() || pState.is(DDBlocks.OTHERSIDE_PORTAL.get());
        }
    }
}
