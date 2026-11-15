package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlockItems;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public final class DDArmorMaterials {
    public static final Holder<ArmorMaterial> LEAD = register("lead", Map.of(
            ArmorItem.Type.BOOTS, 2,
            ArmorItem.Type.LEGGINGS, 5,
            ArmorItem.Type.CHESTPLATE, 6,
            ArmorItem.Type.HELMET, 2
    ), 9, DDSounds.ARMOR_EQUIP_LEAD, () -> Ingredient.of(DDItems.LEAD_INGOT), 0.0f, 0.0f);
    public static final Holder<ArmorMaterial> RADIOACTIVE = register("radioactive", Map.of(
            ArmorItem.Type.BOOTS, 3,
            ArmorItem.Type.LEGGINGS, 6,
            ArmorItem.Type.CHESTPLATE, 8,
            ArmorItem.Type.HELMET, 3
    ), 11, DDSounds.ARMOR_EQUIP_RADIOACTIVE, () -> Ingredient.of(DDItems.RADIOACTIVE_INGOT), 2.0f, 1.0f);
    public static final Holder<ArmorMaterial> RESONARIUM = register("resonarium", Map.of(
            ArmorItem.Type.BOOTS, 2,
            ArmorItem.Type.LEGGINGS, 6,
            ArmorItem.Type.CHESTPLATE, 7,
            ArmorItem.Type.HELMET, 3
    ), 10, DDSounds.ARMOR_EQUIP_RESONARIUM, () -> Ingredient.of(DDItems.RESONARIUM), 1.0f, 0.0f);
    public static final Holder<ArmorMaterial> WARDEN = register("warden", Map.of(
            ArmorItem.Type.BOOTS, 4,
            ArmorItem.Type.LEGGINGS, 7,
            ArmorItem.Type.CHESTPLATE, 9,
            ArmorItem.Type.HELMET, 4
    ), 18, DDSounds.ARMOR_EQUIP_WARDEN, () -> Ingredient.of(DDItems.REINFORCED_ECHO_SHARD), 4.0f, 0.1f);
    public static final Holder<ArmorMaterial> GUARDIAN = register("warden", Map.of(
            ArmorItem.Type.BOOTS, 4,
            ArmorItem.Type.LEGGINGS, 7,
            ArmorItem.Type.CHESTPLATE, 9,
            ArmorItem.Type.HELMET, 4
    ), 22, DDSounds.ARMOR_EQUIP_GUARDIAN, () -> Ingredient.of(DDBlockItems.VIRTUE_SOUL), 6.0f, 0.2f);

    private static Holder<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance) {
        ArmorMaterial armorMaterial = new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, List.of(new ArmorMaterial.Layer(DeeperDarker.id(id))), toughness, knockbackResistance);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, DeeperDarker.id(id), armorMaterial);
    }
}
