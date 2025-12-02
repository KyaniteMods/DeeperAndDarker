package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePiece;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class DDStructurePieceTypes {
    public static final StructurePieceType MAZE_PIECE = contextless(MazeStructurePiece::new, "maze_piece");

    private static StructurePieceType contextless(StructurePieceType.ContextlessType structurePieceType, String string) {
        return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, new ResourceLocation(DeeperDarker.MOD_ID, string), structurePieceType);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering structure piece types");
    }
}
