package com.kyanite.deeperdarker.forge.datagen.loot;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class DDEntityLoot extends EntityLootSubProvider {
    protected DDEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        add(DDEntities.SCULK_LEECH.get(), LootTable.lootTable());
        add(DDEntities.SCULK_SNAPPER.get(), LootTable.lootTable());
        add(DDEntities.SCULK_WORM.get(), LootTable.lootTable());
        add(DDEntities.STALKER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL.get()))));
        add(DDEntities.SCULK_CENTIPEDE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()))));
        add(DDEntities.SHATTERED.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get())).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.25f, 0.0375f))));
    }
}
