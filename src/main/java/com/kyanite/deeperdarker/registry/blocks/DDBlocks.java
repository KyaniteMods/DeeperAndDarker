package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.blocks.custom.sculkvines.SculkVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.sculkvines.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperAndDarker.MOD_ID);

    // Echo Wood
    public static final RegistryObject<Block> ECHO_PLANKS = register("echo_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 20; }
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 5; }
    });
    public static final RegistryObject<RotatedPillarBlock> ECHO_LOG = register("echo_log", () -> new FlammableWoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_LOG = register("stripped_echo_log", () -> new FlammableWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_WOOD = register("stripped_echo_wood", () -> new FlammableWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> ECHO_WOOD = register("echo_wood", () -> new FlammableWoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<LeavesBlock> ECHO_LEAVES = register("echo_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
        protected boolean decaying(@NotNull BlockState state) { return state.getValue(DISTANCE) == 16; }
    });
    public static final RegistryObject<SlabBlock> ECHO_SLAB = register("echo_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<FenceBlock> ECHO_FENCE = register("echo_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<StairBlock> ECHO_STAIRS = register("echo_stairs", () -> new StairBlock(ECHO_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<ButtonBlock> ECHO_BUTTON = register("echo_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<PressurePlateBlock> ECHO_PRESSURE_PLATE = register("echo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<DoorBlock> ECHO_DOOR = register("echo_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<TrapDoorBlock> ECHO_TRAPDOOR = register("echo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<FenceGateBlock> ECHO_FENCE_GATE = register("echo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<StandingSignBlock> ECHO_SIGN = BLOCKS.register("echo_sign", () -> new DDStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), DDWoodTypes.ECHO));
    public static final RegistryObject<Block> ECHO_WALL_SIGN = BLOCKS.register("echo_wall_sign", () -> new DDWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).lootFrom(ECHO_SIGN), DDWoodTypes.ECHO));

    public static final RegistryObject<Block> ECHO_SOIL = register("echo_soil", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));

    // Sculk Stone
    public static final RegistryObject<Block> SCULK_STONE = register("sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4.5f, 5.5f).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> SCULK_STONE_SLAB = register("sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_STAIRS = register("sculk_stone_stairs", () -> new StairBlock(SCULK_STONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_WALL = register("sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    // Cobbled
    public static final RegistryObject<Block> COBBLED_SCULK_STONE = register("cobbled_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get()).strength(5f, 5.5f)));
    public static final RegistryObject<SlabBlock> COBBLED_SCULK_STONE_SLAB = register("cobbled_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> COBBLED_SCULK_STONE_STAIRS = register("cobbled_sculk_stone_stairs", () -> new StairBlock(COBBLED_SCULK_STONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> COBBLED_SCULK_STONE_WALL = register("cobbled_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));

    // Polished
    public static final RegistryObject<Block> POLISHED_SCULK_STONE = register("polished_sculk_stone", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get()).strength(5f, 5.5f)));
    public static final RegistryObject<SlabBlock> POLISHED_SCULK_STONE_SLAB = register("polished_sculk_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final RegistryObject<StairBlock> POLISHED_SCULK_STONE_STAIRS = register("polished_sculk_stone_stairs", () -> new StairBlock(POLISHED_SCULK_STONE.get()::defaultBlockState, BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final RegistryObject<WallBlock> POLISHED_SCULK_STONE_WALL = register("polished_sculk_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));

    // Bricks
    public static final RegistryObject<Block> SCULK_STONE_BRICKS = register("sculk_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(SCULK_STONE.get()).strength(5f, 5.5f)));
    public static final RegistryObject<SlabBlock> SCULK_STONE_BRICK_SLAB = register("sculk_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final RegistryObject<StairBlock> SCULK_STONE_BRICK_STAIRS = register("sculk_stone_brick_stairs", () -> new StairBlock(SCULK_STONE_BRICKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> SCULK_STONE_BRICK_WALL = register("sculk_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));

    // Sculk Stone Ores
    public static final RegistryObject<Block> SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(2, 4)));
    public static final RegistryObject<Block> SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(6, 14)));
    public static final RegistryObject<Block> SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(4, 10)));
    public static final RegistryObject<Block> SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get()), UniformInt.of(6, 14)));
    public static final RegistryObject<Block> INFESTED_SCULK = register("infested_sculk", () -> new InfestedSculk(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    // Vegetation
    public static final RegistryObject<SculkVinesBlock> SCULK_VINES = register("sculk_vines", () -> new SculkVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak().randomTicks()));
    public static final RegistryObject<SculkVinesPlantBlock> SCULK_VINES_PLANT = BLOCKS.register("sculk_vines_plant", () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak()));
//    public static final RegistryObject<GloomVinesBlock> GLOOM_VINES = BLOCKS.register("gloom_vines", () -> new GloomVinesBlock(BlockBehaviour.Properties.copy(SCULK_VINES.get()).noLootTable().lightLevel(state -> 3)));
//    public static final RegistryObject<GloomVinesPlantBlock> GLOOM_VINES_PLANT = BLOCKS.register("gloom_vines_plant", () -> new GloomVinesPlantBlock(BlockBehaviour.Properties.copy(SCULK_VINES_PLANT.get()).noLootTable().lightLevel(state -> 3)));

    public static final RegistryObject<DropExperienceBlock> SCULK_GLEAM = register("sculk_gleam", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15)));

    // Miscellaneous
    public static final RegistryObject<OthersidePortalBlock> OTHERSIDE_PORTAL = BLOCKS.register("otherside_portal", () -> new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).lightLevel(state -> 5).noLootTable()));
    public static final RegistryObject<Block> ANCIENT_VASE = register("ancient_vase", () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE).noOcclusion()));
    public static final RegistryObject<Block> SCULK_JAW = register("sculk_jaw", () -> new SculkJaw(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(6f)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockProperties);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
        return block;
    }
}
