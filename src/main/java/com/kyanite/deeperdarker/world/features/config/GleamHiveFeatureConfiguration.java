package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record GleamHiveFeatureConfiguration(BlockStateProvider fillingProvider, BlockStateProvider outerProvider, BlockStateProvider alternateOuterProvider, double useAlternateBlockChance, IntProvider mainRadiusProvider, IntProvider secondaryRadiusProvider) implements FeatureConfiguration {
    public static final Codec<GleamHiveFeatureConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("filling_provider").forGetter(f -> f.fillingProvider),
            BlockStateProvider.CODEC.fieldOf("outer_provider").forGetter(f -> f.outerProvider),
            BlockStateProvider.CODEC.fieldOf("alternate_outer_provider").forGetter(f -> f.alternateOuterProvider),
            Codec.DOUBLE.fieldOf("use_alternate_block_chance").forGetter(f -> f.useAlternateBlockChance),
            IntProvider.CODEC.fieldOf("main_radius_provider").forGetter(f -> f.mainRadiusProvider),
            IntProvider.CODEC.fieldOf("secondary_radius_provider").forGetter(f -> f.secondaryRadiusProvider)
    ).apply(instance, GleamHiveFeatureConfiguration::new));
}
