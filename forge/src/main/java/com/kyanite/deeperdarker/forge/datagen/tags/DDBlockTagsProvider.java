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
        tag(BlockTags.MINEABLE_WITH_AXE).add(DDBlocks.SCULK_VINES_PLANT, DDBlocks.SCULK_VINES);
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.SCULK_GLEAM, DDBlocks.INFESTED_SCULK, DDBlocks.SCULK_JAW);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.ANCIENT_VASE, DDBlocks.SCULK_STONE, DDBlocks.SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICKS, DDBlocks.SCULK_STONE_BRICK_SLAB, DDBlocks.SCULK_STONE_BRICK_STAIRS, DDBlocks.SCULK_STONE_BRICK_WALL, DDBlocks.SCULK_STONE_COAL_ORE, DDBlocks.SCULK_STONE_IRON_ORE, DDBlocks.SCULK_STONE_COPPER_ORE, DDBlocks.SCULK_STONE_GOLD_ORE, DDBlocks.SCULK_STONE_REDSTONE_ORE, DDBlocks.SCULK_STONE_EMERALD_ORE, DDBlocks.SCULK_STONE_LAPIS_ORE, DDBlocks.SCULK_STONE_DIAMOND_ORE);
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(DDBlocks.ECHO_SOIL);

        tag(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE);
        tag(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS);
        tag(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS);
        tag(BlockTags.SAND).add(DDBlocks.ECHO_SOIL);
        tag(BlockTags.STANDING_SIGNS).add(DDBlocks.ECHO_SIGN);
        tag(BlockTags.WALL_SIGNS).add(DDBlocks.ECHO_WALL_SIGN);
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.ECHO_BUTTON);
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.ECHO_DOOR);
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.ECHO_FENCE);
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.ECHO_PRESSURE_PLATE);
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.ECHO_SLAB);
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.ECHO_STAIRS);
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.ECHO_TRAPDOOR);
        tag(Tags.Blocks.FENCE_GATES_WOODEN).add(DDBlocks.ECHO_FENCE_GATE);
        tag(Tags.Blocks.FENCES_WOODEN).add(DDBlocks.ECHO_FENCE);

        tag(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_VINES, DDBlocks.SCULK_VINES_PLANT);
        tag(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB, DDBlocks.COBBLED_SCULK_STONE_SLAB, DDBlocks.POLISHED_SCULK_STONE_SLAB, DDBlocks.SCULK_STONE_BRICK_SLAB);
        tag(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS, DDBlocks.COBBLED_SCULK_STONE_STAIRS, DDBlocks.POLISHED_SCULK_STONE_STAIRS, DDBlocks.SCULK_STONE_BRICK_STAIRS);
        tag(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL, DDBlocks.COBBLED_SCULK_STONE_WALL, DDBlocks.POLISHED_SCULK_STONE_WALL, DDBlocks.SCULK_STONE_BRICK_WALL);
        tag(BlockTags.PORTALS).add(DDBlocks.OTHERSIDE_PORTAL);

        tag(BlockTags.COAL_ORES).add(DDBlocks.SCULK_STONE_COAL_ORE);
        tag(BlockTags.IRON_ORES).add(DDBlocks.SCULK_STONE_IRON_ORE);
        tag(BlockTags.COPPER_ORES).add(DDBlocks.SCULK_STONE_COPPER_ORE);
        tag(BlockTags.GOLD_ORES).add(DDBlocks.SCULK_STONE_GOLD_ORE);
        tag(BlockTags.REDSTONE_ORES).add(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        tag(BlockTags.EMERALD_ORES).add(DDBlocks.SCULK_STONE_EMERALD_ORE);
        tag(BlockTags.LAPIS_ORES).add(DDBlocks.SCULK_STONE_LAPIS_ORE);
        tag(BlockTags.DIAMOND_ORES).add(DDBlocks.SCULK_STONE_DIAMOND_ORE);

        tag(Tags.Blocks.ORES_COAL).add(DDBlocks.SCULK_STONE_COAL_ORE);
        tag(Tags.Blocks.ORES_IRON).add(DDBlocks.SCULK_STONE_IRON_ORE);
        tag(Tags.Blocks.ORES_COPPER).add(DDBlocks.SCULK_STONE_COPPER_ORE);
        tag(Tags.Blocks.ORES_GOLD).add(DDBlocks.SCULK_STONE_GOLD_ORE);
        tag(Tags.Blocks.ORES_REDSTONE).add(DDBlocks.SCULK_STONE_REDSTONE_ORE);
        tag(Tags.Blocks.ORES_EMERALD).add(DDBlocks.SCULK_STONE_EMERALD_ORE);
        tag(Tags.Blocks.ORES_LAPIS).add(DDBlocks.SCULK_STONE_LAPIS_ORE);
        tag(Tags.Blocks.ORES_DIAMOND).add(DDBlocks.SCULK_STONE_DIAMOND_ORE);

        tag(BlockTags.SCULK_REPLACEABLE).add(DDBlocks.INFESTED_SCULK).add(DDBlocks.SCULK_JAW).addTags(BlockTags.LEAVES);
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(Blocks.SHROOMLIGHT, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT, DDBlocks.INFESTED_SCULK, DDBlocks.SCULK_JAW);

        tag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG, DDBlocks.ECHO_WOOD, DDBlocks.STRIPPED_ECHO_LOG, DDBlocks.STRIPPED_ECHO_WOOD);

        tag(DDTags.Blocks.STRIPPED_LOGS).add(Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_WARPED_STEM);
        tag(DDTags.Blocks.WOOD).add(Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD, Blocks.CRIMSON_HYPHAE, Blocks.WARPED_HYPHAE);
        tag(DDTags.Blocks.STRIPPED_WOOD).add(Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
        tag(DDTags.Blocks.TRANSMITTABLE).add(Blocks.CHEST, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.BARREL, Blocks.SMOKER, Blocks.STONECUTTER);
    }

    @NotNull
    @Override
    public String getName() {
        return "Block Tags";
    }
}
