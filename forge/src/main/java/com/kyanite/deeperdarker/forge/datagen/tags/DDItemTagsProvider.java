package com.kyanite.deeperdarker.forge.datagen.tags;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class DDItemTagsProvider extends ItemTagsProvider {
    public DDItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);

        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.WALLS, ItemTags.WALLS);

        copy(BlockTags.COAL_ORES, ItemTags.COAL_ORES);
        copy(BlockTags.IRON_ORES, ItemTags.IRON_ORES);
        copy(BlockTags.COPPER_ORES, ItemTags.COPPER_ORES);
        copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
        copy(BlockTags.REDSTONE_ORES, ItemTags.REDSTONE_ORES);
        copy(BlockTags.EMERALD_ORES, ItemTags.EMERALD_ORES);
        copy(BlockTags.LAPIS_ORES, ItemTags.LAPIS_ORES);
        copy(BlockTags.DIAMOND_ORES, ItemTags.DIAMOND_ORES);

        copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        copy(Tags.Blocks.FENCES_WOODEN, Tags.Items.FENCES_WOODEN);
        copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
        copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
        copy(Tags.Blocks.ORES_COPPER, Tags.Items.ORES_COPPER);
        copy(Tags.Blocks.ORES_GOLD, Tags.Items.ORES_GOLD);
        copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
        copy(Tags.Blocks.ORES_EMERALD, Tags.Items.ORES_EMERALD);
        copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
        copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);

        copy(DDTags.Blocks.ECHO_LOGS, DDTags.Items.ECHO_LOGS);

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(DDBlocks.COBBLED_SCULK_STONE.asItem());
        tag(ItemTags.STONE_TOOL_MATERIALS).add(DDBlocks.COBBLED_SCULK_STONE.asItem());

        tag(ItemTags.CHEST_BOATS).add(DDItems.ECHO_CHEST_BOAT);
        tag(ItemTags.BOATS).add(DDItems.ECHO_BOAT);

        tag(Tags.Items.TOOLS_SWORDS).add(DDItems.WARDEN_SWORD);
        tag(Tags.Items.TOOLS_SHOVELS).add(DDItems.WARDEN_SHOVEL);
        tag(Tags.Items.TOOLS_PICKAXES).add(DDItems.WARDEN_PICKAXE);
        tag(Tags.Items.TOOLS_AXES).add(DDItems.WARDEN_AXE);
        tag(Tags.Items.TOOLS_HOES).add(DDItems.WARDEN_HOE);
        tag(Tags.Items.ARMORS_HELMETS).add(DDItems.WARDEN_HELMET);
        tag(Tags.Items.ARMORS_CHESTPLATES).add(DDItems.WARDEN_CHESTPLATE);
        tag(Tags.Items.ARMORS_LEGGINGS).add(DDItems.WARDEN_LEGGINGS);
        tag(Tags.Items.ARMORS_BOOTS).add(DDItems.WARDEN_BOOTS);
    }

    @NotNull
    @Override
    public String getName() {
        return "Item Tags";
    }
}
