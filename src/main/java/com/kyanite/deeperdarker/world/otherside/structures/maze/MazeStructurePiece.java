package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;

public class MazeStructurePiece extends StructurePiece {
    private Pos mazePos;
    private int mazeWidth, mazeHeight, mazeDepth;

    public MazeStructurePiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth) {
        super(DDStructurePieceTypes.MAZE_PIECE, 0, makeBoundingBox(pos.getX(), pos.getY(), pos.getZ(), Direction.SOUTH, 3, 3, 3));
        setOrientation(Direction.SOUTH);
        this.mazePos = mazePos;
        this.mazeWidth = mazeWidth;
        this.mazeHeight = mazeHeight;
        this.mazeDepth = mazeDepth;
    }

    public MazeStructurePiece(CompoundTag tag) {
        super(DDStructurePieceTypes.MAZE_PIECE, tag);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
    }

    @Override
    public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
            for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                    BlockState state;
                    int worldMazeX = mazePos.x() * 3 + x;
                    int worldMazeY = mazePos.y() * 3 + y;
                    int worldMazeZ = mazePos.z() * 3 + z;
                    if ((x % 2 == 0 && y % 2 == 0 && z % 2 == 0) || worldMazeX == 0 || worldMazeY == 0 || worldMazeZ == 0 || worldMazeX == (mazeWidth * 3) - 1 || worldMazeY == (mazeHeight * 3) - 1 || worldMazeZ == (mazeDepth * 3) - 1)
                        state = DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState();
                    else if (x == 1 && y == 1 && z == 1)
                        state = DDBlocks.SCULK_GLEAM.defaultBlockState();
                    else if ((x + y + z) % 2 == 1)
                        state = DDBlocks.PROTECTED_SCULK_GRIME_GLASS.defaultBlockState();
                    else
                        state = DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState();
                    placeBlock(worldGenLevel, state, x, y, z, boundingBox);
                }
            }
        }
    }
}
