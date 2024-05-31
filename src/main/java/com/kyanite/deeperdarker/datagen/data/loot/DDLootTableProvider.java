package com.kyanite.deeperdarker.datagen.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DDLootTableProvider extends LootTableProvider {
    public DDLootTableProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)), pRegistries);
    }
}
