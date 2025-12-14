package com.kyanite.deeperdarker.world.otherside.structures.maze.generation;

import com.mojang.datafixers.util.Pair;

import java.util.*;

public class MazeState {
    private Tile[][][] tiles;
    private final List<Pos> remainingPositions;
    private final int width;
    private final int height;
    private final int depth;
    private final Stack<Pos> currentWalk;
    private Tile[][][] currentWalkTiles;

    public MazeState(Pair<Tile[][][], List<Pos>> tiles, int width, int height, int depth) {
        this.tiles = tiles.getFirst();
        remainingPositions = tiles.getSecond();
        this.width = width;
        this.height = height;
        this.depth = depth;
        currentWalk = new Stack<>();
        currentWalkTiles = deepCopy(this.tiles);
    }

    public MazeState(int width, int height, int depth) {
        this(from(width, height, depth), width, height, depth);
    }

    private static Pair<Tile[][][], List<Pos>> from(int width, int height, int depth) {
        Tile[][][] tiles = new Tile[width][height][depth];
        List<Pos> remainingPositions = new ArrayList<>();

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    tiles[x][y][z] = Tile.wall();
                    if (x % 2 != 0 && y % 2 != 0 && z % 2 != 0) remainingPositions.add(new Pos(x, y, z));
                }
            }
        }

        return Pair.of(tiles, remainingPositions);
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

    public Pos walk(Pos pos, Tile tile) {
        if (!currentWalk.isEmpty()) {
            Pos last = currentWalk.peek();
            currentWalkTiles[(last.x() + pos.x()) / 2][(last.y() + pos.y()) / 2][(last.z() + pos.z()) / 2] = tile.copy();
        }
        currentWalk.push(pos);
        currentWalkTiles[pos.x()][pos.y()][pos.z()] = tile;
        return pos;
    }

    public Pos walk(Pos pos) {
        return walk(pos, Tile.path());
    }

    public Pos walk(int x, int y, int z) {
        return walk(new Pos(x, y, z));
    }

    public void walkBack() {
        currentWalk.pop();
    }

    public void revertWalk() {
        Pos pos = currentWalk.pop();
        currentWalkTiles[pos.x()][pos.y()][pos.z()] = tiles[pos.x()][pos.y()][pos.z()].copy();
        if (!currentWalk.isEmpty()) {
            Pos last = currentWalk.peek();
            currentWalkTiles[(last.x() + pos.x()) / 2][(last.y() + pos.y()) / 2][(last.z() + pos.z()) / 2] = tiles[(last.x() + pos.x()) / 2][(last.y() + pos.y()) / 2][(last.z() + pos.z()) / 2].copy();
        }
    }

    public void merge() {
        tiles = deepCopy(currentWalkTiles);
        remainingPositions.removeAll(currentWalk);
        currentWalk.clear();
    }

    public Pos set(Pos pos, Tile tile) {
        currentWalkTiles[pos.x()][pos.y()][pos.z()] = tile.copy();
        tiles[pos.x()][pos.y()][pos.z()] = tile;
        remainingPositions.remove(pos);
        return pos;
    }

    public Pos set(Pos pos) {
        return set(pos, Tile.path());
    }

    public Pos set(int x, int y, int z, Tile tile) {
        return set(new Pos(x, y, z), tile);
    }

    public Pos set(int x, int y, int z) {
        return set(new Pos(x, y, z));
    }


    public Tile[][][] getTiles() {
        return tiles;
    }

    public Tile get(Pos pos) {
        return get(pos.x(), pos.y(), pos.z());
    }

    public Tile get(int x, int y, int z) {
        return tiles[x][y][z];
    }

    public Stack<Pos> getCurrentWalk() {
        return currentWalk;
    }

    public Tile[][][] getCurrentWalkTiles() {
        return currentWalkTiles;
    }

    public List<Pos> getRemainingPositions() {
        return remainingPositions;
    }
}
