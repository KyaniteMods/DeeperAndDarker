package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class DDEffects {
    public static final MobEffect SCULK_AFFINITY = register("sculk_affinity", new MobEffect(MobEffectCategory.BENEFICIAL, 0x00ffd0) {
        @Override
        public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
            return true;
        }
    });

    public static final MobEffect HEMOPHILIA = register("hemophilia", new MobEffect(MobEffectCategory.HARMFUL, 0x63030a) {});

    public static final MobEffect CORRUPTION = register("corruption", new InstantenousMobEffect(MobEffectCategory.HARMFUL, 0x0d031a) {
        @Override
        public void applyEffectTick(LivingEntity livingEntity, int i) {
            boolean converted = SculkConversionRegistry.corruptionConversion(livingEntity);
            if (!converted) {
                if (livingEntity.getMobType() == DDMobType.SCULK) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 1));
                } else {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 260, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                }
            }
        }

        @Override
        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int i, double d) {
            boolean converted = SculkConversionRegistry.corruptionConversion(livingEntity);
            if (!converted) {
                if (livingEntity.getMobType() == DDMobType.SCULK) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 260, 1));
                } else {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 260, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                }
            }
        }
    });
    public static final MobEffect PURITY = register("purity", new InstantenousMobEffect(MobEffectCategory.BENEFICIAL, 0x42cf67) {
        @Override
        public void applyEffectTick(LivingEntity livingEntity, int i) {
            boolean converted = SculkConversionRegistry.corruptionConversion(livingEntity);
            if (!converted) {
                if (livingEntity.getMobType() == DDMobType.SCULK) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 6));
                } else {
                    livingEntity.removeEffect(MobEffects.DARKNESS);
                    livingEntity.removeEffect(MobEffects.WITHER);
                }
            }
        }

        @Override
        public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity2, LivingEntity livingEntity, int i, double d) {
            boolean converted = SculkConversionRegistry.purityConversion(livingEntity);
            if (!converted) {
                if (livingEntity.getMobType() == DDMobType.SCULK) {
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 8));
                } else {
                    livingEntity.removeEffect(MobEffects.DARKNESS);
                    livingEntity.removeEffect(MobEffects.WITHER);
                }
            }
        }
    });

    private static MobEffect register(String id, MobEffect mobEffect) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, DeeperDarker.id(id), mobEffect);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering effects");
    }
}
