package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePieces;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructureSettings;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.Objects;

public abstract class RoomType<T extends RoomOptions> {
    private final RoomFactory<T> roomFactory;
    private final int width;
    private final int height;
    private final int depth;

    protected RoomType(RoomFactory<T> roomFactory, int width, int height, int depth) {
        this.roomFactory = roomFactory;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public RoomFactory<T> roomFactory() {
        return roomFactory;
    }

    public abstract Codec<T> codec();

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int depth() {
        return depth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RoomType<?>) obj;
        return Objects.equals(this.roomFactory, that.roomFactory) &&
                this.width == that.width &&
                this.height == that.height &&
                this.depth == that.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomFactory, width, height, depth);
    }

    @Override
    public String toString() {
        return "RoomType[" +
                "roomFactory=" + roomFactory + ", " +
                "width=" + width + ", " +
                "height=" + height + ", " +
                "depth=" + depth + ']';
    }

    public interface RoomFactory<T extends RoomOptions> {
        MazeStructurePieces.MazeStructurePiece create(T options, Structure.GenerationContext context, MazeStructureSettings settings, BlockPos origin, Pos pos, Pos entrance);
    }
}
