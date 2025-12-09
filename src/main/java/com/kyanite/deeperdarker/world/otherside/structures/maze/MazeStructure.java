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
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class MazeStructure extends Structure {
    public static final Codec<MazeStructure> CODEC = ExtraCodecs.validate(RecordCodecBuilder.mapCodec(instance -> instance.group(
            settingsCodec(instance),
            Codec.INT.fieldOf("width").forGetter(MazeStructure::getWidth),
            Codec.INT.fieldOf("height").forGetter(MazeStructure::getHeight),
            Codec.INT.fieldOf("depth").forGetter(MazeStructure::getDepth),
            Codec.INT.fieldOf("tile_size").forGetter(MazeStructure::getTileSize),
            Pos.CODEC.optionalFieldOf("boss_room_position").forGetter(MazeStructure::getBossRoomPosition)).apply(instance, MazeStructure::new)), MazeStructure::verify).codec();
    private final int width;
    private final int height;
    private final int depth;
    private final int tileSize;
    private final Optional<Pos> bossRoomPosition;

    public MazeStructure(StructureSettings structureSettings, int width, int height, int depth, int tileSize, Optional<Pos> bossRoomPosition) {
        super(structureSettings);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.tileSize = tileSize;
        this.bossRoomPosition = bossRoomPosition;
    }

    private static DataResult<MazeStructure> verify(MazeStructure mazeStructure) {
        int width = mazeStructure.getWidth();
        int height = mazeStructure.getHeight();
        int depth = mazeStructure.getDepth();
        if (width > 128 || height > 128 || depth > 128) {
            return DataResult.error(() -> "Structure width, height or depth must not exceed 128");
        }

        Pos bossRoomPos;
        if (mazeStructure.getBossRoomPosition().isPresent()
                && ((bossRoomPos = mazeStructure.getBossRoomPosition().get()).x() < 0 || bossRoomPos.x() > width - 1
                || bossRoomPos.y() < 0 || bossRoomPos.y() > height - 1
                || bossRoomPos.z() < 0 || bossRoomPos.z() > depth - 1)) {
            return DataResult.error(() -> "Boss room position is out of bounds");
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
        final BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), 60, chunkPos.getMinBlockZ());

        MazeGenerator generator = new WilsonMazeGenerator(getWidth(), getHeight(), getDepth(), false);

        if (getBossRoomPosition().isPresent()) {
            Pos bossRoomPos = getBossRoomPosition().get();
            generator.addRoomEntry(new RoomEntry((pos, entrance) -> new MazeStructurePieces.MazeBossRoomPiece(blockPos.offset(pos.x() * tileSize, pos.y() * tileSize, pos.z() * tileSize), pos, getWidth(), getHeight(), getDepth(), getTileSize(), Blocks.AIR.defaultBlockState()), Optional.of(bossRoomPos), 7, 1, 7, true));
        }

        MazeResult result = generator.generate(context.random());

        OptionalInt startReturnStatueDistance = OptionalInt.empty();
        for (Pos pos : result.getPositions()) {
            int x = pos.x();
            int y = pos.y();
            int z = pos.z();
            boolean returnStatue = result.get(x, y, z).getData() >= 2;
            if (y - 1 < 0 || !result.get(x, y - 1, z).getType().isSolid()) returnStatue = false;
            boolean generateReturnStatue = returnStatue && (startReturnStatueDistance.isEmpty() || startReturnStatueDistance.getAsInt() == result.get(x, y, z).getData());

            BlockPos pieceBlockPos = blockPos.offset(x * tileSize, y * tileSize, z * tileSize);
            Pos piecePos = new Pos(x, y, z);

            if (result.get(x, y, z).getType() == Tile.Type.ROOM) continue;

            if (result.get(x, y, z).getType() == Tile.Type.WALL) {
                builder.addPiece(new MazeStructurePieces.MazeWallPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), getTileSize()));
                continue;
            }

            if (isCorner(result, x, y, z) && (generateReturnStatue || context.random().nextFloat() < 0.01f)) {
                builder.addPiece(new MazeStructurePieces.MazeStatuePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), getTileSize(), blockPos.offset(result.start().x() * getTileSize() + getTileSize() / 2, result.start().y() * getTileSize(), result.start().z() * getTileSize() + getTileSize() / 2)));
                if (returnStatue && startReturnStatueDistance.isEmpty()) startReturnStatueDistance = OptionalInt.of(result.get(x, y, z).getData());
                continue;
            }

            if (isHole(result, x, y, z)) {
                boolean isLava = context.random().nextFloat() < 0.8f;
                builder.addPiece(new MazeStructurePieces.MazeFluidPathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), getTileSize(), isLava ? Blocks.LAVA.defaultBlockState() : Blocks.WATER.defaultBlockState(), (!isLava || context.random().nextFloat() < 0.6f) ? null : DDChestLootTableProvider.MAZE_SECRET));
                continue;
            }

            if (context.random().nextFloat() < 0.03f) {
                builder.addPiece(new MazeStructurePieces.MazePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), getTileSize(), context.random().nextBoolean() ? DDBlocks.SCULK_GRIME_GLASS.defaultBlockState() : DDBlocks.FRAGILE_SCULK_GRIME_BRICKS.defaultBlockState()));
                continue;
            }

            if (context.random().nextFloat() < 0.01f && y - 1 >= 0 && result.get(x, y - 1, z).getType().isSolid()) {
                for (Direction direction : Arrays.stream(Direction.values()).filter(direction -> direction.getAxis().isHorizontal()).collect(Collectors.toSet())) {
                    Pos adjacentPos = piecePos.add(direction.getNormal());
                    if (result.isWithinBounds(adjacentPos) && result.get(adjacentPos).getType().isSolid()) {
                        builder.addPiece(new MazeStructurePieces.MazeChestPathPiece(pieceBlockPos, piecePos, direction, getWidth(), getHeight(), getDepth(), getTileSize(), DDChestLootTableProvider.MAZE_BASIC));
                        break;
                    }
                }
                continue;
            }

            builder.addPiece(new MazeStructurePieces.MazePathPiece(pieceBlockPos, piecePos, getWidth(), getHeight(), getDepth(), getTileSize(), Blocks.AIR.defaultBlockState()));
        }

        for (Room room : result.rooms()) {
            builder.addPiece(room.create());
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

    public int getTileSize() {
        return tileSize;
    }

    public Optional<Pos> getBossRoomPosition() {
        return bossRoomPosition;
    }

    @Override
    public StructureType<?> type() {
        return DDStructureTypes.MAZE;
    }
}
