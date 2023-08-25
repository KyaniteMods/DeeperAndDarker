package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DDEffects {
    public static final MobEffect SCULK_AFFINITY = Registry.register(Registry.MOB_EFFECT, new ResourceLocation(
            DeeperDarker.MOD_ID, "sculk_affinity"), new MobEffect(MobEffectCategory.BENEFICIAL, 0x00ffd0) {
        @Override
        public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
            return true;
        }
    });

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering effects");
    }
}
