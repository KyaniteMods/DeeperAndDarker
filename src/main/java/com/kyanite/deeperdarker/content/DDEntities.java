package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import com.kyanite.deeperdarker.content.entities.acidsprite.AcidSprite;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselItem;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystal;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerLaser;
import com.kyanite.deeperdarker.mixin.DefaultAttributeRegistryAccessor;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;

public class DDEntities {
    public static final EntityType<DDBoat> BOAT = register("boat", FabricEntityTypeBuilder.<DDBoat>create(MobCategory.MISC, DDBoat::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeChunks(10).build());
    public static final EntityType<DDChestBoat> CHEST_BOAT = register("chest_boat", FabricEntityTypeBuilder.<DDChestBoat>create(MobCategory.MISC, DDChestBoat::new).dimensions(EntityDimensions.fixed(1.375f, 0.5625f)).trackRangeChunks(10).build());
    public static final EntityType<IcicleShard> ICICLE_SHARD = register("icicle_shard", FabricEntityTypeBuilder.<IcicleShard>create(MobCategory.MISC, IcicleShard::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).trackRangeChunks(10).build());
    public static final EntityType<OvercastVesselItem> OVERCAST_VESSEL_ITEM = register("overcast_vessel_item", FabricEntityTypeBuilder.<OvercastVesselItem>create(MobCategory.MISC, OvercastVesselItem::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeChunks(10).build());
    public static final EntityType<OverseerCrystal> OVERSEER_CRYSTAL = register("overseer_crystal", FabricEntityTypeBuilder.<OverseerCrystal>create(MobCategory.MISC, OverseerCrystal::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeChunks(10).build());
    public static final EntityType<OverseerLaser> OVERSEER_LASER = register("overseer_laser", FabricEntityTypeBuilder.<OverseerLaser>create(MobCategory.MISC, OverseerLaser::new).dimensions(EntityDimensions.fixed(0.0f, 0.0f)).trackRangeChunks(10).build());

    public static final EntityType<AnglerFish> ANGLER_FISH = register("angler_fish", FabricEntityTypeBuilder.create(MobCategory.WATER_CREATURE, AnglerFish::new).dimensions(EntityDimensions.fixed(0.7f, 0.4f)).trackRangeChunks(10).build());
    public static final EntityType<SculkCentipede> SCULK_CENTIPEDE = register("sculk_centipede", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkCentipede::new).dimensions(EntityDimensions.fixed(1f, 0.2f)).trackRangeChunks(10).build());
    public static final EntityType<SculkLeech> SCULK_LEECH = register("sculk_leech", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkLeech::new).dimensions(EntityDimensions.fixed(0.42f, 0.2f)).trackRangeChunks(10).build());
    public static final EntityType<SculkSnapper> SCULK_SNAPPER = register("sculk_snapper", FabricEntityTypeBuilder.create(MobCategory.MONSTER, SculkSnapper::new).dimensions(EntityDimensions.fixed(0.65f, 0.65f)).trackRangeChunks(10).build());
    public static final EntityType<Shattered> SHATTERED = register("shattered", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Shattered::new).dimensions(EntityDimensions.fixed(0.8f, 2.125f)).trackRangeChunks(10).build());
    public static final EntityType<ShriekWorm> SHRIEK_WORM = register("shriek_worm", FabricEntityTypeBuilder.create(MobCategory.MONSTER, ShriekWorm::new).dimensions(EntityDimensions.fixed(1.0f, 5.7f)).trackRangeChunks(10).build());
    public static final EntityType<Sludge> SLUDGE = register("sludge", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Sludge::new).dimensions(EntityDimensions.scalable(2.04f, 2.04f)).trackRangeChunks(10).build());
    public static final EntityType<Stalker> STALKER = register("stalker", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Stalker::new).dimensions(EntityDimensions.fixed(1f, 4.4f)).trackRangeChunks(10).build());
    public static final EntityType<BloomingGolem> BLOOMING_GOLEM = register("blooming_golem", FabricEntityTypeBuilder.<BloomingGolem>create(MobCategory.MONSTER, BloomingGolem::new).dimensions(EntityDimensions.fixed(3f, 3f)).trackRangeChunks(10).build());
    public static final EntityType<OvercastPot> POTTY = register("potty", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(0.85f, 1.875f)).trackRangeChunks(10).build());
    public static final EntityType<OvercastPot> POT = register("pot", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(0.85f, 1.2f)).trackRangeChunks(10).build());
    public static final EntityType<OvercastPot> POTTER = register("potter", FabricEntityTypeBuilder.create(MobCategory.MONSTER, OvercastPot::new).dimensions(EntityDimensions.fixed(1.3f, 1.2f)).trackRangeChunks(10).build());
    public static final EntityType<OvercastVessel> OVERCAST_VESSEL = register("overcast_vessel", FabricEntityTypeBuilder.<OvercastVessel>create(MobCategory.MONSTER, OvercastVessel::new).dimensions(EntityDimensions.fixed(3f, 3f)).trackRangeChunks(10).build());
    public static final EntityType<AcidSprite> ACID_SPRITE = register("acid_sprite", FabricEntityTypeBuilder.create(MobCategory.MONSTER, AcidSprite::new).dimensions(EntityDimensions.fixed(0.5f, 0.6f)).trackRangeChunks(10).build());
    public static final EntityType<Bubblox> BUBBLOX = register("bubblox", FabricEntityTypeBuilder.<Bubblox>create(MobCategory.MONSTER, Bubblox::new).dimensions(EntityDimensions.fixed(1.0f, 1.0f)).trackRangeChunks(10).build());
    public static final EntityType<Overseer> OVERSEER = register("overseer", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Overseer::new).dimensions(EntityDimensions.fixed(2.0f, 2.0f)).trackRangeChunks(10).build());
    public static final EntityType<Floater> FLOATER = register("floater", FabricEntityTypeBuilder.create(MobCategory.MONSTER, Floater::new).dimensions(EntityDimensions.fixed(0.625f, 0.625f)).trackRangeChunks(10).build());

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
        DefaultAttributeRegistryAccessor.getRegistry().put(SLUDGE, Sludge.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_CENTIPEDE, SculkCentipede.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(BLOOMING_GOLEM, BloomingGolem.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(POTTY, OvercastPot.createAttributes(-10));
        DefaultAttributeRegistryAccessor.getRegistry().put(POT, OvercastPot.createAttributes(0));
        DefaultAttributeRegistryAccessor.getRegistry().put(POTTER, OvercastPot.createAttributes(10));
        DefaultAttributeRegistryAccessor.getRegistry().put(OVERCAST_VESSEL, OvercastVessel.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(ACID_SPRITE, AcidSprite.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(OVERSEER, Overseer.createAttributes());
        DefaultAttributeRegistryAccessor.getRegistry().put(FLOATER, Floater.createFloaterAttributes());
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
        SpawnPlacements.register(ACID_SPRITE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }
}
