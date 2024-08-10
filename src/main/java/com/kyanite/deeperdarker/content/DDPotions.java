package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class DDPotions {
    public static final Holder<Potion> SCULK_AFFINITY = register("sculk_affinity", new Potion(new MobEffectInstance(
            DDEffects.SCULK_AFFINITY, 3600)));
    public static final Holder<Potion> LONG_SCULK_AFFINITY = register("long_sculk_affinity", new Potion(new MobEffectInstance(
            DDEffects.SCULK_AFFINITY, 9600)));

    private static Holder<Potion> register(String id, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, DeeperDarker.rl(id), potion);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering potions");
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.addMix(Potions.AWKWARD, DDItems.SOUL_CRYSTAL, SCULK_AFFINITY));
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.addMix(Potions.INVISIBILITY, DDItems.SOUL_DUST, SCULK_AFFINITY));
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.addMix(SCULK_AFFINITY, Items.REDSTONE, LONG_SCULK_AFFINITY));
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.addMix(Potions.LONG_INVISIBILITY, DDItems.SOUL_DUST, LONG_SCULK_AFFINITY));
    }
}
