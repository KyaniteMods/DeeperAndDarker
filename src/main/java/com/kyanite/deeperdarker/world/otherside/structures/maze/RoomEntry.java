package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Optional;

public record RoomEntry(RoomType roomType, Optional<Pos> pos, boolean required) {
    public static final Codec<RoomEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RoomTypeRegistry.REGISTRY.byNameCodec().fieldOf("room_type").forGetter(RoomEntry::roomType),
            Pos.CODEC.optionalFieldOf("position").forGetter(RoomEntry::pos),
            Codec.BOOL.optionalFieldOf("required", false).forGetter(RoomEntry::required)
    ).apply(instance, RoomEntry::new));

    public boolean isInBounds(int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        return pos.x() + roomType().width() <= mazeWidth - 1 && pos.y() + roomType().height() <= mazeHeight - 1 && pos.z() + roomType().depth() <= mazeDepth - 1;
    }

    public boolean fits(Tile[][][] partialResult, int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        if (!isInBounds(mazeWidth, mazeHeight, mazeDepth, pos)) return false;

        for (int z = pos.z(); z < pos.z() + roomType().depth(); z++) {
            for (int y = pos.y(); y < pos.y() + roomType().height(); y++) {
                for (int x = pos.x(); x < pos.x() + roomType().width(); x++) {
                    if (partialResult[x][y][z].getType() == Tile.Type.ROOM) return false;
                }
            }
        }

        return true;
    }

    public Room toRoom(Pos pos, Pos entrance) {
        return new Room(roomType(), pos, entrance);
    }
}
