package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.PlatformHelper;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.blocks.custom.vines.sculkvines.SculkVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vines.sculkvines.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DDBlocks {
    public static final Map<String, Supplier<Block>> BLOCKS = new HashMap<>();

    // Echo Wood
    public static final Supplier<Block> ECHO_PLANKS = registerBlock("echo_planks", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 20; }
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 5; }
    }) ;

    public static final Supplier<Block> ECHO_LOG = registerBlock("echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<Block> STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<Block> ECHO_WOOD = registerBlock("echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<Block> STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<Block> ECHO_LEAVES = registerBlock("echo_leaves", true, () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
        protected boolean decaying(@NotNull BlockState state) { return state.getValue(DISTANCE) == 16; }
    });

    public static final Supplier<Block> ECHO_SLAB = registerBlock("echo_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<Block> ECHO_STAIRS = registerBlock("echo_stairs", true, () -> new StairBlock(ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<Block> ECHO_WALL = registerBlock("echo_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<Block> ECHO_FENCE = registerBlock("echo_fence", true, () -> new FenceBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<Block> ECHO_FENCE_GATE = registerBlock("echo_fence_gate", true, () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<Block> ECHO_BUTTON = registerBlock("echo_button", true, () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final Supplier<Block> ECHO_PRESSURE_PLATE = registerBlock("echo_pressure_plate", true, () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Supplier<Block> ECHO_DOOR = registerBlock("echo_door", true, () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final Supplier<Block> ECHO_TRAPDOOR = registerBlock("echo_trapdoor", true, () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final Supplier<Block> ECHO_WALL_SIGN = registerBlock("echo_wall_sign", false, () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), DDWoodTypes.ECHO));
    public static Supplier<Item> ECHO_SIGN_ITEM;
    public static final Supplier<Block> ECHO_SIGN = registerSign("echo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), DDWoodTypes.ECHO), ECHO_WALL_SIGN, ECHO_SIGN_ITEM);
    public static final Supplier<Block> ECHO_SOIL = registerBlock("echo_soil", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));

    // Sculk Stone
    public static final Supplier<Block> SCULK_STONE = registerBlock("sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<Block> SCULK_STONE_SLAB = registerBlock("sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final Supplier<Block> SCULK_STONE_STAIRS = registerBlock("sculk_stone_stairs", true, () -> new StairBlock(SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final Supplier<Block> SCULK_STONE_WALL = registerBlock("sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    // Cobbled
    public static final Supplier<Block> COBBLED_SCULK_STONE = registerBlock("cobbled_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<Block> COBBLED_SCULK_STONE_SLAB = registerBlock("cobbled_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final Supplier<Block> COBBLED_SCULK_STONE_STAIRS = registerBlock("cobbled_sculk_stone_stairs", true, () -> new StairBlock(COBBLED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final Supplier<Block> COBBLED_SCULK_STONE_WALL = registerBlock("cobbled_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));

    // Polished
    public static final Supplier<Block> POLISHED_SCULK_STONE = registerBlock("polished_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<Block> POLISHED_SCULK_STONE_SLAB = registerBlock("polished_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final Supplier<Block> POLISHED_SCULK_STONE_STAIRS = registerBlock("polished_sculk_stone_stairs", true, () -> new StairBlock(POLISHED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final Supplier<Block> POLISHED_SCULK_STONE_WALL = registerBlock("polished_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));

    // Bricks
    public static final Supplier<Block> SCULK_STONE_BRICKS = registerBlock("sculk_stone_bricks", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<Block> SCULK_STONE_BRICK_SLAB = registerBlock("sculk_stone_brick_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final Supplier<Block> SCULK_STONE_BRICK_STAIRS = registerBlock("sculk_stone_brick_stairs", true, () -> new StairBlock(SCULK_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final Supplier<Block> SCULK_STONE_BRICK_WALL = registerBlock("sculk_stone_brick_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));

    // Sculk Stone Ores
    public static final Supplier<Block> SCULK_STONE_COAL_ORE = registerBlock("sculk_stone_coal_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final Supplier<Block> SCULK_STONE_IRON_ORE = registerBlock("sculk_stone_iron_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final Supplier<Block> SCULK_STONE_COPPER_ORE = registerBlock("sculk_stone_copper_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final Supplier<Block> SCULK_STONE_GOLD_ORE = registerBlock("sculk_stone_gold_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final Supplier<Block> SCULK_STONE_REDSTONE_ORE = registerBlock("sculk_stone_redstone_ore", true, () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Supplier<Block> SCULK_STONE_EMERALD_ORE = registerBlock("sculk_stone_emerald_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(6, 14)));
    public static final Supplier<Block> SCULK_STONE_LAPIS_ORE = registerBlock("sculk_stone_lapis_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(4, 10)));
    public static final Supplier<Block> SCULK_STONE_DIAMOND_ORE = registerBlock("sculk_stone_diamond_ore", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(6, 14)));

    // Vegetation
    public static final Supplier<Block> SCULK_VINES = registerBlock("sculk_vines", true, () -> new SculkVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak().randomTicks()));
    public static final Supplier<Block> SCULK_VINES_PLANT = registerBlock("sculk_vines_plant", false, () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak()));
    public static final Supplier<Block> SCULK_GLEAM = registerBlock("sculk_gleam", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15)));

    // Miscellaneous
    public static final Supplier<Block> SCULK_JAW = registerBlock("sculk_jaw", true, () -> new SculkJawBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(6f)));
    public static final Supplier<Block> INFESTED_SCULK = registerBlock("infested_sculk", true, () -> new InfestedSculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Supplier<Block> ANCIENT_VASE = registerBlock("ancient_vase", true, () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE).noOcclusion()));
    public static final Supplier<Block> OTHERSIDE_PORTAL = registerBlock("otherside_portal", false, () -> new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).lightLevel(state -> 5).noLootTable()));

    public static <T extends Block> Supplier<Block> registerBlock(String name, boolean createBlockItem, Supplier<Block> block) {
        Supplier<Block> result = PlatformHelper.registerBlock(name, block);
        if(createBlockItem) PlatformHelper.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB.get())));
        BLOCKS.put(name, result);
        return result;
    }

    private static <T extends Block> Supplier<Block> registerSign(String name, Supplier<Block> block, Supplier<Block> wallBlock, Supplier<Item> item) {
        Supplier<Block> standing = PlatformHelper.registerBlock(name, block);
        BLOCKS.put(name, standing);
        item = PlatformHelper.registerItem(name, () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB.get()), standing.get(), wallBlock.get()));
        return standing;
    }

    public static RotatedPillarBlock log(MaterialColor materialColor, MaterialColor materialColor2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> {
            return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? materialColor : materialColor2;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    public static void registerBlocks() {
        DeeperAndDarker.LOGGER.info("Deeper And Darker blocks have been registered");
    }
}
