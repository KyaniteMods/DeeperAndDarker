package com.kyanite.deeperdarker.client.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkShriekerBlock;
import net.minecraft.world.level.block.SculkSpreader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SculkPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SculkPatchConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkPatchFeature.class)
public abstract class SculkPatchFeatureMixin {
    @Shadow protected abstract boolean canSpreadFrom(LevelAccessor levelAccessor, BlockPos blockPos);

    @Inject(method = "place", at = @At("HEAD"), cancellable = true)
    public void place(FeaturePlaceContext<SculkPatchConfiguration> featurePlaceContext, CallbackInfoReturnable<Boolean> cir) {
        cir.cancel();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        if (!canSpreadFrom(worldGenLevel, blockPos)) {
            cir.setReturnValue(false);
        } else {
            SculkPatchConfiguration sculkPatchConfiguration = (SculkPatchConfiguration) featurePlaceContext.config();
            RandomSource randomSource = featurePlaceContext.random();
            SculkSpreader sculkSpreader = SculkSpreader.createWorldGenSpreader();
            int i = sculkPatchConfiguration.spreadRounds() + sculkPatchConfiguration.growthRounds();

            int k;
            int l;
            for (int j = 0; j < i; ++j) {
                for (k = 0; k < sculkPatchConfiguration.chargeCount(); ++k) {
                    sculkSpreader.addCursors(blockPos, sculkPatchConfiguration.amountPerCharge());
                }

                boolean bl = j < sculkPatchConfiguration.spreadRounds();

                for (l = 0; l < sculkPatchConfiguration.spreadAttempts(); ++l) {
                    sculkSpreader.updateCursors(worldGenLevel, blockPos, randomSource, bl);
                }

                sculkSpreader.clear();
            }

            BlockPos blockPos2 = blockPos.below();
            if (randomSource.nextFloat() <= sculkPatchConfiguration.catalystChance() && worldGenLevel.getBlockState(blockPos2).isCollisionShapeFullBlock(worldGenLevel, blockPos2)) {
                worldGenLevel.setBlock(blockPos, Blocks.SCULK_CATALYST.defaultBlockState(), 3);
            }

            k = sculkPatchConfiguration.extraRareGrowths().sample(randomSource);

            for (l = 0; l < k; ++l) {
                BlockPos blockPos3 = blockPos.offset(randomSource.nextInt(5) - 2, 0, randomSource.nextInt(5) - 2);
                if (worldGenLevel.getBlockState(blockPos3).isAir() && worldGenLevel.getBlockState(blockPos3.below()).isFaceSturdy(worldGenLevel, blockPos3.below(), Direction.UP)) {
                    worldGenLevel.setBlock(blockPos3, (BlockState) Blocks.SCULK_SHRIEKER.defaultBlockState().setValue(SculkShriekerBlock.CAN_SUMMON, true), 3);
                }
            }

            cir.setReturnValue(true);
        }
    }
}
