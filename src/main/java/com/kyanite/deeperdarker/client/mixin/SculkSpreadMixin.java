package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
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
    @Shadow public abstract void onDischarged(LevelAccessor p_222359_, BlockState p_222360_, BlockPos p_222361_, RandomSource p_222362_);

    public BlockState getBlockState(BlockState blockstate1) {
        BlockState blockstate2 = Blocks.SCULK.defaultBlockState();
        if(blockstate1.is(DDTags.Blocks.SCULK_STONE_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_STAIRS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_SLABS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_WALLS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_BRICKS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_BRICKS.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_BRICKS_SLABS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_BRICK_SLAB.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_BRICKS_STAIRS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_BRICK_STAIRS.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.SCULK_STONE_BRICKS_WALLS_REPLACE)) {
            blockstate2 = DDBlocks.SCULK_STONE_BRICK_WALL.get().defaultBlockState();
        }

        else if(blockstate1.is(DDTags.Blocks.COBBLED_SCULK_STONE_REPLACE)) {
            blockstate2 = DDBlocks.COBBLED_SCULK_STONE.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.COBBLED_SCULK_STONE_SLABS_REPLACE)) {
            blockstate2 = DDBlocks.COBBLED_SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.COBBLED_SCULK_STONE_STAIRS_REPLACE)) {
            blockstate2 = DDBlocks.COBBLED_SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.COBBLED_SCULK_STONE_WALLS_REPLACE)) {
            blockstate2 = DDBlocks.COBBLED_SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(blockstate1.is(DDTags.Blocks.POLISHED_SCULK_STONE_REPLACE)) {
            blockstate2 = DDBlocks.POLISHED_SCULK_STONE.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.POLISHED_SCULK_STONE_STAIRS_REPLACE)) {
            blockstate2 = DDBlocks.POLISHED_SCULK_STONE_STAIRS.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.POLISHED_SCULK_STONE_SLABS_REPLACE)) {
            blockstate2 = DDBlocks.POLISHED_SCULK_STONE_SLAB.get().defaultBlockState();
        }else if(blockstate1.is(DDTags.Blocks.POLISHED_SCULK_STONE_WALLS_REPLACE)) {
            blockstate2 = DDBlocks.POLISHED_SCULK_STONE_WALL.get().defaultBlockState();
        }

        else if(blockstate1 == Blocks.WEEPING_VINES.defaultBlockState()) {
            blockstate2 = DDBlocks.SCULK_VINES.get().defaultBlockState();
        }else if(blockstate1 == Blocks.WEEPING_VINES_PLANT.defaultBlockState()) {
            blockstate2 = DDBlocks.SCULK_VINES_PLANT.get().defaultBlockState();
        }




        return blockstate2;
    }
    @Inject(method = "attemptPlaceSculk", cancellable = true, at = @At("HEAD"))
    public void attemptSculk(SculkSpreader p_222376_, LevelAccessor p_222377_, BlockPos p_222378_, RandomSource p_222379_, CallbackInfoReturnable<Boolean> cir) {
        cir.cancel();
        BlockState blockstate = p_222377_.getBlockState(p_222378_);
        TagKey<Block> tagkey = p_222376_.replaceableBlocks();

        for(Direction direction : Direction.allShuffled(p_222379_)) {
            if (hasFace(blockstate, direction)) {
                BlockPos blockpos = p_222378_.relative(direction);
                BlockState blockstate1 = p_222377_.getBlockState(blockpos);
                if (blockstate1.is(tagkey)) {
                    BlockState blockstate2 = getBlockState(blockstate1);
                    p_222377_.setBlock(blockpos, blockstate2, 3);
                    Block.pushEntitiesUp(blockstate1, blockstate2, p_222377_, blockpos);
                    p_222377_.playSound((Player)null, blockpos, SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1.0F, 1.0F);
                    this.veinSpreader.spreadAll(blockstate2, p_222377_, blockpos, p_222376_.isWorldGeneration());
                    Direction direction1 = direction.getOpposite();

                    for(Direction direction2 : DIRECTIONS) {
                        if (direction2 != direction1) {
                            BlockPos blockpos1 = blockpos.relative(direction2);
                            BlockState blockstate3 = p_222377_.getBlockState(blockpos1);
                            if (blockstate3.is(this)) {
                                this.onDischarged(p_222377_, blockstate3, blockpos1, p_222379_);
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
    public MultifaceSpreader getSpreader() {
        return veinSpreader;
    }
}
