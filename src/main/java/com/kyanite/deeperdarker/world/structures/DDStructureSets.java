package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDStructureSets {
    public static final DeferredRegister<StructureSet> STRUCTURE_SETS = DeferredRegister.create(Registry.STRUCTURE_SET_REGISTRY, DeeperDarker.MOD_ID);

    public static final RegistryObject<StructureSet> ANCIENT_TEMPLE = STRUCTURE_SETS.register("ancient_temple", () -> new StructureSet(DDStructures.ANCIENT_TEMPLE.getHolder().get(), new RandomSpreadStructurePlacement(28, 8, RandomSpreadType.LINEAR, 40510257)));
}
