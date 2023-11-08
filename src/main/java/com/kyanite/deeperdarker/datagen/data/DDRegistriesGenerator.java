package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDDamageTypes;
import com.kyanite.deeperdarker.world.DDConfiguredFeatures;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.structures.DDPools;
import com.kyanite.deeperdarker.world.structures.DDProcessorLists;
import com.kyanite.deeperdarker.world.structures.DDStructureSets;
import com.kyanite.deeperdarker.world.structures.DDStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DDRegistriesGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.BIOME, OthersideBiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, DDConfiguredFeatures::bootstrap).add(Registries.DAMAGE_TYPE, DDDamageTypes::bootstrap).add(Registries.DIMENSION_TYPE, OthersideDimension::bootstrap).add(Registries.PLACED_FEATURE, DDPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, DDProcessorLists::bootstrap).add(Registries.STRUCTURE, DDStructures::bootstrap).add(Registries.STRUCTURE_SET, DDStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, DDPools::bootstrap);

    public DDRegistriesGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DeeperDarker.MOD_ID));
    }
}
