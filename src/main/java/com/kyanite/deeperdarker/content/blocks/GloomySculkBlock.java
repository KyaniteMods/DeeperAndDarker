package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.world.DDConfiguredFeatures;
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

@SuppressWarnings("NullableProblems")
public class GloomySculkBlock extends SculkBlock implements BonemealableBlock, SculkBehaviour {
    public GloomySculkBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        registry.getHolder(DDConfiguredFeatures.GLOOMY_SCULK_PATCH).ifPresent(holder -> holder.value().place(level, level.getChunkSource().getGenerator(), random, pos.above()));
    }
}
