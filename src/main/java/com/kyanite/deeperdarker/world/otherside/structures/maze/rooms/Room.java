package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePieces;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructureSettings;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.kyanite.deeperdarker.world.otherside.structures.maze.rooms.RoomOptions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;

public record Room(RoomOptions roomOptions, Pos pos, Pos entrance) {
    public MazeStructurePieces.MazeStructurePiece create(Structure.GenerationContext context, MazeStructureSettings settings, BlockPos origin) {
        return roomOptions().create(context, settings, origin, pos(), entrance());
    }
}
