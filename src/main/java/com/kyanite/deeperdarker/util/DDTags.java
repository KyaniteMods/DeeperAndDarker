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
        public static final TagKey<Block> BLOOM_STEMS = tag("bloom_stems");

        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = tag("sculk_stone_replaceables");
        public static final TagKey<Block> SCULK_REPLACEABLES = tag("sculk_replaceables");
        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = tag("gloomslate_replaceable");
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = tag("gloomy_sculk_replaceable");
        public static final TagKey<Block> BLOOMING_POOL_REPLACEABLE = tag("blooming_pool_replaceable");

        public static final TagKey<Block> SCULK_VINE_PLACEABLE = tag("sculk_vine_placeable");
        public static final TagKey<Block> GLOWING_VINE_PLACEABLE = tag("glowing_vine_placeable");

        public static final TagKey<Block> TRANSMITTABLE = tag("transmittable");
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = tag("infiniburn_otherside");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DeeperDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Item> BLOOM_STEMS = tag("bloom_stems");

        public static final TagKey<Item> DAMPENS_VIBRATIONS = tag("dampens_vibrations");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DeeperDarker.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/ancient_temple"));
    }
}
