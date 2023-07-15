package com.kyanite.deeperdarker.entities.effect;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeeperDarkerStatusEffects {
    public static final StatusEffect SCULK_AFFINITY = Registry.register(Registries.STATUS_EFFECT, new Identifier(
            DeeperDarker.MOD_ID, "sculk_affinity"), new SculkAffinityStatusEffect(StatusEffectCategory.BENEFICIAL, 0x00ffd0));
}
