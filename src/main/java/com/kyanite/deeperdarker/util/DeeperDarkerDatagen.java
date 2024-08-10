package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.content.DDEnchantments;
import com.kyanite.deeperdarker.util.datagen.*;
import com.kyanite.deeperdarker.util.datagen.loot.DDBlockLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.loot.DDEntityLootTableProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DDBlockTagProvider;
import com.kyanite.deeperdarker.util.datagen.tags.DDItemTagProvider;
import com.kyanite.deeperdarker.world.DDCarvers;
import com.kyanite.deeperdarker.world.DDConfiguredFeatures;
import com.kyanite.deeperdarker.world.DDPlacedFeatures;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.kyanite.deeperdarker.world.otherside.gen.OthersideGeneration;
import com.kyanite.deeperdarker.world.otherside.structures.DDPools;
import com.kyanite.deeperdarker.world.otherside.structures.DDProcessorLists;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructureSets;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.dimension.LevelStem;

public class DeeperDarkerDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        DynamicRegistries.register(Registries.LEVEL_STEM, LevelStem.CODEC);
        pack.addProvider(DDRegistryProvider::new);
        pack.addProvider(DDRecipeProvider::new);
        pack.addProvider(DDModelProvider::new);
        pack.addProvider(DDBlockLootTableProvider::new);
        pack.addProvider(DDBlockTagProvider::new);
        pack.addProvider(DDItemTagProvider::new);
        pack.addProvider(DDENLanguageProvider::new);
        pack.addProvider(DDEntityLootTableProvider::new);
        pack.addProvider(DDAdvancementProvider::new);
        pack.addProvider(DDChestLootTableProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.BIOME, OthersideBiomes::bootstrap)
                .add(Registries.CONFIGURED_CARVER, DDCarvers::bootstrap)
                .add(Registries.CONFIGURED_FEATURE, DDConfiguredFeatures::bootstrap)
                .add(Registries.DAMAGE_TYPE, DDDamageTypes::bootstrap)
                .add(Registries.DIMENSION_TYPE, OthersideDimension::bootstrap)
                .add(Registries.LEVEL_STEM, OthersideGeneration::levelBootstrap)
                .add(Registries.NOISE_SETTINGS, OthersideGeneration::noiseBootstrap)
                .add(Registries.PLACED_FEATURE, DDPlacedFeatures::bootstrap)
                .add(Registries.PROCESSOR_LIST, DDProcessorLists::bootstrap)
                .add(Registries.STRUCTURE, DDStructures::bootstrap)
                .add(Registries.STRUCTURE_SET, DDStructureSets::bootstrap)
                .add(Registries.TEMPLATE_POOL, DDPools::bootstrap);
    }
}
