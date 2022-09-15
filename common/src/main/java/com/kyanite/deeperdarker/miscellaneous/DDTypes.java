package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.gameevent.GameEvent;

public class DDTypes {
    public static final MobType SCULK = new MobType();

    public static final TagKey<GameEvent> SHATTERED_CAN_LISTEN = createEventTag("shattered_can_listen");

    private static TagKey<GameEvent> createEventTag(String pName) {
        return TagKey.create(Registry.GAME_EVENT_REGISTRY, new ResourceLocation(pName));
    }
}
