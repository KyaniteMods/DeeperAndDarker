package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.world.otherside.structures.DDStructureTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

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

        MazeGenerator generator = new WilsonMazeGenerator(getWidth(), getHeight(), getDepth(), center.orElse(null), true);

        MazeResult result = generator.generate(context.random());
        for (int z = 0; z < getDepth(); z++) {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    if (result.get(x, y, z).type() == Tile.Type.WALL) {
                        builder.addPiece(new MazeStructurePieces.MazeWallPiece(pos.offset(x * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, y * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, z * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH), new Pos(x, y, z), getWidth(), getHeight(), getDepth()));
//                        builder.addPiece(new IglooPieces.IglooPiece(context.structureTemplateManager(), new ResourceLocation("igloo/top"), pos.offset(x, y, z), Rotation.NONE, 0));
                    } else if (context.random().nextFloat() < 0.01f) {
                        builder.addPiece(new MazeStructurePieces.MazeStatuePathPiece(pos.offset(x * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, y * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, z * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH), new Pos(x, y, z), getWidth(), getHeight(), getDepth(), pos.offset(result.start().x(), result.start().y(), result.start().z())));
                    } else {
                        builder.addPiece(new MazeStructurePieces.MazePathPiece(pos.offset(x * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, y * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH, z * MazeStructurePieces.MazeStructurePiece.SIDE_LENGTH), new Pos(x, y, z), getWidth(), getHeight(), getDepth()));
                    }
                }
            }
        }
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
