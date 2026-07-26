package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.resources.ResourceLocation;

public class DDCriteriaTriggers {
    public static final PlayerTrigger OPEN_DEAD_MANS_CHEST = CriteriaTriggers.register(new PlayerTrigger(DeeperDarker.id("player_opened_dead_mans_chest")));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering criterion triggers");
    }
}
