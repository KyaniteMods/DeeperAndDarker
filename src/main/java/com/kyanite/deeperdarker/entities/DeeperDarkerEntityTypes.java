package com.kyanite.deeperdarker.entities;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.DefaultAttributeRegistryAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeeperDarkerEntityTypes {
    public static EntityType<DeeperDarkerBoatEntity> BOAT;
    public static EntityType<DeeperDarkerChestBoatEntity> CHEST_BOAT;
    public static EntityType<SculkSnapperEntity> SCULK_SNAPPER;
    public static EntityType<ShatteredEntity> SHATTERED;
    public static EntityType<SculkLeechEntity> SCULK_LEECH;
    public static EntityType<ShriekWormEntity> SHRIEK_WORM;

    static {
        BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "boat"),
                FabricEntityTypeBuilder.<DeeperDarkerBoatEntity>create(SpawnGroup.MISC, DeeperDarkerBoatEntity::new).dimensions(EntityType.BOAT.getDimensions()).build());
        CHEST_BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "chest_boat"),
                FabricEntityTypeBuilder.<DeeperDarkerChestBoatEntity>create(SpawnGroup.MISC, DeeperDarkerChestBoatEntity::new).dimensions(EntityType.CHEST_BOAT.getDimensions()).build());
        SCULK_SNAPPER = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "sculk_snapper"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SculkSnapperEntity::new).dimensions(
                        EntityDimensions.fixed(0.65f, 0.65f)).build());
        SHATTERED = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "shattered"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShatteredEntity::new).dimensions(
                        EntityDimensions.fixed(0.8f, 2.125f)).build());
        SCULK_LEECH = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "sculk_leech"),
                FabricEntityTypeBuilder.<SculkLeechEntity>create(SpawnGroup.MONSTER, SculkLeechEntity::new).dimensions(
                        EntityDimensions.fixed(0.42f, 0.2f)).build());
        SHRIEK_WORM = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "shriek_worm"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShriekWormEntity::new).dimensions(
                        EntityDimensions.fixed(1.3f, 5.7f)).build());
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker entity types");
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_SNAPPER, SculkSnapperEntity.createSculkSnapperAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHATTERED, ShatteredEntity.createShatteredAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SCULK_LEECH, SculkLeechEntity.createSculkLeechAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SHRIEK_WORM, ShriekWormEntity.createShriekWormAttributes().build());
    }
}
