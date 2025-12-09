package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.blocks.ReturnStatueBlockEntity;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
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
import org.jetbrains.annotations.Nullable;

public class MazeStructurePieces {
    public static class MazeChestPathPiece extends MazeStructurePiece {
        private ResourceLocation lootTable;
        private Direction orientation;

        public MazeChestPathPiece(BlockPos pos, Pos mazePos, Direction orientation, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette, ResourceLocation lootTable) {
            super(DDStructurePieceTypes.MAZE_CHEST_PATH_PIECE, pos, orientation, mazePos, mazeWidth, mazeHeight, mazeDepth, tileSize, palette);
            this.orientation = orientation;
            this.lootTable = lootTable;
        }

        public MazeChestPathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_CHEST_PATH_PIECE, tag);
            orientation = Direction.from2DDataValue(tag.getInt("orientation"));
            lootTable = ResourceLocation.tryParse(tag.getString("loot_table"));
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
            compoundTag.putInt("orientation", orientation.get2DDataValue());
            compoundTag.putString("loot_table", lootTable.toString());
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        if (x == tileSize / 2 && y == 0 && z == tileSize - 1) {
                            createChest(worldGenLevel, boundingBox, randomSource, getWorldPos(x, y, z), lootTable, Blocks.CHEST.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, orientation.getOpposite()));
                        } else {
                            placeBlock(worldGenLevel, Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                        }
                    }
                }
            }
        }
    }

    public static class MazeStatuePathPiece extends MazeStructurePiece {
        private @Nullable BlockPos mazeStart;

        public MazeStatuePathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette, @Nullable BlockPos mazeStart) {
            super(DDStructurePieceTypes.MAZE_STATUE_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, tileSize, palette);
            this.mazeStart = mazeStart;
        }

        public MazeStatuePathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_STATUE_PATH_PIECE, tag);
            mazeStart = BlockPos.CODEC.parse(NbtOps.INSTANCE, tag.get("maze_start")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(null);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
            if (mazeStart != null) {
                compoundTag.put("maze_start", BlockPos.CODEC.encodeStart(NbtOps.INSTANCE, mazeStart).resultOrPartial(DeeperDarker.LOGGER::error).orElseThrow());
            }
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            BlockState statueState = DDBlocks.RETURN_STATUE.defaultBlockState();
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        if (x == tileSize / 2 && y == 0 && z == tileSize / 2) {
                            placeBlock(worldGenLevel, statueState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), x, y, z, boundingBox);
                            BlockEntity blockEntity = worldGenLevel.getBlockEntity(getWorldPos(x, y, z));
                            if (blockEntity instanceof ReturnStatueBlockEntity returnStatue && mazeStart != null) {
                                returnStatue.teleportPos = mazeStart;
                            }
                        } else if (x == tileSize / 2 && y == 1 && z == tileSize / 2) {
                            placeBlock(worldGenLevel, statueState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), x, y, z, boundingBox);
                        } else placeBlock(worldGenLevel, Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazeFluidPathPiece extends MazeStructurePiece {
        private BlockState fluid;
        private @Nullable ResourceLocation lootTable;

        public MazeFluidPathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette, @Nullable ResourceLocation lootTable, RandomSource random) {
            super(DDStructurePieceTypes.MAZE_FLUID_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, tileSize, palette);
            fluid = palette.fluid().getRandomValue(random).orElseThrow();
            this.lootTable = lootTable;
        }

        public MazeFluidPathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_FLUID_PATH_PIECE, tag);
            fluid = BlockState.CODEC.parse(NbtOps.INSTANCE, tag.get("fluid")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(Blocks.AIR.defaultBlockState());
            if (tag.contains("loot_table", Tag.TAG_STRING)) {
                lootTable = ResourceLocation.tryParse(tag.getString("loot_table"));
            }
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
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
                        if (!fluid.is(DDTags.Blocks.MAZE_CANNOT_HIDE_CHEST) && x == tileSize / 2 && y == 0 && z == tileSize / 2 && lootTable != null) {
                            createChest(worldGenLevel, boundingBox, randomSource, x, y, z, lootTable);
                            continue;
                        }
                        placeBlock(worldGenLevel, y <= Math.max(1, tileSize - 2) ? fluid : Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazePathPiece extends MazeStructurePiece {
        private BlockState state;

        public MazePathPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette, RandomSource random) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, tileSize, palette);
            state = palette.path().getRandomValue(random).orElseThrow();
        }

        public MazePathPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_PATH_PIECE, tag);
            state = BlockState.CODEC.parse(NbtOps.INSTANCE, tag.get("block_state")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(Blocks.AIR.defaultBlockState());
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
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
        public MazeBossRoomPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette) {
            super(DDStructurePieceTypes.MAZE_BOSS_ROOM_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, 7, 1, 7, tileSize, palette);
        }

        public MazeBossRoomPiece(CompoundTag tag) {
            super(DDStructurePieceTypes.MAZE_BOSS_ROOM_PIECE, tag);
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
        }

        @Override
        public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            for (int z = 0; z < getBoundingBox().getZSpan(); z++) {
                for (int y = 0; y < getBoundingBox().getYSpan(); y++) {
                    for (int x = 0; x < getBoundingBox().getXSpan(); x++) {
                        placeBlock(worldGenLevel, y == 0 ? Blocks.MAGENTA_CARPET.defaultBlockState() : Blocks.AIR.defaultBlockState(), x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static class MazeWallPiece extends MazeStructurePiece {
        public MazeWallPiece(BlockPos pos, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette) {
            super(DDStructurePieceTypes.MAZE_WALL_PIECE, pos, Direction.SOUTH, mazePos, mazeWidth, mazeHeight, mazeDepth, tileSize, palette);
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
                        int worldMazeX = mazePos.x() * tileSize + x;
                        int worldMazeY = mazePos.y() * tileSize + y;
                        int worldMazeZ = mazePos.z() * tileSize + z;
                        boolean isStructureCover = worldMazeX == 0 || worldMazeY == 0 || worldMazeZ == 0 || worldMazeX == (mazeWidth * tileSize) - 1 || worldMazeY == (mazeHeight * tileSize) - 1 || worldMazeZ == (mazeDepth * tileSize) - 1;
                        boolean isPieceCorner = (x == 0 || x == tileSize - 1)
                                && (y == 0 || y == tileSize - 1)
                                && (z == 0 || z == tileSize - 1);
                        boolean isPieceCenter = x > 0 && y > 0 && z > 0 && x < tileSize - 1 && y < tileSize - 1 && z < tileSize - 1;
                        boolean isPieceFace = (z == 0 || z == tileSize - 1) && x > 0 && x < tileSize - 1 && y > 0 && y < tileSize - 1
                                || (y == 0 || y == tileSize - 1) && x > 0 && x < tileSize - 1 && z > 0 && z < tileSize - 1
                                || (x == 0 || x == tileSize - 1) && y > 0 && y < tileSize - 1 && z > 0 && z < tileSize - 1;
//                        boolean isPieceEdge = !isPieceCorner && !isPieceCenter && !isPieceFace;

                        if (isStructureCover) state = palette.structureCover().getRandomValue(randomSource).orElseThrow();
                        else if (isPieceCorner) state = palette.wallCorner().getRandomValue(randomSource).orElseThrow();
                        else if (isPieceCenter) state = palette.wallCenter().getRandomValue(randomSource).orElseThrow();
                        else if (isPieceFace) state = palette.wallFace().getRandomValue(randomSource).orElseThrow();
                        else state = palette.wallEdge().getRandomValue(randomSource).orElseThrow();

                        placeBlock(worldGenLevel, state, x, y, z, boundingBox);
                    }
                }
            }
        }
    }

    public static abstract class MazeStructurePiece extends StructurePiece {
        protected Pos mazePos;
        protected int mazeWidth, mazeHeight, mazeDepth;
        protected int tileSize;
        protected MazeStructurePalette palette;

        public MazeStructurePiece(StructurePieceType type, BlockPos pos, Direction direction, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int width, int height, int depth, int tileSize, MazeStructurePalette palette) {
            super(type, 0, makeBoundingBox(pos.getX(), pos.getY(), pos.getZ(), direction, width * tileSize, height * tileSize, depth * tileSize));
            setOrientation(direction);
            this.mazePos = mazePos;
            this.mazeWidth = mazeWidth;
            this.mazeHeight = mazeHeight;
            this.mazeDepth = mazeDepth;
            this.tileSize = tileSize;
            this.palette = palette;
        }

        public MazeStructurePiece(StructurePieceType type, BlockPos pos, Direction direction, Pos mazePos, int mazeWidth, int mazeHeight, int mazeDepth, int tileSize, MazeStructurePalette palette) {
            this(type, pos, direction, mazePos, mazeWidth, mazeHeight, mazeDepth, 1, 1, 1, tileSize, palette);
        }

        public MazeStructurePiece(StructurePieceType type, CompoundTag tag) {
            super(type, tag);
            mazePos = Pos.CODEC.parse(NbtOps.INSTANCE, tag.get("maze_pos")).resultOrPartial(DeeperDarker.LOGGER::error).orElse(new Pos(0, 0, 0));
            mazeWidth = tag.getInt("maze_width");
            mazeHeight = tag.getInt("maze_height");
            mazeDepth = tag.getInt("maze_depth");
            tileSize = tag.getInt("tile_size");
            palette = MazeStructurePalette.CODEC.parse(NbtOps.INSTANCE, tag.get("palette")).resultOrPartial(DeeperDarker.LOGGER::error).orElseThrow();
        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            compoundTag.put("maze_pos", Pos.CODEC.encodeStart(NbtOps.INSTANCE, mazePos).result().orElseThrow());
            compoundTag.putInt("maze_width", mazeWidth);
            compoundTag.putInt("maze_height", mazeHeight);
            compoundTag.putInt("maze_depth", mazeDepth);
            compoundTag.putInt("tile_size", tileSize);
            compoundTag.put("palette", MazeStructurePalette.CODEC.encodeStart(NbtOps.INSTANCE, palette).result().orElseThrow());
        }
    }
}
