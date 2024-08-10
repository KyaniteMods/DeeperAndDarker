package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.create(
                    Registries.BLOCK, DeeperDarker.rl("echo_logs"));

        public static final TagKey<Block> BLOOMING_STEMS = TagKey.create(
                Registries.BLOCK, DeeperDarker.rl("blooming_stems"));
        public static final TagKey<Block> ECHO_SOIL = TagKey.create(
                Registries.BLOCK, DeeperDarker.rl("echo_soil"));
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = TagKey.create(Registries.BLOCK, DeeperDarker.rl("sculk_stone_replaceables"));
        public static final TagKey<Block> SCULK_REPLACEABLES = TagKey.create(Registries.BLOCK, DeeperDarker.rl("sculk_replaceables"));
        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("gloomslate_replaceable"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("gloomy_sculk_replaceable"));
        public static final TagKey<Block> BLOOMING_POOL_REPLACEABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("glooming_pool_replaceable"));

        public static final TagKey<Block> SCULK_VINE_PLACEABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("sculk_vine_placeable"));
        public static final TagKey<Block> GLOWING_VINE_PLACEABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("glowing_vine_placeable"));

        public static final TagKey<Block> TRANSMITTABLE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("transmittable"));
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = TagKey.create(Registries.BLOCK, DeeperDarker.rl("infiniburn_otherside"));
        public static final TagKey<Block> INCORRECT_FOR_RESONARIUM_TOOL = TagKey.create(Registries.BLOCK, DeeperDarker.rl("incorrect_for_resonarium_tool"));
        public static final TagKey<Block> INCORRECT_FOR_WARDEN_TOOL = TagKey.create(Registries.BLOCK, DeeperDarker.rl("incorrect_for_warden_tool"));
        public static final TagKey<Block> OTHERSIDE_CARVER_REPLACEABLES = TagKey.create(Registries.BLOCK, DeeperDarker.rl("otherside_carver_replaceables"));
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.create(
                Registries.ITEM, DeeperDarker.rl("echo_logs"));

        public static final TagKey<Item> BLOOMING_STEMS = TagKey.create(
                Registries.ITEM, DeeperDarker.rl("blooming_stems"));

        public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.create(
                Registries.ITEM, DeeperDarker.rl("dampens_vibrations"));

        public static final TagKey<Item> AVOIDS_SNIFFING = TagKey.create(
                Registries.ITEM, DeeperDarker.rl("avoids_sniffing"));
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, DeeperDarker.rl("has_structure/ancient_temple"));
    }

    public static class Paintings {
        public static final TagKey<PaintingVariant> ANCIENT = TagKey.create(Registries.PAINTING_VARIANT, DeeperDarker.rl("ancient"));
    }

    public static class Structures {
        public static final TagKey<Structure> WARDEN_HEART_PULSES = TagKey.create(
                Registries.STRUCTURE, DeeperDarker.rl("warden_heart_pulses"));
    }

    public static class Enchantments {
        public static final TagKey<Enchantment> PREVENTS_ANCIENT_VASE_SPAWNS = TagKey.create(Registries.ENCHANTMENT, DeeperDarker.rl("prevents_ancient_vase_spawns"));
        public static final TagKey<Enchantment> PICKS_UP_CRYSTALLIZED_AMBER = TagKey.create(Registries.ENCHANTMENT, DeeperDarker.rl("picks_up_crystallized_amber"));
        public static final TagKey<Enchantment> PREVENTS_INFESTED_SCULK_SPAWNS = TagKey.create(Registries.ENCHANTMENT, DeeperDarker.rl("prevents_infested_sculk_spawns"));
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> SCULK = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.rl("sculk"));
        public static final TagKey<EntityType<?>> SENSITIVE_TO_SCULK_SMITE = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.rl("sensitive_to_sculk_smite"));
    }

    public static class GameEvents {
        public static final TagKey<GameEvent> CHEST_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.rl("chest_vibrations"));
        public static final TagKey<GameEvent> FEET_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.rl("feet_vibrations"));
    }
}
