package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class DDArmorMaterials extends ArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, DeeperDarker.MOD_ID);

    private static final EnumMap<ArmorItem.Type, Integer> WARDEN_DEFENSE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
        map.put(ArmorItem.Type.BODY, 11);
    });
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> WARDEN = ARMOR_MATERIALS.register("warden", () -> new ArmorMaterial(
            WARDEN_DEFENSE, 18, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD.get()), List.of(new ArmorMaterial.Layer(new ResourceLocation(DeeperDarker.MOD_ID, "warden"))), 4, 0.1f)
    );
}
