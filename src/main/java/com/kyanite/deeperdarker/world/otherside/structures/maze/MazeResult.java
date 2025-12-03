package com.kyanite.deeperdarker.world.otherside.structures.maze;

public record MazeResult(Tile[][][] result, Pos start, Pos end) {
    public Tile get(int x, int y, int z) {
        return result()[x][y][z];
    }
}
