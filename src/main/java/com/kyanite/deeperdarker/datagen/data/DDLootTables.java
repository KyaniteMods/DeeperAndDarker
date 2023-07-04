package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.registries.DDBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DDLootTables extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

    protected DDLootTables() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(DDBlocks.ECHO_LOG.get());
        dropSelf(DDBlocks.ECHO_WOOD.get());
        dropSelf(DDBlocks.STRIPPED_ECHO_LOG.get());
        dropSelf(DDBlocks.STRIPPED_ECHO_WOOD.get());
        dropSelf(DDBlocks.ECHO_PLANKS.get());
        dropSelf(DDBlocks.ECHO_STAIRS.get());
        add(DDBlocks.ECHO_SLAB.get(), this::createSlabItemTable);
        dropSelf(DDBlocks.ECHO_FENCE.get());
        dropSelf(DDBlocks.ECHO_FENCE_GATE.get());
        add(DDBlocks.ECHO_DOOR.get(), this::createDoorTable);
        dropSelf(DDBlocks.ECHO_TRAPDOOR.get());
        dropSelf(DDBlocks.ECHO_PRESSURE_PLATE.get());
        dropSelf(DDBlocks.ECHO_BUTTON.get());
        add(DDBlocks.ECHO_LEAVES.get(), (block) -> this.createLeavesDrops(block, Blocks.AIR, NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(DDBlocks.ECHO_SIGN.get());
        dropSelf(DDBlocks.ECHO_HANGING_SIGN.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return DDBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
