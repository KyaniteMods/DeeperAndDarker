package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.client.rendering.armor.WardenArmorRenderer;
import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.enchantments.DDEnchantments;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.SculkLeechEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.mojang.logging.LogUtils;
import dev.architectury.injectables.targets.ArchitecturyTarget;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.Heightmap;
import org.slf4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.Map;

public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {

        //GeckoLib.initialize();
       // GeckoLibMod.DISABLE_IN_DEV = true;

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

        GeckoLib.initialize();
        //  CustomPortalBuilder.beginPortal()
        //        .frameBlock(Blocks.REINFORCED_DEEPSLATE)
          //      .customIgnitionSource(PortalIgnitionSource.ItemUseSource(DDItems.HEART_OF_THE_DEEP))
            //    .destDimID(new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"))
              //  .tintColor(5, 98, 93)
               // .customPortalBlock((CustomPortalBlock) DDBlocks.OTHERSIDE_PORTAL)
                //.forcedSize(20, 6)
                //.registerPortal();

    }

    public static void commonInit() {
        ComposterBlock.COMPOSTABLES.put(DDBlocks.ECHO_LEAVES.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_GLEAM.get().asItem(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(DDBlocks.SCULK_VINES.get().asItem(), 0.5f);

        PotionBrewing.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST.get(), DDPotions.SCULK_AFFINITY.get());
        SpawnPlacements.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
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