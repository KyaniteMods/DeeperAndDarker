package com.kyanite.deeperdarker.platform.fabric;

import com.kyanite.deeperdarker.fabric.client.SoulElytraItem;
import com.kyanite.deeperdarker.fabric.client.warden_armor.WardenArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Supplier;

public class ClientHelperImpl {
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, ArmorItem.Type pType, Item.Properties pProperties) {
        return () -> (T) new WardenArmorItem(pMaterial, pType, pProperties);
    }

    public static <T extends Item> Supplier<T> getElytraItem() {
        return () -> (T) new SoulElytraItem(new FabricItemSettings().maxDamage(1500).rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.CHEST));
    }
}
