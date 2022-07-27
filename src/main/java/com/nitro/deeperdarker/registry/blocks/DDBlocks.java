package com.nitro.deeperdarker.registry.blocks;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.items.DDItems;
import com.nitro.deeperdarker.registry.properties.DDBlockProperties;
import com.nitro.deeperdarker.util.DDCreativeTab;
import com.teamabnormals.blueprint.common.block.wood.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDBlocks {
//    private static final BlockSubRegistryHelper HELPER = DeeperAndDarker.REGISTRY_HELPER.getBlockSubHelper();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperAndDarker.MODID);

    // Bone Block "wood" variants
    public static final RegistryObject<Block> BONE_PLANKS = register("bone_planks", () -> new PlanksBlock(DDBlockProperties.BONE_WOOD));
    public static final RegistryObject<Block> BONE_SLAB = register("bone_slab", () -> new WoodSlabBlock(DDBlockProperties.BONE_WOOD));
    public static final RegistryObject<Block> BONE_STAIRS = register("bone_stairs", () -> new WoodStairBlock(BONE_PLANKS.get().defaultBlockState(), DDBlockProperties.BONE_WOOD));
    public static final RegistryObject<Block> BONE_FENCE = register("bone_fence", () -> new WoodFenceBlock(DDBlockProperties.BONE_WOOD));
    public static final RegistryObject<Block> BONE_BUTTON = register("bone_button", () -> new BlueprintWoodButtonBlock(DDBlockProperties.getBoneWood(false, true)));
    public static final RegistryObject<Block> BONE_PRESSURE_PLATE = register("bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, DDBlockProperties.BONE_WOOD));
    public static final RegistryObject<Block> BONE_DOOR = register("bone_door", () -> new WoodDoorBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID));
    public static final RegistryObject<Block> BONE_TRAPDOOR = register("bone_trapdoor", () -> new WoodTrapDoorBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID));
    public static final RegistryObject<Block> BONE_FENCE_GATE = register("bone_fence_gate", () -> new WoodFenceGateBlock(DDBlockProperties.BONE_WOOD));
/*
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> BONE_SIGN = HELPER.createSignBlock("bone", MaterialColor.SAND);
    public static final Pair<RegistryObject<BlueprintChestBlock>, RegistryObject<BlueprintTrappedChestBlock>> BONE_CHEST = HELPER.createCompatChestBlocks("indev", "bone", MaterialColor.SAND);
    public static final RegistryObject<Block> BONE_VERTICAL_PLANKS = HELPER.createCompatBlock("indev", "vertical_bone_planks", () -> new Block(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_VERTICAL_SLAB = HELPER.createCompatBlock("indev", "bone_vertical_slab", () -> new VerticalSlabBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_BOOKSHELF = HELPER.createCompatBlock("indev", "bone_bookshelf", () -> new BookshelfBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BONE_LADDER = HELPER.createCompatBlock("indev", "bone_ladder", () -> new BlueprintLadderBlock(DDBlockProperties.BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BONE_BEEHIVE = HELPER.createCompatBlock("indev", "bone_beehive", () -> new BlueprintBeehiveBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BONE_POST = HELPER.createCompatBlock("indev", "bone_post", () -> new WoodPostBlock(DDBlockProperties.BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
*/

    // Sculk Bone Block and "wood" variants
    public static final RegistryObject<Block> SCULK_BONE_BLOCK = register("sculk_bone_block", () -> new StrippedLogBlock(DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_PLANKS = register("sculk_bone_planks", () -> new PlanksBlock(DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_SLAB = register("sculk_bone_slab", () -> new WoodSlabBlock(DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_STAIRS = register("sculk_bone_stairs", () -> new WoodStairBlock(SCULK_BONE_PLANKS.get().defaultBlockState(), DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_FENCE = register("sculk_bone_fence", () -> new WoodFenceBlock(DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_BUTTON = register("sculk_bone_button", () -> new BlueprintWoodButtonBlock(DDBlockProperties.getSculkBoneWood(false, true)));
    public static final RegistryObject<Block> SCULK_BONE_PRESSURE_PLATE = register("sculk_bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_DOOR = register("sculk_bone_door", () -> new WoodDoorBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID));
    public static final RegistryObject<Block> SCULK_BONE_TRAPDOOR = register("sculk_bone_trapdoor", () -> new WoodTrapDoorBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID));
    public static final RegistryObject<Block> SCULK_BONE_FENCE_GATE = register("sculk_bone_fence_gate", () -> new WoodFenceGateBlock(DDBlockProperties.SCULK_BONE_WOOD));
/*
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> SCULK_BONE_SIGN = HELPER.createSignBlock("sculk_bone", MaterialColor.SAND);
    public static final Pair<RegistryObject<BlueprintChestBlock>, RegistryObject<BlueprintTrappedChestBlock>> SCULK_BONE_CHEST = HELPER.createCompatChestBlocks("indev", "sculk_bone", MaterialColor.COLOR_BLACK);
    public static final RegistryObject<Block> SCULK_BONE_VERTICAL_PLANKS = HELPER.createCompatBlock("indev", "vertical_sculk_bone_planks", () -> new Block(DDBlockProperties.SCULK_BONE_WOOD));
    public static final RegistryObject<Block> SCULK_BONE_VERTICAL_SLAB = HELPER.createCompatBlock("indev", "sculk_bone_vertical_slab", () -> new VerticalSlabBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_BOOKSHELF = HELPER.createCompatBlock("indev", "sculk_bone_bookshelf", () -> new BookshelfBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SCULK_BONE_LADDER = HELPER.createCompatBlock("indev", "sculk_bone_ladder", () -> new BlueprintLadderBlock(DDBlockProperties.SCULK_BONE_WOOD_NOT_SOLID), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SCULK_BONE_BEEHIVE = HELPER.createCompatBlock("indev", "sculk_bone_beehive", () -> new BlueprintBeehiveBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> SCULK_BONE_POST = HELPER.createCompatBlock("indev", "sculk_bone_post", () -> new WoodPostBlock(DDBlockProperties.SCULK_BONE_WOOD), CreativeModeTab.TAB_BUILDING_BLOCKS);
*/

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockProperties);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeTab.DEEPER_DARKER)));
        return block;
    }
}
