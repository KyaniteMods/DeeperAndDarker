package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SculkBehaviour;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class GloomSculkBlock extends SculkBlock implements BonemealableBlock, SculkBehaviour {
    public GloomSculkBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return levelReader.getBlockState(blockPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        Registry<ConfiguredFeature<?, ?>> registry = pLevel.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        registry.getHolder(DDConfiguredFeatures.GLOOM_SCULK_VEGETATION_COLLECTION).ifPresent(holder -> {
            holder.value().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, pPos.above());

        });
    }
}
