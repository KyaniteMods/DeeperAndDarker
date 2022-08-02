package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.util.DDCreativeModeTab;
import com.kyanite.deeperdarker.util.DDWoodTypes;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperAndDarker.MOD_ID);

    // Bone Block Wood
    public static final RegistryObject<Block> BONE_PLANKS = register("bone_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> BONE_SLAB = register("bone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> BONE_STAIRS = register("bone_stairs", () -> new StairBlock(BONE_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceBlock> BONE_FENCE = register("bone_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> BONE_BUTTON = register("bone_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).strength(0.5f).sound(SoundType.BONE_BLOCK).noCollission().requiresCorrectToolForDrops()));
    public static final RegistryObject<PressurePlateBlock> BONE_PRESSURE_PLATE = register("bone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).strength(0.5f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<DoorBlock> BONE_DOOR = register("bone_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(2f, 6f).sound(SoundType.BONE_BLOCK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<TrapDoorBlock> BONE_TRAPDOOR = register("bone_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(2f, 6f).sound(SoundType.BONE_BLOCK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> BONE_FENCE_GATE = register("bone_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(2f, 6f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BONE_WALL_SIGN = BLOCKS.register("bone_wall_sign", () -> new DDWallSignBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.BONE));
    public static final RegistryObject<StandingSignBlock> BONE_SIGN = BLOCKS.register("bone_sign", () -> new DDStandingSignBlock(BlockBehaviour.Properties.copy(BONE_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.BONE));

    // Sculk Bone Block Wood
    public static final RegistryObject<RotatedPillarBlock> SCULK_BONE_BLOCK = register("sculk_bone_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_PLANKS = register("sculk_bone_planks", () -> new Block(BlockBehaviour.Properties.copy(SCULK_BONE_BLOCK.get()).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> SCULK_BONE_SLAB = register("sculk_bone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> SCULK_BONE_STAIRS = register("sculk_bone_stairs", () -> new StairBlock(SCULK_BONE_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceBlock> SCULK_BONE_FENCE = register("sculk_bone_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> SCULK_BONE_BUTTON = register("sculk_bone_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).strength(0.5f).sound(SoundType.SCULK).noCollission().requiresCorrectToolForDrops()));
    public static final RegistryObject<PressurePlateBlock> SCULK_BONE_PRESSURE_PLATE = register("sculk_bone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).strength(0.5f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<DoorBlock> SCULK_BONE_DOOR = register("sculk_bone_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(2f, 3f).sound(SoundType.SCULK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<TrapDoorBlock> SCULK_BONE_TRAPDOOR = register("sculk_bone_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(2f, 3f).sound(SoundType.SCULK).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> SCULK_BONE_FENCE_GATE = register("sculk_bone_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(2f, 3f).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SCULK_BONE_WALL_SIGN = BLOCKS.register("sculk_bone_wall_sign", () -> new DDWallSignBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.SCULK_BONE));
    public static final RegistryObject<StandingSignBlock> SCULK_BONE_SIGN = BLOCKS.register("sculk_bone_sign", () -> new DDStandingSignBlock(BlockBehaviour.Properties.copy(SCULK_BONE_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.SCULK_BONE));

    // Sculk Stone
    public static final RegistryObject<Block> SCULK_STONE = register("sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5.5F, 6.0F).sound(SoundType.SCULK).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> SCULK_STONE_SLAB = register("sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_STAIRS = register("sculk_stone_stairs", () -> new StairBlock(SCULK_STONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_WALL = register("sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    // Polished
    public static final RegistryObject<Block> POLISHED_SCULK_STONE = register("polished_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> POLISHED_SCULK_STONE_SLAB = register("polished_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> POLISHED_SCULK_STONE_STAIRS = register("polished_sculk_stone_stairs", () -> new StairBlock(POLISHED_SCULK_STONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> POLISHED_SCULK_STONE_WALL = register("polished_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    // Bricks
    public static final RegistryObject<Block> SCULK_STONE_BRICKS = register("sculk_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<SlabBlock> SCULK_STONE_BRICK_SLAB = register("sculk_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_BRICK_STAIRS = register("sculk_stone_brick_stairs", () -> new StairBlock(SCULK_STONE_BRICKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_BRICK_WALL = register("sculk_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    // Sculk Stone Ores
    public static final RegistryObject<Block> SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(6, 14)));
    public static final RegistryObject<Block> SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(4, 10)));
    public static final RegistryObject<Block> SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(6, 14)));

    // Misc. Otherside
    public static final RegistryObject<DropExperienceBlock> SCULK_GLEAM = register("sculk_gleam", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel((state) -> 15)));
    public static final RegistryObject<SculkVinesBlock> SCULK_VINES = register("sculk_vines", () -> new SculkVinesBlock(BlockBehaviour.Properties.of(Material.SCULK).noCollission().instabreak().sound(SoundType.SCULK)));
    public static final RegistryObject<SculkVinesPlantBlock> SCULK_VINES_PLANT = BLOCKS.register("sculk_vines_plant", () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.of(Material.SCULK).noCollission().instabreak().sound(SoundType.SCULK)));
    public static final RegistryObject<OthersidePortalBlock> OTHERSIDE_PORTAL = BLOCKS.register("otherside_portal", () -> new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).strength(-1f).noCollission().lightLevel((state) -> 5).noLootTable()));
    public static final RegistryObject<Block> INFESTED_SCULK = register("infested_sculk", () -> new InfestedSculk(BlockBehaviour.Properties.copy(Blocks.SCULK).sound(SoundType.SCULK).strength(0.2F)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockProperties);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
        return block;
    }
}