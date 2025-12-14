package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.mojang.serialization.Codec;

public class SimpleRoomType extends RoomType<SimpleRoomType> implements RoomOptions {
    private final Codec<SimpleRoomType> CODEC = Codec.unit(this::getType);

    public SimpleRoomType(RoomFactory roomFactory, int width, int height, int depth) {
        super(roomFactory, width, height, depth);
    }

    @Override
    public SimpleRoomType getType() {
        return this;
    }

    @Override
    public Codec<SimpleRoomType> codec() {
        return CODEC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimpleRoomType that = (SimpleRoomType) o;

        return CODEC.equals(that.CODEC);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + CODEC.hashCode();
        return result;
    }
}
