package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, DeeperDarker.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<DDBoat>> BOAT = ENTITIES.register("boat", () -> EntityType.Builder.<DDBoat>of(DDBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(DeeperDarker.rl("boat").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<DDChestBoat>> CHEST_BOAT = ENTITIES.register("chest_boat", () -> EntityType.Builder.<DDChestBoat>of(DDChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10).build(DeeperDarker.rl("chest_boat").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<AnglerFish>> ANGLER_FISH = ENTITIES.register("angler_fish", () -> EntityType.Builder.of(AnglerFish::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.4f).clientTrackingRange(10).build(DeeperDarker.rl("angler_fish").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<SculkCentipede>> SCULK_CENTIPEDE = ENTITIES.register("sculk_centipede", () -> EntityType.Builder.of(SculkCentipede::new, MobCategory.MONSTER).sized(1f, 0.2f).clientTrackingRange(10).build(DeeperDarker.rl("sculk_centipede").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<SculkLeech>> SCULK_LEECH = ENTITIES.register("sculk_leech", () -> EntityType.Builder.of(SculkLeech::new, MobCategory.MONSTER).sized(0.42f, 0.2f).clientTrackingRange(10).build(DeeperDarker.rl("sculk_leech").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<SculkSnapper>> SCULK_SNAPPER = ENTITIES.register("sculk_snapper", () -> EntityType.Builder.of(SculkSnapper::new, MobCategory.MONSTER).sized(0.65f, 0.65f).clientTrackingRange(10).build(DeeperDarker.rl("sculk_snapper").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<Shattered>> SHATTERED = ENTITIES.register("shattered", () -> EntityType.Builder.of(Shattered::new, MobCategory.MONSTER).sized(0.8f, 2.125f).clientTrackingRange(10).build(DeeperDarker.rl("shattered").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<ShriekWorm>> SHRIEK_WORM = ENTITIES.register("shriek_worm", () -> EntityType.Builder.of(ShriekWorm::new, MobCategory.MONSTER).sized(1f, 5.7f).clientTrackingRange(10).build(DeeperDarker.rl("shriek_worm").toString()));
    public static final DeferredHolder<EntityType<?>, EntityType<Stalker>> STALKER = ENTITIES.register("stalker", () -> EntityType.Builder.of(Stalker::new, MobCategory.MONSTER).sized(1f, 4.4f).clientTrackingRange(10).build(DeeperDarker.rl("shriek_worm").toString()));
}
