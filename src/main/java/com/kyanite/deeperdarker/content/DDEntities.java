package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.mixin.DefaultAttributeRegistryAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;

public class DDEntities {
    public static final EntityType<DDBoat> BOAT = register("boat", EntityType.Builder.<DDBoat>of(DDBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build("boat"));
    public static final EntityType<DDChestBoat> CHEST_BOAT = register("chest_boat", EntityType.Builder.<DDChestBoat>of(DDChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build("chest_boat"));

    public static final EntityType<AnglerFish> ANGLER_FISH = register("angler_fish", EntityType.Builder.of(AnglerFish::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.4f).clientTrackingRange(10).build("angler_fish"));
    public static final EntityType<SculkCentipede> SCULK_CENTIPEDE = register("sculk_centipede", EntityType.Builder.of(SculkCentipede::new, MobCategory.MONSTER).sized(1f, 0.2f).clientTrackingRange(10).build("sculk_centipede"));
    public static final EntityType<SculkLeech> SCULK_LEECH = register("sculk_leech", EntityType.Builder.of(SculkLeech::new, MobCategory.MONSTER).sized(0.42f, 0.2f).clientTrackingRange(10).build("sculk_leech"));
    public static final EntityType<SculkSnapper> SCULK_SNAPPER = register("sculk_snapper", EntityType.Builder.of(SculkSnapper::new, MobCategory.MONSTER).sized(0.65f, 0.65f).clientTrackingRange(10).build("sculk_snapper"));
    public static final EntityType<Shattered> SHATTERED = register("shattered", EntityType.Builder.of(Shattered::new, MobCategory.MONSTER).sized(0.8f, 2.125f).clientTrackingRange(10).build("shattered"));
    public static final EntityType<ShriekWorm> SHRIEK_WORM = register("shriek_worm", EntityType.Builder.of(ShriekWorm::new, MobCategory.MONSTER).sized(1.0f, 5.7f).clientTrackingRange(10).build("shriek_worm"));
    public static final EntityType<Stalker> STALKER = register("stalker", EntityType.Builder.of(Stalker::new, MobCategory.MONSTER).sized(1f, 4.4f).clientTrackingRange(10).build("stalker"));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker entity types");
        registerAttributes();
        registerSpawnPlacements();
    }

    private static void registerAttributes() {
        DefaultAttributeRegistryAccessor.getRegistry().put(ANGLER_FISH, AnglerFish.createAttributeSupplier());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_SNAPPER, SculkSnapper.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHATTERED, Shattered.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_LEECH, SculkLeech.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHRIEK_WORM, ShriekWorm.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(STALKER, Stalker.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_CENTIPEDE, SculkCentipede.createAttributes());
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, DeeperDarker.rl(name), entity);
    }

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(ANGLER_FISH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        SpawnPlacements.register(SCULK_SNAPPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHATTERED, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_LEECH, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHRIEK_WORM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(STALKER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_CENTIPEDE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}
