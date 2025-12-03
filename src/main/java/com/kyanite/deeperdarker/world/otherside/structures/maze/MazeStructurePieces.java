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
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class MazeStructurePieces {
    public static class MazeWallPiece extends MazeStructurePiece {
        public MazeWallPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth) {
            super(DDStructurePieceTypes.MAZE_WALL_PIECE, pos, mazePos, mazeWidth, mazeHeight, mazeDepth);
        }

        public MazeWallPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_WALL_PIECE, tag);
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        BlockState state;
                        int worldMazeX = mazePos.x() * SIDE_LENGTH + x;
                        int worldMazeY = mazePos.y() * SIDE_LENGTH + y;
                        int worldMazeZ = mazePos.z() * SIDE_LENGTH + z;
                        if ((x % 2 == 0 && y % 2 == 0 && z % 2 == 0) || worldMazeX == 0 || worldMazeY == 0 || worldMazeZ == 0 || worldMazeX == (mazeWidth * SIDE_LENGTH) - 1 || worldMazeY == (mazeHeight * SIDE_LENGTH) - 1 || worldMazeZ == (mazeDepth * SIDE_LENGTH) - 1)
                            state = DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState();
                        else if ((x == 0 || x == SIDE_LENGTH - 1)
                                && (y == 0 || y == SIDE_LENGTH - 1)
                                && (z == 0 || z == SIDE_LENGTH - 1))
                            state = DDBlocks.PROTECTED_SCULK_GRIME_GLASS.defaultBlockState();
                        else if (x > 0 && y > 0 && z > 0 && x < SIDE_LENGTH - 1 && y < SIDE_LENGTH - 1 && z < SIDE_LENGTH - 1)
                            state = DDBlocks.SCULK_GLEAM.defaultBlockState();
                        else
                            state = DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState();
                        placeBlock(worldGenLevel, state, x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static abstract class MazeStructurePiece extends StructurePiece {
        protected Pos mazePos;
        protected int mazeWidth, mazeHeight, mazeDepth;
        public static final int SIDE_LENGTH = 3;

        public MazeStructurePiece(StructurePieceType type, BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth) {
            super(type, 0, makeBoundingBox(pos.getX(), pos.getY(), pos.getZ(), Direction.SOUTH, 3, 3, 3));
            setOrientation(Direction.SOUTH);
            this.mazePos = mazePos;
            this.mazeWidth = mazeWidth;
            this.mazeHeight = mazeHeight;
            this.mazeDepth = mazeDepth;
        }

        public MazeStructurePiece(StructurePieceType type, CompoundTag tag) {
            super(type, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
        }
    }
}
