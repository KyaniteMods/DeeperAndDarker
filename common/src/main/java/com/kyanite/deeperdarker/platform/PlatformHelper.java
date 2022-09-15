package com.kyanite.deeperdarker.platform;

import com.google.common.base.Supplier;
import dev.architectury.injectables.annotations.ExpectPlatform;
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

public class PlatformHelper {
    @ExpectPlatform
    public static Block registerBlock(String name, Block block) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Item registerItem(String name, Item item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Enchantment registerEnchant(String name, Enchantment enchantment) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Potion registerPotion(String name, Potion potion) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static CreativeModeTab registerCreativeModeTab(String name, Supplier<ItemStack> icon) { throw new AssertionError(); }

    @ExpectPlatform
    public static MobEffect registerEffect(String name, MobEffect effect) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SoundEvent registerSound(String name, SoundEvent sound) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static ConfiguredFeature registerConfiguredFeature(String name, ConfiguredFeature feature) { throw new AssertionError(); }

    @ExpectPlatform
    public static Feature registerFeature(String name, Feature feature) { throw new AssertionError(); }
    @ExpectPlatform
    public static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) { throw new AssertionError(); }
    @ExpectPlatform
    public static EntityType registerEntity(String name, EntityType<?> entity) {throw new AssertionError();}

    @ExpectPlatform
    public static Biome registerBiome(ResourceLocation biomeLocation, Biome biomeConsumer) {throw new AssertionError();}

    @ExpectPlatform
    public static WoodType registerWoodType(String name) {throw new AssertionError();}
}
