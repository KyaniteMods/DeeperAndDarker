package com.kyanite.deeperdarker.world.otherside.gen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class OthersideGeneration {
    public static final ResourceKey<LevelStem> OTHERSIDE_STEM = ResourceKey.create(Registries.LEVEL_STEM, DeeperDarker.rl("otherside"));
    public static void levelBootstrap(BootstrapContext<LevelStem> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> dimensions = context.lookup(Registries.DIMENSION_TYPE);

        context.register(OTHERSIDE_STEM, levelStem(biomes, noiseSettings, dimensions));
    }

    private static LevelStem levelStem(HolderGetter<Biome> biomes, HolderGetter<NoiseGeneratorSettings> noiseSettings, HolderGetter<DimensionType> dimensions) {
        NoiseBasedChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(
                Pair.of(Climate.parameters(-0.4f, -0.66f, 0, 0, 0, 0, 0), biomes.getOrThrow(OthersideBiomes.DEEPLANDS)),
                Pair.of(Climate.parameters(0.11f, 0.79f, 0, 0, 0, 0, 0), biomes.getOrThrow(OthersideBiomes.ECHOING_FOREST)),
                Pair.of(Climate.parameters(-0.55f, 0.4f, 0, 0, 0, 0, 0), biomes.getOrThrow(OthersideBiomes.BLOOMING_CAVERNS)),
                Pair.of(Climate.parameters(0.9f, 0.3f, 0, 0, 0, 0, 0), biomes.getOrThrow(OthersideBiomes.OVERCAST_COLUMNS))
        ))), noiseSettings.getOrThrow(OTHERSIDE_GENERATOR));
        return new LevelStem(dimensions.getOrThrow(OthersideDimension.OTHERSIDE), chunkGenerator);
    }

    public static final ResourceKey<NoiseGeneratorSettings> OTHERSIDE_GENERATOR = ResourceKey.create(Registries.NOISE_SETTINGS, DeeperDarker.rl("otherside"));
    public static void noiseBootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunction = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noise = context.lookup(Registries.NOISE);
        context.register(OTHERSIDE_GENERATOR, noiseSettings(densityFunction, noise));
    }

    private static NoiseGeneratorSettings noiseSettings(HolderGetter<DensityFunction> densityFunction, HolderGetter<NormalNoise.NoiseParameters> noise) {
        SurfaceRules.RuleSource bedrockFloor = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()));
        SurfaceRules.RuleSource bedrockRoof = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState()));
        SurfaceRules.RuleSource echoSoilLayer = SurfaceRules.ifTrue(SurfaceRules.isBiome(OthersideBiomes.ECHOING_FOREST), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR), SurfaceRules.state(DDBlocks.ECHO_SOIL.get().defaultBlockState())));
        SurfaceRules.RuleSource biomeSurfaceLayer = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR), SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(OthersideBiomes.BLOOMING_CAVERNS), SurfaceRules.state(DDBlocks.BLOOMING_SCULK_STONE.get().defaultBlockState())),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(OthersideBiomes.OVERCAST_COLUMNS), SurfaceRules.state(DDBlocks.GLOOMY_SCULK.get().defaultBlockState())),
                SurfaceRules.state(Blocks.SCULK.defaultBlockState())
        ));
        SurfaceRules.RuleSource deepslateFloor = SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(12)), SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)));
        SurfaceRules.RuleSource deepslateRoof = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("deepslate_roof", VerticalAnchor.belowTop(12), VerticalAnchor.top())), SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)));
        SurfaceRules.RuleSource gloomslate = SurfaceRules.ifTrue(SurfaceRules.isBiome(OthersideBiomes.OVERCAST_COLUMNS), SurfaceRules.state(DDBlocks.GLOOMSLATE.get().defaultBlockState()));

        return new NoiseGeneratorSettings(NoiseSettings.create(0, 128, 1, 2), DDBlocks.SCULK_STONE.get().defaultBlockState(), DDBlocks.SCULK_GRIME.get().defaultBlockState(), OthersideNoiseRouter.otherside(densityFunction, noise), SurfaceRules.sequence(bedrockFloor, bedrockRoof, echoSoilLayer, biomeSurfaceLayer, deepslateFloor, deepslateRoof, gloomslate), List.of(), 17, false, false, true, false);
    }
}
