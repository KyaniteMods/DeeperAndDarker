package com.kyanite.deeperdarker.datagen.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DDLootTableProvider extends LootTableProvider {
    public DDLootTableProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, Set.of(), List.of(new SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)), pRegistries);
    }
}
