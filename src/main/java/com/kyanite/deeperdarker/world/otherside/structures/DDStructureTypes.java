package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructure;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class DDStructureTypes {
    public static final StructureType<MazeStructure> MAZE = register("maze", MazeStructure.CODEC);

    private static <S extends Structure> StructureType<S> register(String string, Codec<S> codec) {
        return Registry.register(BuiltInRegistries.STRUCTURE_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, string), () -> codec);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering structure types");
    }
}
