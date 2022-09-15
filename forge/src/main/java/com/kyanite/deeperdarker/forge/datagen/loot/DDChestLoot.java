package com.kyanite.deeperdarker.forge.datagen.loot;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class DDChestLoot extends ChestLoot {
    public static final ResourceLocation ANCIENT_TEMPLE = new ResourceLocation(DeeperAndDarker.MOD_ID, "chests/ancient_temple");
    public static final ResourceLocation ANCIENT_TEMPLE_PORTAL = new ResourceLocation(DeeperAndDarker.MOD_ID, "chests/ancient_temple_portal");

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ANCIENT_TEMPLE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(5, 10))
                        .add(LootItem.lootTableItem(Items.DIAMOND_HOE).setWeight(2).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.9f))).apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(30, 50)).allowTreasure()))
                        .add(LootItem.lootTableItem(Items.DIAMOND_LEGGINGS).setWeight(1).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.5f, 0.8f))).apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(30, 50)).allowTreasure()))
                        .add(LootItem.lootTableItem(Items.IRON_LEGGINGS).setWeight(3).apply(SetItemDamageFunction.setDamage(UniformGenerator.between(0.4f, 0.9f))).apply(EnchantWithLevelsFunction.enchantWithLevels(UniformGenerator.between(20, 39)).allowTreasure()))
                        .add(LootItem.lootTableItem(Items.POTION).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))).apply(SetPotionFunction.setPotion(Potions.STRONG_REGENERATION)))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(5).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Enchantments.SWIFT_SNEAK)))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(6).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 13))))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 7))))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 14))))
                        .add(LootItem.lootTableItem(Blocks.CANDLE).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(7).apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 14))))
                        .add(LootItem.lootTableItem(Items.COMPASS).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(Items.DISC_FRAGMENT_5).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.ECHO_SHARD).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(Items.EXPERIENCE_BOTTLE).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.GLOW_BERRIES).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 15))))
                        .add(LootItem.lootTableItem(Blocks.SCULK).setWeight(4).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 10))))
                        .add(LootItem.lootTableItem(Blocks.SCULK_CATALYST).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        .add(LootItem.lootTableItem(Blocks.SCULK_SENSOR).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        .add(LootItem.lootTableItem(Items.SOUL_TORCH).setWeight(6).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 16))))
                        .add(LootItem.lootTableItem(Items.DIAMOND_HORSE_ARMOR).setWeight(2))
                        .add(LootItem.lootTableItem(Items.LEAD).setWeight(2))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_13).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_CAT).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MUSIC_DISC_OTHERSIDE).setWeight(1))
                        .add(LootItem.lootTableItem(Items.NAME_TAG).setWeight(3))
                        .add(LootItem.lootTableItem(Items.SADDLE).setWeight(3))
                        .add(LootItem.lootTableItem(DDItems.WARDEN_CARAPACE).setWeight(1))
                ));

        consumer.accept(ANCIENT_TEMPLE_PORTAL, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(DDItems.SCULK_TRANSMITTER))).withPool(LootPool.lootPool().setRolls(UniformGenerator.between(5, 10)).add(LootItem.lootTableItem(Blocks.COBWEB))));
    }
}
