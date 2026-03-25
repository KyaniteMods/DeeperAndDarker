package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.BloomingStemBlock;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public abstract class StripBloomingStemMixin {
    @Inject(method = "getStripped", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$stripBloomingStem(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
        if (state.is(DDBlocks.BLOOMING_STEM)) {
            cir.setReturnValue(Optional.of(DDBlocks.STRIPPED_BLOOMING_STEM.defaultBlockState().setValue(BloomingStemBlock.UP, state.getValue(BloomingStemBlock.UP)).setValue(BloomingStemBlock.DOWN, state.getValue(BloomingStemBlock.DOWN)).setValue(BloomingStemBlock.NORTH, state.getValue(BloomingStemBlock.NORTH)).setValue(BloomingStemBlock.EAST, state.getValue(BloomingStemBlock.EAST)).setValue(BloomingStemBlock.SOUTH, state.getValue(BloomingStemBlock.SOUTH)).setValue(BloomingStemBlock.WEST, state.getValue(BloomingStemBlock.WEST))));
        }
    }
}
