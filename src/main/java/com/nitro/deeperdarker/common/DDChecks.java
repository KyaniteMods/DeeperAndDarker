package com.nitro.deeperdarker.common;

import com.nitro.deeperdarker.core.registry.other.DDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import static net.minecraft.world.effect.MobEffects.*;
import static net.minecraft.world.item.enchantment.Enchantments.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;


public class DDChecks {

    public static boolean isSculk(Entity potentialVictim) {
        return potentialVictim.getType().is(DDTags.EntityTypes.SCULK);
    }

    public static boolean doesEntityTriggerSculk(LivingEntity checkEntity) {
        return DDChecks.isSculk(checkEntity);
    }
}