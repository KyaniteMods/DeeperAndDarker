package com.kyanite.deeperdarker.world.otherside.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePieces;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class DDStructurePieceTypes {
    public static final StructurePieceType MAZE_WALL_PIECE = contextless(MazeStructurePieces.MazeWallPiece::new, "maze_wall_piece");
    public static final StructurePieceType MAZE_PATH_PIECE = contextless(MazeStructurePieces.MazePathPiece::new, "maze_path_piece");
    public static final StructurePieceType MAZE_STATUE_PATH_PIECE = contextless(MazeStructurePieces.MazeStatuePathPiece::new, "maze_statue_path_piece");
    public static final StructurePieceType MAZE_GLASS_PATH_PIECE = contextless(MazeStructurePieces.MazeGlassPathPiece::new, "maze_glass_path_piece");
    public static final StructurePieceType MAZE_FLUID_PATH_PIECE = contextless(MazeStructurePieces.MazeFluidPathPiece::new, "maze_fluid_path_piece");

    private static StructurePieceType contextless(StructurePieceType.ContextlessType structurePieceType, String string) {
        return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, new ResourceLocation(DeeperDarker.MOD_ID, string), structurePieceType);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering structure piece types");
    }
}
