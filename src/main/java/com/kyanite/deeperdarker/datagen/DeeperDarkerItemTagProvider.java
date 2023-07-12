package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import com.kyanite.deeperdarker.tags.DeeperDarkerTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DeeperDarkerItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DeeperDarkerItemTagProvider(FabricDataOutput output,
                                       CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DeeperDarkerTags.Items.ECHO_LOGS).add(DeeperDarkerItems.ECHO_LOG, DeeperDarkerItems.ECHO_WOOD, DeeperDarkerItems.STRIPPED_ECHO_LOG, DeeperDarkerItems.STRIPPED_ECHO_WOOD);

        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).setReplace(false).add(DeeperDarkerItems.ECHO_HANGING_SIGN);
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).setReplace(false).add(DeeperDarkerItems.ECHO_BUTTON);
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).setReplace(false).add(DeeperDarkerItems.ECHO_DOOR);
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).setReplace(false).add(DeeperDarkerItems.ECHO_FENCE_GATE);
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).setReplace(false).add(DeeperDarkerItems.ECHO_FENCE);
        getOrCreateTagBuilder(ItemTags.LEAVES).setReplace(false).add(DeeperDarkerItems.ECHO_LEAVES);
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).setReplace(false).addTag(DeeperDarkerTags.Items.ECHO_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).setReplace(false).add(DeeperDarkerItems.ECHO_PLANKS);
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).setReplace(false).add(DeeperDarkerItems.ECHO_SLAB);
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).setReplace(false).add(DeeperDarkerItems.ECHO_STAIRS);
        getOrCreateTagBuilder(ItemTags.SIGNS).setReplace(false).add(DeeperDarkerItems.ECHO_SIGN);
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).setReplace(false).add(DeeperDarkerItems.ECHO_PRESSURE_PLATE);
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).setReplace(false).add(DeeperDarkerItems.ECHO_TRAPDOOR);
        getOrCreateTagBuilder(ItemTags.SWORDS).setReplace(false).add(DeeperDarkerItems.WARDEN_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).setReplace(false).add(DeeperDarkerItems.WARDEN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).setReplace(false).add(DeeperDarkerItems.WARDEN_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).setReplace(false).add(DeeperDarkerItems.WARDEN_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).setReplace(false).add(DeeperDarkerItems.WARDEN_HOE);

        getOrCreateTagBuilder(ItemTags.WALLS).setReplace(false).add(
                DeeperDarkerItems.SCULK_STONE_WALL,
                DeeperDarkerItems.COBBLED_SCULK_STONE_WALL,
                DeeperDarkerItems.POLISHED_SCULK_STONE_WALL,
                DeeperDarkerItems.SCULK_STONE_BRICK_WALL,
                DeeperDarkerItems.SCULK_STONE_TILE_WALL,
                DeeperDarkerItems.SMOOTH_SCULK_STONE_WALL,
                DeeperDarkerItems.CUT_SCULK_STONE_WALL,
                DeeperDarkerItems.SCULK_GRIME_BRICK_WALL,
                DeeperDarkerItems.GLOOMSLATE_WALL,
                DeeperDarkerItems.COBBLED_GLOOMSLATE_WALL,
                DeeperDarkerItems.POLISHED_GLOOMSLATE_WALL,
                DeeperDarkerItems.GLOOMSLATE_BRICK_WALL,
                DeeperDarkerItems.GLOOMSLATE_TILE_WALL,
                DeeperDarkerItems.SMOOTH_GLOOMSLATE_WALL,
                DeeperDarkerItems.CUT_GLOOMSLATE_WALL
        );

        getOrCreateTagBuilder(ItemTags.STAIRS).setReplace(false).add(
                DeeperDarkerItems.SCULK_STONE_STAIRS,
                DeeperDarkerItems.COBBLED_SCULK_STONE_STAIRS,
                DeeperDarkerItems.POLISHED_SCULK_STONE_STAIRS,
                DeeperDarkerItems.SCULK_STONE_BRICK_STAIRS,
                DeeperDarkerItems.SCULK_STONE_TILE_STAIRS,
                DeeperDarkerItems.SMOOTH_SCULK_STONE_STAIRS,
                DeeperDarkerItems.CUT_SCULK_STONE_STAIRS,
                DeeperDarkerItems.SCULK_GRIME_BRICK_STAIRS,
                DeeperDarkerItems.GLOOMSLATE_STAIRS,
                DeeperDarkerItems.COBBLED_GLOOMSLATE_STAIRS,
                DeeperDarkerItems.POLISHED_GLOOMSLATE_STAIRS,
                DeeperDarkerItems.GLOOMSLATE_BRICK_STAIRS,
                DeeperDarkerItems.GLOOMSLATE_TILE_STAIRS,
                DeeperDarkerItems.SMOOTH_GLOOMSLATE_STAIRS,
                DeeperDarkerItems.CUT_GLOOMSLATE_STAIRS
        );

        getOrCreateTagBuilder(ItemTags.SLABS).setReplace(false).add(
                DeeperDarkerItems.SCULK_STONE_SLAB,
                DeeperDarkerItems.COBBLED_SCULK_STONE_SLAB,
                DeeperDarkerItems.POLISHED_SCULK_STONE_SLAB,
                DeeperDarkerItems.SCULK_STONE_BRICK_SLAB,
                DeeperDarkerItems.SCULK_STONE_TILE_SLAB,
                DeeperDarkerItems.SMOOTH_SCULK_STONE_SLAB,
                DeeperDarkerItems.CUT_SCULK_STONE_SLAB,
                DeeperDarkerItems.SCULK_GRIME_BRICK_SLAB,
                DeeperDarkerItems.GLOOMSLATE_SLAB,
                DeeperDarkerItems.COBBLED_GLOOMSLATE_SLAB,
                DeeperDarkerItems.POLISHED_GLOOMSLATE_SLAB,
                DeeperDarkerItems.GLOOMSLATE_BRICK_SLAB,
                DeeperDarkerItems.GLOOMSLATE_TILE_SLAB,
                DeeperDarkerItems.SMOOTH_GLOOMSLATE_SLAB,
                DeeperDarkerItems.CUT_GLOOMSLATE_SLAB
        );

        getOrCreateTagBuilder(ItemTags.COAL_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_COAL_ORE);
        getOrCreateTagBuilder(ItemTags.IRON_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_IRON_ORE);
        getOrCreateTagBuilder(ItemTags.COPPER_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_COPPER_ORE);
        getOrCreateTagBuilder(ItemTags.GOLD_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_GOLD_ORE);
        getOrCreateTagBuilder(ItemTags.REDSTONE_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_REDSTONE_ORE);
        getOrCreateTagBuilder(ItemTags.EMERALD_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_EMERALD_ORE);
        getOrCreateTagBuilder(ItemTags.LAPIS_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_LAPIS_ORE);
        getOrCreateTagBuilder(ItemTags.DIAMOND_ORES).setReplace(false).add(DeeperDarkerItems.SCULK_STONE_DIAMOND_ORE);
    }
}