package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
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

    public static ResourceKey<Biome> registerKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }

    private static Biome deeplands(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        addSculkOres(biomeBuilder);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(-0.5f)
                .downfall(-0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x13256b)
                        .waterFogColor(0x132052)
                        .fogColor(0x141c33)
                        .skyColor(calculateSkyColor(-0.5f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static Biome echoingForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        addSculkOres(biomeBuilder);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.3f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x42136b)
                        .waterFogColor(0x39195e)
                        .fogColor(0x301a40)
                        .skyColor(calculateSkyColor(0.3f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static Biome overcastColumns(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 8, 2, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 1, 3));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);

        Music music = Musics.createGameMusic(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP);
        return (new Biome.BiomeBuilder()).hasPrecipitation(true)
                .temperature(0.6f)
                .downfall(0.2f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x452312)
                        .waterFogColor(0x362319)
                        .fogColor(0x472918)
                        .skyColor(calculateSkyColor(0.6f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .backgroundMusic(music).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static void addSculkOres(BiomeGenerationSettings.Builder builder) {
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
