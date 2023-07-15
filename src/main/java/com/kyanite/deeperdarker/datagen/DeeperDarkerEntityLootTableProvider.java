package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class DeeperDarkerEntityLootTableProvider extends SimpleFabricLootTableProvider {

    public DeeperDarkerEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(id("sculk_snapper"), new LootTable.Builder().pool(
                LootPool.builder().with(ItemEntry.builder(DeeperDarkerItems.SOUL_DUST)).apply(SetCountLootFunction.builder(
                        ConstantLootNumberProvider.create(1.0f))).apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)))).randomSequenceId(randomSequenceId("sculk_snapper")));
        exporter.accept(id("shattered"), new LootTable.Builder().pool(
                LootPool.builder().with(ItemEntry.builder(DeeperDarkerItems.SCULK_BONE)).apply(SetCountLootFunction.builder(
                        UniformLootNumberProvider.create(1.0f, 3.0f))).apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0f, 1.0f)))).randomSequenceId(randomSequenceId("shattered")));
    }

    private static Identifier id(String entity) {
        return new Identifier(DeeperDarker.MOD_ID, entity).withPrefixedPath("entity/");
    }

    private static Identifier randomSequenceId(String entity) {
        return new Identifier(DeeperDarker.MOD_ID, entity).withPrefixedPath("entities/");
    }
}
