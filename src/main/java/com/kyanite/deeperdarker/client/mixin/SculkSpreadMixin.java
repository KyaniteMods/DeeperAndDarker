package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
    @Shadow @Final private MultifaceSpreader veinSpreader;

    public SculkSpreadMixin(Properties pProperties) {
        super(pProperties);
    }
    @Shadow public abstract void onDischarged(LevelAccessor levelAccessor, BlockState state, BlockPos pos, RandomSource randomSource);

    public BlockState getBlockState(BlockState state) {
        BlockState replaceState = Blocks.SCULK.defaultBlockState();
        if(state.is(DDTags.Blocks.SCULK_STONE_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_STAIRS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_SLABS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_WALLS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(state.is(DDTags.Blocks.SCULK_STONE_BRICKS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_BRICKS.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_BRICKS_SLABS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_BRICK_SLAB.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_BRICKS_STAIRS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_BRICK_STAIRS.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.SCULK_STONE_BRICKS_WALLS_REPLACE)) {
            replaceState = DDBlocks.SCULK_STONE_BRICK_WALL.get().defaultBlockState();
        }

        else if(state.is(DDTags.Blocks.COBBLED_SCULK_STONE_REPLACE)) {
            replaceState = DDBlocks.COBBLED_SCULK_STONE.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.COBBLED_SCULK_STONE_SLABS_REPLACE)) {
            replaceState = DDBlocks.COBBLED_SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.COBBLED_SCULK_STONE_STAIRS_REPLACE)) {
            replaceState = DDBlocks.COBBLED_SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.COBBLED_SCULK_STONE_WALLS_REPLACE)) {
            replaceState = DDBlocks.COBBLED_SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(state.is(DDTags.Blocks.POLISHED_SCULK_STONE_REPLACE)) {
            replaceState = DDBlocks.POLISHED_SCULK_STONE.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.POLISHED_SCULK_STONE_STAIRS_REPLACE)) {
            replaceState = DDBlocks.POLISHED_SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.POLISHED_SCULK_STONE_SLABS_REPLACE)) {
            replaceState = DDBlocks.POLISHED_SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(state.is(DDTags.Blocks.POLISHED_SCULK_STONE_WALLS_REPLACE)) {
            replaceState = DDBlocks.POLISHED_SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(state == Blocks.SHROOMLIGHT.defaultBlockState()) {
            replaceState = DDBlocks.SCULK_GLEAM.get().defaultBlockState();
        }else if(state == Blocks.WEEPING_VINES.defaultBlockState()) {
            replaceState = DDBlocks.SCULK_VINES.get().defaultBlockState();
        }else if(state == Blocks.WEEPING_VINES_PLANT.defaultBlockState()) {
            replaceState = DDBlocks.SCULK_VINES_PLANT.get().defaultBlockState();
        }




        return replaceState;
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
