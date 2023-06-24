package com.kyanite.deeperdarker.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ClientHelper {
    @ExpectPlatform
    public static <T extends Item> Supplier<T> createArmorItem(ArmorMaterial pMaterial, ArmorItem.Type pSlot, Item.Properties pProperties) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> getElytraItem() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> getAncientChestItem() {
        throw new AssertionError();
    }
}
