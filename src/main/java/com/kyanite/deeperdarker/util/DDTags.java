package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = tag("gloomy_sculk_replaceable");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DeeperDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = tag("echo_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DeeperDarker.MOD_ID, name));
        }
    }
}
