package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class DDPotions {
    public static final Potion SCULK_AFFINITY = register("sculk_affinity", new Potion(new MobEffectInstance(
            DDEffects.SCULK_AFFINITY, 3600)));
    public static final Potion LONG_SCULK_AFFINITY = register("long_sculk_affinity", new Potion(new MobEffectInstance(
            DDEffects.SCULK_AFFINITY, 9600)));

    private static Potion register(String id, Potion potion) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(DeeperDarker.MOD_ID, id), potion);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering potions");
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.INVISIBILITY, Ingredient.of(DDItems.SOUL_DUST), SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(SCULK_AFFINITY, Ingredient.of(Items.REDSTONE), LONG_SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.LONG_INVISIBILITY, Ingredient.of(DDItems.SOUL_DUST), LONG_SCULK_AFFINITY);
    }
}
