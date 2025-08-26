package com.kyanite.deeperdarker.datagen.data;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDDataMaps extends DataMapProvider {
    public DDDataMaps(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void gather(HolderLookup.@NotNull Provider provider) {
        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(DDItems.BLOOM_BERRIES, new Compostable(0.3f, false), false)
                .add(DDBlocks.ECHO_LEAVES.getId(), new Compostable(0.3f, false), false)
                .add(DDBlocks.ECHO_SAPLING.getId(), new Compostable(0.3f, false), false)
                .add(DDBlocks.GLOOMY_CACTUS.getId(), new Compostable(0.5f, false), false)
                .add(DDBlocks.GLOOMY_GRASS.getId(), new Compostable(0.3f, false), false)
                .add(DDBlocks.GLOWING_GRASS.getId(), new Compostable(0.3f, false), false)
                .add(DDBlocks.GLOWING_FLOWERS.getId(), new Compostable(0.3f, false), false)
                .add(DDBlocks.GLOWING_ROOTS.getId(), new Compostable(0.5f, false), false)
                .add(DDBlocks.SCULK_TENDRILS.getId(), new Compostable(0.5f, false), false)
                .add(DDBlocks.SCULK_VINES.getId(), new Compostable(0.5f, false), false)
                .add(DDBlocks.BLOOMING_MOSS_BLOCK.getId(), new Compostable(0.65f, false), false)
                .add(DDBlocks.CRYSTALLIZED_AMBER.getId(), new Compostable(0.65f, false), false)
                .add(DDItems.ICE_LILY, new Compostable(0.65f, false), false)
                .add(DDItems.LILY_FLOWER, new Compostable(0.65f, false), false)
                .add(DDBlocks.POROUS_SCULK_GLEAM.getId(), new Compostable(0.65f, false), false)
                .add(DDBlocks.SCULK_GLEAM.getId(), new Compostable(0.65f, false), false);
    }
}
