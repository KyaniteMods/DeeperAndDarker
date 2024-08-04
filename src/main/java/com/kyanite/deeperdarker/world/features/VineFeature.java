package com.kyanite.deeperdarker.world.features;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.vegetation.GlowingVinesPlantBlock;
import com.kyanite.deeperdarker.world.features.config.VineFeatureConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class VineFeature extends Feature<VineFeatureConfiguration> {
    public VineFeature(Codec<VineFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<VineFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        if(level.isEmptyBlock(origin)) {
            BlockState state = level.getBlockState(origin.above());
            if(state.is(context.config().tag())) {
                this.placeVines(context, level, context.random(), origin);
                return true;
            }
        }

        return false;
    }

    private void placeVines(FeaturePlaceContext<VineFeatureConfiguration> context, LevelAccessor level, RandomSource random, BlockPos pos) {
        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 100; i++) {
            blockPos.setWithOffset(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if(level.isEmptyBlock(blockPos)) {
                BlockState state = level.getBlockState(blockPos.above());
                if(state.is(context.config().tag())) {
                    int length = context.config().height().sample(random);
                    if(random.nextFloat() < context.config().doubleChance()) length *= 2;
                    if(random.nextFloat() < context.config().reducedChance()) length = 1;

                    placeVinesColumn(context, level, random, blockPos, length);
                }
            }
        }
    }

    private void placeVinesColumn(FeaturePlaceContext<VineFeatureConfiguration> context, LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int length) {
        for(int i = 0; i <= length; i++) {
            if(level.isEmptyBlock(pos) && !(level.getBlockState(pos).getBlock() instanceof LeavesBlock)) {
                if(i == length || !level.isEmptyBlock(pos.below())) {
                    level.setBlock(pos, context.config().vine().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, 17, 25)), 3);
                    break;
                }

                BlockState plant = context.config().plant();
                if(plant.is(DDBlocks.GLOWING_VINES_PLANT.get()) && random.nextFloat() < 0.25f) plant = plant.setValue(GlowingVinesPlantBlock.BERRIES, true);
                level.setBlock(pos, plant, 3);
            }

            pos.move(Direction.DOWN);
        }
    }
}
