package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Block> ECHO_SOIL = tag("echo_soil");
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = tag("sculk_stone_replaceables");
        public static final TagKey<Block> SCULK_REPLACEABLES = tag("sculk_replaceables");
        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = tag("gloomslate_replaceable");
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = tag("gloomy_sculk_replaceable");
        public static final TagKey<Block> TRANSMITTABLE = tag("transmittable");
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = tag("infiniburn_otherside");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DeeperDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = ItemTags.create(new ResourceLocation(DeeperDarker.MOD_ID, "echo_logs"));
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/ancient_temple"));
    }
}
