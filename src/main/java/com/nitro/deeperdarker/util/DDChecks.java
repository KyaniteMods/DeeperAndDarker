package com.nitro.deeperdarker.util;

import com.nitro.deeperdarker.registry.properties.DDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DDChecks {
    public static boolean isSculk(Entity potentialVictim) {
        return potentialVictim.getType().is(DDTags.EntityTypes.SCULK);
    }

    public static boolean doesEntityTriggerSculk(LivingEntity checkEntity) {
        return DDChecks.isSculk(checkEntity);
    }
}
