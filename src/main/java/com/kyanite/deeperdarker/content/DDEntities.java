package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.mixin.DefaultAttributeRegistryAccessor;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;

public class DDEntities {
    public static final EntityType<DDBoat> BOAT = register("boat", FabricEntityTypeBuilder.<DDBoat>create(MobCategory.MISC, DDBoat::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeBlocks(10).build());
    public static final EntityType<DDChestBoat> CHEST_BOAT = register("chest_boat", FabricEntityTypeBuilder.<DDChestBoat>create(MobCategory.MISC, DDChestBoat::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeBlocks(10).build());

    public static final EntityType<AnglerFish> ANGLER_FISH = register("angler_fish", FabricEntityTypeBuilder.create(MobCategory.WATER_CREATURE, AnglerFish::new).dimensions(EntityDimensions.fixed(0.7f, 0.4f)).trackRangeBlocks(10).build());
    public static final EntityType<SculkCentipede> SCULK_CENTIPEDE = register("sculk_centipede", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkCentipede::new).dimensions(EntityDimensions.fixed(1f, 0.2f)).trackRangeBlocks(10).build());
    public static final EntityType<SculkLeech> SCULK_LEECH = register("sculk_leech", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkLeech::new).dimensions(EntityDimensions.fixed(0.42f, 0.2f)).trackRangeBlocks(10).build());
    public static final EntityType<SculkSnapper> SCULK_SNAPPER = register("sculk_snapper", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkSnapper::new).dimensions(EntityDimensions.fixed(0.65f, 0.65f)).trackRangeBlocks(10).build());
    public static final EntityType<Shattered> SHATTERED = register("shattered", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Shattered::new).dimensions(EntityDimensions.fixed(0.8f, 2.125f)).trackRangeBlocks(10).build());
    public static final EntityType<ShriekWorm> SHRIEK_WORM = register("shriek_worm", FabricEntityTypeBuilder.create(MobCategory.MONSTER, ShriekWorm::new).dimensions(EntityDimensions.fixed(1.0f, 5.7f)).trackRangeBlocks(10).build());
    public static final EntityType<Sludge> SLUDGE = register("sludge", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Sludge::new).dimensions(EntityDimensions.scalable(2.04f, 2.04f)).trackRangeBlocks(10).build());
    public static final EntityType<Stalker> STALKER = register("stalker", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Stalker::new).dimensions(EntityDimensions.fixed(1f, 4.4f)).trackRangeBlocks(10).build());
    public static final EntityType<OvercastPot> POTTY = register("potty", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(0.85f, 1.2f)).trackRangeBlocks(10).build());
    public static final EntityType<OvercastPot> POT = register("pot", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(0.85f, 1.2f)).trackRangeBlocks(10).build());
    public static final EntityType<OvercastPot> POTTER = register("potter", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(1.3f, 1.2f)).trackRangeBlocks(10).build());

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker entity types");
        registerAttributes();
        registerSpawnPlacements();
    }

    private static void registerAttributes() {
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(ANGLER_FISH, AnglerFish.createAttributeSupplier());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SCULK_SNAPPER, SculkSnapper.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SHATTERED, Shattered.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SCULK_LEECH, SculkLeech.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SHRIEK_WORM, ShriekWorm.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(STALKER, Stalker.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SLUDGE, Sludge.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(SCULK_CENTIPEDE, SculkCentipede.createAttributes());
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(POTTY, OvercastPot.createAttributes(-10));
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(POT, OvercastPot.createAttributes(0));
        DefaultAttributeRegistryAccessor.deeperdarker$getRegistry().put(POTTER, OvercastPot.createAttributes(10));
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entity) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, name), entity);
    }

    public static void registerSpawnPlacements() {
        SpawnPlacements.register(ANGLER_FISH, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AnglerFish::checkAnglerFishSpawnRules);
        SpawnPlacements.register(SCULK_SNAPPER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHATTERED, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_LEECH, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SHRIEK_WORM, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(STALKER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SLUDGE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(SCULK_CENTIPEDE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(POTTY, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(POT, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        SpawnPlacements.register(POTTER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}
