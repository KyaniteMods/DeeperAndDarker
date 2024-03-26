package com.kyanite.deeperdarker.datagen.assets;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.items.DDItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DDENLanguageProvider extends LanguageProvider {

    public DDENLanguageProvider(PackOutput output) {
        super(output, DeeperDarker.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Misc
        add("itemGroup.deeperdarker", "Deeper and Darker");
        
        // Items
        addItem(DDItems.HEART_OF_THE_DEEP, "Heart of the Deep");
        addItem(DDItems.WARDEN_CARAPACE, "Warden Carapace");
        addItem(DDItems.REINFORCED_ECHO_SHARD, "Reinforced Echo Shard");
        addItem(DDItems.SCULK_BONE, "Sculk Bone");
        addItem(DDItems.SOUL_DUST, "Soul Dust");
        addItem(DDItems.SOUL_CRYSTAL, "Soul Crystal");

        // Block items
        addItem(DDItems.ECHO_LOG, "Echo Log");
        addItem(DDItems.ECHO_WOOD, "Echo Wood");
        addItem(DDItems.STRIPPED_ECHO_LOG, "Stripped Echo Log");
        addItem(DDItems.STRIPPED_ECHO_WOOD, "Stripped Echo Wood");
        addItem(DDItems.ECHO_PLANKS, "Echo Planks");
        addItem(DDItems.ECHO_STAIRS, "Echo Stairs");
        addItem(DDItems.ECHO_SLAB, "Echo Slab");
        addItem(DDItems.ECHO_FENCE, "Echo Fence");
        addItem(DDItems.ECHO_FENCE_GATE, "Echo Fence Gate");
        addItem(DDItems.ECHO_DOOR, "Echo Door");
        addItem(DDItems.ECHO_TRAPDOOR, "Echo Trapdoor");
        addItem(DDItems.ECHO_PRESSURE_PLATE, "Echo Pressure Plate");
        addItem(DDItems.ECHO_BUTTON, "Echo Button");
        addItem(DDItems.ECHO_LEAVES, "Echo Leaves");

        addItem(DDItems.BLOOM_PLANKS, "Bloom Planks");
        addItem(DDItems.BLOOM_STAIRS, "Bloom Stairs");
        addItem(DDItems.BLOOM_SLAB, "Bloom Slab");
        addItem(DDItems.BLOOM_FENCE, "Bloom Fence");
        addItem(DDItems.BLOOM_FENCE_GATE, "Bloom Fence Gate");
        addItem(DDItems.BLOOM_DOOR, "Bloom Door");
        addItem(DDItems.BLOOM_TRAPDOOR, "Bloom Trapdoor");
        addItem(DDItems.BLOOM_PRESSURE_PLATE, "Bloom Pressure Plate");
        addItem(DDItems.BLOOM_BUTTON, "Bloom Button");

        // Blocks
    }
}
