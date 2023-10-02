package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DDItemTagsProvider extends ItemTagsProvider {
    public DDItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, DeeperDarker.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

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

        copy(Tags.Blocks.STONE, Tags.Items.STONE);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
        copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
        copy(Tags.Blocks.ORES_COPPER, Tags.Items.ORES_COPPER);
        copy(Tags.Blocks.ORES_GOLD, Tags.Items.ORES_GOLD);
        copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
        copy(Tags.Blocks.ORES_EMERALD, Tags.Items.ORES_EMERALD);
        copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
        copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);

        tag(DDTags.Items.ECHO_LOGS).add(DDBlocks.ECHO_LOG.get().asItem(), DDBlocks.ECHO_WOOD.get().asItem(), DDBlocks.STRIPPED_ECHO_LOG.get().asItem(), DDBlocks.STRIPPED_ECHO_WOOD.get().asItem());

        tag(Tags.Items.FENCE_GATES_WOODEN).add(DDBlocks.ECHO_FENCE_GATE.get().asItem());
        tag(ItemTags.BOATS).add(DDItems.ECHO_BOAT.get());
        tag(ItemTags.CHEST_BOATS).add(DDItems.ECHO_CHEST_BOAT.get());
        tag(Tags.Items.TOOLS_SHOVELS).add(DDItems.WARDEN_SHOVEL.get());
        tag(Tags.Items.TOOLS_PICKAXES).add(DDItems.WARDEN_PICKAXE.get());
        tag(Tags.Items.TOOLS_AXES).add(DDItems.WARDEN_AXE.get());
        tag(Tags.Items.TOOLS_HOES).add(DDItems.WARDEN_HOE.get());
        tag(Tags.Items.TOOLS_SWORDS).add(DDItems.WARDEN_SWORD.get());

        tag(Tags.Items.ARMORS_HELMETS).add(DDItems.WARDEN_HELMET.get());
        tag(Tags.Items.ARMORS_CHESTPLATES).add(DDItems.WARDEN_CHESTPLATE.get());
        tag(Tags.Items.ARMORS_LEGGINGS).add(DDItems.WARDEN_LEGGINGS.get());
        tag(Tags.Items.ARMORS_BOOTS).add(DDItems.WARDEN_BOOTS.get());

        tag(DDTags.Items.DAMPENS_VIBRATIONS).add(DDItems.WARDEN_BOOTS.get());
    }
}
