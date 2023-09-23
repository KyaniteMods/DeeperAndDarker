package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class OthersideBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DeeperDarker.MOD_ID);

    public static final RegistryObject<Biome> DEEPLANDS = BIOMES.register("deeplands", OthersideBiomes::deeplands);
    public static final RegistryObject<Biome> ECHOING_FOREST = BIOMES.register("echoing_forest", OthersideBiomes::echoingForest);
    public static final RegistryObject<Biome> OVERCAST_COLUMNS = BIOMES.register("overcast_columns", OthersideBiomes::overcastColumns);

    public static Biome deeplands() {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_CENTIPEDE.get(), 6, 1, 4));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 11, 3, 6));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 2, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_STONE_COLUMN.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_GLEAM.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SURFACE_SCULK_STONE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_DECORATION.getHolder().get());
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE)
                .temperature(-0.5f)
                .downfall(-0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x13256b)
                        .waterFogColor(0x132052)
                        .fogColor(0x141c33)
                        .skyColor(calculateSkyColor(-0.5f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS.get(), 6000, 8, 2))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_DEEPLANDS.get())).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome echoingForest() {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 9, 1, 2));
        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED.get(), 17, 2, 5));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_GLEAM_FOREST.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.ECHO_TREE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.ECHO_SOIL.getHolder().get());
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE)
                .temperature(0.3f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x42136b)
                        .waterFogColor(0x39195e)
                        .fogColor(0x301a40)
                        .skyColor(calculateSkyColor(0.3f))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.04f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS.get(), 6000, 8, 2))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_ECHOING_FOREST.get())).build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome overcastColumns() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.GLOOMSLATE_COLUMN.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SURFACE_GLOOMSLATE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.GLOOMY_SCULK_VEGETATION.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMY_SCULK.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.MAGMA.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SOUL_SAND.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SOUL_SOIL.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_COAL.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_IRON.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_COPPER.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_GOLD.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_REDSTONE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_EMERALD.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_LAPIS.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.GLOOMSLATE_DIAMOND.getHolder().get());
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE)
                .temperature(0.6f)
                .downfall(0.2f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x452312)
                        .waterFogColor(0x362319)
                        .fogColor(0x472918)
                        .skyColor(calculateSkyColor(0.6f))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.026f))
                        .ambientMoodSound(new AmbientMoodSettings(DDSounds.AMBIENT_OTHERSIDE_ADDITIONS.get(), 6000, 8, 2))
                        .backgroundMusic(Musics.createGameMusic(DDSounds.MUSIC_BIOME_OVERCAST_COLUMNS.get())).build())
                .mobSpawnSettings(MobSpawnSettings.EMPTY)
                .generationSettings(biomeBuilder.build()).build();
    }

    public static void addSculkDecoration(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_TENDRILS.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_VINES.getHolder().get());
    }

    public static void addSculkOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.INFESTED_SCULK.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_JAW.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COAL.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_IRON.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COPPER.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_GOLD.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_REDSTONE.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_EMERALD.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_LAPIS.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_DIAMOND.getHolder().get());
    }

    private static int calculateSkyColor(float temp) {
        float s = temp / 3f;
        s = Mth.clamp(s, -1, 1);
        return Mth.hsvToRgb(0.62222224f - s * 0.05f, 0.5f + s * 0.1f, 1f);
    }
}
