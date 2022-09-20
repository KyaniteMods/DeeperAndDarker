package com.kyanite.deeperdarker.registry.world.biomes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OthersideBiomes {
    public static final ResourceKey<Biome> OTHERSIDE_DEEPLANDS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside_deeplands"));
    public static final ResourceKey<Biome> ECHOING_FOREST = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "echoing_forest"));
    public static final ResourceKey<Biome> BLOOMING_CAVERNS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "blooming_caverns"));
    public static final ResourceKey<Biome> OVERCAST_COLUMNS = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "overcast_columns"));

    public static void createBiomes() {
        RegistryHelper.registerBiome(OTHERSIDE_DEEPLANDS.location(), OthersideBiomes::deeplands);
        RegistryHelper.registerBiome(ECHOING_FOREST.location(), OthersideBiomes::forest);
        RegistryHelper.registerBiome(BLOOMING_CAVERNS.location(), OthersideBiomes::caverns);
        RegistryHelper.registerBiome(OVERCAST_COLUMNS.location(), OthersideBiomes::columns);
    }

    public static Biome columns() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 5, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);

        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);
        BiomeDefaultFeatures.addSculk(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(0.7f)
                .downfall(0.2f)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0xcc9b33)
                        .waterFogColor(0xa88539)
                        .fogColor(0xd19f4f)
                        .skyColor(0x8f6014)
                        .ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome caverns() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        addSculkOres(biomeBuilder);
        addSculkDecoration(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.OTHERSIDE_PILLAR.get()));
        BiomeDefaultFeatures.addSculk(biomeBuilder);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(1f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x56dbd7)
                        .waterFogColor(0x6bc7d1)
                        .fogColor(0x08bcc2)
                        .skyColor(0x22d0e3)
                        .ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome forest() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED.get(), 20, 0, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.ECHO_SAND.get()));
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_JAW.get()));
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_TENDRILS.get()));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.ECHO_TREE_SPAWN.get()));

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(1.2f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x1e055d)
                        .waterFogColor(0x1d1352)
                        .fogColor(0x61519c)
                        .skyColor(0x54458c)
                        .ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.055f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static Biome deeplands() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 12, 5, 8));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 0, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_JAW.get()));
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);

        BiomeDefaultFeatures.addSculk(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.OTHERSIDE_PILLAR.get()));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_VINES.get()));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_GLEAM.get()));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_TENDRILS.get()));

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(0.3f)
                .downfall(0f)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x05305d)
                        .waterFogColor(0x0c2a57)
                        .fogColor(0x046b5d)
                        .skyColor(0x0b364a)
                        .ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static void addSculkOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_COAL_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_IRON_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_COPPER_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_GOLD_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_REDSTONE_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_EMERALD_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_LAPIS_ORE.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_DIAMOND_ORE.get()));
    }

    public static void addSculkDecoration(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK.get()));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.INFESTED_SCULK.get()));
    }
}
