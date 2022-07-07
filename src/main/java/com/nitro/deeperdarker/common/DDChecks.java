package com.nitro.deeperdarker.common;

import com.nitro.deeperdarker.core.registry.other.DDTags;
import net.minecraft.world.entity.LivingEntity;
import static net.minecraft.world.effect.MobEffects.*;
import static net.minecraft.world.item.enchantment.Enchantments.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;


public class DDChecks {

    public static boolean isEntityWearingFeatherFall(LivingEntity potentialVictim) {
        return EnchantmentHelper.getEnchantmentLevel(FALL_PROTECTION, potentialVictim) >= 0;
    }

    public static boolean doesEntityHaveSlowFall(LivingEntity potentialVictim) {
        return potentialVictim.hasEffect(SLOW_FALLING);
    }

    public static boolean isEntitySculkSafe(LivingEntity potentialVictim) {
        return potentialVictim.getType().is(DDTags.EntityTypes.SCULK_SAFE);
    }

    public static boolean doesEntityTriggerSculk(LivingEntity checkEntity) {
        return DDChecks.isEntityWearingFeatherFall(checkEntity) || DDChecks.doesEntityHaveSlowFall(checkEntity) || DDChecks.isEntitySculkSafe(checkEntity);
    }
}