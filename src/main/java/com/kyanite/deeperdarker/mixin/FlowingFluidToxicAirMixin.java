package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FlowingFluid.class)
public class FlowingFluidToxicAirMixin {
    @ModifyReturnValue(method = "canHoldFluid", at = @At("RETURN"))
    private boolean deeperdarker$toxicAirCannotHoldFluid(boolean original, @Local(argsOnly = true) BlockState state) {
        return original && !state.is(DDBlocks.TOXIC_AIR);
    }
}
