package com.kyanite.deeperdarker.registry.world.biomes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.BuiltinRegistries;
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

import java.util.function.Supplier;

public class OthersideBiomes {
    public static final ResourceKey<Biome> OTHERSIDE_DEEPLANDS  = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside_deeplands"));
    public static final ResourceKey<Biome> ECHOING_FOREST  = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "echoing_forest"));

    public static void createBiomes() {
        PlatformHelper.registerBiome(OTHERSIDE_DEEPLANDS.location(), deeplands());
        PlatformHelper.registerBiome(ECHOING_FOREST.location(), forest());
    }

    public static Biome forest() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED, 20, 0, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.ECHO_SAND));
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_JAW));
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.ECHO_TREE_SPAWN));

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
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER, 12, 5,8));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 3, 0, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_JAW));
        addSculkDecoration(biomeBuilder);
        addSculkOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.OTHERSIDE_PILLAR));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_VINES));
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(DDPlacedFeatures.SCULK_GLEAM));

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
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_COAL_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_IRON_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_COPPER_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_GOLD_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_REDSTONE_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_EMERALD_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_LAPIS_ORE));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(DDPlacedFeatures.SCULK_DIAMOND_ORE));
    }

    public static void addSculkDecoration(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.SCULK));
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, Holder.direct(DDPlacedFeatures.INFESTED_SCULK));
    }

}
