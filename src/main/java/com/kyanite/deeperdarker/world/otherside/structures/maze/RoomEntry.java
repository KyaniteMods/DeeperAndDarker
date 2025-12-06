package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.resources.ResourceLocation;

public record RoomEntry(ResourceLocation id, int width, int height, int depth, boolean required) {
    public boolean fits(Tile[][][] partialResult, int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        if (pos.x() + width() > mazeWidth - 2 || pos.y() + height() > mazeHeight - 2 || pos.z() + depth() > mazeDepth - 2) return false;

        for (int z = pos.z(); z < pos.z() + depth(); z++) {
            for (int y = pos.y(); y < pos.y() + height(); y++) {
                for (int x = pos.x(); x < pos.x() + width(); x++) {
                    if (partialResult[x][y][z].getType() == Tile.Type.ROOM) return false;
                }
            }
        }

        return true;
    }
}
