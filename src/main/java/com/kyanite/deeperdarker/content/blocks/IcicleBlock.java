package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.entities.blocks.IcicleBlockEntity;
import com.kyanite.deeperdarker.mixin.AbstractCauldronAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class IcicleBlock extends BaseEntityBlock
        implements Fallable,
        SimpleWaterloggedBlock  {
    public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape TIP_SHAPE_UP = Block.box(6.0, 0.0, 6.0, 10.0, 11.0, 10.0);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box(6.0, 5.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape MIDDLE_SHAPE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
    private static final VoxelShape BASE_SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
    private static final double STALACTITE_DRIP_START_PIXEL = TIP_SHAPE_DOWN.min(Direction.Axis.Y);
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);

    public IcicleBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP).setValue(THICKNESS, DripstoneThickness.TIP).setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return isValidPointedDripstonePlacement(levelReader, blockPos, blockState.getValue(TIP_DIRECTION));
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED).booleanValue()) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        if (direction != Direction.UP && direction != Direction.DOWN) {
            return blockState;
        }
        Direction direction2 = blockState.getValue(TIP_DIRECTION);
        if (direction2 == Direction.DOWN && levelAccessor.getBlockTicks().hasScheduledTick(blockPos, this)) {
            return blockState;
        }
        if (direction == direction2.getOpposite() && !this.canSurvive(blockState, levelAccessor, blockPos)) {
            if (direction2 == Direction.DOWN) {
                levelAccessor.scheduleTick(blockPos, this, 2);
            } else {
                levelAccessor.scheduleTick(blockPos, this, 1);
            }
            return blockState;
        }
        boolean bl = blockState.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
        DripstoneThickness dripstoneThickness = calculateDripstoneThickness(levelAccessor, blockPos, direction2, bl);
        return blockState.setValue(THICKNESS, dripstoneThickness);
    }

    @Override
    public void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        if (!level.isClientSide && projectile.mayInteract(level, blockPos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6) {
            level.destroyBlock(blockPos, true);
        }
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (blockState.getValue(TIP_DIRECTION) == Direction.UP && blockState.getValue(THICKNESS) == DripstoneThickness.TIP) {
            entity.causeFallDamage(f + 2.0f, 2.0f, level.damageSources().stalagmite());
        } else {
            super.fallOn(level, blockState, blockPos, entity, f);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (canDrip(state)) {
            float randomValue = random.nextFloat();
            if (!(randomValue > 0.12F)) {
                spawnDripParticle(level, pos, state, Fluids.WATER);
            }
        }
    }

    public boolean canDrip(BlockState blockState) {
        return isStalactite(blockState) && blockState.getValue(THICKNESS) == DripstoneThickness.TIP && !blockState.getValue(WATERLOGGED);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (isStalagmite(blockState) && !this.canSurvive(blockState, serverLevel, blockPos)) {
            serverLevel.destroyBlock(blockPos, true);
        } else {
            spawnFallingStalactite(blockState, serverLevel, blockPos);
        }
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level2, BlockState blockState2, BlockEntityType<T> blockEntityType) {
        if (!level2.isClientSide) {
            return createTickerHelper(blockEntityType, DDBlockEntities.ICICLE, (level, blockPos, blockState, blockEntity) -> VibrationSystem.Ticker.tick(level, blockEntity.getVibrationData(), blockEntity.getVibrationUser()));
        }
        return null;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        maybeTransferWater(blockState, serverLevel, blockPos, randomSource.nextFloat());
        if (randomSource.nextFloat() < 0.011377778f && isStalactiteStartPos(blockState, serverLevel, blockPos)) {
            growStalactiteOrStalagmiteIfPossiblea(blockState, serverLevel, blockPos, randomSource);
        }
    }

    public void maybeTransferWater(BlockState state, ServerLevel level, BlockPos pos, float randomValue) {
        float transferProbability = 0.17578125F;
        if (randomValue > 0.17578125F || randomValue < transferProbability) return;
        if (!isStalactiteStartPos(state, level, pos)) return;
        Fluid fluid = Fluids.WATER;

        BlockPos stalactiteTipPos = findTip(state, level, pos, 11, false);
        if (stalactiteTipPos != null) {
            BlockPos cauldronPos = findFillableCauldronBelowStalactiteTip(level, stalactiteTipPos, fluid);
            if (cauldronPos != null) {
                level.levelEvent(1504, stalactiteTipPos, 0);
                int fallDistance = stalactiteTipPos.getY() - cauldronPos.getY();
                int delay = 50 + fallDistance;
                BlockState cauldronState = level.getBlockState(cauldronPos);
                level.scheduleTick(cauldronPos, cauldronState.getBlock(), delay);
            }
        }
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos;
        Level levelAccessor = blockPlaceContext.getLevel();
        Direction direction2 = calculateTipDirection(levelAccessor, blockPos = blockPlaceContext.getClickedPos(), blockPlaceContext.getNearestLookingVerticalDirection().getOpposite());
        if (direction2 == null) {
            return null;
        }
        boolean bl = !blockPlaceContext.isSecondaryUseActive();
        DripstoneThickness dripstoneThickness = calculateDripstoneThickness(levelAccessor, blockPos, direction2, bl);
        if (dripstoneThickness == null) {
            return null;
        }
        return this.defaultBlockState().setValue(TIP_DIRECTION, direction2).setValue(THICKNESS, dripstoneThickness).setValue(WATERLOGGED, levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        if (blockState.getValue(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(blockState);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        DripstoneThickness dripstoneThickness = blockState.getValue(THICKNESS);
        VoxelShape voxelShape = dripstoneThickness == DripstoneThickness.TIP_MERGE ? TIP_MERGE_SHAPE : (dripstoneThickness == DripstoneThickness.TIP ? (blockState.getValue(TIP_DIRECTION) == Direction.DOWN ? TIP_SHAPE_DOWN : TIP_SHAPE_UP) : (dripstoneThickness == DripstoneThickness.FRUSTUM ? FRUSTUM_SHAPE : (dripstoneThickness == DripstoneThickness.MIDDLE ? MIDDLE_SHAPE : BASE_SHAPE)));
        Vec3 vec3 = blockState.getOffset(blockGetter, blockPos);
        return voxelShape.move(vec3.x, 0.0, vec3.z);
    }

    @Override
    public boolean isCollisionShapeFullBlock(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    @Override
    public float getMaxHorizontalOffset() {
        return 0.125f;
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos blockPos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            level.levelEvent(1045, blockPos, 0);
        }
    }

    @Override
    public DamageSource getFallDamageSource(Entity entity) {
        return entity.damageSources().fallingStalactite(entity);
    }

    public void spawnFallingStalactite(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();
        BlockState blockState2 = blockState;
        while (isStalactite(blockState2)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(serverLevel, mutableBlockPos, blockState2);
            fallingBlockEntity.setDeltaMovement(new Vec3(0.0, -0.25, 0.0));
            if (isTip(blockState2, true)) {
                int i = Math.max(1 + blockPos.getY() - mutableBlockPos.getY(), 6);
                fallingBlockEntity.setHurtsEntities(i, 40);
                fallingBlockEntity.disableDrop();
                break;
            }
            mutableBlockPos.move(Direction.DOWN);
            blockState2 = serverLevel.getBlockState(mutableBlockPos);
        }
    }

    public void growStalactiteOrStalagmiteIfPossiblea(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        BlockState blockState2 = serverLevel.getBlockState(blockPos.above(1));
        if (!canGrow(blockState2, serverLevel.getBlockState(blockPos.above(2)))) {
            return;
        }
        BlockPos blockPos2 = findTip(blockState, serverLevel, blockPos, 7, false);
        if (blockPos2 == null) {
            return;
        }
        BlockState blockState4 = serverLevel.getBlockState(blockPos2);
        if (!PointedDripstoneBlock.canDrip(blockState4) || !canTipGrow(blockState4, serverLevel, blockPos2)) {
            return;
        }
        if (randomSource.nextBoolean()) {
            grow(serverLevel, blockPos2, Direction.DOWN);
        } else {
            growStalagmiteBelow(serverLevel, blockPos2);
        }
    }

    private void growStalagmiteBelow(ServerLevel serverLevel, BlockPos blockPos) {
        BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();
        for (int i = 0; i < 10; ++i) {
            mutableBlockPos.move(Direction.DOWN);
            BlockState blockState = serverLevel.getBlockState(mutableBlockPos);
            if (!blockState.getFluidState().isEmpty()) {
                return;
            }
            if (isUnmergedTipWithDirection(blockState, Direction.UP) && canTipGrow(blockState, serverLevel, mutableBlockPos)) {
                grow(serverLevel, mutableBlockPos, Direction.UP);
                return;
            }
            if (isValidPointedDripstonePlacement(serverLevel, mutableBlockPos, Direction.UP) && !serverLevel.isWaterAt(mutableBlockPos.below())) {
                grow(serverLevel, mutableBlockPos.below(), Direction.UP);
                return;
            }
            if (canDripThrough(serverLevel, mutableBlockPos, blockState)) continue;
            return;
        }
    }

    private void grow(ServerLevel serverLevel, BlockPos blockPos, Direction direction) {
        BlockPos blockPos2 = blockPos.relative(direction);
        BlockState blockState = serverLevel.getBlockState(blockPos2);
        if (isUnmergedTipWithDirection(blockState, direction.getOpposite())) {
            createMergedTips(blockState, serverLevel, blockPos2);
        } else if (blockState.isAir() || blockState.is(Blocks.WATER)) {
            createIcicle(serverLevel, blockPos2, direction, DripstoneThickness.TIP);
        }
    }

    private void createIcicle(LevelAccessor levelAccessor, BlockPos blockPos, Direction direction, DripstoneThickness dripstoneThickness) {
        BlockState blockState = defaultBlockState().setValue(TIP_DIRECTION, direction).setValue(THICKNESS, dripstoneThickness).setValue(WATERLOGGED, levelAccessor.getFluidState(blockPos).getType() == Fluids.WATER);
        levelAccessor.setBlock(blockPos, blockState, 3);
    }

    private void createMergedTips(BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos) {
        BlockPos blockPos3;
        BlockPos blockPos2;
        if (blockState.getValue(TIP_DIRECTION) == Direction.UP) {
            blockPos2 = blockPos;
            blockPos3 = blockPos.above();
        } else {
            blockPos3 = blockPos;
            blockPos2 = blockPos.below();
        }
        createIcicle(levelAccessor, blockPos3, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createIcicle(levelAccessor, blockPos2, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    private static void spawnDripParticle(Level level, BlockPos pos, BlockState blockState, Fluid fluid) {
        Vec3 offset = blockState.getOffset(level, pos);
        double pixelSize = 0.0625;
        double x = pos.getX() + 0.5 + offset.x;
        double y = pos.getY() + STALACTITE_DRIP_START_PIXEL - pixelSize;
        double z = pos.getZ() + 0.5 + offset.z;
        SimpleParticleType particleOptions = ParticleTypes.DRIPPING_DRIPSTONE_WATER;
        level.addParticle(particleOptions, x, y, z, 0.0, 0.0, 0.0);
    }

    @Nullable
    private BlockPos findTip(BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos2, int i, boolean bl) {
        if (isTip(blockState2, bl)) {
            return blockPos2;
        }
        Direction direction = blockState2.getValue(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> blockState.is(this) && blockState.getValue(TIP_DIRECTION) == direction;
        return findBlockVertical(levelAccessor, blockPos2, direction.getAxisDirection(), biPredicate, blockState -> isTip(blockState, bl), i).orElse(null);
    }

    @Nullable
    private Direction calculateTipDirection(LevelReader levelReader, BlockPos blockPos, Direction direction) {
        Direction direction2;
        if (isValidPointedDripstonePlacement(levelReader, blockPos, direction)) {
            direction2 = direction;
        } else if (isValidPointedDripstonePlacement(levelReader, blockPos, direction.getOpposite())) {
            direction2 = direction.getOpposite();
        } else {
            return null;
        }
        return direction2;
    }

    private DripstoneThickness calculateDripstoneThickness(LevelReader levelReader, BlockPos blockPos, Direction direction, boolean bl) {
        Direction direction2 = direction.getOpposite();
        BlockState blockState = levelReader.getBlockState(blockPos.relative(direction));
        if (isIcicleWithDirection(blockState, direction2)) {
            if (bl || blockState.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE) {
                return DripstoneThickness.TIP_MERGE;
            }
            return DripstoneThickness.TIP;
        }
        if (!isIcicleWithDirection(blockState, direction)) {
            return DripstoneThickness.TIP;
        }
        DripstoneThickness dripstoneThickness = blockState.getValue(THICKNESS);
        if (dripstoneThickness == DripstoneThickness.TIP || dripstoneThickness == DripstoneThickness.TIP_MERGE) {
            return DripstoneThickness.FRUSTUM;
        }
        BlockState blockState2 = levelReader.getBlockState(blockPos.relative(direction2));
        if (!isIcicleWithDirection(blockState2, direction)) {
            return DripstoneThickness.BASE;
        }
        return DripstoneThickness.MIDDLE;
    }

    private boolean canTipGrow(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {
        Direction direction = blockState.getValue(TIP_DIRECTION);
        BlockPos blockPos2 = blockPos.relative(direction);
        BlockState blockState2 = serverLevel.getBlockState(blockPos2);
        if (!blockState2.getFluidState().isEmpty()) {
            return false;
        }
        if (blockState2.isAir()) {
            return true;
        }
        return isUnmergedTipWithDirection(blockState2, direction.getOpposite());
    }

    private boolean isValidPointedDripstonePlacement(LevelReader levelReader, BlockPos blockPos, Direction direction) {
        BlockPos blockPos2 = blockPos.relative(direction.getOpposite());
        BlockState blockState = levelReader.getBlockState(blockPos2);
        return blockState.isFaceSturdy(levelReader, blockPos2, direction) || isIcicleWithDirection(blockState, direction);
    }

    private boolean isTip(BlockState blockState, boolean bl) {
        if (!blockState.is(this)) {
            return false;
        }
        DripstoneThickness dripstoneThickness = blockState.getValue(THICKNESS);
        return dripstoneThickness == DripstoneThickness.TIP || bl && dripstoneThickness == DripstoneThickness.TIP_MERGE;
    }

    private boolean isUnmergedTipWithDirection(BlockState blockState, Direction direction) {
        return isTip(blockState, false) && blockState.getValue(TIP_DIRECTION) == direction;
    }

    private boolean isStalactite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.DOWN);
    }

    private boolean isStalagmite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.UP);
    }

    private boolean isStalactiteStartPos(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return isStalactite(blockState) && !levelReader.getBlockState(blockPos.above()).is(this);
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    private boolean isIcicleWithDirection(BlockState blockState, Direction direction) {
        return blockState.is(this) && blockState.getValue(TIP_DIRECTION) == direction;
    }

    @Nullable
    private static BlockPos findFillableCauldronBelowStalactiteTip(Level level, BlockPos blockPos2, Fluid fluid) {
        Predicate<BlockState> predicate = blockState -> blockState.getBlock() instanceof AbstractCauldronBlock && ((AbstractCauldronAccessor)blockState.getBlock()).callCanReceiveStalactiteDrip(fluid);
        BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> canDripThrough(level, blockPos, blockState);
        return findBlockVertical(level, blockPos2, Direction.DOWN.getAxisDirection(), biPredicate, predicate, 11).orElse(null);
    }

    private static boolean canGrow(BlockState blockState, BlockState blockState2) {
        return blockState.is(Blocks.DRIPSTONE_BLOCK) && blockState2.is(Blocks.WATER) && blockState2.getFluidState().isSource();
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor levelAccessor, BlockPos blockPos, Direction.AxisDirection axisDirection, BiPredicate<BlockPos, BlockState> biPredicate, Predicate<BlockState> predicate, int i) {
        Direction direction = Direction.get(axisDirection, Direction.Axis.Y);
        BlockPos.MutableBlockPos mutableBlockPos = blockPos.mutable();
        for (int j = 1; j < i; ++j) {
            mutableBlockPos.move(direction);
            BlockState blockState = levelAccessor.getBlockState(mutableBlockPos);
            if (predicate.test(blockState)) {
                return Optional.of(mutableBlockPos.immutable());
            }
            if (!levelAccessor.isOutsideBuildHeight(mutableBlockPos.getY()) && biPredicate.test(mutableBlockPos, blockState)) continue;
            return Optional.empty();
        }
        return Optional.empty();
    }

    public static boolean canDripThrough(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        if (blockState.isAir()) {
            return true;
        }
        if (blockState.isSolidRender(blockGetter, blockPos)) {
            return false;
        }
        if (!blockState.getFluidState().isEmpty()) {
            return false;
        }
        VoxelShape voxelShape = blockState.getCollisionShape(blockGetter, blockPos);
        return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelShape, BooleanOp.AND);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new IcicleBlockEntity(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }
}
