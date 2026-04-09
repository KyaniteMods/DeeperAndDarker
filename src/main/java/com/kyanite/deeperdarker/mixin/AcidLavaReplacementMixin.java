package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LavaFluid.class)
public class AcidLavaReplacementMixin {
    @WrapOperation(method = "canBeReplacedWith", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/Fluid;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean deeperdarker$allowAcidToReplaceLava(Fluid instance, TagKey<Fluid> tagKey, Operation<Boolean> original) {
        return original.call(instance, tagKey) || instance.is(DDTags.Fluids.ACID);
    }
}
