package com.kyanite.deeperdarker.world.structures.gloomaze;

/*public class GloomazeStructure extends Structure {
    public static final MapCodec<GloomazeStructure> CODEC = simpleCodec(GloomazeStructure::new);

    public GloomazeStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected @NotNull Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        BlockPos pos = context.chunkPos().getBlockAt(0, 60, 0);
        return Optional.of(new GenerationStub(pos, builder -> generatePieces(builder, context, pos)));
    }

    private void generatePieces(StructurePiecesBuilder builder, GenerationContext context, BlockPos pos) {
        builder.addPiece(new GloomazePiece(context.structureTemplateManager(), "south", pos));
        builder.addPiece(new GloomazePiece(context.structureTemplateManager(), "north_west_east", pos.south(8)));
    }

    @Override
    public @NotNull StructureType<?> type() {
        return CustomStructures.GLOOMAZE.get();
    }
}*/
