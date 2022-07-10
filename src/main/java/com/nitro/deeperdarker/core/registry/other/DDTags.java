package com.nitro.deeperdarker.core.registry.other;

import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DDTags {

    public static class Items {
        @SuppressWarnings("unused")
        private static TagKey<Item> createTag(String name) {
            return TagUtil.itemTag(DeeperAndDarker.MODID, name);
        }
    }

    public static class Blocks {
        @SuppressWarnings("unused")
        private static TagKey<Block> createTag(String name) {
            return TagUtil.blockTag(DeeperAndDarker.MODID, name);
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> SCULK_SAFE = createTag("sculk_safe");


        private static TagKey<EntityType<?>> createTag(String name) {
            return TagUtil.entityTypeTag(DeeperAndDarker.MODID, name);
        }
    }
}