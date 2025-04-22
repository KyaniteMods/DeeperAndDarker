package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, DeeperDarker.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> SCULK_AFFINITY = EFFECTS.register("sculk_affinity", () -> new DDMobEffect(MobEffectCategory.BENEFICIAL, 0x00ffd0));
    public static final DeferredHolder<MobEffect, MobEffect> SCULK_OMEN = EFFECTS.register("sculk_omen", () -> new DDMobEffect(MobEffectCategory.NEUTRAL, 0x05d0eb, ParticleTypes.TRIAL_OMEN).withSoundOnAdded(DDSounds.APPLY_EFFECT_SCULK_OMEN.get()));

    public static class DDMobEffect extends MobEffect {
        public DDMobEffect(MobEffectCategory category, int color) {
            super(category, color);
        }

        public DDMobEffect(MobEffectCategory category, int color, ParticleOptions particle) {
            super(category, color, particle);
        }
    }
}
