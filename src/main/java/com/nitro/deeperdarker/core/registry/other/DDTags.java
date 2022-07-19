package com.nitro.deeperdarker.core.registry.other;

import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.checkerframework.framework.qual.Unused;

public class DDTags {

    public static class Items {
        public static final TagKey<Item> BONE_WOOD = createTag("bone_wood");
        public static final TagKey<Item> SCULK_BONE_WOOD = createTag("sculk_bone_wood");

        private static TagKey<Item> createTag(String name) {
            return TagUtil.itemTag(DeeperAndDarker.MODID, name);
        }
    }

    public static class Blocks {
        public static final TagKey<Block> BONE_WOOD = createTag("bone_wood");
        public static final TagKey<Block> SCULK_BLOCKS = createTag("sculk_blocks");
        public static final TagKey<Block> SCULK_BONE_WOOD = createTag("sculk_bone_wood");

        private static TagKey<Block> createTag(String name) {
            return TagUtil.blockTag(DeeperAndDarker.MODID, name);
        }
    }

    public static class Structures {
        @SuppressWarnings("unused")
        private static TagKey<Structure> createTag(String name) {
            return TagUtil.structureTag(DeeperAndDarker.MODID, name);
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> SCULK = createTag("sculk");


        private static TagKey<EntityType<?>> createTag(String name) {
            return TagUtil.entityTypeTag(DeeperAndDarker.MODID, name);
        }
    }
}