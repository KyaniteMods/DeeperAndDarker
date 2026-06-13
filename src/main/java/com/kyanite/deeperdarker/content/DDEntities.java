package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(DeeperDarker.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> BLOOM_BOAT = ENTITIES.register(
            "bloom_boat",
            () -> EntityType.Builder.<Boat>of((entityType, level) -> new Boat(entityType, level, DDItems.BLOOM_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375f, 0.5625f)
                    .eyeHeight(0.5625f)
                    .clientTrackingRange(10)
                    .build(createKey("bloom_boat"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> BLOOM_CHEST_BOAT = ENTITIES.register(
            "bloom_chest_boat",
            () -> EntityType.Builder.<ChestBoat>of((entityType, level) -> new ChestBoat(entityType, level, DDItems.BLOOM_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375f, 0.5625f)
                    .eyeHeight(0.5625f)
                    .clientTrackingRange(10)
                    .build(createKey("bloom_chest_boat"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Boat>> ECHO_BOAT = ENTITIES.register(
            "echo_boat",
            () -> EntityType.Builder.<Boat>of((entityType, level) -> new Boat(entityType, level, DDItems.ECHO_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375f, 0.5625f)
                    .eyeHeight(0.5625f)
                    .clientTrackingRange(10)
                    .build(createKey("echo_boat"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> ECHO_CHEST_BOAT = ENTITIES.register(
            "echo_chest_boat",
            () -> EntityType.Builder.<ChestBoat>of((entityType, level) -> new ChestBoat(entityType, level, DDItems.ECHO_CHEST_BOAT), MobCategory.MISC)
                    .noLootTable()
                    .sized(1.375f, 0.5625f)
                    .eyeHeight(0.5625f)
                    .clientTrackingRange(10)
                    .build(createKey("echo_chest_boat"))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<AnglerFish>> ANGLER_FISH = ENTITIES.register(
            "angler_fish",
            () -> EntityType.Builder.of(AnglerFish::new, MobCategory.WATER_CREATURE)
                    .sized(0.7f, 0.4f)
                    .eyeHeight(0.26f)
                    .clientTrackingRange(10)
                    .build(createKey("angler_fish"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<OvercastPot>> ANGER_POT = ENTITIES.register(
            "anger_pot",
            () -> EntityType.Builder.of(OvercastPot::new, MobCategory.MONSTER)
                    .sized(1.25f, 0.9375f)
                    .eyeHeight(0.4f)
                    .clientTrackingRange(10)
                    .build(createKey("anger_pot"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<OvercastPot>> FEAR_POT = ENTITIES.register(
            "fear_pot",
            () -> EntityType.Builder.of(OvercastPot::new, MobCategory.MONSTER)
                    .sized(0.75f, 1.9375f)
                    .eyeHeight(1.375f)
                    .clientTrackingRange(10)
                    .build(createKey("fear_pot"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<OvercastPot>> SORROW_POT = ENTITIES.register(
            "sorrow_pot", () -> EntityType.Builder.of(OvercastPot::new, MobCategory.MONSTER)
                    .sized(0.75f, 1.2f)
                    .eyeHeight(0.8f)
                    .clientTrackingRange(10)
                    .build(createKey("sorrow_pot"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SculkCentipede>> SCULK_CENTIPEDE = ENTITIES.register(
            "sculk_centipede", () -> EntityType.Builder.of(SculkCentipede::new, MobCategory.MONSTER)
                    .sized(1f, 0.2f)
                    .clientTrackingRange(10)
                    .build(createKey("sculk_centipede"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SculkLeech>> SCULK_LEECH = ENTITIES.register(
            "sculk_leech", () -> EntityType.Builder.of(SculkLeech::new, MobCategory.MONSTER)
                    .sized(0.42f, 0.2f)
                    .clientTrackingRange(10)
                    .build(createKey("sculk_leech"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SculkSnapper>> SCULK_SNAPPER = ENTITIES.register(
            "sculk_snapper", () -> EntityType.Builder.of(SculkSnapper::new, MobCategory.MONSTER)
                    .sized(0.65f, 0.65f)
                    .clientTrackingRange(10)
                    .build(createKey("sculk_snapper"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Shattered>> SHATTERED = ENTITIES.register(
            "shattered", () -> EntityType.Builder.of(Shattered::new, MobCategory.MONSTER)
                    .sized(0.7f, 2.0625f)
                    .clientTrackingRange(10)
                    .build(createKey("shattered"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShriekWorm>> SHRIEK_WORM = ENTITIES.register(
            "shriek_worm", () -> EntityType.Builder.of(ShriekWorm::new, MobCategory.MONSTER)
                    .sized(1f, 5.7f)
                    .clientTrackingRange(10)
                    .build(createKey("shriek_worm"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Sludge>> SLUDGE = ENTITIES.register(
            "sludge", () -> EntityType.Builder.of(Sludge::new, MobCategory.MONSTER)
                    .sized(0.52f, 0.52f)
                    .eyeHeight(0.325f)
                    .spawnDimensionsScale(4f)
                    .clientTrackingRange(10)
                    .build(createKey("sludge"))
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Stalker>> STALKER = ENTITIES.register(
            "stalker", () -> EntityType.Builder.of(Stalker::new, MobCategory.MONSTER)
                    .sized(0.9f, 4.3375f)
                    .eyeHeight(3.99f)
                    .clientTrackingRange(10)
                    .build(createKey("shriek_worm"))
    );

    public static ResourceKey<EntityType<?>> createKey(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, DeeperDarker.rl(name));
    }
}
