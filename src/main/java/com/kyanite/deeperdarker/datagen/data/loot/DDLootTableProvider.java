package com.kyanite.deeperdarker.datagen.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class DDLootTableProvider extends LootTableProvider {
    public DDLootTableProvider(PackOutput pOutput) {
        super(pOutput, Set.of(), List.of(new LootTableProvider.SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)));
    }
}
