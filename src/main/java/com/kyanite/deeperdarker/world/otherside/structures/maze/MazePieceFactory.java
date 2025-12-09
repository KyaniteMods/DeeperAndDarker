package com.kyanite.deeperdarker.world.otherside.structures.maze;

public interface MazePieceFactory {
    MazeStructurePieces.MazeStructurePiece create(Pos pos, Pos entrance);
}
