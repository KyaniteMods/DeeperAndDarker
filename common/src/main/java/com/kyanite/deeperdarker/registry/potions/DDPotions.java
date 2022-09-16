package com.kyanite.deeperdarker.registry.potions;

import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

import java.util.function.Supplier;

public class DDPotions {
    public static Supplier<Potion> SCULK_AFFINITY;

    public static void registerPotions() {
        SCULK_AFFINITY = RegistryHelper.registerPotion("sculk_affinity", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY.get(), 3600, 0)));
    }
}
