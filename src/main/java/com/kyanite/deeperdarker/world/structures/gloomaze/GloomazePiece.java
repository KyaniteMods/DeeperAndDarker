package com.kyanite.deeperdarker.world.structures.gloomaze;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.world.structures.CustomStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

@SuppressWarnings("NullableProblems")
public class GloomazePiece extends TemplateStructurePiece {
    public GloomazePiece(StructureTemplateManager manager, String name, BlockPos structurePos) {
        super(CustomStructures.GLOOMAZE_PIECE.get(), 0, manager, DeeperDarker.rl("gloomaze/" + name), name, makeSettings(), structurePos);
    }

    public GloomazePiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(CustomStructures.GLOOMAZE_PIECE.get(), tag, context.structureTemplateManager(), rl -> makeSettings());
    }

    private static StructurePlaceSettings makeSettings() {
        return new StructurePlaceSettings().setIgnoreEntities(false).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
    }

    @Override
    protected void handleDataMarker(String name, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox box) {
    }
}
