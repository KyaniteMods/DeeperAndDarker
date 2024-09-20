package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Block> BLOOM_STEMS = tag("bloom_stems");

        public static final TagKey<Block> OTHERSIDE_CARVER_REPLACEABLES = tag("otherside_carver_replaceables");
        public static final TagKey<Block> SCULK_STONE_REPLACEABLES = tag("sculk_stone_replaceables");
        public static final TagKey<Block> SCULK_REPLACEABLES = tag("sculk_replaceables");
        public static final TagKey<Block> DEEPLANDS_COLUMN_BASE = tag("deeplands_column_base");
        public static final TagKey<Block> GLOOMSLATE_REPLACEABLE = tag("gloomslate_replaceable");
        public static final TagKey<Block> GLOOMY_SCULK_REPLACEABLE = tag("gloomy_sculk_replaceable");
        public static final TagKey<Block> OVERCAST_COLUMN_BASE = tag("overcast_column_base");
        public static final TagKey<Block> BLOOMING_POOL_REPLACEABLE = tag("blooming_pool_replaceable");

        public static final TagKey<Block> SCULK_VINE_PLACEABLE = tag("sculk_vine_placeable");
        public static final TagKey<Block> GLOWING_VINE_PLACEABLE = tag("glowing_vine_placeable");

        public static final TagKey<Block> TRANSMITTABLE = tag("transmittable");
        public static final TagKey<Block> INFINIBURN_OTHERSIDE = tag("infiniburn_otherside");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(DeeperDarker.rl(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BLOOM_STEMS = tag("bloom_stems");
        public static final TagKey<Item> ECHO_LOGS = tag("echo_logs");
        public static final TagKey<Item> RESONARIUM_ARMOR = tag("resonarium_armor");
        public static final TagKey<Item> DAMPENS_VIBRATIONS = tag("dampens_vibrations");
        public static final TagKey<Item> SCUTES = tag("scutes");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(DeeperDarker.rl(name));
        }
    }

    public static class Misc {
        public static final TagKey<Biome> HAS_ANCIENT_TEMPLE = TagKey.create(Registries.BIOME, DeeperDarker.rl("has_structure/ancient_temple"));
        public static final TagKey<Enchantment> RESONARIUM_EXCLUDES = TagKey.create(Registries.ENCHANTMENT, DeeperDarker.rl("resonarium_excludes"));
        public static final TagKey<EntityType<?>> SCULK = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.rl("sculk"));
        public static final TagKey<EntityType<?>> SENSITIVE_TO_SCULK_SMITE = TagKey.create(Registries.ENTITY_TYPE, DeeperDarker.rl("sensitive_to_sculk_smite"));
        public static final TagKey<GameEvent> CHEST_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.rl("chest_vibrations"));
        public static final TagKey<GameEvent> FEET_VIBRATIONS = TagKey.create(Registries.GAME_EVENT, DeeperDarker.rl("feet_vibrations"));
        public static final TagKey<PaintingVariant> ANCIENT_PAINTING = TagKey.create(Registries.PAINTING_VARIANT, DeeperDarker.rl("ancient_painting"));
    }
}
