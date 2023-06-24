package com.kyanite.deeperdarker.platform.forge;

import com.kyanite.deeperdarker.forge.client.SoulElytraItem;
import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class ClientHelperImpl {
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, ArmorItem.Type pSlot, Item.Properties pProperties) {
        return () -> (T) new WardenArmorItem(pMaterial, pSlot, pProperties);
    }

    public static <T extends Item> Supplier<T> getElytraItem() {
        return () -> (T) new SoulElytraItem(new Item.Properties().durability(1500).rarity(Rarity.UNCOMMON).fireResistant());
    }
}
