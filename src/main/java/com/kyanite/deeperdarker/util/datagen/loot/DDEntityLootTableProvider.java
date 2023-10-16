package com.kyanite.deeperdarker.util.datagen.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class DDEntityLootTableProvider extends SimpleFabricLootTableProvider {

    public DDEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextParamSets.ENTITY);
    }

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        biConsumer.accept(id("sculk_centipede"), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.STRING)).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))));
        biConsumer.accept(id("sculk_leech"), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(id("sculk_snapper"), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(id("shattered"), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        biConsumer.accept(id("shriek_worm"), LootTable.lootTable());
        biConsumer.accept(id("stalker"), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
    }

    private static ResourceLocation id(String entity) {
        return new ResourceLocation(DeeperDarker.MOD_ID, entity).withPrefix("entities/");
    }
}
