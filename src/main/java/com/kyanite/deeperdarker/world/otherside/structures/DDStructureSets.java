package com.kyanite.deeperdarker.world.otherside.structures;

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
    public static final ResourceKey<StructureSet> ANCIENT_TEMPLES = createKey("ancient_temples");
    public static final ResourceKey<StructureSet> BLOOMAZES = createKey("bloomazes");
    public static final ResourceKey<StructureSet> GLOOMAZES = createKey("gloomazes");

    public static void bootstrap(BootstapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(ANCIENT_TEMPLES, new StructureSet(structures.getOrThrow(DDStructures.ANCIENT_TEMPLE), new RandomSpreadStructurePlacement(28, 8, RandomSpreadType.LINEAR, 40510257)));
        context.register(BLOOMAZES, new StructureSet(structures.getOrThrow(DDStructures.BLOOMAZE), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 27070707)));
        context.register(GLOOMAZES, new StructureSet(structures.getOrThrow(DDStructures.GLOOMAZE), new RandomSpreadStructurePlacement(24, 10, RandomSpreadType.LINEAR, 25122025)));
    }

    static ResourceKey<StructureSet> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(DeeperDarker.MOD_ID, name));
    }
}
