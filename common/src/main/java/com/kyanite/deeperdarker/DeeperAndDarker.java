package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.rendering.armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.miscellaneous.DeeperAndDarkerInitCallback;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.enchantments.DDEnchantments;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkLeechEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.Map;

public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init(DeeperAndDarkerInitCallback callback) {
        GeckoLib.initialize();
        GeckoLibMod.DISABLE_IN_DEV = true;

        DDEntities.registerEntities();
        DDBlocks.registerBlocks();
        DDItems.registerItems();
        DDSounds.registerSounds();
        DDEnchantments.registerEnchantments();
        DDEffects.registerEffects();
        DDPotions.registerPotions();

        DDFeatures.registerFeatures();
        DDConfiguredFeatures.registerConfiguredFeatures();
        DDPlacedFeatures.registerPlacedFeatures();

        DDDimensions.dimension();
        OthersideBiomes.createBiomes();
        //  CustomPortalBuilder.beginPortal()
        //        .frameBlock(Blocks.REINFORCED_DEEPSLATE)
        //      .customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
        //    .destDimID(new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"))
        //  .tintColor(5, 98, 93)
        // .customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
        //.forcedSize(20, 6)
        //.registerPortal();

        callback.callback();
    }

    public static void commonInit() {
    }

    public static void attributes(Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes) {
        attributes.put(DDEntities.SHATTERED.get(), ShatteredEntity.attributes());
        attributes.put(DDEntities.SCULK_LEECH.get(), SculkLeechEntity.attributes());
        attributes.put(DDEntities.SCULK_WORM.get(), SculkWormEntity.attributes());
        attributes.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapperEntity.attributes());
    }

    public static void registerArmor() {
        GeoArmorRenderer.registerArmorRenderer(new WardenArmorRenderer(), DDItems.WARDEN_HELMET.get(),
                DDItems.WARDEN_CHESTPLATE.get(), DDItems.WARDEN_LEGGINGS.get(), DDItems.WARDEN_BOOTS.get());
    }
}