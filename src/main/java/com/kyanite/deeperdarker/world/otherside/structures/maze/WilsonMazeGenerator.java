package com.kyanite.deeperdarker.world.otherside.structures.maze;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WilsonMazeGenerator extends MazeGenerator {
    private int width;
    private int height;
    private int depth;
    private BoundingBox center;
    private boolean cheap;

    public WilsonMazeGenerator(int width, int height, int depth, BoundingBox center, boolean cheap) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.center = center;
        this.cheap = cheap;
    }

    private static Tile[] deepCopy(Tile[] original) {
        Tile[] copy = new Tile[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].copy();
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

    private Tile[][][] randomWalk(RandomSource random, List<Pos> remainingPositions, Tile[][][] partialResult, boolean cheap) {
        Pos start = remainingPositions.get(random.nextInt(remainingPositions.size()));

        MazeStack mazeStack = new MazeStack(deepCopy(partialResult), width, height, depth);

        Pos currentPos = start;

        mazeStack.push(currentPos);

        int walkLength = cheap ? random.nextInt(50, 100) : -1;
        int iterations = 0;

        while ((cheap && iterations < walkLength) || (!cheap && partialResult[currentPos.x()][currentPos.y()][currentPos.z()].getType() != Tile.Type.PATH)) {
            Direction[] ordered = Direction.allShuffled(random).toArray(new Direction[6]);
            Pos newPos = null;
            for (Direction direction : ordered) {
                newPos = new Pos(currentPos.x() + direction.getNormal().getX() * 2, currentPos.y() + direction.getNormal().getY() * 2, currentPos.z() + direction.getNormal().getZ() * 2);
                if (mazeStack.size() >= 2 && mazeStack.get(mazeStack.size() - 2).equals(newPos)) continue;
                if (center != null && center.isInside(newPos.x(), newPos.y(), newPos.z())) continue;
                if (newPos.x() < 0 || newPos.y() < 0 || newPos.z() < 0) continue;
                if (newPos.x() >= width - 1 || newPos.y() >= height - 1 || newPos.z() >= depth - 1) continue;
                break;
            }

            int posIndex = mazeStack.indexOf(newPos);
            if (posIndex >= 0) {
                while (mazeStack.size() > posIndex + 1) {
                    mazeStack.pop();
                }
            } else {
                mazeStack.push(newPos);
            }
            currentPos = newPos;
            iterations++;
        }

        remainingPositions.removeAll(mazeStack);
        return mazeStack.getTiles();
    }

    @Override
    public MazeResult generate(RandomSource random) {
        List<Pos> remainingPositions = new ArrayList<>();
        Tile[][][] result = new Tile[width][height][depth];

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    result[x][y][z] = Tile.wall();
                    if (x % 2 != 0 && y % 2 != 0 && z % 2 != 0 && !center.isInside(x, y, z)) remainingPositions.add(new Pos(x, y, z));
                }
            }
        }

        boolean cheap = this.cheap;
        if (!cheap) {
            int index = random.nextInt(remainingPositions.size());
            Pos pos = remainingPositions.get(index);
            result[pos.x()][pos.y()][pos.z()] = Tile.path();
            remainingPositions.remove(index);
        }

        while (!remainingPositions.isEmpty()) {
            result = randomWalk(random, remainingPositions, result, cheap);
            cheap = false;
        }

        Pos start = new Pos(1, 1, 0);
        Pos end;
        if (center == null) {
            end = new Pos(width - 2, height - 2, depth - 1);
        } else {
            int x = (center.minX() + center.maxX()) / 2;
            end = new Pos(x + ((x - 1) % 2 == 0 ? 0 : -1), center.minY(), center.minZ() - 1);
            for (int ez = center.minZ(); ez < center.maxZ() + 1; ez++) {
                for (int ey = center.minY(); ey < center.maxY() + 1; ey++) {
                    for (int ex = center.minX(); ex < center.maxX() + 1; ex++) {
                        result[ex][ey][ez] = Tile.room();
                    }
                }
            }
        }

        result[end.x()][end.y()][end.z()] = Tile.start();
        result[start.x()][start.y()][start.z()] = Tile.end();

        return MazeResult.createAndNavigate(result, width, height, depth, start, end);
    }
}
