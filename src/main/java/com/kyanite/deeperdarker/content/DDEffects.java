package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DDEffects {
    public static final Holder<MobEffect> SCULK_AFFINITY = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, DeeperDarker.rl("sculk_affinity"), new MobEffect(MobEffectCategory.BENEFICIAL, 0x00ffd0) {
        @Override
        public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
            return true;
        }
    });

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering effects");
    }
}
