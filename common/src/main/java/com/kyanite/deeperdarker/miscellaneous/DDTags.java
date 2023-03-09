package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDTags {
    public static class Blocks {
        public static final TagKey<Block> ECHO_LOGS = createDDTag("echo_logs");
        public static final TagKey<Block> STRIPPED_LOGS = createDDTag("stripped_logs");
        public static final TagKey<Block> WOOD = createDDTag("wood");
        public static final TagKey<Block> STRIPPED_WOOD = createDDTag("stripped_wood");
        public static final TagKey<Block> TRANSMITTABLE = createDDTag("transmittable");
        public static final TagKey<Block> GLOOM_SCULK_REPLACEABLE = createDDTag("gloom_sculk_replaceable");

        private static TagKey<Block> createDDTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }

        private static TagKey<Block> createOtherTag(String modID, String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(modID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> SCULK = createDDTag("sculk");

        private static TagKey<EntityType<?>> createDDTag(String name) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = createDDTag("echo_logs");

        public static final TagKey<Item> HEART = createOtherTag("forge", "heart");

        private static TagKey<Item> createDDTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }

        private static TagKey<Item> createOtherTag(String modID, String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(modID, name));
        }
    }

    public static class Others {
        public static final TagKey<Structure> ALL_STRUCTURES = structureTag("all_structures");
        private static TagKey<Structure> structureTag(String string) {
            return TagKey.create(Registry.STRUCTURE_REGISTRY, new ResourceLocation(string));
        }
    }
}
