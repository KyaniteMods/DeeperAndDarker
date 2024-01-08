package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.mixin.DefaultAttributeRegistryAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.levelgen.Heightmap;

public class DDEntities {
    public static final EntityType<DDBoat> BOAT = register("boat", EntityType.Builder.<DDBoat>of(DDBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "boat").toString()));
    public static final EntityType<DDChestBoat> CHEST_BOAT = register("chest_boat", EntityType.Builder.<DDChestBoat>of(DDChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "chest_boat").toString()));

    public static final EntityType<SculkCentipede> SCULK_CENTIPEDE = register("sculk_centipede", EntityType.Builder.of(SculkCentipede::new, MobCategory.MONSTER).sized(1f, 0.2f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_centipede").toString()));
    public static final EntityType<SculkLeech> SCULK_LEECH = register("sculk_leech", EntityType.Builder.of(SculkLeech::new, MobCategory.MONSTER).sized(0.42f, 0.2f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_leech").toString()));
    public static final EntityType<SculkSnapper> SCULK_SNAPPER = register("sculk_snapper", EntityType.Builder.of(SculkSnapper::new, MobCategory.MONSTER).sized(0.65f, 0.65f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_snapper").toString()));
    public static final EntityType<Shattered> SHATTERED = register("shattered", EntityType.Builder.of(Shattered::new, MobCategory.MONSTER).sized(0.8f, 2.125f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "shattered").toString()));
    public static final EntityType<ShriekWorm> SHRIEK_WORM = register("shriek_worm", EntityType.Builder.of(ShriekWorm::new, MobCategory.MONSTER).sized(1.0f, 5.7f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "shriek_worm").toString()));
    public static final EntityType<Stalker> STALKER = register("stalker", EntityType.Builder.of(Stalker::new, MobCategory.MONSTER).sized(1f, 4.4f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "shriek_worm").toString()));

    public static final EntityType<SculkPrimedTNT> SCULK_TNT = register("sculk_tnt", EntityType.Builder.<SculkPrimedTNT>of(SculkPrimedTNT::new, MobCategory.MISC).sized(0.98f, 0.98f).fireImmune().clientTrackingRange(10).updateInterval(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_tnt").toString()));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker entity types");
        registerAttributes();
        registerSpawnPlacements();
    }

    private static void registerAttributes() {
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_SNAPPER, SculkSnapper.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHATTERED, Shattered.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_LEECH, SculkLeech.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHRIEK_WORM, ShriekWorm.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(STALKER, Stalker.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_CENTIPEDE, SculkCentipede.createAttributes());
    }

    private static EntityType register(String name, EntityType entity) {
        EntityType registeredBlock = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, name), entity);
        return registeredBlock;
    }

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(SCULK_SNAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHATTERED, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_LEECH, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHRIEK_WORM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(STALKER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_CENTIPEDE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}
