package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class DDStructures {
    public static final ResourceKey<Structure> ANCIENT_TEMPLE = createKey("ancient_temple");

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
