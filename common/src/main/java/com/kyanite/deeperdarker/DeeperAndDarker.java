package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.miscellaneous.DDTiers;
import com.kyanite.deeperdarker.miscellaneous.DeeperAndDarkerInitCallback;
import com.kyanite.deeperdarker.registry.blocks.DDBlockEntityTypes;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.enchantments.DDEnchantments;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.*;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.potions.DDPotions;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDFeatures;
import com.kyanite.deeperdarker.registry.world.features.DDPlacedFeatures;
import com.kyanite.paragon.api.ConfigManager;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;
import org.slf4j.Logger;

import java.util.Map;

public class DeeperAndDarker {
    public static final String MOD_ID = "deeperdarker";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static String VERSION = "1.1.5";

    public static void init(DeeperAndDarkerInitCallback callback) {
        ConfigManager.register("deeperdarker", new DDConfig());

        DDEntities.registerEntities();
        DDBlocks.registerBlocks();
        DDBlockEntityTypes.registerBlockEntities();
        DDSounds.registerSounds();
        DDEnchantments.registerEnchantments();
        DDEffects.registerEffects();
        DDPotions.registerPotions();

        DDFeatures.registerFeatures();
        DDConfiguredFeatures.registerConfiguredFeatures();
        DDPlacedFeatures.registerPlacedFeatures();
        OthersideBiomes.createBiomes();
        DDDimensions.registerDimensions();

        DDTiers.registerTypes();
        DDItems.registerItems();
        callback.callback();
    }

    public static void attributes(Map<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes) {
        attributes.put(DDEntities.SHATTERED.get(), ShatteredEntity.attributes());
        attributes.put(DDEntities.SCULK_LEECH.get(), SculkLeechEntity.attributes());
        attributes.put(DDEntities.SCULK_WORM.get(), SculkWormEntity.attributes());
        attributes.put(DDEntities.SCULK_SNAPPER.get(), SculkSnapperEntity.attributes());
        attributes.put(DDEntities.SCULK_CENTIPEDE.get(), SculkCentipedeEntity.attributes());
        attributes.put(DDEntities.STALKER.get(), StalkerEntity.attributes());
        attributes.put(DDEntities.ECHOER.get(), EchoerEntity.attributes());
    }

    public static void spawnPlacements() {
        SpawnPlacements.register(DDEntities.SCULK_CENTIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.SCULK_SNAPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.SHATTERED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.STALKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(DDEntities.ECHOER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        //    SpawnPlacements.register(DDEntities.SCAVENGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}
