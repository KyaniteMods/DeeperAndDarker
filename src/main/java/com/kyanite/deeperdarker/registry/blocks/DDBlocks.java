package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.blocks.custom.gloomvines.GloomVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.gloomvines.GloomVinesPlantBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.sculkvines.SculkVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.sculkvines.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
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

    // Echo Wood
    public static final RegistryObject<RotatedPillarBlock> ECHO_LOG = register("echo_log", () -> new DDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(2f).sound(SoundType.SCULK)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_LOG = register("stripped_echo_log", () -> new DDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> ECHO_WOOD = register("echo_wood", () -> new DDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_ECHO_WOOD = register("stripped_echo_wood", () -> new DDFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<Block> ECHO_PLANKS = register("echo_planks", () -> new Block(BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<SlabBlock> ECHO_SLAB = register("echo_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<StairBlock> ECHO_STAIRS = register("echo_stairs", () -> new StairBlock(ECHO_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(ECHO_LOG.get())));
    public static final RegistryObject<FenceBlock> ECHO_FENCE = register("echo_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<ButtonBlock> ECHO_BUTTON = register("echo_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.5f).noCollission()));
    public static final RegistryObject<PressurePlateBlock> ECHO_PRESSURE_PLATE = register("echo_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.5f)));
    public static final RegistryObject<DoorBlock> ECHO_DOOR = register("echo_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<TrapDoorBlock> ECHO_TRAPDOOR = register("echo_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<FenceGateBlock> ECHO_FENCE_GATE = register("echo_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final RegistryObject<Block> ECHO_WALL_SIGN = BLOCKS.register("echo_wall_sign", () -> new DDWallSignBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.ECHO));
    public static final RegistryObject<StandingSignBlock> ECHO_SIGN = BLOCKS.register("echo_sign", () -> new DDStandingSignBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()).strength(1f).noCollission(), DDWoodTypes.ECHO));

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

    // Misc. Otherside and Sculk
    public static final RegistryObject<Block> ANCIENT_VASE = register("ancient_vase", () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(DDSounds.VASE).noOcclusion()));
    public static final RegistryObject<Block> INFESTED_SCULK = register("infested_sculk", () -> new InfestedSculk(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.2F)));
    public static final RegistryObject<OthersidePortalBlock> OTHERSIDE_PORTAL = BLOCKS.register("otherside_portal", () -> new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).lightLevel((state) -> 5).noLootTable()));
    public static final RegistryObject<DropExperienceBlock> SCULK_GLEAM = register("sculk_gleam", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel((state) -> 15)));
    public static final RegistryObject<SculkVinesBlock> SCULK_VINES = register("sculk_vines", () -> new SculkVinesBlock(BlockBehaviour.Properties.of(Material.SCULK).noCollission().instabreak().sound(SoundType.SCULK)));
    public static final RegistryObject<SculkVinesPlantBlock> SCULK_VINES_PLANT = BLOCKS.register("sculk_vines_plant", () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.copy(SCULK_VINES.get())));
    public static final RegistryObject<Block> GLOOM_GRASS = register("gloom_grass", () -> new GloomGrass(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS).lightLevel((state) -> 0).strength(0.2F)));
    public static final RegistryObject<GloomVinesBlock> GLOOM_VINES = BLOCKS.register("gloom_vines", () -> new GloomVinesBlock(BlockBehaviour.Properties.copy(SCULK_VINES.get())));
    public static final RegistryObject<GloomVinesPlantBlock> GLOOM_VINES_PLANT = BLOCKS.register("gloom_vines_plant", () -> new GloomVinesPlantBlock(BlockBehaviour.Properties.copy(SCULK_VINES.get())));

    public static final RegistryObject<Block> SCULK_TRANSMITTER = register("sculk_transmitter", () -> new SculkTransmitter(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.2F)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockProperties);
        DDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
        return block;
    }
}
