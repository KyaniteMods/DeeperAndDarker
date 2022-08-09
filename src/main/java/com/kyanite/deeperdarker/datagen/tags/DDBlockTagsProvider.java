package com.kyanite.deeperdarker.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
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

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE).add(DDBlocks.BONE_WALL_SIGN.get()).addTag(DDTags.Blocks.BONE_WOOD);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(DDBlocks.SCULK_STONE.get(), DDBlocks.SCULK_STONE_SLAB.get(), DDBlocks.SCULK_STONE_STAIRS.get(), DDBlocks.SCULK_STONE_WALL.get(), DDBlocks.COBBLED_SCULK_STONE.get(), DDBlocks.COBBLED_SCULK_STONE_SLAB.get(), DDBlocks.COBBLED_SCULK_STONE_STAIRS.get(), DDBlocks.COBBLED_SCULK_STONE_WALL.get(), DDBlocks.POLISHED_SCULK_STONE.get(), DDBlocks.POLISHED_SCULK_STONE_SLAB.get(), DDBlocks.POLISHED_SCULK_STONE_STAIRS.get(), DDBlocks.POLISHED_SCULK_STONE_WALL.get(), DDBlocks.SCULK_STONE_BRICKS.get(), DDBlocks.SCULK_STONE_BRICK_SLAB.get(), DDBlocks.SCULK_STONE_BRICK_STAIRS.get(), DDBlocks.SCULK_STONE_BRICK_WALL.get(), DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get()).addTag(DDTags.Blocks.BONE_WOOD);
        tag(BlockTags.MINEABLE_WITH_HOE).add(DDBlocks.SCULK_BONE_WALL_SIGN.get(), DDBlocks.SCULK_GLEAM.get(), DDBlocks.INFESTED_SCULK.get()).addTag(DDTags.Blocks.SCULK_BONE_WOOD);
        tag(BlockTags.SCULK_REPLACEABLE).add(DDBlocks.INFESTED_SCULK.get());
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(DDBlocks.INFESTED_SCULK.get());
        tag(BlockTags.FENCE_GATES).add(DDBlocks.BONE_FENCE_GATE.get(), DDBlocks.SCULK_BONE_FENCE_GATE.get());
        tag(BlockTags.NON_FLAMMABLE_WOOD).add(DDBlocks.BONE_WALL_SIGN.get(), DDBlocks.SCULK_BONE_WALL_SIGN.get()).addTags(DDTags.Blocks.BONE_WOOD, DDTags.Blocks.SCULK_BONE_WOOD);
        tag(BlockTags.PLANKS).add(DDBlocks.BONE_PLANKS.get(), DDBlocks.SCULK_BONE_PLANKS.get());
        tag(BlockTags.WOODEN_BUTTONS).add(DDBlocks.BONE_BUTTON.get(), DDBlocks.SCULK_BONE_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS).add(DDBlocks.BONE_DOOR.get(), DDBlocks.SCULK_BONE_DOOR.get());
        tag(BlockTags.WOODEN_FENCES).add(DDBlocks.BONE_FENCE.get(), DDBlocks.SCULK_BONE_FENCE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(DDBlocks.BONE_PRESSURE_PLATE.get(), DDBlocks.SCULK_BONE_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_SLABS).add(DDBlocks.BONE_SLAB.get(), DDBlocks.SCULK_BONE_SLAB.get());
        tag(BlockTags.WOODEN_STAIRS).add(DDBlocks.BONE_STAIRS.get(), DDBlocks.SCULK_BONE_STAIRS.get());
        tag(BlockTags.WOODEN_TRAPDOORS).add(DDBlocks.BONE_TRAPDOOR.get(), DDBlocks.SCULK_BONE_TRAPDOOR.get());
        tag(BlockTags.WALL_SIGNS).add(DDBlocks.BONE_WALL_SIGN.get(), DDBlocks.SCULK_BONE_WALL_SIGN.get());
        tag(BlockTags.STANDING_SIGNS).add(DDBlocks.BONE_SIGN.get(), DDBlocks.SCULK_BONE_SIGN.get());
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

        tag(Tags.Blocks.ORES).add(DDBlocks.SCULK_STONE_COAL_ORE.get(), DDBlocks.SCULK_STONE_IRON_ORE.get(), DDBlocks.SCULK_STONE_COPPER_ORE.get(), DDBlocks.SCULK_STONE_GOLD_ORE.get(), DDBlocks.SCULK_STONE_REDSTONE_ORE.get(), DDBlocks.SCULK_STONE_EMERALD_ORE.get(), DDBlocks.SCULK_STONE_LAPIS_ORE.get(), DDBlocks.SCULK_STONE_DIAMOND_ORE.get());

        tag(DDTags.Blocks.BONE_WOOD).add(Blocks.BONE_BLOCK, DDBlocks.BONE_PLANKS.get(), DDBlocks.BONE_SLAB.get(), DDBlocks.BONE_STAIRS.get(), DDBlocks.BONE_FENCE.get(), DDBlocks.BONE_BUTTON.get(), DDBlocks.BONE_PRESSURE_PLATE.get(), DDBlocks.BONE_DOOR.get(), DDBlocks.BONE_TRAPDOOR.get(), DDBlocks.BONE_FENCE_GATE.get(), DDBlocks.BONE_SIGN.get());
        tag(DDTags.Blocks.SCULK_BONE_WOOD).add(DDBlocks.SCULK_BONE_BLOCK.get(), DDBlocks.SCULK_BONE_PLANKS.get(), DDBlocks.SCULK_BONE_SLAB.get(), DDBlocks.SCULK_BONE_STAIRS.get(), DDBlocks.SCULK_BONE_FENCE.get(), DDBlocks.SCULK_BONE_BUTTON.get(), DDBlocks.SCULK_BONE_PRESSURE_PLATE.get(), DDBlocks.SCULK_BONE_DOOR.get(), DDBlocks.SCULK_BONE_TRAPDOOR.get(), DDBlocks.SCULK_BONE_FENCE_GATE.get(), DDBlocks.SCULK_BONE_SIGN.get());

        spreadingReplaceTags();
    }

    @SuppressWarnings("unchecked")
    public void spreadingReplaceTags() {
        tag(DDTags.Blocks.SCULK_STONE_REPLACE).add(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.CALCITE, Blocks.TUFF, Blocks.PACKED_MUD, Blocks.DEEPSLATE, Blocks.NETHERRACK, Blocks.BLACKSTONE);
        tag(DDTags.Blocks.SCULK_STONE_STAIRS_REPLACE).add(Blocks.STONE_STAIRS, Blocks.GRANITE_STAIRS, Blocks.DIORITE_STAIRS, Blocks.ANDESITE_STAIRS, Blocks.BLACKSTONE_STAIRS);
        tag(DDTags.Blocks.SCULK_STONE_SLABS_REPLACE).add(Blocks.STONE_SLAB, Blocks.GRANITE_SLAB, Blocks.DIORITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.BLACKSTONE_SLAB);
        tag(DDTags.Blocks.SCULK_STONE_WALLS_REPLACE).add(Blocks.GRANITE_WALL, Blocks.DIORITE_WALL, Blocks.ANDESITE_WALL, Blocks.BLACKSTONE_WALL);

        tag(DDTags.Blocks.COBBLED_SCULK_STONE_REPLACE).add(Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.COBBLED_DEEPSLATE);
        tag(DDTags.Blocks.COBBLED_SCULK_STONE_STAIRS_REPLACE).add(Blocks.COBBLESTONE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS);
        tag(DDTags.Blocks.COBBLED_SCULK_STONE_SLABS_REPLACE).add(Blocks.COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB);
        tag(DDTags.Blocks.COBBLED_SCULK_STONE_WALLS_REPLACE).add(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL, Blocks.COBBLED_DEEPSLATE_WALL);

        tag(DDTags.Blocks.POLISHED_SCULK_STONE_REPLACE).add(Blocks.SMOOTH_STONE, Blocks.POLISHED_GRANITE, Blocks.POLISHED_DIORITE, Blocks.POLISHED_ANDESITE, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_BLACKSTONE);
        tag(DDTags.Blocks.POLISHED_SCULK_STONE_STAIRS_REPLACE).add(Blocks.POLISHED_GRANITE_STAIRS, Blocks.POLISHED_DIORITE_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_BLACKSTONE_STAIRS);
        tag(DDTags.Blocks.POLISHED_SCULK_STONE_SLABS_REPLACE).add(Blocks.SMOOTH_STONE_SLAB, Blocks.POLISHED_GRANITE_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_BLACKSTONE_SLAB);
        tag(DDTags.Blocks.POLISHED_SCULK_STONE_WALLS_REPLACE).add(Blocks.POLISHED_DEEPSLATE_WALL, Blocks.POLISHED_BLACKSTONE_WALL);

        tag(DDTags.Blocks.SCULK_STONE_BRICKS_REPLACE).add(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.MUD_BRICKS, Blocks.DEEPSLATE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS);
        tag(DDTags.Blocks.SCULK_STONE_BRICKS_STAIRS_REPLACE).add(Blocks.STONE_BRICK_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.MUD_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS);
        tag(DDTags.Blocks.SCULK_STONE_BRICKS_SLABS_REPLACE).add(Blocks.STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.MUD_BRICK_SLAB, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB);
        tag(DDTags.Blocks.SCULK_STONE_BRICKS_WALLS_REPLACE).add(Blocks.STONE_BRICK_WALL, Blocks.MOSSY_STONE_BRICK_WALL, Blocks.MUD_BRICK_WALL, Blocks.DEEPSLATE_BRICK_WALL, Blocks.POLISHED_BLACKSTONE_BRICK_WALL);

        tag(BlockTags.SCULK_REPLACEABLE)
                .add(Blocks.SHROOMLIGHT, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT)
                .addTags(DDTags.Blocks.SCULK_STONE_REPLACE, DDTags.Blocks.SCULK_STONE_STAIRS_REPLACE, DDTags.Blocks.SCULK_STONE_SLABS_REPLACE, DDTags.Blocks.SCULK_STONE_WALLS_REPLACE,
                DDTags.Blocks.COBBLED_SCULK_STONE_REPLACE, DDTags.Blocks.COBBLED_SCULK_STONE_STAIRS_REPLACE, DDTags.Blocks.COBBLED_SCULK_STONE_SLABS_REPLACE, DDTags.Blocks.COBBLED_SCULK_STONE_WALLS_REPLACE,
                DDTags.Blocks.POLISHED_SCULK_STONE_REPLACE, DDTags.Blocks.POLISHED_SCULK_STONE_STAIRS_REPLACE, DDTags.Blocks.POLISHED_SCULK_STONE_SLABS_REPLACE, DDTags.Blocks.POLISHED_SCULK_STONE_WALLS_REPLACE,
                DDTags.Blocks.SCULK_STONE_BRICKS_REPLACE, DDTags.Blocks.SCULK_STONE_BRICKS_STAIRS_REPLACE, DDTags.Blocks.SCULK_STONE_BRICKS_SLABS_REPLACE, DDTags.Blocks.SCULK_STONE_BRICKS_WALLS_REPLACE);
    }
}
