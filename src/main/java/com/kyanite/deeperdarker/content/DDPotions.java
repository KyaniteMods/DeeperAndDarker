package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, DeeperDarker.MOD_ID);
    public static final RegistryObject<Potion> SCULK_AFFINITY = POTIONS.register("sculk_affinity", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY.get(), 3600)));
    public static final RegistryObject<Potion> LONG_SCULK_AFFINITY = POTIONS.register("long_sculk_affinity", () -> new Potion(new MobEffectInstance(DDEffects.SCULK_AFFINITY.get(), 9600)));
}
