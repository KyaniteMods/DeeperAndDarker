package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.content.entities.Shattered;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class SculkConversionRegistry {
    private static final Map<EntityType<? extends LivingEntity>, Consumer<LivingEntity>> CORRUPTION_REGISTRY = new HashMap<>();
    private static final Map<EntityType<? extends LivingEntity>, Consumer<LivingEntity>> PURITY_REGISTRY = new HashMap<>();

    public static void addCorruptionConversion(EntityType<? extends LivingEntity> entity, Consumer<LivingEntity> consumer) {
        CORRUPTION_REGISTRY.put(entity, consumer);
    }

    public static void addPurityConversion(EntityType<? extends LivingEntity> entity, Consumer<LivingEntity> consumer) {
        PURITY_REGISTRY.put(entity, consumer);
    }

    public static boolean corruptionConversion(LivingEntity entity) {
        if (CORRUPTION_REGISTRY.containsKey(entity.getType())) {
            CORRUPTION_REGISTRY.get(entity.getType()).accept(entity);
            return true;
        }
        return false;
    }

    public static boolean purityConversion(LivingEntity entity) {
        if (PURITY_REGISTRY.containsKey(entity.getType())) {
            PURITY_REGISTRY.get(entity.getType()).accept(entity);
            return true;
        }
        return false;
    }

    public static Consumer<LivingEntity> directConversionToMob(EntityType<? extends Mob> entityType) {
        return entity -> {
            if (entity instanceof Mob mob) {
                mob.convertTo(entityType, true);
            }
        };
    }

    static {
        addCorruptionConversion(EntityType.ZOMBIE, directConversionToMob(DDEntities.SHATTERED));
        addCorruptionConversion(EntityType.SLIME, directConversionToMob(DDEntities.SLUDGE));
        addPurityConversion(DDEntities.SHATTERED, directConversionToMob(EntityType.ZOMBIE));
        addPurityConversion(DDEntities.SLUDGE, directConversionToMob(EntityType.SLIME));
    }
}
