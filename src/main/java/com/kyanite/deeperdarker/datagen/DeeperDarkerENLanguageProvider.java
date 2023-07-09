package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItemGroups;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Util;

public class DeeperDarkerENLanguageProvider extends FabricLanguageProvider {
    protected DeeperDarkerENLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.deeperdarker", "Deeper and Darker");
        translationBuilder.add(DeeperDarkerItems.WARDEN_HELMET, "Warden Helmet");
        translationBuilder.add(DeeperDarkerItems.WARDEN_CHESTPLATE, "Warden Chestplate");
        translationBuilder.add(DeeperDarkerItems.WARDEN_LEGGINGS, "Warden Leggings");
        translationBuilder.add(DeeperDarkerItems.WARDEN_BOOTS, "Warden Boots");
        translationBuilder.add(DeeperDarkerItems.WARDEN_SWORD, "Warden Sword");
        translationBuilder.add(DeeperDarkerItems.WARDEN_PICKAXE, "Warden Pickaxe");
        translationBuilder.add(DeeperDarkerItems.WARDEN_AXE, "Warden Axe");
        translationBuilder.add(DeeperDarkerItems.WARDEN_SHOVEL, "Warden Shovel");
        translationBuilder.add(DeeperDarkerItems.WARDEN_HOE, "Warden Hoe");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.applies_to", "Netherite Equipment");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.ingredients", "Reinforced Echo Shard");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.base_slot_description", "Add netherite armor, weapon, or tool");
        translationBuilder.add("item.deeperdarker.smithing_template.warden_upgrade.additions_slot_description", "Add Reinforced Echo Shard");
        translationBuilder.add("upgrade.deeperdarker.warden_upgrade", "Warden Upgrade");
        translationBuilder.add(DeeperDarkerItems.REINFORCED_ECHO_SHARD, "Reinforced Echo Shard");
        translationBuilder.add(DeeperDarkerItems.WARDEN_CARAPACE, "Warden Carapace");
        translationBuilder.add(DeeperDarkerItems.HEART_OF_THE_DEEP, "Heart of the Deep");
        translationBuilder.add(DeeperDarkerItems.SOUL_CRYSTAL, "Soul Crystal");
        translationBuilder.add(DeeperDarkerItems.SOUL_DUST, "Soul Dust");
        translationBuilder.add(DeeperDarkerItems.SCULK_BONE, "Sculk Bone");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_LOG, "Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_WOOD, "Echo Wood");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, "Stripped Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD, "Stripped Echo Wood");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_BUTTON, "Echo Button");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_DOOR, "Echo Door");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_FENCE_GATE, "Echo Fence Gate");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_FENCE, "Echo Fence");
        translationBuilder.add(Util.createTranslationKey("block", Registries.BLOCK.getId(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN)), "Echo Wall Hanging Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_HANGING_SIGN, "Echo Hanging Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_LEAVES, "Echo Leaves");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_PLANKS, "Echo Planks");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE, "Echo Pressure Plate");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SAPLING, "Echo Sapling");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SIGN, "Echo Sign");
        translationBuilder.add(Util.createTranslationKey("block", Registries.BLOCK.getId(DeeperDarkerBlocks.ECHO_WALL_SIGN)), "Echo Wall Sign");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_SLAB, "Echo Slab");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_TRAPDOOR, "Echo Trapdoor");
    }
}