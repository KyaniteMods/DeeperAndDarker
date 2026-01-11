package com.kyanite.deeperdarker.world.features.config;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class IcicleConfiguration implements FeatureConfiguration {
    public static final Codec<IcicleConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BLOCK).fieldOf("replaceable").orElse(DDTags.Blocks.ICE_REPLACEABLE).forGetter(config -> config.replaceable),
            TagKey.codec(Registries.BLOCK).fieldOf("base").orElse(DDTags.Blocks.ICE_BASE).forGetter(config -> config.base),
            BlockStateProvider.CODEC.fieldOf("ice_provider").orElse(new WeightedStateProvider(
                    SimpleWeightedRandomList.<BlockState>builder()
                            .add(Blocks.PACKED_ICE.defaultBlockState(), 1)
                            .add(Blocks.BLUE_ICE.defaultBlockState(), 1).build()
            )).forGetter(config -> config.iceProvider),
            BlockStateProvider.CODEC.fieldOf("icicle_provider").orElse(BlockStateProvider.simple(DDBlocks.ICICLE)).forGetter(config -> config.icicleProvider),
            IntProvider.POSITIVE_CODEC.fieldOf("height_provider").orElse(UniformInt.of(3, 6)).forGetter(config -> config.heightProvider),
            Codec.floatRange(0.0f, 1.0f).fieldOf("chance_of_directional_spread").orElse(0.7f).forGetter(config -> config.chanceOfDirectionalSpread),
            Codec.floatRange(0.0f, 1.0f).fieldOf("chance_of_spread_radius2").orElse(0.6f).forGetter(config -> config.chanceOfSpreadRadius2),
            Codec.floatRange(0.0f, 1.0f).fieldOf("chance_of_spread_radius3").orElse(0.6f).forGetter(config -> config.chanceOfSpreadRadius3)
    ).apply(instance, IcicleConfiguration::new));
    public final TagKey<Block> replaceable;
    public final TagKey<Block> base;
    public final BlockStateProvider iceProvider;
    public final BlockStateProvider icicleProvider;
    public final IntProvider heightProvider;
    public final float chanceOfDirectionalSpread;
    public final float chanceOfSpreadRadius2;
    public final float chanceOfSpreadRadius3;

    public IcicleConfiguration(TagKey<Block> replaceable, TagKey<Block> base, BlockStateProvider iceProvider, BlockStateProvider icicleProvider, IntProvider heightProvider, float chanceOfDirectionalSpread, float chanceOfSpreadRadius2, float chanceOfSpreadRadius3) {
        this.replaceable = replaceable;
        this.base = base;
        this.iceProvider = iceProvider;
        this.icicleProvider = icicleProvider;
        this.heightProvider = heightProvider;
        this.chanceOfDirectionalSpread = chanceOfDirectionalSpread;
        this.chanceOfSpreadRadius2 = chanceOfSpreadRadius2;
        this.chanceOfSpreadRadius3 = chanceOfSpreadRadius3;
    }
}
