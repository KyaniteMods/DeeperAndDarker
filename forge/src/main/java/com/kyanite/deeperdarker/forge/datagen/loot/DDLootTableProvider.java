package com.kyanite.deeperdarker.forge.datagen.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class DDLootTableProvider extends LootTableProvider {
    private final List<SubProviderEntry> lootTables = List.of(new LootTableProvider.SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY));

    public DDLootTableProvider(PackOutput output) {
        super(output, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(DDBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(DDChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(DDEntityLoot::new, LootContextParamSets.ENTITY)));
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext context) {
        map.forEach((id, table) -> LootTables.validate(context, id, table));
    }
}
