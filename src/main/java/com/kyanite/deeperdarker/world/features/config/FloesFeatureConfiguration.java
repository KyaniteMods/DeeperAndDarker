package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.Optional;

public record FloesFeatureConfiguration(RuleBasedBlockStateProvider floeBlockState,
                                        Optional<RuleBasedBlockStateProvider> seamBlockState,
                                        int maxFloeHeight,
                                        int maxSeamHeight,
                                        float threshold,
                                        TagKey<Biome> allowedBiomes) implements FeatureConfiguration {
    public static final Codec<FloesFeatureConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RuleBasedBlockStateProvider.CODEC.fieldOf("floe_block_state").forGetter(FloesFeatureConfiguration::floeBlockState),
            RuleBasedBlockStateProvider.CODEC.optionalFieldOf("seam_block_state").forGetter(FloesFeatureConfiguration::seamBlockState),
            Codec.INT.fieldOf("max_floe_height").forGetter(FloesFeatureConfiguration::maxFloeHeight),
            Codec.INT.fieldOf("max_seam_height").forGetter(FloesFeatureConfiguration::maxSeamHeight),
            Codec.floatRange(0f, 1f).fieldOf("threshold").forGetter(FloesFeatureConfiguration::threshold),
            TagKey.codec(Registries.BIOME).fieldOf("allowed_biomes").forGetter(FloesFeatureConfiguration::allowedBiomes)
    ).apply(instance, FloesFeatureConfiguration::new));
}
