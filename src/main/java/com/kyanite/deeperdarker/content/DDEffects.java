package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, DeeperDarker.MOD_ID);
    public static final DeferredHolder<MobEffect, MobEffect> SCULK_AFFINITY = EFFECTS.register("sculk_affinity", () -> new MobEffect(MobEffectCategory.BENEFICIAL, 0x00ffd0));
}
