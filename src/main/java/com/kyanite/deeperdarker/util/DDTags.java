package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("echo_logs"));
        public static final TagKey<Block> BLOOMING_STEMS = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("blooming_stems"));
        public static final TagKey<Block> SCULK_SPRUCE_LOGS = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_spruce_logs"));

        public static final TagKey<Block> OTHERSIDE_CARVER_REPLACEABLES = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("otherside_carver_replaceables"));
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_stone_replaceables"));
        public static final TagKey<Block> SCULK_REPLACEABLES = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_replaceables"));
        public static final TagKey<Block> DEEPLANDS_COLUMN_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("deeplands_column_replaceable"));
        public static final TagKey<Block> DEEPLANDS_COLUMN_BASE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("deeplands_column_base"));

        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("gloomslate_replaceable"));
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("gloomy_sculk_replaceable"));
        public static final TagKey<Block> OVERCAST_COLUMN_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("overcast_column_replaceable"));
        public static final TagKey<Block> OVERCAST_COLUMN_BASE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("overcast_column_base"));

        public static final TagKey<Block> BLOOMING_POOL_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("blooming_pool_replaceable"));

        public static final TagKey<Block> SCULK_VINE_PLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_vine_placeable"));
        public static final TagKey<Block> GLOWING_VINE_PLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("glowing_vine_placeable"));

        public static final TagKey<Block> SCULK_SPRUCE_FOREST_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_spruce_forest_replaceable"));
        public static final TagKey<Block> ICE_REPLACEABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("ice_replaceable"));
        public static final TagKey<Block> ICE_BASE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("ice_base"));

        public static final TagKey<Block> DARK_FOUNTAIN_BEAM_PASSTHROUGH = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("dark_fountain_beam_passthrough"));

        public static final TagKey<Block> TRANSMITTABLE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("transmittable"));
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("infiniburn_otherside"));

        public static final TagKey<Block> ECHO_SOIL = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("echo_soil"));

        public static final TagKey<Block> MAZE_CANNOT_HIDE_CHEST = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("maze/cannot_hide_chest"));
        public static final TagKey<Block> BLOOMING_GOLEM_CAN_WALK_THROUGH = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("blooming_golem_can_walk_through"));
        public static final TagKey<Block> BLOOMING_GOLEM_CAN_DESTROY = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("blooming_golem_can_destroy"));

        public static final TagKey<Block> SCULK_LIGHT_SOURCES = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("sculk_light_sources"));
        public static final TagKey<Block> OVERSEER_VALID_ORIGIN = TagKey.create(
                Registries.BLOCK, DeeperDarker.id("overseer_valid_origin")
        );
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("echo_logs"));

        public static final TagKey<Item> BLOOMING_STEMS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("blooming_stems"));

        public static final TagKey<Item> SCULK_SPRUCE_LOGS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("sculk_spruce_logs"));

        public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("dampens_vibrations"));

        public static final TagKey<Item> PAINTINGS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("paintings"));

        public static final TagKey<Item> SCUTES = TagKey.create(
                Registries.ITEM, DeeperDarker.id("scutes"));

        public static final TagKey<Item> RESONARIUM_ARMOR = TagKey.create(
                Registries.ITEM, DeeperDarker.id("resonarium_armor"));

        public static final TagKey<Item> SCULK_TRANSMITTERS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("sculk_transmitters"));

        public static final TagKey<Item> UNLOCKS_SMALL_LOCK = TagKey.create(
                Registries.ITEM, DeeperDarker.id("unlocks_small_lock"));

        public static final TagKey<Item> UNLOCKS_LARGE_LOCK = TagKey.create(
                Registries.ITEM, DeeperDarker.id("unlocks_large_lock"));

        public static final TagKey<Item> FULLBRIGHT = TagKey.create(
                Registries.ITEM, DeeperDarker.id("fullbright"));

        public static final TagKey<Item> ACID_RESISTANT = TagKey.create(
                Registries.ITEM, DeeperDarker.id("acid_resistant"));

        public static final TagKey<Item> ACID_IMMUNE_ARMOR = TagKey.create(
                Registries.ITEM, DeeperDarker.id("acid_immune_armor"));

        public static final TagKey<Item> ALLOWS_ACID_SPRITE_TRADES = TagKey.create(
                Registries.ITEM, DeeperDarker.id("allows_acid_sprite_trades"));

        public static final TagKey<Item> SHIELD_AUGMENT_ITEMS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("shield_augment_items"));

        public static final TagKey<Item> CLUTTER_ITEMS = TagKey.create(
                Registries.ITEM, DeeperDarker.id("clutter_items"));
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> TOXIC_AIR_IMMUNE = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.id("toxic_air_immune"));
        public static final TagKey<EntityType<?>> ACID_IMMUNE = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.id("acid_immune"));
        public static final TagKey<EntityType<?>> OVERCASTERS = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.id("overcasters"));
    }

    public static class Biomes {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/ancient_temple"));
        public static final TagKey<Biome> HAS_BLOOMAZE = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/bloomaze"));
        public static final TagKey<Biome> HAS_GLOOMAZE = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/gloomaze"));
        public static final TagKey<Biome> HAS_CASTLE = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/castle"));
        public static final TagKey<Biome> HAS_SCULK_RUINS = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/sculk_ruins"));
        public static final TagKey<Biome> HAS_WATCHTOWER = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/watchtower"));
        public static final TagKey<Biome> HAS_VILLAGER_CAMP = TagKey.create(Registries.BIOME, DeeperDarker.id("has_structure/villager_camp"));
        public static final TagKey<Biome> HAS_ACID_FLOES = TagKey.create(Registries.BIOME, DeeperDarker.id("has_acid_floes"));
        public static final TagKey<Biome> SCULK_PHANTOM_BIOMES = TagKey.create(Registries.BIOME, DeeperDarker.id("sculk_phantom_biomes"));
    }

    public static class Paintings {
        public static final TagKey<PaintingVariant> ANCIENT = TagKey.create(Registries.PAINTING_VARIANT, DeeperDarker.id("ancient"));
    }

    public static class Structures {
        public static final TagKey<Structure> WARDEN_HEART_PULSES = TagKey.create(
                Registries.STRUCTURE, DeeperDarker.id("warden_heart_pulses"));

        public static final TagKey<Structure> NO_BLOOMING_POOL_GENERATION = TagKey.create(
                Registries.STRUCTURE, DeeperDarker.id("no_blooming_pool_generation"));
    }

    public static class GameEvents {
        public static final TagKey<GameEvent> CHEST_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.id("chest_vibrations"));
        public static final TagKey<GameEvent> FEET_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.id("feet_vibrations"));
    }

    public static class Fluids {
        public static final TagKey<Fluid> BLOCKS_DARK_FOUNTAIN_BEAM = TagKey.create(
                Registries.FLUID, DeeperDarker.id("blocks_dark_fountain_beam"));

        public static final TagKey<Fluid> ACID = TagKey.create(
                Registries.FLUID, DeeperDarker.id("acid"));
    }
}
