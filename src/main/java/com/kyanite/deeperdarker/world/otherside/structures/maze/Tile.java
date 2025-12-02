package com.kyanite.deeperdarker.world.otherside.structures.maze;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public record Tile(@NotNull Type type, int data) {
    public static final Tile START = new Tile(Type.ENDPOINT, 0);
    public static final Tile END = new Tile(Type.ENDPOINT, 1);
    public static final Tile WALL = new Tile(Type.WALL, 0);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (data != tile.data) return false;
        return type == tile.type;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + data;
        return result;
    }

    @Override
    public String toString() {
        return type().name().toLowerCase(Locale.ROOT) + ":" + data();
    }

    public enum Type {
        PATH,
        ROOM,
        WALL,
        ENDPOINT,
        DEBUG
    }
}
