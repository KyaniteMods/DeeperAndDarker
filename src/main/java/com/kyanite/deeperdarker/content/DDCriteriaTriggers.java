package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.*;

public class DDCriteriaTriggers {
    public static final PlayerTrigger OPEN_DEAD_MANS_CHEST = CriteriaTriggers.register(new PlayerTrigger(DeeperDarker.id("player_opened_dead_mans_chest")));
    public static final KilledTrigger PLAYER_KILLED_WORM = CriteriaTriggers.register(new KilledTrigger(DeeperDarker.id("player_killed_worm")));

    public static KilledTrigger.TriggerInstance playerKilledWorm(EntityPredicate.Builder builder) {
        return new KilledTrigger.TriggerInstance(
                PLAYER_KILLED_WORM.getId(), ContextAwarePredicate.ANY, EntityPredicate.wrap(builder.build()), DamageSourcePredicate.ANY
        );
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering criterion triggers");
    }
}
