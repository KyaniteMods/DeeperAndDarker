package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends ItemTagsProvider {
    public DDItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);

        copy(BlockTags.COAL_ORES, ItemTags.COAL_ORES);
        copy(BlockTags.IRON_ORES, ItemTags.IRON_ORES);
        copy(BlockTags.COPPER_ORES, ItemTags.COPPER_ORES);
        copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
        copy(BlockTags.REDSTONE_ORES, ItemTags.REDSTONE_ORES);
        copy(BlockTags.EMERALD_ORES, ItemTags.EMERALD_ORES);
        copy(BlockTags.LAPIS_ORES, ItemTags.LAPIS_ORES);
        copy(BlockTags.DIAMOND_ORES, ItemTags.DIAMOND_ORES);

        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        copy(Tags.Blocks.STONES, Tags.Items.STONES);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
        copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
        copy(Tags.Blocks.ORES_COPPER, Tags.Items.ORES_COPPER);
        copy(Tags.Blocks.ORES_GOLD, Tags.Items.ORES_GOLD);
        copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
        copy(Tags.Blocks.ORES_EMERALD, Tags.Items.ORES_EMERALD);
        copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
        copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);

        copy(DDTags.Blocks.ECHO_LOGS, DDTags.Items.ECHO_LOGS);
        copy(DDTags.Blocks.BLOOM_STEMS, DDTags.Items.BLOOM_STEMS);

        tag(ItemTags.BOATS).add(DDItems.ECHO_BOAT.get(), DDItems.BLOOM_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(DDItems.ECHO_CHEST_BOAT.get(), DDItems.BLOOM_CHEST_BOAT.get());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(DDItems.RESONARIUM_PICKAXE.get(), DDItems.WARDEN_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(DDItems.RESONARIUM_SHOVEL.get(), DDItems.WARDEN_SHOVEL.get());
        tag(ItemTags.PICKAXES).add(DDItems.RESONARIUM_PICKAXE.get(), DDItems.WARDEN_PICKAXE.get());
        tag(ItemTags.AXES).add(DDItems.RESONARIUM_AXE.get(), DDItems.WARDEN_AXE.get());
        tag(ItemTags.HOES).add(DDItems.RESONARIUM_HOE.get(), DDItems.WARDEN_HOE.get());
        tag(ItemTags.SWORDS).add(DDItems.RESONARIUM_SWORD.get(), DDItems.WARDEN_SWORD.get());

        tag(ItemTags.HEAD_ARMOR).add(DDItems.WARDEN_HELMET.get());
        tag(ItemTags.CHEST_ARMOR).add(DDItems.WARDEN_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(DDItems.WARDEN_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(DDItems.WARDEN_BOOTS.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(DDItems.SOUL_ELYTRA.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(DDItems.SOUL_ELYTRA.get(), DDItems.RESONARIUM_HELMET.get(), DDItems.RESONARIUM_CHESTPLATE.get(), DDItems.RESONARIUM_LEGGINGS.get(), DDItems.RESONARIUM_BOOTS.get());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(DDItems.RESONARIUM_HELMET.get(), DDItems.RESONARIUM_CHESTPLATE.get(), DDItems.RESONARIUM_LEGGINGS.get(), DDItems.RESONARIUM_BOOTS.get());

        tag(DDTags.Items.DAMPENS_VIBRATIONS).add(DDItems.WARDEN_BOOTS.get());
    }
}
