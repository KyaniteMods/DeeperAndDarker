package com.kyanite.deeperdarker.registry.effects;

import java.util.function.Supplier;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DDEffects {
    public static Supplier<MobEffect> SCULK_AFFINITY;

    public static void registerEffects() {
        SCULK_AFFINITY = PlatformHelper.registerEffect("sculk_affinity", () -> new SculkAffinity(MobEffectCategory.BENEFICIAL, 0x38DBE1));
    }
}
