package com.kyanite.deeperdarker.registry.entities;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.entities.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DDEntities {
    public static final Map<String, Supplier<EntityType>> ENTITIES = new HashMap<>();
    public static final Supplier<EntityType> SHATTERED = RegistryHelper.registerEntity(
           "shattered",
            () -> EntityType.Builder.of(ShatteredEntity::new, MobCategory.MONSTER).sized(0.85f, 2.45f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "shattered").toString())
    );

    public static final Supplier<EntityType> SCULK_LEECH = RegistryHelper.registerEntity(
            "sculk_leech",
            () -> EntityType.Builder.of(SculkLeechEntity::new, MobCategory.MONSTER).sized(0.3f, 0.2f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_leech").toString())
    );

    public static final Supplier<EntityType> SCULK_SNAPPER = RegistryHelper.registerEntity(
            "sculk_snapper",
            () -> EntityType.Builder.of(SculkSnapperEntity::new, MobCategory.MONSTER).sized(1, 1).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_snapper").toString())
    );

    public static final Supplier<EntityType> SCULK_WORM = RegistryHelper.registerEntity(
            "shriek_worm",
            () -> EntityType.Builder.of(SculkWormEntity::new, MobCategory.MONSTER).sized(1.5f, 5.7f).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "shriek_worm").toString())
    );

    public static final Supplier<EntityType<DDBoat>> BOAT = RegistryHelper.registerEntity(
            "boat",
            () -> EntityType.Builder.of(DDBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "boat").toString())
    );

    public static final Supplier<EntityType<DDChestBoat>> CHEST_BOAT = RegistryHelper.registerEntity(
            "chest_boat",
            () -> EntityType.Builder.of(DDChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "chest_boat").toString())
    );

    public static void registerEntities() {
        ENTITIES.put("shattered", SHATTERED);
        ENTITIES.put("sculk_leech", SCULK_LEECH);
        ENTITIES.put("sculk_snapper", SCULK_SNAPPER);
        ENTITIES.put("shriek_worm", SCULK_WORM);

        DeeperAndDarker.LOGGER.info("Deeper And Darker entities have been registered");
    }
}
