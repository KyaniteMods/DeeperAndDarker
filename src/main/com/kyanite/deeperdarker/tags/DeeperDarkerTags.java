package com.kyanite.deeperdarker.tags;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DeeperDarkerTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.of(
                RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));
        public static final TagKey<Block> ECHO_SOIL = TagKey.of(
                RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "echo_soil"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "gloomy_sculk_replaceable"));
        public static final TagKey<Block> SCULK_STONE_REPLACEABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "sculk_stone_replaceable"));

        public static final TagKey<Block> NOT_TRANSMITTABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "not_transmittable"));
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.of(
                RegistryKeys.ITEM, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));
    }
}
