package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

public class OakTreeRoomType extends RoomType<OakTreeRoomOptions> {
    protected OakTreeRoomType(RoomFactory<OakTreeRoomOptions> roomFactory, int width, int height, int depth) {
        super(roomFactory, width, height, depth);
    }

    @Override
    public MapCodec<OakTreeRoomOptions> codec() {
        return OakTreeRoomOptions.CODEC;
    }
}
