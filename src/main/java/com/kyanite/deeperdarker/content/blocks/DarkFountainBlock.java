package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDBlockEntities;
import com.kyanite.deeperdarker.content.entities.blocks.DarkFountainBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DarkFountainBlock extends BaseEntityBlock {
    public static final VoxelShape FOUNTAIN_SHAPE = box(7.0, 0.0, 7.0, 9.0, 1.0, 9.0);
    public static final BooleanProperty HAS_BEAM = BooleanProperty.create("has_beam");

    public DarkFountainBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(HAS_BEAM, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_BEAM);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DarkFountainBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public static boolean canBeamPassThrough(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        if (blockState.is(DDTags.Blocks.DARK_FOUNTAIN_BEAM_PASSTHROUGH)) {
            return true;
        }
        if (blockState.isAir()) {
            return true;
        }
        if (blockState.isSolidRender(blockGetter, blockPos)) {
            return false;
        }
        if (blockState.getFluidState().is(DDTags.Fluids.BLOCKS_DARK_FOUNTAIN_BEAM)) {
            return false;
        }
        VoxelShape voxelShape = blockState.getVisualShape(blockGetter, blockPos, CollisionContext.empty());
        return !Shapes.joinIsNotEmpty(FOUNTAIN_SHAPE, voxelShape, BooleanOp.AND);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, DDBlockEntities.DARK_FOUNTAIN, DarkFountainBlockEntity::tick);
    }
}
