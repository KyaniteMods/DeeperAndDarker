package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = createTag("echo_logs");

        public static final TagKey<Block> LOGS = createTag("logs");
        public static final TagKey<Block> STRIPPED_LOGS = createTag("stripped_logs");
        public static final TagKey<Block> WOOD = createTag("wood");
        public static final TagKey<Block> STRIPPED_WOOD = createTag("stripped_wood");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = createTag("echo_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }
}
