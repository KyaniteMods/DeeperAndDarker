package com.kyanite.deeperdarker.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ClientHelper {
    @ExpectPlatform
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Item.Properties pProperties) {
        throw new AssertionError();
    }
}
