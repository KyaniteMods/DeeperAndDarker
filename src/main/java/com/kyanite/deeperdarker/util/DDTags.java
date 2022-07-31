package com.kyanite.deeperdarker.util;

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
        public static final TagKey<Block> SCULK_BLOCKS = createTag("sculk_blocks");
        public static final TagKey<Block> SCULK_BONE_WOOD = createTag("sculk_bone_wood");
        public static final TagKey<Block> SCULK_VINES = createTag("sculk_vines");
        public static final TagKey<Block> SCULK_STONE_ORE_REPLACEABLES = createTag("sculk_vines");

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
