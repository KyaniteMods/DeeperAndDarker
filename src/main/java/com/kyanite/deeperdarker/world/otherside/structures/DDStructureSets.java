package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class DDStructureSets {
    public static final ResourceKey<StructureSet> ANCIENT_TEMPLES = createKey("ancient_temples");

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(ANCIENT_TEMPLES, new StructureSet(structures.getOrThrow(DDStructures.ANCIENT_TEMPLE), new RandomSpreadStructurePlacement(28, 8, RandomSpreadType.LINEAR, 40510257)));
    }

    static ResourceKey<StructureSet> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, DeeperDarker.rl(name));
    }
}
