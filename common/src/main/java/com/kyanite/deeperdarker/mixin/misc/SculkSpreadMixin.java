package com.kyanite.deeperdarker.mixin.misc;

import com.kyanite.deeperdarker.miscellaneous.DDRecipeTypes;
import com.kyanite.deeperdarker.miscellaneous.SculkSpreadingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

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

    @Inject(method = "attemptPlaceSculk", cancellable = true, at = @At("HEAD"))
    public void attemptSculk(SculkSpreader sculkSpreader, LevelAccessor levelAccessor, BlockPos pos, RandomSource randomSource, CallbackInfoReturnable<Boolean> cir) {
        cir.cancel();
        BlockState state = levelAccessor.getBlockState(pos);
        TagKey<Block> replaceable = sculkSpreader.replaceableBlocks();

        for (Direction direction : Direction.allShuffled(randomSource)) {
            if (hasFace(state, direction)) {
                BlockPos relativePos = pos.relative(direction);
                BlockState relativeState = levelAccessor.getBlockState(relativePos);
                if (relativeState.is(replaceable)) {
                    RecipeManager recipeManager = levelAccessor.getServer().getRecipeManager();
                    Optional<SculkSpreadingRecipe> optionalRecipe = recipeManager.getRecipeFor(DDRecipeTypes.SCULK_SPREADING, new SimpleContainer(1), (Level) levelAccessor.getLevelData());
                    if (optionalRecipe.isPresent()) {
                        SculkSpreadingRecipe recipe = optionalRecipe.get();
                        ItemStack output = recipe.getResultItem();
                        if (!output.isEmpty()) {
                            BlockState outputState = Block.byItem(output.getItem()).defaultBlockState();
                            levelAccessor.setBlock(relativePos, outputState, 3);
                            Block.pushEntitiesUp(relativeState, outputState, levelAccessor, relativePos);
                            levelAccessor.playSound(null, relativePos, SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1.0F, 1.0F);
                            this.veinSpreader.spreadAll(outputState, levelAccessor, relativePos, sculkSpreader.isWorldGeneration());
                            Direction direction1 = direction.getOpposite();

                            for (Direction direction2 : DIRECTIONS) {
                                if (direction2 != direction1) {
                                    BlockPos blockPos = relativePos.relative(direction2);
                                    BlockState checkState = levelAccessor.getBlockState(blockPos);
                                    if (checkState.is(this)) {
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
        }
    }
}
