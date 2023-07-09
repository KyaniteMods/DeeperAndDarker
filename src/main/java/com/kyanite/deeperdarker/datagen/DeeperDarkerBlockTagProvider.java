package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DeeperDarkerBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DeeperDarkerBlockTagProvider(FabricDataOutput output,
                                        CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static TagKey<Block> ECHO_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(DeeperDarker.MOD_ID, "echo_logs"));

    private static TagKey<Block> CEILING_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("ceiling_hanging_signs"));
    private static TagKey<Block> WOODEN_BUTTONS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_buttons"));
    private static TagKey<Block> WOODEN_DOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_doors"));
    private static TagKey<Block> FENCE_GATES = TagKey.of(RegistryKeys.BLOCK, new Identifier("fence_gates"));
    private static TagKey<Block> WOODEN_FENCES = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_fences"));
    private static TagKey<Block> LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier("leaves"));
    private static TagKey<Block> LOGS_THAT_BURN = TagKey.of(RegistryKeys.BLOCK, new Identifier("logs_that_burn"));
    private static TagKey<Block> PLANKS = TagKey.of(RegistryKeys.BLOCK, new Identifier("planks"));
    private static TagKey<Block> WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_slabs"));
    private static TagKey<Block> WOODEN_STAIRS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_stairs"));
    private static TagKey<Block> STANDING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("standing_signs"));
    private static TagKey<Block> WALL_HANGING_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wall_hanging_signs"));
    private static TagKey<Block> WALL_SIGNS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wall_signs"));
    private static TagKey<Block> WOODEN_PRESSURE_PLATES = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_pressure_plates"));
    private static TagKey<Block> WOODEN_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("wooden_trapdoors"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ECHO_LOGS).add(DeeperDarkerBlocks.ECHO_LOG, DeeperDarkerBlocks.ECHO_WOOD, DeeperDarkerBlocks.STRIPPED_ECHO_LOG, DeeperDarkerBlocks.STRIPPED_ECHO_WOOD);

        getOrCreateTagBuilder(CEILING_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_HANGING_SIGN);
        getOrCreateTagBuilder(WALL_HANGING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(WOODEN_BUTTONS).setReplace(false).add(DeeperDarkerBlocks.ECHO_BUTTON);
        getOrCreateTagBuilder(WOODEN_DOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_DOOR);
        getOrCreateTagBuilder(FENCE_GATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE_GATE);
        getOrCreateTagBuilder(WOODEN_FENCES).setReplace(false).add(DeeperDarkerBlocks.ECHO_FENCE);
        getOrCreateTagBuilder(LEAVES).setReplace(false).add(DeeperDarkerBlocks.ECHO_LEAVES);
        getOrCreateTagBuilder(LOGS_THAT_BURN).setReplace(false).addTag(ECHO_LOGS);
        getOrCreateTagBuilder(PLANKS).setReplace(false).add(DeeperDarkerBlocks.ECHO_PLANKS);
        getOrCreateTagBuilder(WOODEN_SLABS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SLAB);
        getOrCreateTagBuilder(WOODEN_STAIRS).setReplace(false).add(DeeperDarkerBlocks.ECHO_STAIRS);
        getOrCreateTagBuilder(STANDING_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_SIGN);
        getOrCreateTagBuilder(WALL_SIGNS).setReplace(false).add(DeeperDarkerBlocks.ECHO_WALL_SIGN);
        getOrCreateTagBuilder(WOODEN_PRESSURE_PLATES).setReplace(false).add(DeeperDarkerBlocks.ECHO_PRESSURE_PLATE);
        getOrCreateTagBuilder(WOODEN_TRAPDOORS).setReplace(false).add(DeeperDarkerBlocks.ECHO_TRAPDOOR);
    }
}
