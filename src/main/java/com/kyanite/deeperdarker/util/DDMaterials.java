package com.kyanite.deeperdarker.util;

import com.google.common.collect.Maps;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class DDMaterials {
    public static class Tool {
        public static final ToolMaterial RESONARIUM = new ToolMaterial(
                DDTags.Blocks.INCORRECT_FOR_RESONARIUM_TOOL,
                1601,
                8.5f,
                3f,
                11,
                DDTags.Items.RESONARIUM_TOOL_MATERIALS
        );

        public static final ToolMaterial WARDEN = new ToolMaterial(
                DDTags.Blocks.INCORRECT_FOR_WARDEN_TOOL,
                2519,
                10f,
                5f,
                18,
                DDTags.Items.WARDEN_TOOL_MATERIALS
        );
    }

    public static class Armor {
        public static final ResourceKey<EquipmentAsset> RESONARIUM_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, DeeperDarker.rl("resonarium"));
        public static final ResourceKey<EquipmentAsset> WARDEN_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, DeeperDarker.rl("warden"));

        public static final ArmorMaterial RESONARIUM = new ArmorMaterial(
                30,
                makeDefense(3, 6, 8, 3, 11),
                10,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                2f,
                0f,
                DDTags.Items.REPAIRS_RESONARIUM_ARMOR,
                RESONARIUM_ASSET
        );

        public static final ArmorMaterial WARDEN = new ArmorMaterial(
                40,
                makeDefense(4, 7, 9, 4, 11),
                18,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                4f,
                0.1f,
                DDTags.Items.REPAIRS_WARDEN_ARMOR,
                WARDEN_ASSET
        );

        private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
            return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
        }
    }
}
