package com.kyanite.deeperdarker.world.otherside.structures.maze;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public record MazeStructurePalette(SimpleWeightedRandomList<BlockState> structureCover, SimpleWeightedRandomList<BlockState> wallCorner, SimpleWeightedRandomList<BlockState> wallFace, SimpleWeightedRandomList<BlockState> wallEdge, SimpleWeightedRandomList<BlockState> wallCenter, SimpleWeightedRandomList<BlockState> path, SimpleWeightedRandomList<BlockState> entrance, SimpleWeightedRandomList<BlockState> fluid) {
    public static final Codec<MazeStructurePalette> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("structure_cover").forGetter(MazeStructurePalette::structureCover),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("wall_corner").forGetter(MazeStructurePalette::wallCorner),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("wall_face").forGetter(MazeStructurePalette::wallFace),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("wall_edge").forGetter(MazeStructurePalette::wallEdge),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("wall_center").forGetter(MazeStructurePalette::wallCenter),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("path").forGetter(MazeStructurePalette::path),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("entrance").forGetter(MazeStructurePalette::entrance),
            SimpleWeightedRandomList.wrappedCodec(BlockState.CODEC).fieldOf("fluid").forGetter(MazeStructurePalette::fluid)
    ).apply(instance, MazeStructurePalette::new));

    public static final MazeStructurePalette BLOOMAZE = MazeStructurePalette.builder()
            .addStructureCovers(WeightedEntry.wrap(DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState(), 10), WeightedEntry.wrap(DDBlocks.SCULK_STONE_BRICKS.defaultBlockState(), 1))
            .addWallCorners(WeightedEntry.wrap(DDBlocks.SCULK_GRIME_BRICKS.defaultBlockState(), 1))
            .addWallFaces(WeightedEntry.wrap(DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState(), 1))
            .addWallEdges(WeightedEntry.wrap(DDBlocks.PROTECTED_SCULK_GRIME_GLASS.defaultBlockState(), 1))
            .addWallCenters(WeightedEntry.wrap(DDBlocks.PROTECTED_SCULK_GLEAM.defaultBlockState(), 1))
            .addPathBlocks(WeightedEntry.wrap(Blocks.AIR.defaultBlockState(), 100), WeightedEntry.wrap(DDBlocks.FRAGILE_SCULK_GRIME_BRICKS.defaultBlockState(), 2), WeightedEntry.wrap(DDBlocks.SCULK_GRIME_GLASS.defaultBlockState(), 1))
            .addEntranceBlocks(WeightedEntry.wrap(Blocks.AIR.defaultBlockState(), 100), WeightedEntry.wrap(DDBlocks.FRAGILE_SCULK_GRIME_BRICKS.defaultBlockState(), 2), WeightedEntry.wrap(DDBlocks.SCULK_GRIME_GLASS.defaultBlockState(), 1))
            .addFluids(WeightedEntry.wrap(Blocks.LAVA.defaultBlockState(), 2), WeightedEntry.wrap(Blocks.WATER.defaultBlockState(), 1))
            .build();

    public static final MazeStructurePalette GLOOMAZE = MazeStructurePalette.builder()
            .addStructureCovers(WeightedEntry.wrap(DDBlocks.GLOOMSLATE_BRICKS.defaultBlockState(), 1))
            .addWallCorners(WeightedEntry.wrap(DDBlocks.GLOOMSLATE_BRICKS.defaultBlockState(), 1))
            .addWallFaces(WeightedEntry.wrap(DDBlocks.SCULK_LAMP.defaultBlockState(), 1))
            .addWallEdges(WeightedEntry.wrap(DDBlocks.GLOOMSLATE_BARRIER.defaultBlockState(), 1))
            .addWallCenters(WeightedEntry.wrap(DDBlocks.SCULK_LAMP.defaultBlockState(), 1))
            .addPathBlocks(WeightedEntry.wrap(Blocks.AIR.defaultBlockState(), 100), WeightedEntry.wrap(DDBlocks.FRAGILE_GLOOMSLATE_BRICKS.defaultBlockState(), 2), WeightedEntry.wrap(DDBlocks.SCULK_GRIME_GLASS.defaultBlockState(), 1))
            .addEntranceBlocks(WeightedEntry.wrap(DDBlocks.GLOOMSLATE_LOCK.defaultBlockState(), 1))
            .addFluids(WeightedEntry.wrap(Blocks.LAVA.defaultBlockState(), 1))
            .build();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SimpleWeightedRandomList.Builder<BlockState> structureCover = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> wallCorner = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> wallFace = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> wallEdge = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> wallCenter = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> path = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> entrance = SimpleWeightedRandomList.builder();
        private final SimpleWeightedRandomList.Builder<BlockState> fluid = SimpleWeightedRandomList.builder();

        @SafeVarargs
        public final Builder addStructureCovers(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                structureCover.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addWallCorners(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                wallCorner.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addWallFaces(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                wallFace.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addWallEdges(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                wallEdge.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addWallCenters(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                wallCenter.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addPathBlocks(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                path.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addEntranceBlocks(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                entrance.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        @SafeVarargs
        public final Builder addFluids(WeightedEntry.Wrapper<BlockState>... entries) {
            for (WeightedEntry.Wrapper<BlockState> entry : entries) {
                fluid.add(entry.getData(), entry.getWeight().asInt());
            }
            return this;
        }

        public MazeStructurePalette build() {
            return new MazeStructurePalette(structureCover.build(), wallCorner.build(), wallFace.build(), wallEdge.build(), wallCenter.build(), path.build(), entrance.build(), fluid.build());
        }
    }
}
