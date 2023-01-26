package com.kyanite.deeperdarker.mixin.misc;

import com.kyanite.deeperdarker.registry.world.biomes.OthersideBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SculkBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(SculkBlock.class)
public class SculkBlockMixin {
    @Inject(method = "getRandomGrowthState", at = @At("HEAD"), cancellable = true)
    public void getRandomGrowthState(LevelAccessor levelAccessor, BlockPos blockPos, RandomSource randomSource, boolean bl, CallbackInfoReturnable<BlockState> cir) {
        if(levelAccessor.getBiome(blockPos).is(Objects.requireNonNull(OthersideBiomes.OTHERSIDE_DEEPLANDS.location())) || levelAccessor.getBiome(blockPos).is(Objects.requireNonNull(OthersideBiomes.ECHOING_FOREST.location()))) {
            cir.cancel();
            BlockState blockState = Blocks.SCULK_SENSOR.defaultBlockState();
            cir.setReturnValue(blockState.hasProperty(BlockStateProperties.WATERLOGGED) && !levelAccessor.getFluidState(blockPos).isEmpty() ? blockState.setValue(BlockStateProperties.WATERLOGGED, true) : blockState);
        }
    }
}
