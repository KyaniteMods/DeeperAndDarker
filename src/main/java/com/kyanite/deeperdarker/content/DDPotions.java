package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DDPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, DeeperDarker.MOD_ID);
    public static final DeferredHolder<Potion, Potion> SCULK_AFFINITY = POTIONS.register("sculk_affinity", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY, 3600)));
    public static final DeferredHolder<Potion, Potion> LONG_SCULK_AFFINITY = POTIONS.register("long_sculk_affinity", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY, 9600)));
}
