package com.kyanite.deeperdarker.common;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> BONE_WOOD = createTag("bone_wood");
        public static final TagKey<Block> SCULK_BONE_WOOD = createTag("sculk_bone_wood");

        public static final TagKey<Block> SCULK_STONE_REPLACE = createTag("sculk_stone_replace");
        public static final TagKey<Block> COBBLED_SCULK_STONE_REPLACE = createTag("cobbled_sculk_stone_replace");
        public static final TagKey<Block> POLISHED_SCULK_STONE_REPLACE = createTag("polished_sculk_stone_replace");
        public static final TagKey<Block> SCULK_STONE_BRICKS_REPLACE = createTag("sculk_stone_bricks_replace");

        public static final TagKey<Block> SCULK_STONE_STAIRS_REPLACE = createTag("sculk_stone_stairs_replace");
        public static final TagKey<Block> COBBLED_SCULK_STONE_STAIRS_REPLACE = createTag("cobbled_sculk_stone_stairs_replace");
        public static final TagKey<Block> POLISHED_SCULK_STONE_STAIRS_REPLACE = createTag("polished_sculk_stone_stairs_replace");
        public static final TagKey<Block> SCULK_STONE_BRICKS_STAIRS_REPLACE = createTag("sculk_stone_bricks_stairs_replace");

        public static final TagKey<Block> SCULK_STONE_SLABS_REPLACE = createTag("sculk_stone_slabs_replace");
        public static final TagKey<Block> COBBLED_SCULK_STONE_SLABS_REPLACE = createTag("cobbled_sculk_stone_slabs_replace");
        public static final TagKey<Block> POLISHED_SCULK_STONE_SLABS_REPLACE = createTag("polished_sculk_stone_slabs_replace");
        public static final TagKey<Block> SCULK_STONE_BRICKS_SLABS_REPLACE = createTag("sculk_stone_bricks_slabs_replace");
        public static final TagKey<Block> SCULK_STONE_BRICKS_WALLS_REPLACE = createTag("sculk_stone_bricks_walls_replace");
        public static final TagKey<Block> COBBLED_SCULK_STONE_WALLS_REPLACE = createTag("cobbled_sculk_stone_walls_replace");
        public static final TagKey<Block> POLISHED_SCULK_STONE_WALLS_REPLACE = createTag("polished_sculk_stone_walls_replace");
        public static final TagKey<Block> SCULK_STONE_WALLS_REPLACE = createTag("sculk_stone_walls_replace");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BONE_WOOD = createTag("bone_wood");
        public static final TagKey<Item> SCULK_BONE_WOOD = createTag("sculk_bone_wood");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }
}
