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
    public static final Potion FIZZY = register("fizzy", new Potion());
    public static final Potion CORRUPTION = register("corruption", new Potion(new MobEffectInstance(
            DDEffects.CORRUPTION, 1)));
    public static final Potion PURITY = register("purity", new Potion(new MobEffectInstance(
            DDEffects.PURITY, 1)));

    private static Potion register(String id, Potion potion) {
        return Registry.register(BuiltInRegistries.POTION, DeeperDarker.id(id), potion);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering potions");
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(DDItems.SOUL_CRYSTAL), SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.INVISIBILITY, Ingredient.of(DDItems.SOUL_DUST), SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(SCULK_AFFINITY, Ingredient.of(Items.REDSTONE), LONG_SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.LONG_INVISIBILITY, Ingredient.of(DDItems.SOUL_DUST), LONG_SCULK_AFFINITY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(Potions.WATER, Ingredient.of(DDItems.FIZZ), FIZZY);
        FabricBrewingRecipeRegistry.registerPotionRecipe(FIZZY, Ingredient.of(DDItems.CORRUPTION_SOUL), CORRUPTION);
        FabricBrewingRecipeRegistry.registerPotionRecipe(CORRUPTION, Ingredient.of(Items.FERMENTED_SPIDER_EYE), PURITY);
    }
}
