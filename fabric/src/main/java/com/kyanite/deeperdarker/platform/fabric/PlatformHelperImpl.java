package com.kyanite.deeperdarker.platform.fabric;

import com.google.common.base.Supplier;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.fabric.mixin.WoodTypeAccessor;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlatformHelperImpl {
    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(DeeperAndDarker.MOD_ID, name), block);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(DeeperAndDarker.MOD_ID, name), item);
    }

    public static Biome registerBiome(ResourceLocation biomeLocation, Biome biomeConsumer) {
        return Registry.register(BuiltinRegistries.BIOME, biomeLocation, biomeConsumer);
    }

    public static EntityType registerEntity(String name, EntityType<?> entity) {
        return Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), entity);
    }

    public static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, new ResourceLocation(DeeperAndDarker.MOD_ID, name), potion);
    }

    public static ConfiguredFeature registerConfiguredFeature(String name, ConfiguredFeature feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature);
    }

    public static Feature registerFeature(String name, Feature feature) {
        return Registry.register(Registry.FEATURE,
                new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature);
    }

    public static MobEffect registerEffect(String name, MobEffect effect) {
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), effect);
    }

    public static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), placedFeature);
    }

    public static CreativeModeTab registerCreativeModeTab(String name, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(new ResourceLocation(DeeperAndDarker.MOD_ID, name), icon);
    }

    public static Enchantment registerEnchant(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), enchantment);
    }

    public static SoundEvent registerSound(String name, SoundEvent sound) {
        return Registry.register(Registry.SOUND_EVENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), new SoundEvent(new ResourceLocation(DeeperAndDarker.MOD_ID, name)));
    }

    public static WoodType registerWoodType(String name) {
        return WoodTypeAccessor.registerNew(WoodTypeAccessor.newWoodType(name));
    }
}
