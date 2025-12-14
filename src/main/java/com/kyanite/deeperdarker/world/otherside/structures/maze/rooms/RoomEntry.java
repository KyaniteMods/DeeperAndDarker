package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Tile;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Optional;

public record RoomEntry(RoomOptions<?> roomOptions, Optional<Pos> pos, boolean required) {
    public static final Codec<RoomEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RoomTypeRegistry.CODEC.fieldOf("options").forGetter(RoomEntry::roomOptions),
            Pos.CODEC.optionalFieldOf("position").forGetter(RoomEntry::pos),
            Codec.BOOL.optionalFieldOf("required", false).forGetter(RoomEntry::required)
    ).apply(instance, RoomEntry::new));

    public boolean isInBounds(int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        return pos.x() + roomOptions().getType().width() <= mazeWidth - 1 && pos.y() + roomOptions().getType().height() <= mazeHeight - 1 && pos.z() + roomOptions().getType().depth() <= mazeDepth - 1;
    }

    public boolean fits(Tile[][][] partialResult, int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        if (!isInBounds(mazeWidth, mazeHeight, mazeDepth, pos)) return false;

        for (int z = pos.z(); z < pos.z() + roomOptions().getType().depth(); z++) {
            for (int y = pos.y(); y < pos.y() + roomOptions().getType().height(); y++) {
                for (int x = pos.x(); x < pos.x() + roomOptions().getType().width(); x++) {
                    if (partialResult[x][y][z].getType() == Tile.Type.ROOM) return false;
                }
            }
        }

        return true;
    }

    public Room toRoom(Pos pos, Pos entrance) {
        return new Room(roomOptions(), pos, entrance);
    }
}
