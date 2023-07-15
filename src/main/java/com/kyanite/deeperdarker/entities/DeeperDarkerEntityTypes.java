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

    static {
        BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "boat"),
                FabricEntityTypeBuilder.<DeeperDarkerBoatEntity>create(SpawnGroup.MISC, DeeperDarkerBoatEntity::new).dimensions(EntityType.BOAT.getDimensions()).build());
        CHEST_BOAT = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "chest_boat"),
                FabricEntityTypeBuilder.<DeeperDarkerChestBoatEntity>create(SpawnGroup.MISC, DeeperDarkerChestBoatEntity::new).dimensions(EntityType.CHEST_BOAT.getDimensions()).build());
        SCULK_SNAPPER = Registry.register(Registries.ENTITY_TYPE, new Identifier(DeeperDarker.MOD_ID, "sculk_snapper"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SculkSnapperEntity::new).dimensions(
                        EntityDimensions.fixed(0.65f, 0.65f)).build());
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker entity types");
        DefaultAttributeRegistryAccessor.getRegistry().put(DeeperDarkerEntityTypes.SCULK_SNAPPER, SculkSnapperEntity.createSculkSnapperAttributes().build());
    }
}
