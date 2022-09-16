package com.kyanite.deeperdarker.platform.fabric;

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

import java.util.function.Supplier;

public class RegistryHelperImpl {
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return () -> Registry.register(Registry.BLOCK, new ResourceLocation(DeeperAndDarker.MOD_ID, name), block.get());
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return () -> Registry.register(Registry.ITEM, new ResourceLocation(DeeperAndDarker.MOD_ID, name), item.get());
    }

    public static <T extends Biome> Supplier<T> registerBiome(ResourceLocation biomeLocation, Supplier<T> biomeConsumer) {
        return () -> Registry.register(BuiltinRegistries.BIOME, biomeLocation, biomeConsumer.get());
    }

    public static <T extends EntityType<?>> Supplier<T> registerEntity(String name, Supplier<T> entity){
        return () -> Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), entity.get());
    }

    public static <T extends Potion> Supplier<T> registerPotion(String name, Supplier<T> potion) {
        return () -> Registry.register(Registry.POTION, new ResourceLocation(DeeperAndDarker.MOD_ID, name), potion.get());
    }

    public static <T extends ConfiguredFeature> Supplier<T> registerConfiguredFeature(String name, Supplier<T> feature) {
        return () -> (T) Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature.get());
    }

    public static <T extends Feature<?>> Supplier<T> registerFeature(String name, Supplier<T> feature) {
        return () -> Registry.register(Registry.FEATURE,
                new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature.get());
    }

    public static <T extends MobEffect> Supplier<T> registerEffect(String name, Supplier<T> effect) {
        return () -> Registry.register(Registry.MOB_EFFECT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), effect.get());
    }


    public static <T extends PlacedFeature> Supplier<T>  registerPlacedFeature(String name, Supplier<T> placedFeature) {
        return () -> Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), placedFeature.get());
    }

    public static <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String name, Supplier<ItemStack> icon) {
        return () -> (T) FabricItemGroupBuilder.build(new ResourceLocation(DeeperAndDarker.MOD_ID, name), icon);
    }

    public static <T extends Enchantment> Supplier<T> registerEnchant(String name, Supplier<T> enchantment) {
        return () -> Registry.register(Registry.ENCHANTMENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), enchantment.get());
    }

    public static <T extends SoundEvent> Supplier<T> registerSound(String name, Supplier<T> sound) {
        return () -> Registry.register(Registry.SOUND_EVENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), sound.get());
    }

    public static WoodType registerWoodType(String name) {
        return WoodTypeAccessor.registerNew(WoodTypeAccessor.newWoodType(name));
    }
}
