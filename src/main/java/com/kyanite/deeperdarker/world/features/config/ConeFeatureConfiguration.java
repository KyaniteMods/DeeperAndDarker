package com.kyanite.deeperdarker.world.features.config;

import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ConeFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<ConeFeatureConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK).fieldOf("replaceable").orElse(DDTags.Blocks.SCULK_SPRUCE_FOREST_REPLACEABLE).forGetter(config -> config.replaceable),
            BlockStateProvider.CODEC.fieldOf("state_provider").forGetter(config -> config.blockStateProvider),
            IntProvider.codec(1, 128).fieldOf("width").orElse(UniformInt.of(4, 5)).forGetter(config -> config.widthProvider),
            IntProvider.codec(1, 128).fieldOf("depth").orElse(UniformInt.of(5, 7)).forGetter(config -> config.depthProvider),
            IntProvider.codec(1, 128).fieldOf("height").orElse(UniformInt.of(6, 8)).forGetter(config -> config.heightProvider),
            IntProvider.codec(-16, 16).fieldOf("tip_x_shift").orElse(UniformInt.of(-3, 3)).forGetter(config -> config.tipXShiftProvider),
            IntProvider.codec(-128, 0).fieldOf("y_shift").orElse(ConstantInt.of(0)).forGetter(config -> config.yShiftProvider),
            IntProvider.codec(-16, 16).fieldOf("tip_z_shift").orElse(UniformInt.of(-3, 3)).forGetter(config -> config.tipZShiftProvider)
    ).apply(instance, ConeFeatureConfiguration::new));
    public final TagKey<Block> replaceable;
    public final BlockStateProvider blockStateProvider;
    public final IntProvider widthProvider;
    public final IntProvider depthProvider;
    public final IntProvider heightProvider;
    public final IntProvider tipXShiftProvider;
    public final IntProvider yShiftProvider;
    public final IntProvider tipZShiftProvider;

    public ConeFeatureConfiguration(TagKey<Block> replaceable, BlockStateProvider blockStateProvider, IntProvider widthProvider, IntProvider depthProvider, IntProvider heightProvider, IntProvider tipXShiftProvider, IntProvider yShiftProvider, IntProvider tipZShiftProvider) {
        this.replaceable = replaceable;
        this.blockStateProvider = blockStateProvider;
        this.widthProvider = widthProvider;
        this.depthProvider = depthProvider;
        this.heightProvider = heightProvider;
        this.tipXShiftProvider = tipXShiftProvider;
        this.yShiftProvider = yShiftProvider;
        this.tipZShiftProvider = tipZShiftProvider;
    }
}
