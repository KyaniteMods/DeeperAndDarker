package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;
import java.util.stream.IntStream;

public record RoomEntry(ResourceLocation id, Optional<Pos> pos, int width, int height, int depth, boolean required) {
    public static final Codec<RoomEntry> CODEC = RecordCodecBuilder.create(instance -> instance.group(ResourceLocation.CODEC.fieldOf("id").forGetter(RoomEntry::id), Pos.CODEC.optionalFieldOf("pos").forGetter(RoomEntry::pos), Codec.INT_STREAM.comapFlatMap(stream -> Util.fixedSize(stream, 3).map(ints -> new int[]{ints[0], ints[1], ints[2]}), IntStream::of).fieldOf("size").forGetter(entry -> new int[]{entry.width(), entry.height(), entry.depth()}), Codec.BOOL.fieldOf("required").forGetter(RoomEntry::required)).apply(instance, (id, pos, size, required) -> new RoomEntry(id, pos, size[0], size[1], size[2], required)));

    public boolean fits(Tile[][][] partialResult, int mazeWidth, int mazeHeight, int mazeDepth, Pos pos) {
        if (pos.x() + width() > mazeWidth - 1 || pos.y() + height() > mazeHeight - 1 || pos.z() + depth() > mazeDepth - 1) return false;

        for (int z = pos.z(); z < pos.z() + depth(); z++) {
            for (int y = pos.y(); y < pos.y() + height(); y++) {
                for (int x = pos.x(); x < pos.x() + width(); x++) {
                    if (partialResult[x][y][z].getType() == Tile.Type.ROOM) return false;
                }
            }
        }

        return true;
    }

    public Room toRoom(Pos pos, Pos entrance) {
        return new Room(id(), pos, entrance);
    }
}
