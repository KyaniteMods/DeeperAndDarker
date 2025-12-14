package com.kyanite.deeperdarker.world.otherside.structures.maze.rooms;

import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructurePieces;
import com.kyanite.deeperdarker.world.otherside.structures.maze.MazeStructureSettings;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface RoomOptions {
    RoomType<?> getType();

    default MazeStructurePieces.MazeStructurePiece create(Structure.GenerationContext context, MazeStructureSettings settings, BlockPos origin, Pos pos, Pos entrance) {
        return getType().roomFactory().create(this, context, settings, origin, pos, entrance);
    }
}
