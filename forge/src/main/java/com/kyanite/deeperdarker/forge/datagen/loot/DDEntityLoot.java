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
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class DDEntityLoot extends EntityLoot {
    @Override
    protected void addTables() {
        add(DDEntities.SCULK_LEECH.get(), LootTable.lootTable());
        add(DDEntities.SCULK_SNAPPER.get(), LootTable.lootTable());
        add(DDEntities.SCULK_WORM.get(), LootTable.lootTable());
        add(DDEntities.SHATTERED.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get())).when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.25f, 0.0375f))));
    }

    @NotNull
    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        Stream<? extends EntityType<?>> stream = DDEntities.ENTITIES.values().stream().map(Supplier::get);
        return () -> (Iterator<EntityType<?>>) stream.iterator();
    }
}
