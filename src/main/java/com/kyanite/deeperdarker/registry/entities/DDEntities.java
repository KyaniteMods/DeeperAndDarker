package com.kyanite.deeperdarker.registry.entities;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<EntityType<BoatEntity>> BOAT = ENTITY_TYPES.register("boat", () -> EntityType.Builder.of(BoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "boat").toString()));
    public static final RegistryObject<EntityType<ChestBoatEntity>> CHEST_BOAT = ENTITY_TYPES.register("chest_boat", () -> EntityType.Builder.of(ChestBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "chest_boat").toString()));
    public static final RegistryObject<EntityType<SculkCentipedeEntity>> CENTIPEDE = ENTITY_TYPES.register("sculk_centipede", () -> EntityType.Builder.of(SculkCentipedeEntity::new, MobCategory.MONSTER).sized(0.3f, 0.2f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_centipede").toString()));
    public static final RegistryObject<EntityType<SculkLeechEntity>> SCULK_LEECH = ENTITY_TYPES.register("sculk_leech", () -> EntityType.Builder.of(SculkLeechEntity::new, MobCategory.MONSTER).sized(0.3f, 0.2f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_leech").toString()));
    public static final RegistryObject<EntityType<SculkSnapperEntity>> SCULK_SNAPPER = ENTITY_TYPES.register("sculk_snapper", () -> EntityType.Builder.of(SculkSnapperEntity::new, MobCategory.MONSTER).sized(1, 1).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk_snapper").toString()));
    public static final RegistryObject<EntityType<ShatteredEntity>> SHATTERED = ENTITY_TYPES.register("shattered", () -> EntityType.Builder.of(ShatteredEntity::new, MobCategory.MONSTER).sized(0.85f, 2.45f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "shattered").toString()));
    public static final RegistryObject<EntityType<ShriekWormEntity>> SHRIEK_WORM = ENTITY_TYPES.register("shriek_worm", () -> EntityType.Builder.of(ShriekWormEntity::new, MobCategory.MONSTER).sized(1.5f, 5.7f).clientTrackingRange(10).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "shriek_worm").toString()));
    public static final RegistryObject<EntityType<StalkerEntity>> STALKER = ENTITY_TYPES.register("stalker", () -> EntityType.Builder.of(StalkerEntity::new, MobCategory.MONSTER).sized(1f, 4.4f).build(new ResourceLocation(DeeperAndDarker.MOD_ID, "stalker").toString()));
}