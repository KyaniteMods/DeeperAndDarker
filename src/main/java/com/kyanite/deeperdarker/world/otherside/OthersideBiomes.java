package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
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
    public static final ResourceKey<Biome> DEEPLANDS = registerKey("deeplands");
    public static final ResourceKey<Biome> ECHOING_FOREST = registerKey("echoing_forest");
    public static final ResourceKey<Biome> OVERCAST_COLUMNS = registerKey("overcast_columns");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(DEEPLANDS, deeplands(placedFeatures, worldCarvers));
        context.register(ECHOING_FOREST, echoingForest(placedFeatures, worldCarvers));
        context.register(OVERCAST_COLUMNS, overcastColumns(placedFeatures, worldCarvers));
    }

    private static Biome deeplands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(-0.25f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x13256b)
                        .waterFogColor(0x132052)
                        .fogColor(0x1f2e59)
                        .skyColor(calculateSkyColor(-0.25f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    private static Biome echoingForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.275f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x42136b)
                        .waterFogColor(0x39195e)
                        .fogColor(0x391d4f)
                        .skyColor(calculateSkyColor(0.275f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    private static Biome overcastColumns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        generationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.4f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x452312)
                        .waterFogColor(0x362319)
                        .fogColor(0x472918)
                        .skyColor(calculateSkyColor(0.4f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(generationSettings.build()).build();
    }

    protected static int calculateSkyColor(float temp) {
        float s = temp / 3f;
        s = Mth.clamp(s, -1, 1);
        return Mth.hsvToRgb(0.62222224f - s * 0.05f, 0.5f + s * 0.1f, 1f);
    }

    public static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
