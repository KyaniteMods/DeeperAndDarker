package com.kyanite.deeperdarker.platform;

import java.util.function.Supplier;
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

public class RegistryHelper {
    @ExpectPlatform
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Enchantment> Supplier<T> registerEnchant(String name, Supplier<T> enchantment) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Potion> Supplier<T> registerPotion(String name, Supplier<T> potion) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<ItemStack> icon) { throw new AssertionError(); }

    @ExpectPlatform
    public static <T extends MobEffect> Supplier<T> registerEffect(String name, Supplier<T> effect) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends SoundEvent> Supplier<T> registerSound(String name, Supplier<T> sound) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ConfiguredFeature> Supplier<T> registerConfiguredFeature(String name, java.util.function.Supplier<T> feature) { throw new AssertionError(); }

    @ExpectPlatform
    public static <T extends Feature<?>> Supplier<T> registerFeature(String name, Supplier<T> feature) { throw new AssertionError(); }
    @ExpectPlatform
    public static <T extends PlacedFeature> Supplier<T>  registerPlacedFeature(String name, Supplier<T> placedFeature) { throw new AssertionError(); }
    @ExpectPlatform
    public static <T extends EntityType<?>> Supplier<T> registerEntity(String name, Supplier<T> entity) {throw new AssertionError();}

    @ExpectPlatform
    public static <T extends Biome> Supplier<T>  registerBiome(ResourceLocation biomeLocation, Supplier<T> biomeConsumer) {throw new AssertionError();}

    @ExpectPlatform
    public static WoodType registerWoodType(String name) {throw new AssertionError();}
}
