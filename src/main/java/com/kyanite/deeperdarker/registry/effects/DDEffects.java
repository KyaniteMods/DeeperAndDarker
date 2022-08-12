package com.kyanite.deeperdarker.registry.effects;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<MobEffect> SCULK_AFFINITY = MOB_EFFECTS.register("sculk_affinity", () -> new SculkAffinity(MobEffectCategory.BENEFICIAL, 0x38DBE1));
}
