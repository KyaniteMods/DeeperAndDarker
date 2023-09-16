package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.*;
import com.kyanite.deeperdarker.content.blocks.vegetation.*;
import com.kyanite.deeperdarker.content.entities.blocks.DDSignBlockEntity;
import com.kyanite.deeperdarker.mixin.AbstractBlockSettingsAccessor;
import com.kyanite.deeperdarker.util.DDCreativeTab;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.trees.EchoTreeGrower;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

@SuppressWarnings("NullableProblems")
public class DDBlocks {
    private static class DDWoodType extends WoodType {
        protected DDWoodType(String string) {
            super(string);
        }
    }

    public static final WoodType ECHO = WoodType.register(new DDWoodType(new ResourceLocation(DeeperDarker.MOD_ID, "echo").toString()));

    public static final Block ECHO_LOG = register("echo_log", new RotatedPillarBlock(getEchoLogProperties()));
    public static final Block ECHO_WOOD = register("echo_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).color(MaterialColor.COLOR_PURPLE)));
    public static final Block STRIPPED_ECHO_LOG = register("stripped_echo_log", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block STRIPPED_ECHO_WOOD = register("stripped_echo_wood", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_PLANKS = register("echo_planks", new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_STAIRS = register("echo_stairs", new StairBlock(ECHO_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_SLAB = register("echo_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_FENCE = register("echo_fence", new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_FENCE_GATE = register("echo_fence_gate", new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_DOOR = register("echo_door", new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_TRAPDOOR = register("echo_trapdoor", new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_PRESSURE_PLATE = register("echo_pressure_plate", new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Block ECHO_BUTTON = register("echo_button", new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final Block ECHO_LEAVES = register("echo_leaves", new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).color(MaterialColor.COLOR_PURPLE)));
    public static final Block ECHO_SAPLING = register("echo_sapling", new SaplingBlock(new EchoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)) {
        @Override
        protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
            return pState.is(DDTags.Blocks.ECHO_SOIL);
        }
    });
    public static final Block ECHO_SIGN = registerWithoutItem("echo_sign", new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).color(MaterialColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });

    public static final Block ECHO_WALL_SIGN = registerWithoutItem("echo_wall_sign", new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(ECHO_SIGN).color(MaterialColor.COLOR_LIGHT_GRAY), ECHO) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
            return new DDSignBlockEntity(pPos, pState);
        }
    });

    public static final Block POTTED_ECHO_SAPLING = registerWithoutItem("potted_echo_sapling", new FlowerPotBlock(ECHO_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

    public static final Block SCULK_STONE = register("sculk_stone", new Block(BlockBehaviour.Properties.copy(Blocks.STONE).color(MaterialColor.COLOR_CYAN).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops()));
    public static final Block SCULK_STONE_STAIRS = register("sculk_stone_stairs", new StairBlock(SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_SLAB = register("sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_WALL = register("sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE = register("cobbled_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_STAIRS = register("cobbled_sculk_stone_stairs", new StairBlock(COBBLED_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_SLAB = register("cobbled_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block COBBLED_SCULK_STONE_WALL = register("cobbled_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE = register("polished_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_STAIRS = register("polished_sculk_stone_stairs", new StairBlock(POLISHED_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_SLAB = register("polished_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block POLISHED_SCULK_STONE_WALL = register("polished_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE)));
    public static final Block SCULK_STONE_BRICKS = register("sculk_stone_bricks", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_BRICK_STAIRS = register("sculk_stone_brick_stairs", new StairBlock(SCULK_STONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_BRICK_SLAB = register("sculk_stone_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_BRICK_WALL = register("sculk_stone_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS)));
    public static final Block SCULK_STONE_TILES = register("sculk_stone_tiles", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_TILE_STAIRS = register("sculk_stone_tile_stairs", new StairBlock(SCULK_STONE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SCULK_STONE_TILE_SLAB = register("sculk_stone_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SCULK_STONE_TILE_WALL = register("sculk_stone_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_STONE_TILES)));
    public static final Block SMOOTH_SCULK_STONE = register("smooth_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_STAIRS = register("smooth_sculk_stone_stairs", new StairBlock(SMOOTH_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_SLAB = register("smooth_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block SMOOTH_SCULK_STONE_WALL = register("smooth_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE = register("cut_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_STAIRS = register("cut_sculk_stone_stairs", new StairBlock(CUT_SCULK_STONE.defaultBlockState(), BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_SLAB = register("cut_sculk_stone_slab", new SlabBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CUT_SCULK_STONE_WALL = register("cut_sculk_stone_wall", new WallBlock(BlockBehaviour.Properties.copy(CUT_SCULK_STONE)));
    public static final Block CHISELED_SCULK_STONE = register("chiseled_sculk_stone", new Block(BlockBehaviour.Properties.copy(SCULK_STONE)));

    public static final Block GLOOMSLATE = register("gloomslate", new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).color(MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops()));
    public static final Block GLOOMSLATE_STAIRS = register("gloomslate_stairs", new StairBlock(GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_SLAB = register("gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_WALL = register("gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE = register("cobbled_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_STAIRS = register("cobbled_gloomslate_stairs", new StairBlock(COBBLED_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_SLAB = register("cobbled_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block COBBLED_GLOOMSLATE_WALL = register("cobbled_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE = register("polished_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_STAIRS = register("polished_gloomslate_stairs", new StairBlock(POLISHED_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_SLAB = register("polished_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block POLISHED_GLOOMSLATE_WALL = register("polished_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE)));
    public static final Block GLOOMSLATE_BRICKS = register("gloomslate_bricks", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_BRICK_STAIRS = register("gloomslate_brick_stairs", new StairBlock(GLOOMSLATE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_BRICK_SLAB = register("gloomslate_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_BRICK_WALL = register("gloomslate_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS)));
    public static final Block GLOOMSLATE_TILES = register("gloomslate_tiles", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_TILE_STAIRS = register("gloomslate_tile_stairs", new StairBlock(GLOOMSLATE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block GLOOMSLATE_TILE_SLAB = register("gloomslate_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block GLOOMSLATE_TILE_WALL = register("gloomslate_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES)));
    public static final Block SMOOTH_GLOOMSLATE = register("smooth_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_STAIRS = register("smooth_gloomslate_stairs", new StairBlock(SMOOTH_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_SLAB = register("smooth_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block SMOOTH_GLOOMSLATE_WALL = register("smooth_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE = register("cut_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_STAIRS = register("cut_gloomslate_stairs", new StairBlock(CUT_GLOOMSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_SLAB = register("cut_gloomslate_slab", new SlabBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CUT_GLOOMSLATE_WALL = register("cut_gloomslate_wall", new WallBlock(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE)));
    public static final Block CHISELED_GLOOMSLATE = register("chiseled_gloomslate", new Block(BlockBehaviour.Properties.copy(GLOOMSLATE)));

    public static final Block SCULK_GRIME = register("sculk_grime", new MudBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f).color(MaterialColor.COLOR_CYAN)));
    public static final Block SCULK_GRIME_BRICKS = register("sculk_grime_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).color(MaterialColor.TERRACOTTA_GREEN)));
    public static final Block SCULK_GRIME_BRICK_SLAB = register("sculk_grime_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_STAIRS = register("sculk_grime_brick_stairs", new StairBlock(SCULK_GRIME_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));
    public static final Block SCULK_GRIME_BRICK_WALL = register("sculk_grime_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(SCULK_GRIME_BRICKS)));

    public static final Block ECHO_SOIL = register("echo_soil", new Block(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f).color(MaterialColor.COLOR_PURPLE)));
    public static final Block GLOOMY_SCULK = register("gloomy_sculk", new GloomySculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f)));
    public static final Block GLOOMY_GEYSER = register("gloomy_geyser", new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9).noLootTable()));
    public static final Block CRYSTALLIZED_AMBER = register("crystallized_amber", new HalfTransparentBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).lightLevel(state -> 1).sound(SoundType.GLASS).noOcclusion()));
    public static final Block SCULK_GLEAM = register("sculk_gleam", new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15).color(MaterialColor.SAND), UniformInt.of(1, 3)));

    public static final Block SCULK_STONE_COAL_ORE = register("sculk_stone_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(1, 4)));
    public static final Block SCULK_STONE_IRON_ORE = register("sculk_stone_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_COPPER_ORE = register("sculk_stone_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_GOLD_ORE = register("sculk_stone_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE)));
    public static final Block SCULK_STONE_REDSTONE_ORE = register("sculk_stone_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(SCULK_STONE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block SCULK_STONE_EMERALD_ORE = register("sculk_stone_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block SCULK_STONE_LAPIS_ORE = register("sculk_stone_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(4, 8)));
    public static final Block SCULK_STONE_DIAMOND_ORE = register("sculk_stone_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SCULK_STONE), UniformInt.of(5, 10)));
    public static final Block GLOOMSLATE_COAL_ORE = register("gloomslate_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(1, 4)));
    public static final Block GLOOMSLATE_IRON_ORE = register("gloomslate_iron_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_COPPER_ORE = register("gloomslate_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_GOLD_ORE = register("gloomslate_gold_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE)));
    public static final Block GLOOMSLATE_REDSTONE_ORE = register("gloomslate_redstone_ore", new RedStoneOreBlock(BlockBehaviour.Properties.copy(GLOOMSLATE).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)));
    public static final Block GLOOMSLATE_EMERALD_ORE = register("gloomslate_emerald_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));
    public static final Block GLOOMSLATE_LAPIS_ORE = register("gloomslate_lapis_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(4, 8)));
    public static final Block GLOOMSLATE_DIAMOND_ORE = register("gloomslate_diamond_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(GLOOMSLATE), UniformInt.of(5, 10)));

    public static final Block GLOOMY_GRASS = register("gloomy_grass", new GloomyGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 1)));
    public static final Block GLOOMY_CACTUS = register("gloomy_cactus", new GloomyCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_ORANGE).strength(0.5f).lightLevel(state -> 6).sound(SoundType.WOOL)));
    public static final Block SCULK_TENDRILS = register("sculk_tendrils", new SculkTendrilsBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).randomTicks().noCollission().instabreak()));
    public static final Block SCULK_TENDRILS_PLANT = register("sculk_tendrils_plant", new SculkTendrilsPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak()));
    public static final Block SCULK_VINES = register("sculk_vines", new SculkVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak().randomTicks()));
    public static final Block SCULK_VINES_PLANT = register("sculk_vines_plant", new SculkVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak()));

    public static final Block ANCIENT_VASE = register("ancient_vase", new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE)));

    public static final Block INFESTED_SCULK = register("infested_sculk", new InfestedSculkBlock(Blocks.SCULK, BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Block SCULK_JAW = register("sculk_jaw", new SculkJawBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).randomTicks()));

    public static final Block OTHERSIDE_PORTAL = registerWithoutItem("otherside_portal", new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

    private static BlockBehaviour.Properties getEchoLogProperties() {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(Blocks.OAK_LOG);
        ((AbstractBlockSettingsAccessor)properties).setMaterialColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.COLOR_LIGHT_GRAY : MaterialColor.COLOR_PURPLE);
        return properties;
    }

    private static Block register(String name, Block block) {
        Block registeredBlock = registerWithoutItem(name, block);
        DDItems.register(name, new BlockItem(block, new Item.Properties().tab(DDCreativeTab.DEEPER_AND_DARKER)));
        return registeredBlock;
    }

    private static Block registerWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, name), block);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering blocks");
        StrippableBlockRegistry.register(ECHO_LOG, STRIPPED_ECHO_LOG);
        StrippableBlockRegistry.register(ECHO_WOOD, STRIPPED_ECHO_WOOD);
    }
}
