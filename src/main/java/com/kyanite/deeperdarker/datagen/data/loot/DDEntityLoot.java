package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.content.DDEntities;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.stream.Stream;

public class DDEntityLoot extends EntityLoot {
    @Override
    protected void addTables() {
        /*add(DDEntities.SCULK_CENTIPEDE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.STRING)).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))));
        add(DDEntities.SCULK_LEECH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SCULK_SNAPPER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SHATTERED.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SHRIEK_WORM.get(), LootTable.lootTable());
        add(DDEntities.STALKER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));*/
    }

    @SuppressWarnings("unchecked")
    @Override
    protected @NotNull Iterable<EntityType<?>> getKnownEntities() {
        Stream<? extends EntityType<?>> stream = DDEntities.ENTITIES.getEntries().stream().map(RegistryObject::get);
        return () -> (Iterator<EntityType<?>>) stream.iterator();
    }
}
