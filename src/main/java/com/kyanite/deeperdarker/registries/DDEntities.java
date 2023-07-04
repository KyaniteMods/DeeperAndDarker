package com.kyanite.deeperdarker.registries;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.registries.entities.DDBoat;
import com.kyanite.deeperdarker.registries.entities.DDChestBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeeperDarker.MOD_ID);

    public static final RegistryObject<EntityType<DDBoat>> DEEPER_DARKER_BOAT = ENTITIES.register("deeper_darker_boat", () -> EntityType.Builder.<DDBoat>of(DDBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "boat").toString()));
    public static final RegistryObject<EntityType<DDChestBoat>> DEEPER_DARKER_CHEST_BOAT = ENTITIES.register("deeper_darker_chest_boat", () -> EntityType.Builder.<DDChestBoat>of(DDChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(new ResourceLocation(DeeperDarker.MOD_ID, "chest_boat").toString()));
}
