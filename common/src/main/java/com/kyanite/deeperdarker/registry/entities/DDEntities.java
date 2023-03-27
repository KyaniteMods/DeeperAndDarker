package com.kyanite.deeperdarker.registry.entities;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.entities.custom.*;
import com.kyanite.deeperdarker.registry.entities.custom.projectiles.ShriekProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DDEntities {
    public static final Map<String, Supplier<EntityType<?>>> ENTITIES = new HashMap<>();

    public static final Supplier<EntityType<ShriekProjectile>> SHRIEK_PROJECTILE = RegistryHelper.registerEntity("shriek_projectile", ShriekProjectile::new, MobCategory.MISC, 0.5F, 0.5F, 4);

    public static final Supplier<EntityType<ShatteredEntity>> SHATTERED = RegistryHelper.registerEntity("shattered", ShatteredEntity::new, MobCategory.MONSTER, 0.85f, 2.45f, 10);
    public static final Supplier<EntityType<SculkLeechEntity>> SCULK_LEECH = RegistryHelper.registerEntity("sculk_leech", SculkLeechEntity::new, MobCategory.MONSTER, 0.3f, 0.2f, 10);
    public static final Supplier<EntityType<SculkSnapperEntity>> SCULK_SNAPPER = RegistryHelper.registerEntity("sculk_snapper", SculkSnapperEntity::new, MobCategory.MONSTER, 1, 1, 10);

    public static final Supplier<EntityType<EchoerEntity>> ECHOER = RegistryHelper.registerEntity("echoer", EchoerEntity::new, MobCategory.MONSTER, 0.85f, 2.45f, 10);

    // public static final Supplier<EntityType<ScavengerEntity>> SCAVENGER = RegistryHelper.registerEntity(
    //         "scavenger",
    //         ScavengerEntity::new, MobCategory.MONSTER, 1, 1, 10
    // );

    public static final Supplier<EntityType<SculkWormEntity>> SCULK_WORM = RegistryHelper.registerEntity("shriek_worm", SculkWormEntity::new, MobCategory.MONSTER, 1.5f, 5.7f, 10);
    public static final Supplier<EntityType<DDBoat>> BOAT = RegistryHelper.registerEntity("boat", DDBoat::new, MobCategory.MISC, 1.375F, 0.5625F, 10);
    public static final Supplier<EntityType<DDChestBoat>> CHEST_BOAT = RegistryHelper.registerEntity("chest_boat", DDChestBoat::new, MobCategory.MISC, 1.375F, 0.5625F, 10);
    public static final Supplier<EntityType<SculkCentipedeEntity>> SCULK_CENTIPEDE = RegistryHelper.registerEntity("sculk_centipede", SculkCentipedeEntity::new, MobCategory.MONSTER, 2.3f, 0.3f, 10);
    public static final Supplier<EntityType<StalkerEntity>> STALKER = RegistryHelper.registerEntity("stalker", StalkerEntity::new, MobCategory.MONSTER, 1f, 4.4f, 10);

    public static void registerEntities() {
        DeeperAndDarker.LOGGER.info("Deeper and Darker entities have been registered");
    }
}
