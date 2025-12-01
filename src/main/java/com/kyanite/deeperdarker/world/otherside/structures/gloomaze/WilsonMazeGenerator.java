package com.kyanite.deeperdarker.world.otherside.structures.gloomaze;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WilsonMazeGenerator extends MazeGenerator {
    private int width;
    private int height;
    private int depth;
    private BoundingBox center;

    public WilsonMazeGenerator(int width, int height, int depth, BoundingBox center) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.center = center;
    }

    private static Tile[] deepCopy(Tile[] original) {
        Tile[] copy = new Tile[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    private static Tile[][] deepCopy(Tile[][] original) {
        Tile[][] copy = new Tile[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i]);
        }
        return copy;
    }

    private static Tile[][][] deepCopy(Tile[][][] original) {
        Tile[][][] copy = new Tile[original.length][][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = deepCopy(original[i]);
        }
        return copy;
    }

    private Tile[][][] randomWalk(RandomSource random, List<Pos> remainingPositions, Tile[][][] partialResult) {
        Pos start = remainingPositions.get(random.nextInt(remainingPositions.size()));

        MazeStack mazeStack = new MazeStack(deepCopy(partialResult));

        Pos currentPos = start;
        Direction lastDirection = null;

        mazeStack.push(currentPos);

        while (partialResult[currentPos.x()][currentPos.y()][currentPos.z()].type() != Tile.Type.PATH) {
            Direction[] ordered = Direction.allShuffled(random).toArray(new Direction[6]);
            Pos newPos = null;
            for (Direction direction : ordered) {
                if (lastDirection != null && direction.equals(lastDirection.getOpposite())) continue;
                newPos = new Pos(currentPos.x() + direction.getNormal().getX() * 2, currentPos.y() + direction.getNormal().getY() * 2, currentPos.z() + direction.getNormal().getZ() * 2);
                if (center.isInside(newPos.x(), newPos.y(), newPos.z())) continue;
                if (newPos.x() < 0 || newPos.y() < 0 || newPos.z() < 0) continue;
                if (newPos.x() >= width - 1 || newPos.y() >= height - 1 || newPos.z() >= depth - 1) continue;
                lastDirection = direction;
                break;
            }
            if (newPos == null) throw new IllegalStateException("Couldn't move!");

            int posIndex = mazeStack.indexOf(newPos);
            if (posIndex >= 0) {
                while (mazeStack.size() > posIndex + 1) {
                    mazeStack.pop();
                }
            } else {
                mazeStack.push(newPos);
            }
            currentPos = newPos;
        }

        remainingPositions.removeAll(mazeStack);
        return mazeStack.getTiles();
    }

    @Override
    public Tile[][][] generate(RandomSource random) {
        List<Pos> remainingPositions = new ArrayList<>();
        Tile[][][] result = new Tile[width][height][depth];

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    result[x][y][z] = new Tile(Tile.Type.WALL, 0);
                    if (x % 2 != 0 && y % 2 != 0 && z % 2 != 0 && !center.isInside(x, y, z)) remainingPositions.add(new Pos(x, y, z));
                }
            }
        }

        int index = random.nextInt(remainingPositions.size());
        Pos pos = remainingPositions.get(index);
        result[pos.x()][pos.y()][pos.z()] = new Tile(Tile.Type.PATH, 0);
        remainingPositions.remove(index);

        while (!remainingPositions.isEmpty()) {
            result = randomWalk(random, remainingPositions, result);
        }

        Pos end;
        if (center == null) {
            end = new Pos(width - 2, height - 2, depth - 1);
        } else {
            int x = (center.minX() + center.maxX()) / 2;
            end = new Pos(x + ((x - 1) % 2 == 0 ? 0 : -1), center.minY(), center.minZ() - 1);
        }

        result[end.x()][end.y()][end.z()] = new Tile(Tile.Type.ENDPOINT, 0);
        result[1][1][0] = new Tile(Tile.Type.ENDPOINT, 1);

        for (int ez = center.minZ(); ez < center.maxZ() + 1; ez++) {
            for (int ey = center.minY(); ey < center.maxY() + 1; ey++) {
                for (int ex = center.minX(); ex < center.maxX() + 1; ex++) {
                    result[ex][ey][ez] = new Tile(Tile.Type.ROOM, 0);
                }
            }
        }
        return result;
    }
}
