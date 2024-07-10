package com.kyanite.deeperdarker.datagen.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DDLootTableProvider extends LootTableProvider {
    public DDLootTableProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, BuiltInLootTables.all(), List.of(new SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)), pRegistries);
    }

    @Override
    protected void validate(WritableRegistry<LootTable> registry, ValidationContext context, ProblemReporter.Collector collector) {
        registry.holders().forEach(lootTable -> lootTable.value().validate(context.setParams(lootTable.value().getParamSet()).enterElement("{" + lootTable.key().location() + "}", lootTable.key())));
    }
}
