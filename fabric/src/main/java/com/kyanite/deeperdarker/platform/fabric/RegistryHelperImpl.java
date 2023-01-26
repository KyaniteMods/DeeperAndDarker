package com.kyanite.deeperdarker.platform.fabric;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.fabric.mixin.WoodTypeAccessor;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Supplier;

public class RegistryHelperImpl {
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        T registry = Registry.register(Registry.BLOCK, new ResourceLocation(DeeperAndDarker.MOD_ID, name), block.get());
        return () -> registry;
    }
    public static <T extends BlockEntityType<?>> Supplier<T> registerBlockEntity(String name, Supplier<T> blockEntityType) {
        T registry = Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), blockEntityType.get());
        return () -> registry;
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        T registry = Registry.register(Registry.ITEM, new ResourceLocation(DeeperAndDarker.MOD_ID, name), item.get());
        return () -> registry;
    }

    public static <T extends Biome> Supplier<T> registerBiome(ResourceLocation biomeLocation, Supplier<T> biomeConsumer) {
        T registry = Registry.register(BuiltinRegistries.BIOME, biomeLocation, biomeConsumer.get());
        return () -> registry;
    }

    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.EntityFactory<T> entityFactory, MobCategory category, float width, float height, int clientTrackingRange) {
        EntityType<T> registry = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), FabricEntityTypeBuilder.create(category, entityFactory).dimensions(EntityDimensions.scalable(width, height)).trackRangeChunks(clientTrackingRange).build());
        return () -> registry;
    }

    public static <T extends Potion> Supplier<T> registerPotion(String name, Supplier<T> potion) {
        T registry = Registry.register(Registry.POTION, new ResourceLocation(DeeperAndDarker.MOD_ID, name), potion.get());
        return () -> registry;
    }

    public static <T extends ConfiguredFeature<?, ?>> Supplier<T> registerConfiguredFeature(String name, Supplier<T> feature) {
        T registry = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature.get());
        return () -> registry;
    }

    public static <T extends Feature<?>> Supplier<T> registerFeature(String name, Supplier<T> feature) {
        T registry = Registry.register(Registry.FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), feature.get());
        return () -> registry;
    }

    public static <T extends MobEffect> Supplier<T> registerEffect(String name, Supplier<T> effect) {
        T registry = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), effect.get());
        return () -> registry;
    }


    public static <T extends PlacedFeature> Supplier<T> registerPlacedFeature(String name, Supplier<T> placedFeature) {
        T registry = Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), placedFeature.get());
        return () -> registry;
    }

    public static <T extends CreativeModeTab> T registerCreativeModeTab(Supplier<ItemStack> icon) {
        return (T) FabricItemGroupBuilder.build(new ResourceLocation(DeeperAndDarker.MOD_ID, DeeperAndDarker.MOD_ID), icon);
    }

    public static <T extends Enchantment> Supplier<T> registerEnchant(String name, Supplier<T> enchantment) {
        T registry = Registry.register(Registry.ENCHANTMENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), enchantment.get());
        return () -> registry;
    }

    public static <T extends SoundEvent> Supplier<T> registerSound(String name, Supplier<T> sound) {
        T registry = Registry.register(Registry.SOUND_EVENT, new ResourceLocation(DeeperAndDarker.MOD_ID, name), sound.get());
        return () -> registry;
    }

    public static <T extends PoiType> Supplier<T> registerPOI(String name, Supplier<T> portal) {
        T registry = Registry.register(Registry.POINT_OF_INTEREST_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, name), portal.get());
        return () -> registry;
    }

    public static WoodType registerWoodType(String name) {
        return WoodTypeAccessor.registerNew(WoodTypeAccessor.newWoodType(name));
    }
}
