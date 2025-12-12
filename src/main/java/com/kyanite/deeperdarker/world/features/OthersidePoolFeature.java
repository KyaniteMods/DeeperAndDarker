package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingGrassBlock;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class OthersidePoolFeature extends Feature<NoneFeatureConfiguration> {
    public OthersidePoolFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos origin = pContext.origin();
        WorldGenLevel level = pContext.level();
        RandomSource random = pContext.random();

        if(origin.getY() <= level.getMinBuildHeight() + 4) return false;

        int size = random.nextInt(5, 10);

        Registry<Structure> registry = pContext.level().registryAccess().registryOrThrow(Registries.STRUCTURE);

        StructureManager structureManager = level.getLevel().structureManager();
        SectionPos sectionPos = SectionPos.of(origin);

        ChunkAccess chunkAccess = level.getChunk(sectionPos.x(), sectionPos.z(), ChunkStatus.STRUCTURE_REFERENCES);
        if (chunkAccess.getHighestGeneratedStatus().isOrAfter(ChunkStatus.STRUCTURE_REFERENCES)) {
            Map<Structure, LongSet> references = chunkAccess.getAllReferences();
            for (Map.Entry<Structure, LongSet> entry : references.entrySet()) {
                if (registry.getHolder(registry.getResourceKey(entry.getKey()).get()).get().is(DDTags.Structures.NO_BLOOMING_POOL_GENERATION)) {
                    for (long ref : entry.getValue()) {
                        SectionPos sectionPos1 = SectionPos.of(new ChunkPos(ref), level.getMinBuildHeight());
                        if (!level.hasChunk(sectionPos.x(), sectionPos.z())) {
                            continue;
                        }
                        StructureStart structureStart = structureManager.getStartForStructure(sectionPos1, entry.getKey(), level.getChunk(sectionPos1.x(), sectionPos1.z(), ChunkStatus.STRUCTURE_STARTS));
                        if (structureStart != null && structureStart.isValid() && structureStart.getBoundingBox().intersects(new BoundingBox(origin.getX() - size / 2, origin.getY(), origin.getZ() - size / 2, origin.getX() + size, origin.getY() + 4, origin.getZ() + size))) {
                            return false;
                        }
                    }
                }
            }
        }


        origin = origin.below(4);
        boolean[] arr = new boolean[2048];

        for(int i = 0; i < size; i++) {
            double length = random.nextDouble() * 6 + 3;
            double depth = random.nextDouble() * 5 + 2;
            double width = random.nextDouble() * 6 + 3;
            double d3 = random.nextDouble() * (14 - length) + 1 + length / 2.0;
            double d4 = random.nextDouble() * (4 - depth) + 2 + depth / 2.0;
            double d5 = random.nextDouble() * (14 - width) + 1 + width / 2.0;

            for(int l = 1; l < 15; l++) {
                for(int i1 = 1; i1 < 15; i1++) {
                    for(int j1 = 1; j1 < 7; j1++) {
                        double d6 = ((double)l - d3) / (length / 2.0);
                        double d7 = ((double)j1 - d4) / (depth / 2.0);
                        double d8 = ((double)i1 - d5) / (width / 2.0);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                        if(d9 < 1) arr[(l * 16 + i1) * 8 + j1] = true;
                    }
                }
            }
        }

        for(int k1 = 0; k1 < 16; k1++) {
            for(int k = 0; k < 16; k++) {
                for(int l2 = 0; l2 < 8; l2++) {
                    boolean flag = !arr[(k1 * 16 + k) * 8 + l2] && (k1 < 15 && arr[((k1 + 1) * 16 + k) * 8 + l2] || k1 > 0 && arr[((k1 - 1) * 16 + k) * 8 + l2] || k < 15 && arr[(k1 * 16 + k + 1) * 8 + l2] || k > 0 && arr[(k1 * 16 + (k - 1)) * 8 + l2] || l2 < 7 && arr[(k1 * 16 + k) * 8 + l2 + 1] || l2 > 0 && arr[(k1 * 16 + k) * 8 + (l2 - 1)]);
                    if(flag) {
                        BlockState state = level.getBlockState(origin.offset(k1, l2, k));
                        if (l2 >= 4 && state.liquid()) return false;
                        if (l2 < 4 && !state.isSolid() && !level.getBlockState(origin.offset(k1, l2, k)).is(Blocks.WATER)) return false;
                    }
                }
            }
        }

        for(int l1 = 0; l1 < 16; ++l1) {
            for(int i2 = 0; i2 < 16; ++i2) {
                for(int i3 = 0; i3 < 8; ++i3) {
                    if(arr[(l1 * 16 + i2) * 8 + i3]) {
                        BlockPos pos = origin.offset(l1, i3, i2);
                        if(this.canReplaceBlock(level.getBlockState(pos))) {
                            boolean above = i3 >= 4;
                            if(!above && level.getBlockState(pos.below()).is(DDBlocks.SCULK_STONE) && random.nextFloat() < 0.1f) level.setBlock(pos, DDBlocks.GLOWING_GRASS.defaultBlockState().setValue(GlowingGrassBlock.WATERLOGGED, true), 2);
                            else level.setBlock(pos, above ? Blocks.CAVE_AIR.defaultBlockState() : Blocks.WATER.defaultBlockState(), 2);
                            if(above) {
                                level.scheduleTick(pos, Blocks.CAVE_AIR, 0);
                                this.markAboveForPostProcessing(level, pos);
                            }
                        }
                    }
                }
            }
        }

        for(int j2 = 0; j2 < 16; ++j2) {
            for(int j3 = 0; j3 < 16; ++j3) {
                for(int l3 = 0; l3 < 8; ++l3) {
                    boolean flag2 = !arr[(j2 * 16 + j3) * 8 + l3] && (j2 < 15 && arr[((j2 + 1) * 16 + j3) * 8 + l3] || j2 > 0 && arr[((j2 - 1) * 16 + j3) * 8 + l3] || j3 < 15 && arr[(j2 * 16 + j3 + 1) * 8 + l3] || j3 > 0 && arr[(j2 * 16 + (j3 - 1)) * 8 + l3] || l3 < 7 && arr[(j2 * 16 + j3) * 8 + l3 + 1] || l3 > 0 && arr[(j2 * 16 + j3) * 8 + (l3 - 1)]);
                    if(flag2 && (l3 < 4 || random.nextInt(2) != 0)) {
                        BlockState state = level.getBlockState(origin.offset(j2, l3, j3));
                        if(state.isSolid() && !state.is(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)) {
                            BlockPos pos = origin.offset(j2, l3, j3);
                            if(level.getBlockState(pos.above()).isAir()) level.setBlock(pos, DDBlocks.BLOOMING_SCULK_STONE.defaultBlockState(), 2);
                            else level.setBlock(pos, DDBlocks.SCULK_STONE.defaultBlockState(), 2);
                            this.markAboveForPostProcessing(level, pos);
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean canReplaceBlock(BlockState state) {
        return !state.is(BlockTags.FEATURES_CANNOT_REPLACE);
    }
}
