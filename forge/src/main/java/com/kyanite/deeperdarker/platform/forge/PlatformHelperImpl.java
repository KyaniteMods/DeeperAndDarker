package com.kyanite.deeperdarker.platform.forge;

import com.google.common.base.Supplier;
import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PlatformHelperImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperAndDarker.MOD_ID);


    public static Block registerBlock(String name, Block block) {
        return BLOCKS.register(name, () -> block).get();
    }

    public static Item registerItem(String name, Item item) {
        return ITEMS.register(name, () -> item).get();
    }

    public static Biome registerBiome(ResourceLocation biomeLocation, Biome biomeConsumer) {
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, biomeLocation);
        return BIOMES.register(biome.location().getPath(), () -> biomeConsumer).get();
    }

    public static EntityType registerEntity(String name, EntityType<?> entity) {
        return ENTITY_TYPES.register(name, () -> entity).get();
    }

    public static Potion registerPotion(String name, Potion potion) {
        return POTIONS.register(name, () -> potion).get();
    }

    public static ConfiguredFeature registerConfiguredFeature(String name, ConfiguredFeature feature) {
        return CONFIGURED_FEATURES.register(name, () -> feature).get();
    }

    public static Feature registerFeature(String name, Feature feature) {
        return FEATURES.register(name, () -> feature).get();
    }

    public static MobEffect registerEffect(String name, MobEffect effect) {
        return MOB_EFFECTS.register(name, () -> effect).get();
    }

    public static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
        return PLACED_FEATURES.register(name, () -> placedFeature).get();
    }

    public static CreativeModeTab registerCreativeModeTab(String name, Supplier<ItemStack> icon) {
        return new CreativeModeTab(new ResourceLocation(DeeperAndDarker.MOD_ID, name).toLanguageKey()) {
            @Override
            public ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    public static Enchantment registerEnchant(String name, Enchantment enchantment) {
        return ENCHANTMENTS.register(name, () -> enchantment).get();
    }

    public static SoundEvent registerSound(String name, SoundEvent sound) {
        return SOUND_EVENTS.register(name, () -> sound).get();
    }

    public static WoodType registerWoodType(String name) {
        return WoodType.register(WoodType.create(new ResourceLocation(DeeperAndDarker.MOD_ID, name).toString()));
    }
}
