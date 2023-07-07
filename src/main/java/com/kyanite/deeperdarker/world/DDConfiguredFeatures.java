package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class DDConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_VEGETATION = registerKey("gloomy_sculk_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOOMY_SCULK_BONEMEAL = registerKey("gloomy_sculk_bonemeal");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> feature = context.lookup(Registries.CONFIGURED_FEATURE);

        FeatureUtils.register(context, GLOOMY_SCULK_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DDBlocks.GLOOMY_GRASS.get().defaultBlockState(), 9).add(DDBlocks.GLOOMY_CACTUS.get().defaultBlockState(), 1))));
        FeatureUtils.register(context, GLOOMY_SCULK_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DDTags.Blocks.GLOOMY_SCULK_REPLACEABLE, BlockStateProvider.simple(DDBlocks.GLOOMY_SCULK.get()), PlacementUtils.inlinePlaced(feature.getOrThrow(GLOOMY_SCULK_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0, 2, 0.2f, UniformInt.of(1, 2), 0.7f));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
