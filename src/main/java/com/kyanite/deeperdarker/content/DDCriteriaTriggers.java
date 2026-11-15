package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class DDCriteriaTriggers {
    public static final PlayerTrigger OPEN_DEAD_MANS_CHEST = register(DeeperDarker.id("player_opened_dead_mans_chest"), new PlayerTrigger());
    public static final KilledTrigger PLAYER_KILLED_WORM = register(DeeperDarker.id("player_killed_worm"), new KilledTrigger());

    public static Criterion<KilledTrigger.TriggerInstance> playerKilledWorm(EntityPredicate.Builder builder) {
        return PLAYER_KILLED_WORM.createCriterion(new KilledTrigger.TriggerInstance(
                Optional.empty(), Optional.of(EntityPredicate.wrap(builder.build())), Optional.empty()
        ));
    }

    public static Criterion<PlayerTrigger.TriggerInstance> openDeadMansChest(Optional<EntityPredicate> builder) {
        return OPEN_DEAD_MANS_CHEST.createCriterion(new PlayerTrigger.TriggerInstance(EntityPredicate.wrap(builder)));
    }

    public static <T extends CriterionTrigger<?>> T register(ResourceLocation id, T criterionTrigger) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES, id, criterionTrigger);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering criterion triggers");
    }
}
