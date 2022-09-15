package com.kyanite.deeperdarker.forge.datagen.loot;

import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class DDEntityLoot extends EntityLoot {
    @Override
    protected void addTables() {
        add(DDEntities.SCULK_LEECH, LootTable.lootTable());
        add(DDEntities.SCULK_SNAPPER, LootTable.lootTable());
        add(DDEntities.SCULK_WORM, LootTable.lootTable());
        add(DDEntities.SHATTERED, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST)).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.25f, 0.0375f))));
    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return DDEntities.ENTITIES.values().stream()::iterator;
    }
}
