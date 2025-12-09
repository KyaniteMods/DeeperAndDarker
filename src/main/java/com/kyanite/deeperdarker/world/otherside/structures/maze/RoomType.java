package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;

public record RoomType(RoomFactory roomFactory, int width, int height, int depth) {
    public interface RoomFactory {
        MazeStructurePieces.MazeStructurePiece create(Structure.GenerationContext context, MazeStructureSettings settings, BlockPos origin, Pos pos, Pos entrance);
    }
}
