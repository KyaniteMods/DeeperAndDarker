package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructurePieceTypes;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructureTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class MazeStructure extends Structure {
    public static final Codec<MazeStructure> CODEC = ExtraCodecs.validate(RecordCodecBuilder.mapCodec(instance -> instance.group(
            settingsCodec(instance),
            Codec.INT.fieldOf("width").forGetter(MazeStructure::getWidth),
            Codec.INT.fieldOf("height").forGetter(MazeStructure::getHeight),
            Codec.INT.fieldOf("depth").forGetter(MazeStructure::getDepth),
            BoundingBox.CODEC.optionalFieldOf("center").forGetter(MazeStructure::getCenter)).apply(instance, MazeStructure::new)), MazeStructure::verify).codec();
    private final int width;
    private final int height;
    private final int depth;
    private final Optional<BoundingBox> center;

    public MazeStructure(StructureSettings structureSettings, int width, int height, int depth, Optional<BoundingBox> center) {
        super(structureSettings);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.center = center;
    }

    private static DataResult<MazeStructure> verify(MazeStructure mazeStructure) {
        int width = mazeStructure.getWidth();
        int height = mazeStructure.getHeight();
        int depth = mazeStructure.getDepth();
        if (width > 128 || height > 128 || depth > 128) {
            return DataResult.error(() -> "Structure width, height or depth must not exceed 128");
        }

        BoundingBox center = mazeStructure.getCenter().orElse(null);
        if (center != null && (center.minX() < 0 || center.maxX() >= width
                || center.minY() < 0 || center.maxY() >= height
                || center.minZ() < 0 || center.maxZ() >= depth)) {
            return DataResult.error(() -> "Maze center exceeds bounds of maze");
        }
        return DataResult.success(mazeStructure);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        BlockPos pos = context.chunkPos().getBlockAt(0, 60, 0);
        return Optional.of(new GenerationStub(pos, builder -> generatePieces(builder, context)));
    }

    private void generatePieces(StructurePiecesBuilder builder, GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        BlockPos pos = new BlockPos(chunkPos.getMinBlockX(), 60, chunkPos.getMinBlockZ());

        MazeGenerator generator = new WilsonMazeGenerator(getWidth(), getHeight(), getDepth(), true);
        if (center.isPresent()) generator.addRoomEntry(new RoomEntry(BuiltInRegistries.STRUCTURE_PIECE.getKey(DDStructurePieceTypes.MAZE_BOSS_ROOM_PIECE), Optional.of(new Pos(center.get().minX(), center.get().minY(), center.get().minZ())), center.get().getXSpan(), center.get().getYSpan(), center.get().getZSpan(), true));
        generator.addRoomEntry(new RoomEntry(new ResourceLocation(DeeperDarker.MOD_ID, "test"), Optional.empty(), 3, 1, 3, false));

        MazeResult result = generator.generate(context.random());

        int sideLength = MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH;

        boolean placedStartReturnStatue = false;
        for (int z = 0; z < getDepth(); z++) {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    boolean returnStatue = (result.get(x, y, z).getData() >= 2 && y - 1 >= 0 && result.get(x, y - 1, z).getType().isSolid());

                    BlockPos pieceBlockPos = pos.offset(x * sideLength, y * sideLength, z * sideLength);
                    Pos piecePos = new Pos(x, y, z);

                    if (result.get(x, y, z).getType() == Tile.Type.ROOM) continue;

                    if (result.get(x, y, z).getType() == Tile.Type.WALL) {
                        builder.addPiece(new MazeStructurePieces.MazeWallPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth()));
                    } else if (isCorner(result, x, y, z) && ((returnStatue && !placedStartReturnStatue) || context.random().nextFloat() < 0.01f)) {
                        builder.addPiece(new MazeStructurePieces.MazeStatuePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), pos.offset(result.start().x() * sideLength + sideLength / 2, result.start().y() * sideLength, result.start().z() * sideLength + sideLength / 2)));
                        if (returnStatue && !placedStartReturnStatue) placedStartReturnStatue = true;
                    } else if (isHole(result, x, y, z)) {
                        boolean isLava = context.random().nextFloat() < 0.8f;
                        builder.addPiece(new MazeStructurePieces.MazeFluidPathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), isLava ? Blocks.LAVA.defaultBlockState() : Blocks.WATER.defaultBlockState(), (!isLava || context.random().nextFloat() < 0.6f) ? null : DDChestLootTableProvider.MAZE_SECRET));
                    } else if (context.random().nextFloat() < 0.03f) {
                        builder.addPiece(new MazeStructurePieces.MazePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), context.random().nextBoolean() ? DDBlocks.SCULK_GRIME_GLASS.defaultBlockState() : DDBlocks.FRAGILE_SCULK_GRIME_BRICKS.defaultBlockState()));
                    } else if (context.random().nextFloat() < 0.01f && y - 1 >= 0 && result.get(x, y - 1, z).getType().isSolid()) {
                        for (Direction direction : Arrays.stream(Direction.values()).filter(direction -> direction.getAxis().isHorizontal()).collect(Collectors.toSet())) {
                            Pos adjacentPos = piecePos.add(direction.getNormal());
                            if (result.isWithinBounds(adjacentPos) && result.get(adjacentPos).getType().isSolid()) {
                                builder.addPiece(new MazeStructurePieces.MazeChestPathPiece(pieceBlockPos, piecePos, direction, getWidth(), getHeight(), getDepth(), DDChestLootTableProvider.MAZE_BASIC));
                                break;
                            }
                        }
                    } else {
                        builder.addPiece(new MazeStructurePieces.MazePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), Blocks.AIR.defaultBlockState()));
                    }
                }
            }
        }
    }

    private static boolean isCorner(MazeResult result, int x, int y, int z) {
        if (result.get(x, y, z).getType().isSolid() || y - 1 < 0 || !result.get(x, y - 1, z).getType().isSolid()) return false;
        return ((x + 1 <= result.width() - 1 && result.get(x + 1, y, z).getType().isSolid()) || (x - 1 >= 0 && result.get(x - 1, y, z).getType().isSolid()))
                && ((z + 1 <= result.depth() - 1 && result.get(x, y, z + 1).getType().isSolid()) || (z - 1 >= 0 && result.get(x, y, z - 1).getType().isSolid()));
    }

    private static boolean isHole(MazeResult result, int x, int y, int z) {
        if (result.get(x, y, z).getType().isSolid() || y - 1 < 0 || !result.get(x, y - 1, z).getType().isSolid()) return false;
        return ((x + 1 <= result.width() - 1 && result.get(x + 1, y, z).getType().isSolid()) && (x - 1 >= 0 && result.get(x - 1, y, z).getType().isSolid()))
                && ((z + 1 <= result.depth() - 1 && result.get(x, y, z + 1).getType().isSolid()) && (z - 1 >= 0 && result.get(x, y, z - 1).getType().isSolid()));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public Optional<BoundingBox> getCenter() {
        return center;
    }

    @Override
    public StructureType<?> type() {
        return DDStructureTypes.MAZE;
    }
}
