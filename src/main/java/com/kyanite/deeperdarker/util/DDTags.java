package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "echo_logs"));
        public static final TagKey<Block> BLOOMING_STEMS = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "blooming_stems"));

        public static final TagKey<Block> OTHERSIDE_CARVER_REPLACEABLES = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "otherside_carver_replaceables"));
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_stone_replaceables"));
        public static final TagKey<Block> SCULK_REPLACEABLES = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_replaceables"));
        public static final TagKey<Block> DEEPLANDS_COLUMN_REPLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "deeplands_column_replaceable"));
        public static final TagKey<Block> DEEPLANDS_COLUMN_BASE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "deeplands_column_base"));

        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "gloomslate_replaceable"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "gloomy_sculk_replaceable"));
        public static final TagKey<Block> OVERCAST_COLUMN_REPLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "overcast_column_replaceable"));
        public static final TagKey<Block> OVERCAST_COLUMN_BASE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "overcast_column_base"));

        public static final TagKey<Block> BLOOMING_POOL_REPLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "blooming_pool_replaceable"));

        public static final TagKey<Block> SCULK_VINE_PLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_vine_placeable"));
        public static final TagKey<Block> GLOWING_VINE_PLACEABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "glowing_vine_placeable"));

        public static final TagKey<Block> TRANSMITTABLE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "transmittable"));
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "infiniburn_otherside"));

        public static final TagKey<Block> ECHO_SOIL = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "echo_soil"));

        public static final TagKey<Block> MAZE_CANNOT_HIDE_CHEST = TagKey.create(
                Registries.BLOCK, new ResourceLocation(DeeperDarker.MOD_ID, "maze/cannot_hide_chest"));
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "echo_logs"));

        public static final TagKey<Item> BLOOMING_STEMS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "blooming_stems"));

        public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "dampens_vibrations"));

        public static final TagKey<Item> PAINTINGS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "paintings"));

        public static final TagKey<Item> SCUTES = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "scutes"));

        public static final TagKey<Item> RESONARIUM_ARMOR = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "resonarium_armor"));

        public static final TagKey<Item> SCULK_TRANSMITTERS = TagKey.create(
                Registries.ITEM, new ResourceLocation(DeeperDarker.MOD_ID, "sculk_transmitters"));
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/ancient_temple"));
        public static final TagKey<Biome> HAS_BLOOMAZE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/bloomaze"));
        public static final TagKey<Biome> HAS_GLOOMAZE = TagKey.create(Registries.BIOME, new ResourceLocation(DeeperDarker.MOD_ID, "has_structure/gloomaze"));
    }

    public static class Paintings {
        public static final TagKey<PaintingVariant> ANCIENT = TagKey.create(Registries.PAINTING_VARIANT, new ResourceLocation(DeeperDarker.MOD_ID, "ancient"));
    }

    public static class Structures {
        public static final TagKey<Structure> WARDEN_HEART_PULSES = TagKey.create(
                Registries.STRUCTURE, new ResourceLocation(DeeperDarker.MOD_ID, "warden_heart_pulses"));

        public static final TagKey<Structure> NO_BLOOMING_POOL_GENERATION = TagKey.create(
                Registries.STRUCTURE, new ResourceLocation(DeeperDarker.MOD_ID, "no_blooming_pool_generation"));
    }

    public static class GameEvents {
        public static final TagKey<GameEvent> CHEST_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, new ResourceLocation(DeeperDarker.MOD_ID, "chest_vibrations"));
        public static final TagKey<GameEvent> FEET_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, new ResourceLocation(DeeperDarker.MOD_ID, "feet_vibrations"));
    }
}
