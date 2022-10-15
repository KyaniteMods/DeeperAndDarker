package com.kyanite.deeperdarker.platform.fabric;

import com.kyanite.deeperdarker.fabric.client.warden_armor.WardenArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ClientHelperImpl {
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Item.Properties pProperties) {
        return () -> (T) new WardenArmorItem(pMaterial, pSlot, pProperties);
    }
}
