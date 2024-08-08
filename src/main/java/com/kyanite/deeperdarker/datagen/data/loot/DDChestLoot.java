package com.kyanite.deeperdarker.datagen.data.loot;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDEnchantments;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public record DDChestLoot(HolderLookup.Provider registries) implements LootTableSubProvider {
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_BASEMENT = register("chests/ancient_temple_basement");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_SECRET = register("chests/ancient_temple_secret");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_STORAGE = register("chests/ancient_temple_storage");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_FOUNTAIN = register("chests/ancient_temple_fountain");
    public static final ResourceKey<LootTable> ANCIENT_TEMPLE_APEX = register("chests/ancient_temple_apex");
    public static final ResourceKey<LootTable> CRYSTALLIZED_AMBER = register("chests/crystallized_amber");

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pOutput) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        pOutput.accept(ANCIENT_TEMPLE_BASEMENT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(4, 6))
                        .add(loot(Blocks.SCULK, 32, 6, 8))
                        .add(loot(Blocks.SOUL_SOIL, 31, 3, 7))
                        .add(loot(DDItems.SOUL_DUST.get(), 31, 3, 7))
                        .add(loot(Items.ECHO_SHARD, 30, 4, 7))
                        .add(loot(DDItems.GRIME_BRICK.get(), 28, 5, 13))
                        .add(loot(Items.NAME_TAG, 26))
                        .add(loot(DDItems.SCULK_BONE.get(), 25, 2, 7))
                        .add(loot(Items.STRING, 20, 9, 16))
                        .add(loot(DDBlocks.CRYSTALLIZED_AMBER.get(), 18, 2, 5))
                        .add(loot(Items.IRON_INGOT, 16, 7, 14))
                        .add(loot(Items.GOLD_INGOT, 13, 7, 12))
                        .add(loot(Items.DIAMOND, 10, 3, 7))
                        .add(loot(Items.BOOK, 8, 1, 2).apply(EnchantRandomlyFunction.randomApplicableEnchantment(this.registries)))
                        .add(loot(Items.ENCHANTED_GOLDEN_APPLE, 3, 1, 2))
                        .add(loot(Items.MUSIC_DISC_OTHERSIDE, 2))
                        .add(loot(Items.BOOK, 1).apply(EnchantRandomlyFunction.randomEnchantment().withEnchantment(enchantments.getOrThrow(DDEnchantments.CATALYSIS))))
                        .add(loot(DDItems.WARDEN_CARAPACE.get(), 1, 1, 2))
                ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2))
                        .add(loot(Items.POTION, 10).apply(SetPotionFunction.setPotion(Potions.STRONG_STRENGTH)))
                        .add(loot(Items.IRON_LEGGINGS, 7).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(25, 35))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.2f, 0.5f))))
                        .add(loot(Items.IRON_SHOVEL, 7).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(15, 30))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.9f))))
                        .add(loot(Items.DIAMOND_BOOTS, 5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(25, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.1f, 0.2f))))
                        .add(loot(Items.IRON_HOE, 5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 40))))
                        .add(loot(Items.DIAMOND_SWORD, 4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.4f, 0.8f))))
                        .add(loot(Items.DIAMOND_HELMET, 3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(35, 50))))
                        .add(loot(Items.DIAMOND_HOE, 3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                        .add(loot(Items.DIAMOND_LEGGINGS, 3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.15f, 0.4f))))
                        .add(loot(Items.DIAMOND_AXE, 2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.7f))))
                        .add(loot(Items.DIAMOND_CHESTPLATE, 2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.7f))))
                )
        );

        pOutput.accept(ANCIENT_TEMPLE_SECRET, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 6))
                        .add(loot(Blocks.COBWEB, 97, 1, 2))
                        .add(loot(Items.ECHO_SHARD, 29, 1, 5))
                        .add(EmptyLootItem.emptyItem().setWeight(17))
                        .add(loot(Items.DIAMOND, 2, 2, 6))
                        .add(loot(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE.get(), 1))
                ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(loot(DDItems.SCULK_TRANSMITTER.get(), 1))
                )
        );

        pOutput.accept(ANCIENT_TEMPLE_STORAGE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3, 5))
                .add(loot(DDBlocks.SCULK_STONE.get(), 16, 1, 6))
                .add(loot(Blocks.COBBLESTONE, 16, 2, 8))
                .add(loot(DDBlocks.ECHO_LOG.get(), 13, 2, 8))
                .add(loot(Items.AMETHYST_SHARD, 11, 3, 6))
                .add(loot(Items.REDSTONE, 10, 3, 6))
                .add(loot(Items.LAPIS_LAZULI, 10, 1, 8))
                .add(loot(Items.RAW_IRON, 8, 1, 10))
                .add(loot(Items.RAW_COPPER, 8, 1, 10))
                .add(loot(Items.RAW_GOLD, 7, 1, 10))
                .add(loot(Items.EMERALD, 3, 1, 4))
                .add(loot(Items.DIAMOND, 3, 1, 4))
        ));

        pOutput.accept(ANCIENT_TEMPLE_FOUNTAIN, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(4, 6))
                .add(loot(Blocks.COBWEB, 33, 1, 6))
                .add(loot(Items.STRING, 31, 2, 10))
                .add(loot(Blocks.COBBLESTONE, 28, 3, 8))
                .add(loot(Blocks.SCULK, 25, 3, 10))
                .add(loot(Items.GOLD_INGOT, 16, 3, 8))
                .add(loot(Items.IRON_INGOT, 16, 4, 8))
                .add(loot(Items.REDSTONE, 14, 4, 9))
                .add(loot(Items.RAW_COPPER, 13, 2, 10))
                .add(loot(DDItems.SOUL_DUST.get(), 10, 2, 5))
                .add(loot(Items.GOLD_NUGGET, 9, 5, 17))
                .add(loot(Items.QUARTZ, 9, 1, 7))
                .add(loot(Items.DIAMOND, 8, 3, 6))
                .add(loot(Blocks.SCULK_SENSOR, 4, 1, 2))
                .add(loot(Blocks.SCULK_CATALYST, 3, 1, 2))
                .add(loot(Items.DIAMOND_SWORD, 1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 50))))
                .add(loot(DDItems.SOUL_CRYSTAL.get(), 1, 1, 2))
        ));

        pOutput.accept(ANCIENT_TEMPLE_APEX, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(5, 6))
                .add(loot(Blocks.SCULK, 41, 5, 8))
                .add(loot(DDItems.SCULK_BONE.get(), 40, 2, 6))
                .add(loot(Items.ECHO_SHARD, 40, 5, 9))
                .add(loot(DDItems.GRIME_BRICK.get(), 37, 7, 13))
                .add(loot(DDItems.GRIME_BALL.get(), 34, 8, 18))
                .add(loot(Blocks.TNT, 30, 4, 9))
                .add(loot(Items.FLINT, 30, 1, 6))
                .add(loot(Items.IRON_INGOT, 27, 4, 10))
                .add(loot(Items.QUARTZ, 22, 5, 13))
                .add(loot(Items.REDSTONE, 18, 3, 12))
                .add(loot(Items.DISC_FRAGMENT_5, 17, 1, 3))
                .add(loot(Items.LAPIS_LAZULI, 17, 7, 19))
                .add(loot(Items.DIAMOND, 17, 4, 8))
                .add(loot(Items.EMERALD, 15, 3, 9))
                .add(loot(DDBlocks.CRYSTALLIZED_AMBER.get(), 15, 1, 3))
                .add(loot(Blocks.SCULK_SENSOR, 12, 1, 3))
                .add(loot(Blocks.SCULK_CATALYST, 12, 1, 2))
                .add(loot(Items.IRON_HELMET, 5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                .add(loot(Items.IRON_SWORD, 5).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 40))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.3f, 0.6f))))
                .add(loot(Items.DIAMOND_BOOTS, 4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.4f, 0.7f))))
                .add(loot(Items.DIAMOND_HELMET, 4).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.8f, 1f))))
                .add(loot(Items.BOOK, 3, 1, 2).apply(EnchantRandomlyFunction.randomApplicableEnchantment(this.registries)))
                .add(loot(Items.DIAMOND_CHESTPLATE, 2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.6f, 0.9f))))
                .add(loot(Items.DIAMOND_LEGGINGS, 2).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(40, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.6f, 0.8f))))
                .add(loot(Items.ENCHANTED_GOLDEN_APPLE, 1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
                .add(loot(DDItems.WARDEN_CARAPACE.get(), 1).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(30, 50))).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))))
        ));

        pOutput.accept(CRYSTALLIZED_AMBER, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(loot(Items.GOLD_INGOT, 8))
                .add(loot(DDItems.SCULK_BONE.get(), 8))
                .add(loot(DDItems.SOUL_DUST.get(), 8))
                .add(loot(Items.IRON_INGOT, 7))
                .add(loot(Items.QUARTZ, 7))
                .add(loot(Items.AMETHYST_SHARD, 5))
                .add(loot(Items.DIAMOND, 4))
                .add(loot(Items.IRON_BOOTS, 4))
                .add(loot(Items.IRON_BOOTS, 3).apply(EnchantWithLevelsFunction.enchantWithLevels(this.registries, UniformGenerator.between(20, 30))))
                .add(loot(Items.EMERALD, 2))
                .add(loot(Items.DIAMOND_AXE, 1))
        ));
    }

    private static LootPoolSingletonContainer.Builder<?> loot(ItemLike item, int... val) {
        if (val.length > 1)
            return LootItem.lootTableItem(item).setWeight(val[0]).apply(SetItemCountFunction.setCount(UniformGenerator.between(val[1], val[2])));
        return LootItem.lootTableItem(item).setWeight(val[0]);
    }

    private static ResourceKey<LootTable> register(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, DeeperDarker.rl(name));
    }
}
