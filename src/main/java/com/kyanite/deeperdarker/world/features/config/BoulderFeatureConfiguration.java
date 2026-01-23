package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BoulderFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<BoulderFeatureConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(f -> f.stateProvider),
            IntProvider.codec(1, 64).fieldOf("diameter").forGetter(f -> f.diameter)
    ).apply(instance, BoulderFeatureConfiguration::new));
    public final BlockStateProvider stateProvider;
    public final IntProvider diameter;

    public BoulderFeatureConfiguration(BlockStateProvider stateProvider, IntProvider diameter) {
        this.stateProvider = stateProvider;
        this.diameter = diameter;
    }
}
