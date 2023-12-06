package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.create(
                    Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "echo_logs"));

        public static final TagKey<Block> BLOOMING_STEMS = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "blooming_stems"));
        public static final TagKey<Block> ECHO_SOIL = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "echo_soil"));
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_stone_replaceables"));
        public static final TagKey<Block> SCULK_REPLACEABLES = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_replaceables"));
        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "gloomslate_replaceable"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "gloomy_sculk_replaceable"));

        public static final TagKey<Block> TRANSMITTABLE = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "transmittable"));

        public static final TagKey<Block> INFINIBURN_OTHERSIDE = TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "infiniburn_otherside"));
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "echo_logs"));

        public static final TagKey<Item> BLOOMING_STEMS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "blooming_stems"));

        public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "dampens_vibrations"));
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/ancient_temple"));
    }
}
