package com.kyanite.deeperdarker.world.structures;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CustomStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, DeeperDarker.MOD_ID);
    public static final DeferredRegister<StructurePieceType> PIECE_TYPE = DeferredRegister.create(Registries.STRUCTURE_PIECE, DeeperDarker.MOD_ID);

//    public static final DeferredHolder<StructureType<?>, StructureType<GloomazeStructure>> GLOOMAZE = STRUCTURE_TYPE.register("gloomaze", () -> () -> GloomazeStructure.CODEC);
//    public static final DeferredHolder<StructurePieceType, StructurePieceType> GLOOMAZE_PIECE = PIECE_TYPE.register("gloomaze", () -> GloomazePiece::new);
}
