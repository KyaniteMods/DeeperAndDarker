package com.kyanite.deeperdarker.mixin.misc;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkVeinBlock.class)
public abstract class SculkSpreadMixin extends MultifaceBlock {
    @Shadow
    @Final
    private MultifaceSpreader veinSpreader;

    public SculkSpreadMixin(Properties pProperties) {
        super(pProperties);
    }

    @Shadow
    public abstract void onDischarged(LevelAccessor levelAccessor, BlockState state, BlockPos pos, RandomSource randomSource);

    public BlockState getBlockState(BlockState state) {

        if(state.is(Blocks.STONE)) return DDBlocks.SCULK_STONE.get().defaultBlockState();
        if(state.is(BlockTags.LOGS)) return DDBlocks.ECHO_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
        if(state.is(DDTags.Blocks.STRIPPED_LOGS)) return DDBlocks.STRIPPED_ECHO_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
        if(state.is(DDTags.Blocks.WOOD)) return DDBlocks.ECHO_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
        if(state.is(DDTags.Blocks.STRIPPED_WOOD)) return DDBlocks.STRIPPED_ECHO_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS));
        if(state.is(BlockTags.LEAVES)) return DDBlocks.ECHO_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, state.getValue(LeavesBlock.DISTANCE)).setValue(LeavesBlock.PERSISTENT, state.getValue(LeavesBlock.PERSISTENT)).setValue(LeavesBlock.WATERLOGGED, state.getValue(LeavesBlock.WATERLOGGED));
        if(state == Blocks.SHROOMLIGHT.defaultBlockState()) return DDBlocks.SCULK_GLEAM.get().defaultBlockState();
        if(state == Blocks.WEEPING_VINES.defaultBlockState()) return DDBlocks.SCULK_VINES.get().defaultBlockState();
        if(state == Blocks.WEEPING_VINES_PLANT.defaultBlockState()) return DDBlocks.SCULK_VINES_PLANT.get().defaultBlockState();
        if(state == Blocks.TWISTING_VINES.defaultBlockState()) return DDBlocks.SCULK_TENDRILS.get().defaultBlockState();
        if(state == Blocks.TWISTING_VINES_PLANT.defaultBlockState()) return DDBlocks.SCULK_TENDRILS_PLANT.get().defaultBlockState();

        return Blocks.SCULK.defaultBlockState();
    }

    @Inject(method = "attemptPlaceSculk", cancellable = true, at = @At("HEAD"))
    public void attemptSculk(SculkSpreader sculkSpreader, LevelAccessor levelAccessor, BlockPos pos, RandomSource randomSource, CallbackInfoReturnable<Boolean> cir) {
        cir.cancel();
        BlockState state = levelAccessor.getBlockState(pos);
        TagKey<Block> replaceable = sculkSpreader.replaceableBlocks();

        for(Direction direction : Direction.allShuffled(randomSource)) {
            if(hasFace(state, direction)) {
                BlockPos relativePos = pos.relative(direction);
                BlockState relativeState = levelAccessor.getBlockState(relativePos);
                if(relativeState.is(replaceable)) {
                    BlockState blockState = getBlockState(relativeState);
                    levelAccessor.setBlock(relativePos, blockState, 3);
                    Block.pushEntitiesUp(relativeState, blockState, levelAccessor, relativePos);
                    levelAccessor.playSound(null, relativePos, SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1.0F, 1.0F);
                    this.veinSpreader.spreadAll(blockState, levelAccessor, relativePos, sculkSpreader.isWorldGeneration());
                    Direction direction1 = direction.getOpposite();

                    for(Direction direction2 : DIRECTIONS) {
                        if(direction2 != direction1) {
                            BlockPos blockPos = relativePos.relative(direction2);
                            BlockState checkState = levelAccessor.getBlockState(blockPos);
                            if(checkState.is(this)) {
                                this.onDischarged(levelAccessor, checkState, blockPos, randomSource);
                            }
                        }
                    }

                    cir.setReturnValue(true);
                }
            }
        }

        cir.setReturnValue(false);
    }

    @Override
    public @NotNull MultifaceSpreader getSpreader() {
        return veinSpreader;
    }
}
