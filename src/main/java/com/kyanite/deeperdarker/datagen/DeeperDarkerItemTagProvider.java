package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DeeperDarkerItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DeeperDarkerItemTagProvider(FabricDataOutput output,
                                       CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final TagKey<Item> ECHO_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));

    private static final TagKey<Item> HANGING_SIGNS = TagKey.of(RegistryKeys.ITEM, new Identifier("hanging_signs"));
    private static final TagKey<Item> WOODEN_BUTTONS = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_buttons"));
    private static final TagKey<Item> WOODEN_DOORS = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_doors"));
    private static final TagKey<Item> FENCE_GATES = TagKey.of(RegistryKeys.ITEM, new Identifier("fence_gates"));
    private static final TagKey<Item> WOODEN_FENCES = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_fences"));
    private static final TagKey<Item> LEAVES = TagKey.of(RegistryKeys.ITEM, new Identifier("leaves"));
    private static final TagKey<Item> LOGS_THAT_BURN = TagKey.of(RegistryKeys.ITEM, new Identifier("logs_that_burn"));
    private static final TagKey<Item> PLANKS = TagKey.of(RegistryKeys.ITEM, new Identifier("planks"));
    private static final TagKey<Item> WOODEN_SLABS = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_slabs"));
    private static final TagKey<Item> WOODEN_STAIRS = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_stairs"));
    private static final TagKey<Item> SIGNS = TagKey.of(RegistryKeys.ITEM, new Identifier("signs"));
    private static final TagKey<Item> WOODEN_PRESSURE_PLATES = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_pressure_plates"));
    private static final TagKey<Item> WOODEN_TRAPDOORS = TagKey.of(RegistryKeys.ITEM, new Identifier("wooden_trapdoors"));
    private static final TagKey<Item> WALLS = TagKey.of(RegistryKeys.ITEM, new Identifier("walls"));

    private static final TagKey<Item> SWORDS = TagKey.of(RegistryKeys.ITEM, new Identifier("swords"));
    private static final TagKey<Item> PICKAXES = TagKey.of(RegistryKeys.ITEM, new Identifier("pickaxes"));
    private static final TagKey<Item> AXES = TagKey.of(RegistryKeys.ITEM, new Identifier("axes"));
    private static final TagKey<Item> SHOVELS = TagKey.of(RegistryKeys.ITEM, new Identifier("shovels"));
    private static final TagKey<Item> HOES = TagKey.of(RegistryKeys.ITEM, new Identifier("hoes"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ECHO_LOGS).add(DeeperDarkerItems.ECHO_LOG, DeeperDarkerItems.ECHO_WOOD, DeeperDarkerItems.STRIPPED_ECHO_LOG, DeeperDarkerItems.STRIPPED_ECHO_WOOD);

        getOrCreateTagBuilder(HANGING_SIGNS).setReplace(false).add(DeeperDarkerItems.ECHO_HANGING_SIGN);
        getOrCreateTagBuilder(WOODEN_BUTTONS).setReplace(false).add(DeeperDarkerItems.ECHO_BUTTON);
        getOrCreateTagBuilder(WOODEN_DOORS).setReplace(false).add(DeeperDarkerItems.ECHO_DOOR);
        getOrCreateTagBuilder(FENCE_GATES).setReplace(false).add(DeeperDarkerItems.ECHO_FENCE_GATE);
        getOrCreateTagBuilder(WOODEN_FENCES).setReplace(false).add(DeeperDarkerItems.ECHO_FENCE);
        getOrCreateTagBuilder(LEAVES).setReplace(false).add(DeeperDarkerItems.ECHO_LEAVES);
        getOrCreateTagBuilder(LOGS_THAT_BURN).setReplace(false).addTag(ECHO_LOGS);
        getOrCreateTagBuilder(PLANKS).setReplace(false).add(DeeperDarkerItems.ECHO_PLANKS);
        getOrCreateTagBuilder(WOODEN_SLABS).setReplace(false).add(DeeperDarkerItems.ECHO_SLAB);
        getOrCreateTagBuilder(WOODEN_STAIRS).setReplace(false).add(DeeperDarkerItems.ECHO_STAIRS);
        getOrCreateTagBuilder(SIGNS).setReplace(false).add(DeeperDarkerItems.ECHO_SIGN);
        getOrCreateTagBuilder(WOODEN_PRESSURE_PLATES).setReplace(false).add(DeeperDarkerItems.ECHO_PRESSURE_PLATE);
        getOrCreateTagBuilder(WOODEN_TRAPDOORS).setReplace(false).add(DeeperDarkerItems.ECHO_TRAPDOOR);
        getOrCreateTagBuilder(SWORDS).setReplace(false).add(DeeperDarkerItems.WARDEN_SWORD);
        getOrCreateTagBuilder(PICKAXES).setReplace(false).add(DeeperDarkerItems.WARDEN_PICKAXE);
        getOrCreateTagBuilder(AXES).setReplace(false).add(DeeperDarkerItems.WARDEN_AXE);
        getOrCreateTagBuilder(SHOVELS).setReplace(false).add(DeeperDarkerItems.WARDEN_SHOVEL);
        getOrCreateTagBuilder(HOES).setReplace(false).add(DeeperDarkerItems.WARDEN_HOE);

        getOrCreateTagBuilder(WALLS).setReplace(false).add(
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
    }
}