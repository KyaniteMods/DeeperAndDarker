package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.entities.effect.DeeperDarkerStatusEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DeeperDarkerPotions {
    public static final Potion SCULK_AFFINITY = register("sculk_affinity", new Potion(new StatusEffectInstance(
            DeeperDarkerStatusEffects.SCULK_AFFINITY, 3600)));
    public static final Potion LONG_SCULK_AFFINITY = register("long_sculk_affinity", new Potion(new StatusEffectInstance(
            DeeperDarkerStatusEffects.SCULK_AFFINITY, 9600)));

    private static Potion register(String id, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(DeeperDarker.MOD_ID, id), potion);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker potions");
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(DeeperDarkerItems.SOUL_CRYSTAL), SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.INVISIBILITY, Ingredient.ofItems(DeeperDarkerItems.SOUL_DUST), SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(SCULK_AFFINITY, Ingredient.ofItems(Items.REDSTONE), LONG_SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.LONG_INVISIBILITY, Ingredient.ofItems(DeeperDarkerItems.SOUL_DUST), LONG_SCULK_AFFINITY);
    }
}
