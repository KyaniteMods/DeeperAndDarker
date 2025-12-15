package com.kyanite.deeperdarker.world;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.*;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.function.Function;

public class DDNoodleCarver extends CaveWorldCarver {
    public DDNoodleCarver(Codec<CaveCarverConfiguration> codec) {
        super(codec);
    }

    @Override
    protected boolean carveBlock(CarvingContext carvingContext, CaveCarverConfiguration carverConfiguration, ChunkAccess chunkAccess, Function<BlockPos, Holder<Biome>> function, CarvingMask carvingMask, BlockPos.MutableBlockPos mutableBlockPos, BlockPos.MutableBlockPos mutableBlockPos2, Aquifer aquifer, MutableBoolean mutableBoolean) {
        BlockState blockState2 = chunkAccess.getBlockState(mutableBlockPos);
        if (!this.canReplaceBlock(carverConfiguration, blockState2) && !blockState2.isAir()) {
            return false;
        }
        BlockState blockState22 = DDBlocks.SCULK_TISSUE.defaultBlockState();
        chunkAccess.setBlockState(mutableBlockPos, blockState22, false);
        return true;
    }
}
