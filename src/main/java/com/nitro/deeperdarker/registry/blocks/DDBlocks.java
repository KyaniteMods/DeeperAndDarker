package com.nitro.deeperdarker.registry.blocks;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.registry.items.DDItems;
import com.nitro.deeperdarker.util.DDCreativeTab;
import com.teamabnormals.blueprint.common.block.wood.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperAndDarker.MODID);

    // Bone Block "wood" variants
    public static final RegistryObject<Block> BONE_PLANKS = register("bone_planks", () -> new PlanksBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_SLAB = register("bone_slab", () -> new WoodSlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_STAIRS = register("bone_stairs", () -> new WoodStairBlock(BONE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_FENCE = register("bone_fence", () -> new WoodFenceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_BUTTON = register("bone_button", () -> new BlueprintWoodButtonBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f).sound(SoundType.BONE_BLOCK).noCollission().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_PRESSURE_PLATE = register("bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.STONE).strength(0.5f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_DOOR = register("bone_door", () -> new WoodDoorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_TRAPDOOR = register("bone_trapdoor", () -> new WoodTrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_FENCE_GATE = register("bone_fence_gate", () -> new WoodFenceGateBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));

    // Sculk Bone Block and "wood" variants
    public static final RegistryObject<Block> SCULK_BONE_BLOCK = register("sculk_bone_block", () -> new StrippedLogBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_PLANKS = register("sculk_bone_planks", () -> new PlanksBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_SLAB = register("sculk_bone_slab", () -> new WoodSlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_STAIRS = register("sculk_bone_stairs", () -> new WoodStairBlock(SCULK_BONE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_FENCE = register("sculk_bone_fence", () -> new WoodFenceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_BUTTON = register("sculk_bone_button", () -> new BlueprintWoodButtonBlock(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f).sound(SoundType.SCULK).noCollission().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_PRESSURE_PLATE = register("sculk_bone_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.STONE).strength(0.5f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_DOOR = register("sculk_bone_door", () -> new WoodDoorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_TRAPDOOR = register("sculk_bone_trapdoor", () -> new WoodTrapDoorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_FENCE_GATE = register("sculk_bone_fence_gate", () -> new WoodFenceGateBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockProperties);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeTab.DEEPER_DARKER)));
        return block;
    }
}
