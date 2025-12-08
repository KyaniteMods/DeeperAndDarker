package com.kyanite.deeperdarker.world.otherside.structures.maze;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public final class Tile {
    private final @NotNull Type type;
    private int data;

    public Tile(@NotNull Type type, int data) {
        this.type = type;
        this.data = data;
    }

    public static Tile start() {
        return new Tile(Type.ENDPOINT, 0);
    }

    public static Tile end() {
        return new Tile(Type.ENDPOINT, 1);
    }

    public static Tile entrance(int i) {
        return new Tile(Type.ROOM_ENTRANCE, i);
    }

    public static Tile wall() {
        return new Tile(Type.WALL, 0);
    }

    public static Tile room(int order) {
        return new Tile(Type.ROOM, order);
    }

    public static Tile path() {
        return new Tile(Type.PATH, -1);
    }

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
        return getType().name().toLowerCase(Locale.ROOT) + ":" + getData();
    }

    public @NotNull Type getType() {
        return type;
    }

    public int getData() {
        return data;
    }

    public void setData(int value) {
        data = value;
    }

    public Tile copy() {
        return new Tile(type, data);
    }

    public enum Type {
        PATH(false),
        ROOM(false),
        ROOM_ENTRANCE(false),
        WALL(true),
        ENDPOINT(false),
        DEBUG(true);

        private final boolean isSolid;

        Type(boolean isSolid) {
            this.isSolid = isSolid;
        }

        public boolean isSolid() {
            return isSolid;
        }
    }
}
