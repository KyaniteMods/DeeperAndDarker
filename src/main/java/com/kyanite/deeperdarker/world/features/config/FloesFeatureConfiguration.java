package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.Optional;

public record FloesFeatureConfiguration(RuleBasedBlockStateProvider floeBlockState,
                                        Optional<RuleBasedBlockStateProvider> seamBlockState,
                                        int maxFloeHeight,
                                        int maxSeamHeight,
                                        float threshold) implements FeatureConfiguration {
    public static final Codec<FloesFeatureConfiguration> CODEC = RecordCodecBuilder.create(config -> config.group(
            RuleBasedBlockStateProvider.CODEC.fieldOf("floe_block_state").forGetter(FloesFeatureConfiguration::floeBlockState),
            RuleBasedBlockStateProvider.CODEC.optionalFieldOf("seam_block_state").forGetter(FloesFeatureConfiguration::seamBlockState),
            Codec.INT.fieldOf("max_floe_height").forGetter(FloesFeatureConfiguration::maxFloeHeight),
            Codec.INT.fieldOf("max_seam_height").forGetter(FloesFeatureConfiguration::maxSeamHeight),
            Codec.floatRange(0f, 1f).fieldOf("threshold").forGetter(FloesFeatureConfiguration::threshold)).apply(config, FloesFeatureConfiguration::new));
}
