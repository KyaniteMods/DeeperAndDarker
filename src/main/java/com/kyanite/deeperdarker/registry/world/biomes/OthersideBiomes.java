package com.kyanite.deeperdarker.registry.world.biomes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OthersideBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<Biome> OTHERSIDE_LOWLAND = registerBiome("otherside_lowland", OthersideBiomes::lowland);

    public static final RegistryObject<Biome> ECHOING_FOREST = registerBiome("echoing_forest", OthersideBiomes::forest);

    public static RegistryObject<Biome> registerBiome(String name, Supplier<Biome> biomeSupplier) {
        ResourceKey<Biome> biomeResourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        return BIOMES.register(biomeResourceKey.location().getPath(), biomeSupplier);
    }

    public static Biome forest() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SHATTERED.get(), 20, 0, 1));

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_JAW.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.ECHO_SAND.getHolder().get());

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COAL_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_IRON_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COPPER_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_GOLD_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_REDSTONE_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_EMERALD_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_LAPIS_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_DIAMOND_ORE.getHolder().get());

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.ECHO_TREE_PLACED.getHolder().get());

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);


        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x05305D)
                        .waterFogColor(0x05285D)
                        .fogColor(0x61519c)
                        .skyColor(0x61519c)
                        .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.055F))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES))
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome lowland() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(DDEntities.SCULK_SNAPPER.get(), 50, 6,9));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 12, 0, 2));

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK_JAW.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.INFESTED_SCULK.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DDPlacedFeatures.SCULK.getHolder().get());

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COAL_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_IRON_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_COPPER_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_GOLD_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_REDSTONE_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_EMERALD_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_LAPIS_ORE.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DDPlacedFeatures.SCULK_DIAMOND_ORE.getHolder().get());

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_VINES.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.OTHERSIDE_PILLAR.getHolder().get());
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DDPlacedFeatures.SCULK_GLEAM.getHolder().get());

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x05305D)
                        .waterFogColor(0x05285D)
                        .fogColor(0x046b5d)
                        .skyColor(0x05385C)
                        .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES))
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
