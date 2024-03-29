package com.kyanite.deeperdarker.datagen.data.loot;

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
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class DDEntityLoot extends EntityLootSubProvider {
    public DDEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        add(DDEntities.ANGLER_FISH.get(), LootTable.lootTable());
        add(DDEntities.SCULK_CENTIPEDE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.STRING)).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1)))));
        add(DDEntities.SCULK_LEECH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SCULK_SNAPPER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_DUST.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SHATTERED.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_BONE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
        add(DDEntities.SHRIEK_WORM.get(), LootTable.lootTable());
        add(DDEntities.STALKER.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SOUL_CRYSTAL.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))));
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return DDEntities.ENTITIES.getEntries().stream().map(RegistryObject::get);
    }
}
