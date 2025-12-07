package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.blocks.ReturnStatueBlockEntity;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MazeStructurePieces {
    public static class MazeChestPathPiece extends MazeStructurePiece {
        private ResourceLocation lootTable;
        private Direction direction;

        public MazeChestPathPiece(BlockPos pos, Pos mazePos, Direction direction, int mazeWidth, int mazeHeight, int mazeDepth, ResourceLocation lootTable) {
            super(DDStructurePieceTypes.MAZE_CHEST_PATH_PIECE, pos, direction, mazePos, mazeWidth, mazeHeight, mazeDepth);
            this.direction = direction;
            this.lootTable = lootTable;
        }

        public MazeChestPathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_CHEST_PATH_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.putString("loot_table", lootTable.toString());
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        if (x == 1 && y == 0 && z == 2) {
                            createChest(worldGenLevel, boundingBox, randomSource, getWorldPos(x, y, z), lootTable, Blocks.CHEST.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction.getOpposite()));
                        } else {
                            placeBlock(worldGenLevel, Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                        }
                    }
                }
            }
        }
    }

    public static class MazeStatuePathPiece extends MazeStructurePiece {
        private BlockPos mazeStart;

        public MazeStatuePathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, BlockPos mazeStart) {
            super(DDStructurePieceTypes.MAZE_STATUE_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth);
            this.mazeStart = mazeStart;
        }

        public MazeStatuePathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_STATUE_PATH_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.put("maze_start", BlockPos.CODEC.encodeStart(NbtOps.INSTANCE, mazeStart).result().orElseThrow());
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            BlockState statueState = DDBlocks.RETURN_STATUE.defaultBlockState();
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        if (x == 1 && y == 0 && z == 1) {
                            placeBlock(worldGenLevel, statueState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), x, y, z, boundingBox);
                            BlockEntity blockEntity = worldGenLevel.getBlockEntity(getWorldPos(x, y, z));
                            if (blockEntity instanceof ReturnStatueBlockEntity returnStatue) {
                                returnStatue.teleportPos = mazeStart;
                            }
                        } else if (x == 1 && y == 1 && z == 1) {
                            placeBlock(worldGenLevel, statueState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), x, y, z, boundingBox);
                        } else placeBlock(worldGenLevel, Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazeFluidPathPiece extends MazeStructurePiece {
        private @Nullable ResourceLocation lootTable;
        private BlockState fluid;

        public MazeFluidPathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, @NotNull BlockState fluid, @Nullable ResourceLocation lootTable) {
            super(DDStructurePieceTypes.MAZE_FLUID_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth);
            this.lootTable = lootTable;
            this.fluid = fluid;
        }

        public MazeFluidPathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_FLUID_PATH_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.put("fluid", BlockState.CODEC.encodeStart(NbtOps.INSTANCE, fluid).result().orElseThrow());
            if (lootTable != null) {
                compoundTag.putString("loot_table", lootTable.toString());
            }
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        if (x == 1 && y == 0 && z == 1 && lootTable != null) {
                            createChest(worldGenLevel, boundingBox, randomSource, x, y, z, lootTable);
                            continue;
                        }
                        placeBlock(worldGenLevel, y <= 1 ? fluid : Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazePathPiece extends MazeStructurePiece {
        private BlockState state;

        public MazePathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, BlockState state) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth);
            this.state = state;
        }

        public MazePathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.put("block_state", BlockState.CODEC.encodeStart(NbtOps.INSTANCE, state).result().orElseThrow());
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        placeBlock(worldGenLevel, state, x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazeBossRoomPiece extends MazeStructurePiece {
        private BlockState state;

        public MazeBossRoomPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, BlockState state) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, 7, 1, 7);
            this.state = state;
        }

        public MazeBossRoomPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.put("block_state", BlockState.CODEC.encodeStart(NbtOps.INSTANCE, state).result().orElseThrow());
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        placeBlock(worldGenLevel, state, x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazeWallPiece extends MazeStructurePiece {
        public MazeWallPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth) {
            super(DDStructurePieceTypes.MAZE_WALL_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth);
        }

        public MazeWallPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_WALL_PIECE, tag);
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
                        int worldMazeX = mazePos.x() * SIDE_LENGTH + x;
                        int worldMazeY = mazePos.y() * SIDE_LENGTH + y;
                        int worldMazeZ = mazePos.z() * SIDE_LENGTH + z;
                        boolean isOuter = worldMazeX == 0 || worldMazeY == 0 || worldMazeZ == 0 || worldMazeX == (mazeWidth * SIDE_LENGTH) - 1 || worldMazeY == (mazeHeight * SIDE_LENGTH) - 1 || worldMazeZ == (mazeDepth * SIDE_LENGTH) - 1;
                        boolean isPieceCorner = (x == 0 || x == SIDE_LENGTH - 1)
                                && (y == 0 || y == SIDE_LENGTH - 1)
                                && (z == 0 || z == SIDE_LENGTH - 1);
                        boolean isPieceCore = x > 0 && y > 0 && z > 0 && x < SIDE_LENGTH - 1 && y < SIDE_LENGTH - 1 && z < SIDE_LENGTH - 1;
                        boolean isPieceFace = (z == 0 || z == SIDE_LENGTH - 1) && x > 0 && x < SIDE_LENGTH - 1 && y > 0 && y < SIDE_LENGTH - 1
                                || (y == 0 || y == SIDE_LENGTH - 1) && x > 0 && x < SIDE_LENGTH - 1 && z > 0 && z < SIDE_LENGTH - 1
                                || (x == 0 || x == SIDE_LENGTH - 1) && y > 0 && y < SIDE_LENGTH - 1 && z > 0 && z < SIDE_LENGTH - 1;
                        boolean isPieceEdge = !isPieceCorner && !isPieceCore && !isPieceFace;

                        if (isOuter || isPieceCorner || randomSource.nextFloat() < 0.03f) state = DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState();
                        else if (isPieceEdge) state = DDBlocks.PROTECTED_SCULK_GRIME_GLASS.defaultBlockState();
                        else state = DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState();

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

        public MazeStructurePiece(StructurePieceType type, BlockPos pos, Direction direction, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int width, int height, int depth) {
            super(type, 0, makeBoundingBox(pos.getX(), pos.getY(), pos.getZ(), direction, width * SIDE_LENGTH, height * SIDE_LENGTH, depth * SIDE_LENGTH));
            setOrientation(direction);
            this.mazePos = mazePos;
            this.mazeWidth = mazeWidth;
            this.mazeHeight = mazeHeight;
            this.mazeDepth = mazeDepth;
        }

        public MazeStructurePiece(StructurePieceType type, BlockPos pos, Direction direction, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth) {
            this(type, pos, direction, mazePos, mazeWidth, mazeHeight, mazeDepth, 1, 1, 1);
        }

        public MazeStructurePiece(StructurePieceType type, CompoundTag tag) {
            super(type, tag);
        }
    }
}
