package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class DDBlockTagsProvider extends BlockTagsProvider {
    public DDBlockTagsProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }


    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.ECHO_LEAVES.get(), DDBlocks.SCULK_GLEAM.get(), DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get(), DDBlocks.INFESTED_SCULK.get(), DDBlocks.SCULK_JAW.get(), DDBlocks.GLOOM_SCULK.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.CRYSTALLIZED_AMBER.get(), DDBlocks.ANCIENT_VASE.get(), DDBlocks.ANCIENT_CHEST.get(), DDBlocks.DEEPSLATE_CHEST.get(),
                DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_WALL.get(),
                DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(),
                DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(),
                DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(),
                DDBlocks.SCULK_STONE_TILES.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get(), DDBlocks.SCULK_STONE_TILE_WALL.get(),
                DDBlocks.SMOOTH_SCULK_STONE.get(), DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), DDBlocks.SMOOTH_SCULK_STONE_WALL.get(),
                DDBlocks.CUT_SCULK_STONE.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get(), DDBlocks.CUT_SCULK_STONE_WALL.get(),
                DDBlocks.CHISELED_SCULK_STONE.get(),
                DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get(),
                DDBlocks.GLOOMSLATE.get(), DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE_WALL.get(),
                DDBlocks.COBBLED_GLOOMSLATE.get(), DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), DDBlocks.COBBLED_GLOOMSLATE_WALL.get(),
                DDBlocks.POLISHED_GLOOMSLATE.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get(),
                DDBlocks.GLOOMSLATE_BRICKS.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get(),
                DDBlocks.GLOOMSLATE_TILES.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get(),
                DDBlocks.SMOOTH_GLOOMSLATE.get(), DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(),
                DDBlocks.CUT_GLOOMSLATE.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get(),
                DDBlocks.CHISELED_GLOOMSLATE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(DDBlocks.GEYSER.get(), DDBlocks.ECHO_SOIL.get());

        tag(BlockTags.NEEDS_STONE_TOOL).add(DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(DDBlocks.GEYSER.get(), DDBlocks.CRYSTALLIZED_AMBER.get());

        tag(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE.get());
        tag(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS);
        tag(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS.get());
        tag(BlockTags.SAND).add(DDBlocks.ECHO_SOIL.get());
        tag(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN.get());
        tag(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR.get());
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB.get());
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR.get());
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(DDBlocks.ECHO_FENCE_GATE.get());
        tag(Tags.Blocks.FENCES_WOODEN).add(DDBlocks.ECHO_FENCE.get());

        tag(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get(), DDBlocks.SCULK_TENDRILS.get(), DDBlocks.SCULK_TENDRILS_PLANT.get());
        tag(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_TILE_SLAB.get(), DDBlocks.SMOOTH_SCULK_STONE_SLAB.get(), DDBlocks.CUT_SCULK_STONE_SLAB.get(), DDBlocks.GLOOMSLATE_SLAB.get(), DDBlocks.COBBLED_GLOOMSLATE_SLAB.get(), DDBlocks.POLISHED_GLOOMSLATE_SLAB.get(), DDBlocks.GLOOMSLATE_BRICK_SLAB.get(), DDBlocks.GLOOMSLATE_TILE_SLAB.get(), DDBlocks.SMOOTH_GLOOMSLATE_SLAB.get(), DDBlocks.CUT_GLOOMSLATE_SLAB.get());
        tag(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_TILE_STAIRS.get(), DDBlocks.SMOOTH_SCULK_STONE_STAIRS.get(), DDBlocks.CUT_SCULK_STONE_STAIRS.get(), DDBlocks.GLOOMSLATE_STAIRS.get(), DDBlocks.COBBLED_GLOOMSLATE_STAIRS.get(), DDBlocks.POLISHED_GLOOMSLATE_STAIRS.get(), DDBlocks.GLOOMSLATE_BRICK_STAIRS.get(), DDBlocks.GLOOMSLATE_TILE_STAIRS.get(), DDBlocks.SMOOTH_GLOOMSLATE_STAIRS.get(), DDBlocks.CUT_GLOOMSLATE_STAIRS.get());
        tag(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_TILE_WALL.get(), DDBlocks.SMOOTH_SCULK_STONE_WALL.get(), DDBlocks.CUT_SCULK_STONE_WALL.get(), DDBlocks.GLOOMSLATE_WALL.get(), DDBlocks.COBBLED_GLOOMSLATE_WALL.get(), DDBlocks.POLISHED_GLOOMSLATE_WALL.get(), DDBlocks.GLOOMSLATE_BRICK_WALL.get(), DDBlocks.GLOOMSLATE_TILE_WALL.get(), DDBlocks.SMOOTH_GLOOMSLATE_WALL.get(), DDBlocks.CUT_GLOOMSLATE_WALL.get());
        tag(BlockTags.PORTALS).add(DDBlocks.OTHERSIDE_PORTAL.get());

        tag(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE.get());
        tag(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE.get());
        tag(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        tag(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        tag(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        tag(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        tag(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        tag(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        tag(Tags.Blocks.ORES_COAL).add(DDBlocks.SCULK_STONE_COAL_ORE.get());
        tag(Tags.Blocks.ORES_IRON).add(DDBlocks.SCULK_STONE_IRON_ORE.get());
        tag(Tags.Blocks.ORES_COPPER).add(DDBlocks.SCULK_STONE_COPPER_ORE.get());
        tag(Tags.Blocks.ORES_GOLD).add(DDBlocks.SCULK_STONE_GOLD_ORE.get());
        tag(Tags.Blocks.ORES_REDSTONE).add(DDBlocks.SCULK_STONE_REDSTONE_ORE.get());
        tag(Tags.Blocks.ORES_EMERALD).add(DDBlocks.SCULK_STONE_EMERALD_ORE.get());
        tag(Tags.Blocks.ORES_LAPIS).add(DDBlocks.SCULK_STONE_LAPIS_ORE.get());
        tag(Tags.Blocks.ORES_DIAMOND).add(DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        tag(Tags.Blocks.COBBLESTONE).add(DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_GLOOMSLATE.get());
        tag(Tags.Blocks.STONE).add(DDBlocks.SCULK_STONE.get(), DDBlocks.GLOOMSLATE.get());

        tag(BlockTags.SCULK_REPLACEABLE).add(Blocks.MOSS_BLOCK, DDBlocks.INFESTED_SCULK.get(), DDBlocks.SCULK_JAW.get()).addTags(BlockTags.LEAVES);
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(Blocks.SHROOMLIGHT, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT, DDBlocks.INFESTED_SCULK.get(), DDBlocks.SCULK_JAW.get());

        tag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG.get(), DDBlocks.ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get(), DDBlocks.STRIPPED_ECHO_WOOD.get());
        tag(DDTags.Blocks.STRIPPED_LOGS).add(Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_WARPED_STEM);
        tag(DDTags.Blocks.STRIPPED_WOOD).add(Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
        tag(DDTags.Blocks.WOOD).add(Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD, Blocks.CRIMSON_HYPHAE, Blocks.WARPED_HYPHAE);

        tag(DDTags.Blocks.GLOOM_SCULK_REPLACEABLE).add(DDBlocks.GLOOM_SCULK.get(), DDBlocks.GLOOMSLATE.get(), DDBlocks.SCULK_STONE.get(), DDBlocks.INFESTED_SCULK.get(), DDBlocks.ECHO_SOIL.get(), Blocks.STONE, Blocks.DEEPSLATE, Blocks.SCULK);

        tag(DDTags.Blocks.TRANSMITTABLE).add(Blocks.CHEST, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.BARREL, Blocks.SMOKER, Blocks.STONECUTTER);
    }

    @NotNull
    @Override
    public String getName() {
        return "Block Tags";
    }
}
