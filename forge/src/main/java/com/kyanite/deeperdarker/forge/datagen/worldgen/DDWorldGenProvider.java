package com.kyanite.deeperdarker.forge.datagen.worldgen;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DDWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, GeodePlusConfiguredFeatureRegistry::bootstrap)
            .add(Registries.PLACED_FEATURE, GeodePlusPlacedFeatureRegistry::bootstrap);

    public DDWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, Set<String> modIds) {
        super(output, registries, BUILDER, Set.of(DeeperAndDarker.MOD_ID));
    }
}
