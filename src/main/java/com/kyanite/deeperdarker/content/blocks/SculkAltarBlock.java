package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.entities.blocks.SculkAltarBlockEntity;
import com.kyanite.deeperdarker.network.AddSculkAltarItemPacket;
import com.kyanite.deeperdarker.network.RemoveSculkAltarItemPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SculkAltarBlock extends BaseEntityBlock {
    protected static final VoxelShape SHAPE_BOTTOM = Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
    protected static final VoxelShape SHAPE_RING = Shapes.join(
            Block.box(0.0, 12.0, 0.0, 16.0, 16.0, 16.0),
            Block.box(4.0, 12.0, 4.0, 12.0, 16.0, 12.0),
            BooleanOp.ONLY_FIRST
    );
    protected static final VoxelShape SHAPE = Shapes.or(SHAPE_BOTTOM, SHAPE_RING);

    public static final BooleanProperty HAS_ITEMS = BooleanProperty.create("has_items");
    public static final BooleanProperty CAN_SPAWN_BOSS = BooleanProperty.create("can_spawn_boss");
    public static final BooleanProperty BOSS_LOCKED = BooleanProperty.create("boss_locked");

    public SculkAltarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(HAS_ITEMS, false).setValue(CAN_SPAWN_BOSS, true).setValue(BOSS_LOCKED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_ITEMS, CAN_SPAWN_BOSS, BOSS_LOCKED);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState blockState) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(HAS_ITEMS) ? SHAPE : SHAPE_BOTTOM;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BOTTOM;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return SHAPE_BOTTOM;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SculkAltarBlockEntity(blockPos, blockState);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, DDBlockEntities.SCULK_ALTAR, SculkAltarBlockEntity::tick);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.getBlockEntity(blockPos) instanceof SculkAltarBlockEntity blockEntity) {
            if (!level.isClientSide()) return InteractionResult.CONSUME;

            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (itemStack.isEmpty()) {
                if (!itemsHit(blockHitResult)) return InteractionResult.PASS;

                float angle = (float) Mth.atan2(blockHitResult.getLocation().z() - blockHitResult.getBlockPos().getCenter().z(), blockHitResult.getBlockPos().getCenter().x() - blockHitResult.getLocation().x()) * Mth.RAD_TO_DEG + 540.0f - blockEntity.getRotationDegrees(0.0f);
                ClientPlayNetworking.send(new RemoveSculkAltarItemPacket((int)(angle / 360.0f * blockEntity.getItems().size()), blockPos));
            } else {
                int slot = interactionHand == InteractionHand.MAIN_HAND ? player.getInventory().selected : 40;
                ClientPlayNetworking.send(new AddSculkAltarItemPacket(slot, blockPos));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private static boolean itemsHit(BlockHitResult blockHitResult) {
        return blockHitResult.getLocation().y - blockHitResult.getBlockPos().getY() > 0.75;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof SculkAltarBlockEntity sculkAltarBlockEntity) {
                Containers.dropContents(level, blockPos, sculkAltarBlockEntity.getItems());
            }

            super.onRemove(blockState, level, blockPos, blockState2, bl);
        }
    }
}
