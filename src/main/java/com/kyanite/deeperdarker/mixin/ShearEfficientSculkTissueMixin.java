package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShearsItem.class)
public class ShearEfficientSculkTissueMixin {
    @Inject(method = "getDestroySpeed", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$shearEfficientSculkTissue(ItemStack itemStack, BlockState blockState, CallbackInfoReturnable<Float> cir) {
        if (blockState.is(DDBlocks.SCULK_TISSUE)) cir.setReturnValue(5.0f);
    }
}
