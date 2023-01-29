package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.platform.PortalHelper;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.GloomCactusBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.GloomGrassBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils.SculkTendrilsBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils.SculkTendrilsPlantBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.vines.SculkVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.vines.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
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
    public static final Supplier<Block> ECHO_PLANKS = registerBlock("echo_planks", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<RotatedPillarBlock> ECHO_LOG = registerBlock("echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<RotatedPillarBlock> STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<RotatedPillarBlock> STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<RotatedPillarBlock> ECHO_WOOD = registerBlock("echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final Supplier<Block> ECHO_LEAVES = registerBlock("echo_leaves", true, () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
        protected boolean decaying(@NotNull BlockState state) {
            return state.getValue(DISTANCE) == 16;
        }
    });
    public static final Supplier<SlabBlock> ECHO_SLAB = registerBlock("echo_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<FenceBlock> ECHO_FENCE = registerBlock("echo_fence", true, () -> new FenceBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<StairBlock> ECHO_STAIRS = registerBlock("echo_stairs", true, () -> new StairBlock(ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<ButtonBlock> ECHO_BUTTON = registerBlock("echo_button", true, () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final Supplier<PressurePlateBlock> ECHO_PRESSURE_PLATE = registerBlock("echo_pressure_plate", true, () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Supplier<DoorBlock> ECHO_DOOR = registerBlock("echo_door", true, () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)));
    public static final Supplier<TrapDoorBlock> ECHO_TRAPDOOR = registerBlock("echo_trapdoor", true, () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final Supplier<FenceGateBlock> ECHO_FENCE_GATE = registerBlock("echo_fence_gate", true, () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ECHO_PLANKS.get())));
    public static final Supplier<WallSignBlock> ECHO_WALL_SIGN = registerBlock("echo_wall_sign", false, () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), DDWoodTypes.ECHO));
    public static final Supplier<StandingSignBlock> ECHO_SIGN = registerSign("echo_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), DDWoodTypes.ECHO), ECHO_WALL_SIGN);
    public static final Supplier<Block> INFESTED_SCULK = registerBlock("infested_sculk", true, () -> new InfestedSculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Supplier<SculkJawBlock> SCULK_JAW = registerBlock("sculk_jaw", true, () -> new SculkJawBlock(BlockBehaviour.Properties.of(Material.SCULK).sound(DDSounds.SCULK_JAW).strength(6f)));

    // Echo Soil/Sculk Grime
    public static final Supplier<Block> ECHO_SOIL = registerBlock("echo_soil", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));
    public static final Supplier<Block> SCULK_GRIME = registerBlock("sculk_grime", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f)));
    public static final Supplier<Block> GRIME_BRICKS = registerBlock("sculk_grime_bricks", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).color(MaterialColor.COLOR_BLACK).sound(DDSounds.SCULK_STONE)));
    public static final Supplier<SlabBlock> GRIME_BRICK_SLAB = registerBlock("sculk_grime_brick_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get())));
    public static final Supplier<StairBlock> GRIME_BRICK_STAIRS = registerBlock("sculk_grime_brick_stairs", true, () -> new StairBlock(GRIME_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get())));
    public static final Supplier<WallBlock> GRIME_BRICK_WALL = registerBlock("sculk_grime_brick_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get())));

    // Sculk Stone
    public static final Supplier<Block> SCULK_STONE = registerBlock("sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> SCULK_STONE_SLAB = registerBlock("sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final Supplier<StairBlock> SCULK_STONE_STAIRS = registerBlock("sculk_stone_stairs", true, () -> new StairBlock(SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE.get())));
    public static final Supplier<WallBlock> SCULK_STONE_WALL = registerBlock("sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE.get())));

    public static final Supplier<Block> COBBLED_SCULK_STONE = registerBlock("cobbled_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> COBBLED_SCULK_STONE_SLAB = registerBlock("cobbled_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final Supplier<StairBlock> COBBLED_SCULK_STONE_STAIRS = registerBlock("cobbled_sculk_stone_stairs", true, () -> new StairBlock(COBBLED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));
    public static final Supplier<WallBlock> COBBLED_SCULK_STONE_WALL = registerBlock("cobbled_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get())));

    public static final Supplier<Block> POLISHED_SCULK_STONE = registerBlock("polished_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> POLISHED_SCULK_STONE_SLAB = registerBlock("polished_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final Supplier<StairBlock> POLISHED_SCULK_STONE_STAIRS = registerBlock("polished_sculk_stone_stairs", true, () -> new StairBlock(POLISHED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));
    public static final Supplier<WallBlock> POLISHED_SCULK_STONE_WALL = registerBlock("polished_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get())));

    public static final Supplier<Block> SCULK_STONE_BRICKS = registerBlock("sculk_stone_bricks", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> SCULK_STONE_BRICK_SLAB = registerBlock("sculk_stone_brick_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final Supplier<StairBlock> SCULK_STONE_BRICK_STAIRS = registerBlock("sculk_stone_brick_stairs", true, () -> new StairBlock(SCULK_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));
    public static final Supplier<WallBlock> SCULK_STONE_BRICK_WALL = registerBlock("sculk_stone_brick_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get())));

    public static final Supplier<Block> SCULK_STONE_TILES = registerBlock("sculk_stone_tiles", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> SCULK_STONE_TILE_SLAB = registerBlock("sculk_stone_tile_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));
    public static final Supplier<StairBlock> SCULK_STONE_TILE_STAIRS = registerBlock("sculk_stone_tile_stairs", true, () -> new StairBlock(SCULK_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));
    public static final Supplier<WallBlock> SCULK_STONE_TILE_WALL = registerBlock("sculk_stone_tile_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get())));

    public static final Supplier<Block> SMOOTH_SCULK_STONE = registerBlock("smooth_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> SMOOTH_SCULK_STONE_SLAB = registerBlock("smooth_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));
    public static final Supplier<StairBlock> SMOOTH_SCULK_STONE_STAIRS = registerBlock("smooth_sculk_stone_stairs", true, () -> new StairBlock(SMOOTH_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));
    public static final Supplier<WallBlock> SMOOTH_SCULK_STONE_WALL = registerBlock("smooth_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get())));

    public static final Supplier<Block> CUT_SCULK_STONE = registerBlock("cut_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> CUT_SCULK_STONE_SLAB = registerBlock("cut_sculk_stone_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));
    public static final Supplier<StairBlock> CUT_SCULK_STONE_STAIRS = registerBlock("cut_sculk_stone_stairs", true, () -> new StairBlock(CUT_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));
    public static final Supplier<WallBlock> CUT_SCULK_STONE_WALL = registerBlock("cut_sculk_stone_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get())));

    public static final Supplier<Block> CHISELED_SCULK_STONE = registerBlock("chiseled_sculk_stone", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));

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
    public static final Supplier<SculkTendrilsBlock> SCULK_TENDRILS = registerBlock("sculk_tendrils", true, () -> new SculkTendrilsBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).randomTicks().noOcclusion().noCollission().instabreak()));
    public static final Supplier<SculkTendrilsPlantBlock> SCULK_TENDRILS_PLANT = registerBlock("sculk_tendrils_plant", false, () -> new SculkTendrilsPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak()));
    public static final Supplier<Block> SCULK_GLEAM = registerBlock("sculk_gleam", true, () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15)));

    // Overcast Columns
    public static final Supplier<GloomSculkBlock> GLOOM_SCULK = registerBlock("gloom_sculk", true, () -> new GloomSculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Supplier<GeyserBlock> GEYSER = registerBlock("geyser", true, () -> new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CRYSTALLIZED_AMBER = registerBlock("crystallized_amber", true, () -> new HalfTransparentBlock(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion().lightLevel(state -> 1).sound(SoundType.GLASS)));
    public static final Supplier<Block> GLOOM_CACTUS = registerBlock("gloom_cactus", true, () -> new GloomCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(0.5f).lightLevel(state -> 6).sound(SoundType.WOOL)));
    public static final Supplier<Block> GLOOMY_GRASS = registerBlock("gloomy_grass", true, () -> new GloomGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 1)));

    // Gloomslate
    public static final Supplier<Block> GLOOMSLATE = registerBlock("gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Supplier<SlabBlock> GLOOMSLATE_SLAB = registerBlock("gloomslate_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<StairBlock> GLOOMSLATE_STAIRS = registerBlock("gloomslate_stairs", true, () -> new StairBlock(GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<WallBlock> GLOOMSLATE_WALL = registerBlock("gloomslate_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));

    public static final Supplier<Block> COBBLED_GLOOMSLATE = registerBlock("cobbled_gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> COBBLED_GLOOMSLATE_SLAB = registerBlock("cobbled_gloomslate_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));
    public static final Supplier<StairBlock> COBBLED_GLOOMSLATE_STAIRS = registerBlock("cobbled_gloomslate_stairs", true, () -> new StairBlock(COBBLED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));
    public static final Supplier<WallBlock> COBBLED_GLOOMSLATE_WALL = registerBlock("cobbled_gloomslate_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get())));

    public static final Supplier<Block> POLISHED_GLOOMSLATE = registerBlock("polished_gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> POLISHED_GLOOMSLATE_SLAB = registerBlock("polished_gloomslate_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));
    public static final Supplier<StairBlock> POLISHED_GLOOMSLATE_STAIRS = registerBlock("polished_gloomslate_stairs", true, () -> new StairBlock(POLISHED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));
    public static final Supplier<WallBlock> POLISHED_GLOOMSLATE_WALL = registerBlock("polished_gloomslate_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get())));

    public static final Supplier<Block> GLOOMSLATE_BRICKS = registerBlock("gloomslate_bricks", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> GLOOMSLATE_BRICK_SLAB = registerBlock("gloomslate_brick_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));
    public static final Supplier<StairBlock> GLOOMSLATE_BRICK_STAIRS = registerBlock("gloomslate_brick_stairs", true, () -> new StairBlock(GLOOMSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));
    public static final Supplier<WallBlock> GLOOMSLATE_BRICK_WALL = registerBlock("gloomslate_brick_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get())));

    public static final Supplier<Block> GLOOMSLATE_TILES = registerBlock("gloomslate_tiles", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> GLOOMSLATE_TILE_SLAB = registerBlock("gloomslate_tile_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));
    public static final Supplier<StairBlock> GLOOMSLATE_TILE_STAIRS = registerBlock("gloomslate_tile_stairs", true, () -> new StairBlock(GLOOMSLATE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));
    public static final Supplier<WallBlock> GLOOMSLATE_TILE_WALL = registerBlock("gloomslate_tile_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get())));

    public static final Supplier<Block> SMOOTH_GLOOMSLATE = registerBlock("smooth_gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> SMOOTH_GLOOMSLATE_SLAB = registerBlock("smooth_gloomslate_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));
    public static final Supplier<StairBlock> SMOOTH_GLOOMSLATE_STAIRS = registerBlock("smooth_gloomslate_stairs", true, () -> new StairBlock(SMOOTH_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));
    public static final Supplier<WallBlock> SMOOTH_GLOOMSLATE_WALL = registerBlock("smooth_gloomslate_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get())));

    public static final Supplier<Block> CUT_GLOOMSLATE = registerBlock("cut_gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));
    public static final Supplier<SlabBlock> CUT_GLOOMSLATE_SLAB = registerBlock("cut_gloomslate_slab", true, () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));
    public static final Supplier<StairBlock> CUT_GLOOMSLATE_STAIRS = registerBlock("cut_gloomslate_stairs", true, () -> new StairBlock(CUT_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));
    public static final Supplier<WallBlock> CUT_GLOOMSLATE_WALL = registerBlock("cut_gloomslate_wall", true, () -> new WallBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get())));

    public static final Supplier<Block> CHISELED_GLOOMSLATE = registerBlock("chiseled_gloomslate", true, () -> new Block(BlockBehaviour.Properties.copy(GLOOMSLATE.get())));

    // Miscellaneous
    public static final Supplier<Block> ANCIENT_VASE = registerBlock("ancient_vase", true, () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE).noOcclusion()));
    public static final Supplier<Block> OTHERSIDE_PORTAL = registerBlock("otherside_portal", false, PortalHelper.getPortalBlock());
    //   public static final Supplier<Block> ANCIENT_CHEST = registerBlock("ancient_chest", false, () -> new AncientChestBlock(BlockBehaviour.Properties.of(Material.STONE)
      //      .strength(6.2f).sound(SoundType.DEEPSLATE_TILES).color(MaterialColor.DEEPSLATE).noOcclusion(), false));
  //  public static final Supplier<Block> DEEPSLATE_CHEST = registerBlock("deepslate_chest", false, () -> new AncientChestBlock(BlockBehaviour.Properties.of(Material.STONE)
     //       .strength(6.2f).sound(SoundType.DEEPSLATE_TILES).color(MaterialColor.DEEPSLATE).noOcclusion(), true));

    @SuppressWarnings("unchecked")
    public static <T extends Block> Supplier<T> registerBlock(String name, boolean createItem, Supplier<T> block) {
        Supplier<T> toReturn = RegistryHelper.registerBlock(name, block);
        BLOCKS.put(name, (Supplier<Block>) toReturn);
        if(createItem) RegistryHelper.registerItem(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> Supplier<T> registerSign(String name, Supplier<T> block, Supplier<WallSignBlock> wallBlock) {
        Supplier<T> standing = RegistryHelper.registerBlock(name, block);
        BLOCKS.put(name, (Supplier<Block>) standing);
        RegistryHelper.registerItem(name, () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), standing.get(), wallBlock.get()));
        return standing;
    }

    public static RotatedPillarBlock log(MaterialColor materialColor, MaterialColor materialColor2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? materialColor : materialColor2).strength(2.0F).sound(SoundType.WOOD));
    }

    public static void registerBlocks() {
        DeeperAndDarker.LOGGER.info("Deeper and Darker blocks have been registered");
    }
}
