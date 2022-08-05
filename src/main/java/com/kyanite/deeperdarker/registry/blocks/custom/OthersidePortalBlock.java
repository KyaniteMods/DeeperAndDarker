package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.registry.world.dimension.OthersideTeleporter;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class OthersidePortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public OthersidePortalBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if(pState.getValue(AXIS) == Direction.Axis.X) return X_AABB;
        return Z_AABB;
    }

    public boolean spawnPortal(LevelAccessor worldIn, BlockPos pos) {
        OthersidePortalBlock.Size portal = this.isPortal(worldIn, pos);
        if(portal != null && !trySpawningPortal(worldIn, pos, portal)) {
            portal.placePortalBlocks();
            return true;
        } else return false;
    }

    public static boolean trySpawningPortal(LevelAccessor world, BlockPos pos, OthersidePortalBlock.Size portal) {
        return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), portal));
    }

    @Cancelable
    public static class PortalSpawnEvent extends BlockEvent {
        private final OthersidePortalBlock.Size size;

        public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, OthersidePortalBlock.Size size) {
            super(world, pos, state);
            this.size = size;
        }

        public OthersidePortalBlock.Size getPortalSize() {
            return size;
        }
    }

    public OthersidePortalBlock.Size isPortal(LevelAccessor level, BlockPos pos) {
        OthersidePortalBlock.Size portalX = new Size(level, pos, Direction.Axis.X);
        if(portalX.isValid() && portalX.portalBlockCount == 0) {
            return portalX;
        } else {
            OthersidePortalBlock.Size portalZ = new Size(level, pos, Direction.Axis.Z);
            return portalZ.isValid() && portalZ.portalBlockCount == 0 ? portalZ : null;
        }
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        Direction.Axis facingAxis = pDirection.getAxis();
        Direction.Axis axis = pState.getValue(AXIS);
        boolean flag = axis != facingAxis && facingAxis.isHorizontal();
        return !flag && pNeighborState.getBlock() != this && !(new Size(pLevel, pCurrentPos, axis)).validatePortal() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pEntity.isPassenger() && !pEntity.isVehicle() && pEntity.canChangeDimensions()) {
            if(pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
            }
            else {
                if(!pEntity.level.isClientSide && !pPos.equals(pEntity.portalEntrancePos)) {
                    pEntity.portalEntrancePos = pPos.immutable();
                }
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
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if(pRandom.nextInt(350) == 0) {
            pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D,
                    (double)pPos.getZ() + 0.5D, DDSounds.PORTAL_GROAN.get(),
                    SoundSource.BLOCKS, 0.5F, pRandom.nextFloat() * 0.4F + 0.8F, false);
        }

        // TODO: for loop with particles
        /*=for(int i = 0; i < 4; i++) {
            double x = (double)pPos.getX() + pRandom.nextDouble();
            double y = (double)pPos.getY() + pRandom.nextDouble();
            double z = (double)pPos.getZ() + pRandom.nextDouble();
            double xSpeed = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double)pRandom.nextFloat() - 0.5D) * 0.5D;
            int j = pRandom.nextInt(2) * 2 - 1;
            if(!pLevel.getBlockState(pPos.west()).is(this) && !pLevel.getBlockState(pPos.east()).is(this)) {
                x = (double)pPos.getX() + 0.5D + 0.25D * (double)j;
                xSpeed = pRandom.nextFloat() * 2.0F * (float)j;
            }
            else {
                z = (double)pPos.getZ() + 0.5D + 0.25D * (double)j;
                zSpeed = pRandom.nextFloat() * 2.0F * (float)j;
            }

            pLevel.addParticle(PARTICLE_TYPE, x, y, z, xSpeed, ySpeed, zSpeed);
        }*/
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

    public static class Size {
        private final LevelAccessor level;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
            this.level = level;
            this.axis = axis;
            if(axis == Direction.Axis.X) {
                this.leftDir = Direction.EAST;
                this.rightDir = Direction.WEST;
            }
            else {
                this.leftDir = Direction.NORTH;
                this.rightDir = Direction.SOUTH;
            }

            int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
            if(i >= 0) {
                this.bottomLeft = pos.relative(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if(this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if(this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }

        }

        public int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
            int i;
            for(i = 0; i < 22; i++) {
                BlockPos blockpos = pos.relative(directionIn, i);
                if(!this.canConnect(this.level.getBlockState(blockpos)) ||
                        !(this.level.getBlockState(blockpos.below()).is(Blocks.REINFORCED_DEEPSLATE))) {
                    break;
                }
            }

            BlockPos framePos = pos.relative(directionIn, i);
            return this.level.getBlockState(framePos).is(Blocks.REINFORCED_DEEPSLATE) ? i : 0;
        }

        public int calculatePortalHeight() {
            calc:
            for(this.height = 0; this.height < 21; this.height++) {
                for(int i = 0; i < this.width; i++) {
                    BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
                    BlockState blockstate = this.level.getBlockState(blockpos);
                    if(!this.canConnect(blockstate)) {
                        break calc;
                    }

                    Block block = blockstate.getBlock();
                    if(block == DDBlocks.OTHERSIDE_PORTAL.get()) {
                        this.portalBlockCount++;
                    }

                    if(i == 0) {
                        BlockPos framePos = blockpos.relative(this.leftDir);
                        if(!(this.level.getBlockState(framePos).is(Blocks.REINFORCED_DEEPSLATE))) {
                            break calc;
                        }
                    }
                    else if(i == this.width - 1) {
                        BlockPos framePos = blockpos.relative(this.rightDir);
                        if(!(this.level.getBlockState(framePos).is(Blocks.REINFORCED_DEEPSLATE))) {
                            break calc;
                        }
                    }
                }
            }

            for(int j = 0; j < this.width; j++) {
                BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
                if(!(this.level.getBlockState(framePos).is(Blocks.REINFORCED_DEEPSLATE))) {
                    this.height = 0;
                    break;
                }
            }

            if(this.height <= 21 && this.height >= 3) {
                return this.height;
            }
            else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }

        public boolean canConnect(BlockState pos) {
            Block block = pos.getBlock();
            return pos.isAir() || block == DDBlocks.OTHERSIDE_PORTAL.get();
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks() {
            for(int i = 0; i < this.width; i++) {
                BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);

                for(int j = 0; j < this.height; j++) {
                    this.level.setBlock(blockpos.above(j), DDBlocks.OTHERSIDE_PORTAL.get().defaultBlockState().setValue(OthersidePortalBlock.AXIS, this.axis), 18);
                }
            }

        }

        public boolean validatePortal() {
            return this.isValid() && this.portalBlockCount >= this.width * this.height;
        }
    }
}
