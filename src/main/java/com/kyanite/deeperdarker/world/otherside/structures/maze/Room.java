package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;

public record Room(RoomType roomType, Pos pos, Pos entrance) {
    public MazeStructurePieces.MazeStructurePiece create(Structure.GenerationContext context, MazeStructureSettings settings, BlockPos origin) {
        return roomType().roomFactory().create(context, settings, origin, pos(), entrance());
    }
}
