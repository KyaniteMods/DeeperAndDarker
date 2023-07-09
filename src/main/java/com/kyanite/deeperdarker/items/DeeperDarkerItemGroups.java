package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.itemgroup.ItemGroupsMixin;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DeeperDarkerItemGroups {
    public static final ItemGroup DEEPER_AND_DARKER = Registry.register(Registries.ITEM_GROUP, new Identifier(DeeperDarker.MOD_ID, "deeper_and_darker"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.deeperdarker")).icon(() -> new ItemStack(DeeperDarkerItems.WARDEN_SWORD)).entries(((displayContext, entries) -> {
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_HELMET));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_CHESTPLATE));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_LEGGINGS));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_BOOTS));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_SWORD));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_PICKAXE));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_AXE));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_SHOVEL));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_HOE));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_UPGRADE_SMITHING_TEMPLATE));
                entries.add(new ItemStack(DeeperDarkerItems.REINFORCED_ECHO_SHARD));
                entries.add(new ItemStack(DeeperDarkerItems.WARDEN_CARAPACE));
                entries.add(new ItemStack(DeeperDarkerItems.HEART_OF_THE_DEEP));
                entries.add(new ItemStack(DeeperDarkerItems.SOUL_CRYSTAL));
                entries.add(new ItemStack(DeeperDarkerItems.SOUL_DUST));
                entries.add(new ItemStack(DeeperDarkerItems.SCULK_BONE));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_LOG));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_WOOD));
                entries.add(new ItemStack(DeeperDarkerItems.STRIPPED_ECHO_LOG));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_BUTTON));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_DOOR));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_FENCE_GATE));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_FENCE));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_HANGING_SIGN));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_LEAVES));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_PLANKS));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_PRESSURE_PLATE));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_SAPLING));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_SIGN));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_SLAB));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_STAIRS));
                entries.add(new ItemStack(DeeperDarkerItems.ECHO_TRAPDOOR));
            })).build());

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker item groups");
    }
}
