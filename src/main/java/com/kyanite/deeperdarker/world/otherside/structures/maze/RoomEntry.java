package com.kyanite.deeperdarker.world.otherside.structures.maze;

import java.util.Optional;

public record RoomEntry(MazePieceFactory roomFactory, Optional<Pos> pos, int width, int height, int depth, boolean required) {
    public boolean fits(Tile[][][] partialResult, int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        if (pos.x() + width() > mazeWidth - 1 || pos.y() + height() > mazeHeight - 1 || pos.z() + depth() > mazeDepth - 1) return false;

        for (int z = pos.z(); z < pos.z() + depth(); z++) {
            for (int y = pos.y(); y < pos.y() + height(); y++) {
                for (int x = pos.x(); x < pos.x() + width(); x++) {
                    if (partialResult[x][y][z].getType() == Tile.Type.ROOM) return false;
                }
            }
        }

        return true;
    }

    public Room toRoom(Pos pos, Pos entrance) {
        return new Room(roomFactory(), pos, entrance);
    }
}
