package com.kyanite.deeperdarker.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ColumnFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<ColumnFeatureConfiguration> CODEC = RecordCodecBuilder.create(config -> config.group(
            BlockState.CODEC.fieldOf("block").forGetter(f -> f.block),
            BlockState.CODEC.fieldOf("middleBlock").forGetter(f -> f.middleBlock),
            TagKey.codec(Registries.BLOCK).fieldOf("columnBase").forGetter(f -> f.columnBase),
            TagKey.codec(Registries.BLOCK).fieldOf("baseReplaceable").forGetter(f -> f.baseReplaceable),
            Codec.floatRange(0f, 1f).fieldOf("incompleteChance").forGetter(f -> f.incompleteChance)).apply(config, ColumnFeatureConfiguration::new));
    private final BlockState block;
    private final BlockState middleBlock;
    private final TagKey<Block> columnBase;
    private final TagKey<Block> baseReplaceable;
    private final float incompleteChance;

    public ColumnFeatureConfiguration(BlockState state, BlockState middleState, TagKey<Block> columnBase, TagKey<Block> baseReplaceable, float incompleteChance) {
        this.block = state;
        this.middleBlock = middleState;
        this.columnBase = columnBase;
        this.baseReplaceable = baseReplaceable;
        this.incompleteChance = incompleteChance;
    }

    public BlockState block() {
        return block;
    }

    public BlockState middleBlock() {
        return middleBlock;
    }

    public TagKey<Block> columnBase() {
        return columnBase;
    }

    public TagKey<Block> baseReplaceable() {
        return baseReplaceable;
    }

    public float incompleteChance() {
        return incompleteChance;
    }
}
