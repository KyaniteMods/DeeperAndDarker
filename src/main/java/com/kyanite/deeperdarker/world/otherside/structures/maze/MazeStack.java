package com.kyanite.deeperdarker.world.otherside.structures.maze;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MazeStack implements Collection<Pos> {
    private final Tile[][][] tiles;
    private final int width;
    private final int height;
    private final int depth;
    private final Stack<Pos> stack;

    public MazeStack(Tile[][][] tiles, int width, int height, int depth) {
        this.tiles = tiles;
        this.width = width;
        this.height = height;
        this.depth = depth;
        stack = new Stack<>();
    }

    public MazeStack(int width, int height, int depth) {
        this(from(width, height, depth), width, height, depth);
    }

    private static Tile[][][] from(int width, int height, int depth) {
        Tile[][][] tiles = new Tile[width][height][depth];

        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    tiles[x][y][z] = Tile.wall();
                }
            }
        }

        return tiles;
    }

    public Pos push(Pos pos, Tile tile) {
        if (!stack.isEmpty()) {
            Pos last = stack.peek();
            tiles[(last.x() + pos.x()) / 2][(last.y() + pos.y()) / 2][(last.z() + pos.z()) / 2] = tile.copy();
        }
        stack.push(pos);
        tiles[pos.x()][pos.y()][pos.z()] = tile;
        return pos;
    }

    public Pos push(Pos pos) {
        return push(pos, Tile.path());
    }

    public Pos push(int x, int y, int z, Tile tile) {
        return push(new Pos(x, y, z), tile);
    }

    public Pos push(int x, int y, int z) {
        return push(new Pos(x, y, z));
    }

    public Pos pop() {
        Pos pos = stack.pop();
        tiles[pos.x()][pos.y()][pos.z()] = Tile.wall();
        if (!stack.isEmpty()) {
            Pos last = stack.peek();
            tiles[(last.x() + pos.x()) / 2][(last.y() + pos.y()) / 2][(last.z() + pos.z()) / 2] = Tile.wall();
        }
        return pos;
    }

    public Pos back() {
        return stack.pop();
    }

    public Pos peek() {
        return stack.peek();
    }

    public Tile[][][] getTiles() {
        return tiles;
    }

    public Stack<Pos> getStack() {
        return stack;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return stack.contains(o);
    }

    @NotNull
    @Override
    public Iterator<Pos> iterator() {
        return stack.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return stack.toArray();
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return stack.toArray(a);
    }

    @Override
    public boolean add(Pos pos) {
        return stack.add(pos);
    }

    @Override
    public boolean remove(Object o) {
        return stack.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return stack.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Pos> c) {
        return stack.addAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return stack.removeAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return stack.retainAll(c);
    }

    @Override
    public void clear() {
        stack.clear();
    }

    public Pos get(int i) {
        return stack.get(i);
    }

    public int size() {
        return stack.size();
    }

    public Tile get(Pos pos) {
        return get(pos.x(), pos.y(), pos.z());
    }

    public Tile get(int x, int y, int z) {
        return tiles[x][y][z];
    }

    public int indexOf(int x, int y, int z) {
        return indexOf(new Pos(x, y, z));
    }

    public int indexOf(Pos pos) {
        return stack.indexOf(pos);
    }
}
