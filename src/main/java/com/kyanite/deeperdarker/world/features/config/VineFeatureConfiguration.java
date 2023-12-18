package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class VineFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<VineFeatureConfiguration> CODEC = RecordCodecBuilder.create(config -> config.group(BlockState.CODEC.fieldOf("plant").forGetter(f -> f.plant),
            BlockState.CODEC.fieldOf("vine").forGetter(f -> f.vine),
            TagKey.codec(Registries.BLOCK).fieldOf("placeable").forGetter(f -> f.placeable),
            IntProvider.codec(1, 64).fieldOf("height").forGetter(f -> f.height),
            Codec.floatRange(0f, 1f).fieldOf("doubleHeight").forGetter(f -> f.doubleHeight),
            Codec.floatRange(0f, 1f).fieldOf("reducedHeight").forGetter(f -> f.reducedHeight)).apply(config, VineFeatureConfiguration::new));
    private final BlockState plant;
    private final BlockState vine;
    private final TagKey<Block> placeable;
    private final IntProvider height;
    private final float doubleHeight;
    private final float reducedHeight;

    public VineFeatureConfiguration(BlockState plant, BlockState vine, TagKey<Block> placeable, IntProvider height, float doubleHeight, float reducedHeight) {
        this.plant = plant;
        this.vine = vine;
        this.placeable = placeable;
        this.height = height;
        this.doubleHeight = doubleHeight;
        this.reducedHeight = reducedHeight;
    }

    public BlockState plant() {
        return plant;
    }

    public BlockState vine() {
        return vine;
    }

    public TagKey<Block> tag() {
        return placeable;
    }

    public IntProvider height() {
        return height;
    }

    public float doubleChance() {
        return doubleHeight;
    }

    public float reducedChance() {
        return reducedHeight;
    }
}
