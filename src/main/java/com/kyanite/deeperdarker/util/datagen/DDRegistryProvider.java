package com.kyanite.deeperdarker.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class DDRegistryProvider extends FabricDynamicRegistryProvider {
    public DDRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.BIOME));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.configuredCarvers());
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.CONFIGURED_FEATURE));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.DAMAGE_TYPE));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.DIMENSION_TYPE));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.LEVEL_STEM));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.NOISE_SETTINGS));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.placedFeatures());
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.PROCESSOR_LIST));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.STRUCTURE));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.STRUCTURE_SET));
        entries.addAll((HolderLookup.RegistryLookup<?>) entries.getLookup(Registries.TEMPLATE_POOL));
    }

    @Override
    public String getName() {
        return "Registries";
    }
}
