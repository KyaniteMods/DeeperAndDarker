package com.kyanite.deeperdarker.registry.biomes;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDBiomes {
    public static DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, DeeperAndDarker.MOD_ID);

    public static RegistryObject<Biome> OTHERSIDE_LOWLAND = registerBiome("otherside_lowland", DDBiomes::lowland);

    public static RegistryObject<Biome> registerBiome(String biomeName, Supplier<Biome> biomeSupplier) {
        ResourceKey<Biome> biomeResourceKey = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, biomeName));
        return BIOMES.register(biomeResourceKey.location().getPath(), biomeSupplier);
    }

    public static Biome lowland() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_SOUL_FIRE);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x05625D)
                        .waterFogColor(0x05625D)
                        .fogColor(0x05625D)
                        .skyColor(0x05625D)
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
