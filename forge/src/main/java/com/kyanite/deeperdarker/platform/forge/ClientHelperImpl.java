package com.kyanite.deeperdarker.platform.forge;

import com.kyanite.deeperdarker.forge.client.warden_armor.WardenArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ClientHelperImpl {
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Item.Properties pProperties) {
        return () -> (T) new WardenArmorItem(pMaterial, pSlot, pProperties);
    }
}
