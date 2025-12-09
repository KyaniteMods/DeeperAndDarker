package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.util.datagen.loot.DDChestLootTableProvider;
import com.kyanite.deeperdarker.world.otherside.structures.DDStructureTypes;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.MazeGenerator;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.MazeResult;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.Pos;
import com.kyanite.deeperdarker.world.otherside.structures.maze.generation.WilsonMazeGenerator;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
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
            MazeStructureSettings.CODEC.fieldOf("maze_settings").forGetter(MazeStructure::getSettings)).apply(instance, MazeStructure::new)), MazeStructure::verify).codec();
    private final MazeStructureSettings settings;

    public MazeStructure(StructureSettings structureSettings, MazeStructureSettings settings) {
        super(structureSettings);
        this.settings = settings;
    }

    private static DataResult<MazeStructure> verify(MazeStructure mazeStructure) {
        int width = mazeStructure.getSettings().width();
        int height = mazeStructure.getSettings().height();
        int depth = mazeStructure.getSettings().depth();
        if (width > 128 || height > 128 || depth > 128) {
            return DataResult.error(() -> "Structure width, height or depth must not exceed 128");
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
        final BlockPos origin = new BlockPos(chunkPos.getMinBlockX(), 60, chunkPos.getMinBlockZ());

        MazeGenerator generator = new WilsonMazeGenerator(getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().makeExit());

        for (RoomEntry roomEntry : getSettings().rooms()) {
            generator.addRoomEntry(roomEntry);
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

            BlockPos pieceBlockPos = origin.offset(x * getSettings().tileSize(), y * getSettings().tileSize(), z * getSettings().tileSize());
            Pos piecePos = new Pos(x, y, z);

            if (result.get(x, y, z).getType() == Tile.Type.ROOM) continue;

            if (result.get(x, y, z).getType() == Tile.Type.WALL) {
                builder.addPiece(new MazeStructurePieces.MazeWallPiece(pieceBlockPos, piecePos, getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().tileSize(), getSettings().palette()));
                continue;
            }

            if (isCorner(result, x, y, z) && (generateReturnStatue || context.random().nextFloat() < 0.01f)) {
                builder.addPiece(new MazeStructurePieces.MazeStatuePathPiece(pieceBlockPos, piecePos, getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().tileSize(), getSettings().palette(), origin.offset(result.start().x() * getSettings().tileSize() + getSettings().tileSize() / 2, result.start().y() * getSettings().tileSize(), result.start().z() * getSettings().tileSize() + getSettings().tileSize() / 2)));
                if (returnStatue && startReturnStatueDistance.isEmpty()) startReturnStatueDistance = OptionalInt.of(result.get(x, y, z).getData());
                continue;
            }

            if (isHole(result, x, y, z)) {
                builder.addPiece(new MazeStructurePieces.MazeFluidPathPiece(pieceBlockPos, piecePos, getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().tileSize(), getSettings().palette(), DDChestLootTableProvider.MAZE_SECRET, context.random()));
                continue;
            }

            if (context.random().nextFloat() < 0.01f && y - 1 >= 0 && result.get(x, y - 1, z).getType().isSolid()) {
                for (Direction direction : Arrays.stream(Direction.values()).filter(direction -> direction.getAxis().isHorizontal()).collect(Collectors.toSet())) {
                    Pos adjacentPos = piecePos.add(direction.getNormal());
                    if (result.isWithinBounds(adjacentPos) && result.get(adjacentPos).getType().isSolid()) {
                        builder.addPiece(new MazeStructurePieces.MazeChestPathPiece(pieceBlockPos, piecePos, direction, getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().tileSize(), getSettings().palette(), DDChestLootTableProvider.MAZE_BASIC));
                        break;
                    }
                }
                continue;
            }

            builder.addPiece(new MazeStructurePieces.MazePathPiece(pieceBlockPos, piecePos, getSettings().width(), getSettings().height(), getSettings().depth(), getSettings().tileSize(), getSettings().palette(), context.random()));
        }

        for (Room room : result.rooms()) {
            builder.addPiece(room.create(context, getSettings(), origin));
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

    public MazeStructureSettings getSettings() {
        return settings;
    }

    @Override
    public StructureType<?> type() {
        return DDStructureTypes.MAZE;
    }
}
