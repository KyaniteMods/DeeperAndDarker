package com.kyanite.deeperdarker.miscellaneous;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.registries.Registries;
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
        public static final TagKey<Block> GLOOM_SCULK_REPLACEABLE = createDDTag("gloom_sculk_replaceable");

        private static TagKey<Block> createDDTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(DeeperAndDarker.MOD_ID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> SCULK = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(DeeperAndDarker.MOD_ID, "sculk"));
    }

    public static class Items {
        public static final TagKey<Item> ECHO_LOGS = TagKey.create(Registries.ITEM, new ResourceLocation(DeeperAndDarker.MOD_ID, "echo_logs"));
        public static final TagKey<Item> HEART = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "heart"));
    }

    public static class Others {
        public static final TagKey<Structure> ALL_STRUCTURES = TagKey.create(Registries.STRUCTURE, new ResourceLocation("all_structures"));
    }
}
