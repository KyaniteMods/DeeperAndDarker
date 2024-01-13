package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.vegetation.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.kyanite.deeperdarker.content.entities.Stalker;
import com.kyanite.deeperdarker.util.DDConfig;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

@SuppressWarnings({"deprecation", "NullableProblems"})
public class AncientVaseBlock extends FallingBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape BASE = Block.box(3, 0, 3, 13, 1, 13);
    private static final VoxelShape OUTLINE = Block.box(2, 1, 2, 14, 13, 14);
    private static final VoxelShape RIM = Block.box(4, 13, 4, 12, 16, 12);
    public static final MapCodec<AncientVaseBlock> CODEC = simpleCodec(AncientVaseBlock::new);

    public AncientVaseBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(BASE, OUTLINE, RIM).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer, BlockPos pBlockPos, BlockState pBlockState,
                              @Nullable BlockEntity pBlockEntity, ItemStack pItemStack) {
        if (!EnchantmentHelper.hasSilkTouch(pPlayer.getMainHandItem())) {
            RandomSource random = pLevel.getRandom();
            if (random.nextFloat() < DDConfig.HANDLER.instance().spawnSomethingFromAncientVaseChance) {
                if (random.nextDouble() < DDConfig.HANDLER.instance().sculkLeechesFromAncientVaseChance) {
                    for (int i = 0; i < random.nextInt(1, 4); i++) {
                        SculkLeech entity = DDEntities.SCULK_LEECH.create(pLevel);
                        assert entity != null;
                        entity.moveTo(pBlockPos.getX() + random.nextFloat(),
                                pBlockPos.getY() + random.nextFloat() + 0.15f, pBlockPos.getZ() + random.nextFloat(),
                                random.nextFloat() * 360, random.nextFloat() * 360);
                        pLevel.addFreshEntity(entity);
                    }
                } else if (pLevel instanceof ServerLevel serverLevel) {
                    DDEntities.STALKER.spawn(serverLevel, pBlockPos, MobSpawnType.TRIGGERED);
                }
                pPlayer.awardStat(Stats.BLOCK_MINED.get(this));
                return;
            }
        }
        super.playerDestroy(pLevel, pPlayer, pBlockPos, pBlockState, pBlockEntity, pItemStack);
    }
}
