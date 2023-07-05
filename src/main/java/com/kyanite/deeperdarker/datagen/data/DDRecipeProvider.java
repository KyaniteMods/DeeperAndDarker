package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.registries.DDBlocks;
import com.kyanite.deeperdarker.registries.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public DDRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        addWoodenRecipes(pWriter, DDTags.Items.ECHO_LOGS, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.ECHO_PLANKS, DDBlocks.ECHO_STAIRS, DDBlocks.ECHO_SLAB, DDBlocks.ECHO_FENCE, DDBlocks.ECHO_FENCE_GATE, DDBlocks.ECHO_DOOR, DDBlocks.ECHO_TRAPDOOR, DDBlocks.ECHO_PRESSURE_PLATE, DDBlocks.ECHO_BUTTON, DDItems.ECHO_SIGN, DDItems.ECHO_HANGING_SIGN, DDItems.ECHO_BOAT, DDItems.ECHO_CHEST_BOAT);
    }

    private void addWoodenRecipes(Consumer<FinishedRecipe> writer, TagKey<Item> logs, RegistryObject<RotatedPillarBlock> strippedLog, RegistryObject<Block> planks, RegistryObject<StairBlock> stairs, RegistryObject<SlabBlock> slabs, RegistryObject<FenceBlock> fence, RegistryObject<FenceGateBlock> fenceGate, RegistryObject<DoorBlock> door, RegistryObject<TrapDoorBlock> trapDoor, RegistryObject<PressurePlateBlock> pressurePlate, RegistryObject<ButtonBlock> button, RegistryObject<Item> sign, RegistryObject<Item> hangingSign, RegistryObject<Item> boat, RegistryObject<Item> chestBoat) {
        planksFromLogs(writer, planks.get(), logs, 4);
        stairBuilder(stairs.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        slab(writer, RecipeCategory.BUILDING_BLOCKS, slabs.get(), planks.get());
        fenceBuilder(fence.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        fenceGateBuilder(fenceGate.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        doorBuilder(door.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        trapdoorBuilder(trapDoor.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        pressurePlate(writer, pressurePlate.get(), planks.get());
        buttonBuilder(button.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        signBuilder(sign.get(), Ingredient.of(planks.get())).unlockedBy("has_planks", has(planks.get())).save(writer);
        hangingSign(writer, hangingSign.get(), strippedLog.get());
        woodenBoat(writer, boat.get(), planks.get());
        chestBoat(writer, chestBoat.get(), boat.get());
    }
}
