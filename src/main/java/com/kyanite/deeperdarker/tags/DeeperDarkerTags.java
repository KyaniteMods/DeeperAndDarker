package com.kyanite.deeperdarker.tags;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DeeperDarkerTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.of(
                RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "gloomy_sculk_replaceable"));
    }
}
