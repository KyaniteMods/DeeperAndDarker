package com.nitro.deeperdarker.core.registry;

import com.mojang.datafixers.util.Pair;
import com.nitro.deeperdarker.core.registry.properties.DDBlockProperties;
import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;
import com.teamabnormals.blueprint.common.block.BlueprintLadderBlock;
import com.teamabnormals.blueprint.common.block.BookshelfBlock;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.wood.*;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDBlocks {
    private static final BlockSubRegistryHelper HELPER = DeeperAndDarker.REGISTRY_HELPER.getBlockSubHelper();

    // Bone Block "wood" variants
    public static final RegistryObject<Block> BONE_PLANKS = HELPER.createBlock("bone_planks", () -> new PlanksBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_SLAB = HELPER.createBlock("bone_slab", () -> new WoodSlabBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_STAIRS = HELPER.createBlock("bone_stairs", () -> new WoodStairBlock(BONE_PLANKS.get().defaultBlockState(), DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_FENCE = HELPER.createBlock("bone_fence", () -> new WoodFenceBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BONE_BUTTON = HELPER.createBlock("bone_button", () -> new BlueprintWoodButtonBlock(DDBlockProperties.getBoneWood(false, true)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> BONE_PRESSURE_PLATE = HELPER.createBlock("bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> BONE_DOOR = HELPER.createBlock("bone_door", () -> new WoodDoorBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> BONE_TRAPDOOR = HELPER.createBlock("bone_trapdoor", () -> new WoodTrapDoorBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> BONE_FENCE_GATE = HELPER.createBlock("bone_fence_gate", () -> new WoodFenceGateBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> BONE_SIGN = HELPER.createSignBlock("bone", MaterialColor.SAND);
    public static final Pair<RegistryObject<BlueprintChestBlock>, RegistryObject<BlueprintTrappedChestBlock>> BONE_CHEST = HELPER.createCompatChestBlocks("indev", "bone", MaterialColor.SAND);
    public static final RegistryObject<Block> BONE_VERTICAL_PLANKS = HELPER.createCompatBlock("indev", "vertical_bone_planks", () -> new Block(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_VERTICAL_SLAB = HELPER.createCompatBlock("indev", "bone_vertical_slab", () -> new VerticalSlabBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_BOOKSHELF = HELPER.createCompatBlock("indev", "bone_bookshelf", () -> new BookshelfBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_LADDER = HELPER.createCompatBlock("indev", "bone_ladder", () -> new BlueprintLadderBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BONE_BEEHIVE = HELPER.createCompatBlock("indev", "bone_beehive", () -> new BlueprintBeehiveBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BONE_POST = HELPER.createCompatBlock("indev", "bone_post", () -> new WoodPostBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);


    // Sculk Bone Block and "wood" variants
    public static final RegistryObject<Block> SCULK_BONE_BLOCK = HELPER.createBlock("sculk_bone_block", () -> new StrippedLogBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_PLANKS = HELPER.createBlock("sculk_bone_planks", () -> new PlanksBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_SLAB = HELPER.createBlock("sculk_bone_slab", () -> new WoodSlabBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_STAIRS = HELPER.createBlock("sculk_bone_stairs", () -> new WoodStairBlock(SCULK_BONE_PLANKS.get().defaultBlockState(), DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_FENCE = HELPER.createBlock("sculk_bone_fence", () -> new WoodFenceBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SCULK_BONE_BUTTON = HELPER.createBlock("sculk_bone_button", () -> new BlueprintWoodButtonBlock(DDBlockProperties.getSculkBoneWood(false, true)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> SCULK_BONE_PRESSURE_PLATE = HELPER.createBlock("sculk_bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> SCULK_BONE_DOOR = HELPER.createBlock("sculk_bone_door", () -> new WoodDoorBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> SCULK_BONE_TRAPDOOR = HELPER.createBlock("sculk_bone_trapdoor", () -> new WoodTrapDoorBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> SCULK_BONE_FENCE_GATE = HELPER.createBlock("sculk_bone_fence_gate", () -> new WoodFenceGateBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> SCULK_BONE_SIGN = HELPER.createSignBlock("sculk_bone", MaterialColor.SAND);
    public static final Pair<RegistryObject<BlueprintChestBlock>, RegistryObject<BlueprintTrappedChestBlock>> SCULK_BONE_CHEST = HELPER.createCompatChestBlocks("indev", "sculk_bone", MaterialColor.COLOR_BLACK);
    public static final RegistryObject<Block> SCULK_BONE_VERTICAL_PLANKS = HELPER.createCompatBlock("indev", "vertical_sculk_bone_planks", () -> new Block(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_VERTICAL_SLAB = HELPER.createCompatBlock("indev", "sculk_bone_vertical_slab", () -> new VerticalSlabBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_BOOKSHELF = HELPER.createCompatBlock("indev", "sculk_bone_bookshelf", () -> new BookshelfBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_LADDER = HELPER.createCompatBlock("indev", "sculk_bone_ladder", () -> new BlueprintLadderBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SCULK_BONE_BEEHIVE = HELPER.createCompatBlock("indev", "sculk_bone_beehive", () -> new BlueprintBeehiveBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SCULK_BONE_POST = HELPER.createCompatBlock("indev", "sculk_bone_post", () -> new WoodPostBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
}