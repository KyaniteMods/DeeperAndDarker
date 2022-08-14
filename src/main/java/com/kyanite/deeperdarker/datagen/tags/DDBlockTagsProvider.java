package com.kyanite.deeperdarker.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDBlockTagsProvider extends BlockTagsProvider {
    public DDBlockTagsProvider(DataGenerator pGenerator, ExistingFileHelper pExistingFileHelper) {
        super(pGenerator, DeeperAndDarker.MOD_ID, pExistingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE).add(DDBlocks.GLOOM_GRASS.get(), DDBlocks.GLOOM_VINES_PLANT.get(), DDBlocks.GLOOM_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get(), DDBlocks.SCULK_VINES.get());
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.SCULK_GLEAM.get(), DDBlocks.GLOOM_GRASS.get(), DDBlocks.SCULK_TRANSMITTER.get(), DDBlocks.INFESTED_SCULK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.ANCIENT_VASE.get(), DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        tag(BlockTags.FENCE_GATES).add(DDBlocks.ECHO_FENCE_GATE.get());
        tag(BlockTags.LEAVES).add(DDBlocks.ECHO_LEAVES.get());
        tag(BlockTags.LOGS_THAT_BURN).addTag(DDTags.Blocks.ECHO_LOGS);
        tag(BlockTags.PLANKS).add(DDBlocks.ECHO_PLANKS.get());
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

        tag(BlockTags.CLIMBABLE).add(DDBlocks.SCULK_VINES.get(), DDBlocks.SCULK_VINES_PLANT.get());
        tag(BlockTags.SLABS).add(DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get());
        tag(BlockTags.STAIRS).add(DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get());
        tag(BlockTags.WALLS).add(DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get());
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

        tag(BlockTags.SCULK_REPLACEABLE).add(DDBlocks.INFESTED_SCULK.get()).addTags(BlockTags.LEAVES);
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(Blocks.SHROOMLIGHT, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT, DDBlocks.INFESTED_SCULK.get());

        tag(DDTags.Blocks.ECHO_LOGS).add(DDBlocks.ECHO_LOG.get(), DDBlocks.ECHO_WOOD.get(), DDBlocks.STRIPPED_ECHO_LOG.get(), DDBlocks.STRIPPED_ECHO_WOOD.get());

        tag(DDTags.Blocks.LOGS).add(Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG, Blocks.CRIMSON_STEM, Blocks.WARPED_STEM);
        tag(DDTags.Blocks.STRIPPED_LOGS).add(Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_WARPED_STEM);
        tag(DDTags.Blocks.WOOD).add(Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD, Blocks.DARK_OAK_WOOD, Blocks.CRIMSON_HYPHAE, Blocks.WARPED_HYPHAE);
        tag(DDTags.Blocks.STRIPPED_WOOD).add(Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.STRIPPED_BIRCH_WOOD, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
    }
}
