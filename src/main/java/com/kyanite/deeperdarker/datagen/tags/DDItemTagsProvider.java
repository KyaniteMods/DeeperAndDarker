package com.kyanite.deeperdarker.datagen.tags;

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

public class DDItemTagsProvider extends ItemTagsProvider {
    public DDItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, DeeperAndDarker.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
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
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(DDTags.Blocks.ECHO_LOGS, DDTags.Items.ECHO_LOGS);
        tag(ItemTags.NON_FLAMMABLE_WOOD).add(DDItems.ECHO_SIGN.get()).addTags(DDTags.Items.ECHO_LOGS);

        tag(ItemTags.STONE_TOOL_MATERIALS).add(DDBlocks.COBBLED_SCULK_STONE.get().asItem());
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(DDBlocks.COBBLED_SCULK_STONE.get().asItem());
        tag(ItemTags.FOX_FOOD).add(DDItems.GLOOM_BERRIES.get());
        tag(Tags.Items.TOOLS_SWORDS).add(DDItems.WARDEN_SWORD.get());
        tag(Tags.Items.TOOLS_SHOVELS).add(DDItems.WARDEN_SHOVEL.get());
        tag(Tags.Items.TOOLS_PICKAXES).add(DDItems.WARDEN_PICKAXE.get());
        tag(Tags.Items.TOOLS_AXES).add(DDItems.WARDEN_AXE.get());
        tag(Tags.Items.TOOLS_HOES).add(DDItems.WARDEN_HOE.get());
        tag(Tags.Items.ARMORS_HELMETS).add(DDItems.WARDEN_HELMET.get());
        tag(Tags.Items.ARMORS_CHESTPLATES).add(DDItems.WARDEN_CHESTPLATE.get());
        tag(Tags.Items.ARMORS_LEGGINGS).add(DDItems.WARDEN_LEGGINGS.get());
        tag(Tags.Items.ARMORS_BOOTS).add(DDItems.WARDEN_BOOTS.get());
    }
}
