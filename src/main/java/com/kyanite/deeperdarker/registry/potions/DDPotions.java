package com.kyanite.deeperdarker.registry.potions;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<Potion> SCULK_AFFINITY_POTION = POTIONS.register("sculk_affinity_potion", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY.get(), 250, 0)));
}
