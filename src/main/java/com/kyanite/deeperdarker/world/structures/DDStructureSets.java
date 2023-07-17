package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class DDStructureSets {
    public static final  ResourceKey<StructureSet> ANCIENT_TEMPLE = createKey("ancient_temple");

    public static void bootstrap(BootstapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(ANCIENT_TEMPLE, new StructureSet(structures.getOrThrow(DDStructures.ANCIENT_TEMPLE), new RandomSpreadStructurePlacement(28, 8, RandomSpreadType.LINEAR, 40510257)));
    }

    static ResourceKey<StructureSet> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
