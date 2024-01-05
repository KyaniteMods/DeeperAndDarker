package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OthersideBiomes {
    public static final ResourceKey<Biome> DEEPLANDS = createKey("deeplands");
    public static final ResourceKey<Biome> ECHOING_FOREST = createKey("echoing_forest");
    public static final ResourceKey<Biome> BLOOMING_CAVERNS = createKey("blooming_caverns");
    public static final ResourceKey<Biome> OVERCAST_COLUMNS = createKey("overcast_columns");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }

    private static Biome deeplands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_CENTIPEDE, 6, 1, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER, 11, 3, 6));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED, 5, 2, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 2, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_STONE_COLUMN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_GLEAM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SURFACE_SCULK_STONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_DECORATION);
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(-0.5f)
                .downfall(-0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x13256b)
                        .waterFogColor(0x132052)
                        .fogColor(0x141c33)
                        .skyColor(calculateSkyColor(-0.5f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS, 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_ARRIVAL)).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static Biome echoingForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER, 9, 1, 2));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED, 17, 2, 5));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_GLEAM_FOREST);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SURFACE_GLOOMSLATE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.ECHO_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.ECHO_SOIL);
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.3f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x42136b)
                        .waterFogColor(0x39195e)
                        .fogColor(0x301a40)
                        .skyColor(calculateSkyColor(0.3f))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.04f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS, 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_ECHOING_FOREST)).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static Biome bloomingCaverns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER, 1, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.BLOOMING_WATER_EDGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.BLOOMING_SCULK_VEGETATION);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.BLOOMING_MOSS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.BLOOMING_PLANT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.GLOWING_ROOTS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.GLOWING_VINES);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.GLOWING_VINES_SHORT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_VINES_CAVERNS);
        addSculkOres(biomeBuilder);

        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(-0.3f)
                .downfall(0.2f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x27b0d9)
                        .waterFogColor(0x216888)
                        .fogColor(0x1a2f40)
                        .skyColor(calculateSkyColor(-0.3f))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SCULK_CHARGE_POP, 0.002f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS, 6000, 8, 2))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_ECHOING_FOREST)).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static Biome overcastColumns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.GLOOMSLATE_COLUMN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.GLOOMY_SCULK_VEGETATION);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMY_SCULK);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SOUL_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SOUL_SOIL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_COAL);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_IRON);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_COPPER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_GOLD);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_REDSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_EMERALD);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_LAPIS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_DIAMOND);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.6f)
                .downfall(0.2f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x452312)
                        .waterFogColor(0x362319)
                        .fogColor(0x472918)
                        .skyColor(calculateSkyColor(0.6f))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.026f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS, 6000, 8, 2.0D))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_OVERCAST_COLUMNS)).build())
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .generationSettings(biomeBuilder.build()).build();
    }

    public static void addSculkDecoration(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_TENDRILS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_VINES);
    }

    public static void addSculkOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.INFESTED_SCULK);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_JAW);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COAL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_IRON);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_GOLD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_REDSTONE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_EMERALD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_LAPIS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_DIAMOND);
    }

    private static int calculateSkyColor(float temp) {
        float s = temp / 3f;
        s = Mth.clamp(s, -1, 1);
        return Mth.hsvToRgb(0.62222224f - s * 0.05f, 0.5f + s * 0.1f, 1f);
    }
}
