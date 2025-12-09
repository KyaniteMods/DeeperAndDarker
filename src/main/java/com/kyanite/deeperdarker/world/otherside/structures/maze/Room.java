package com.kyanite.deeperdarker.world.otherside.structures.maze;

public record Room(MazePieceFactory roomFactory, Pos pos, Pos entrance) {
    public MazeStructurePieces.MazeStructurePiece create() {
        return roomFactory().create(pos(), entrance());
    }
}
