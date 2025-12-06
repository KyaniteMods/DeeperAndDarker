package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Direction;

import java.util.ArrayDeque;
import java.util.Queue;

public record MazeResult(Tile[][][] result, int width, int height, int depth, Pos start, Pos end) {
    public Tile get(int x, int y, int z) {
        return result()[x][y][z];
    }

    public static MazeResult createAndNavigate(Tile[][][] result, int width, int height, int depth, Pos start, Pos end) {
        MazeResult mazeResult = new MazeResult(result, width, height, depth, start, end);
        mazeResult.updatePathDistances();
        return mazeResult;
    }

    public void updatePathDistances() {
        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Tile tile = get(x, y, z);
                    if (!tile.getType().isSolid()) tile.setData(-1);
                }
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        get(start.x(), start.y(), start.z()).setData(0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Pos pos = queue.remove();
            int distance = get(pos.x(), pos.y(), pos.z()).getData();
            for (Direction direction : Direction.values()) {
                Pos neighbor = pos.add(direction.getNormal());
                if (neighbor.x() < 0 || neighbor.y() < 0 || neighbor.z() < 0 || neighbor.x() >= width || neighbor.y() >= height || neighbor.z() >= depth) continue;
                Tile neighborTile = get(neighbor.x(), neighbor.y(), neighbor.z());
                if (!neighborTile.getType().isSolid() && neighborTile.getData() == -1) {
                    neighborTile.setData(distance + 1);
                    queue.add(neighbor);
                }
            }
        }
    }
}
