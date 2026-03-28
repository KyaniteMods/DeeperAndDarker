package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.fluids.EntityInAcid;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.Swim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Swim.class)
public class AcidSwimMixin {
    @WrapOperation(method = "checkExtraStartConditions(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Mob;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Mob;isInLava()Z"))
    private boolean deeperdarker$mobSwimInAcid(Mob instance, Operation<Boolean> original, @Local(argsOnly = true) Mob mob) {
        return original.call(instance) || ((EntityInAcid) mob).deeperdarker$isInAcid();
    }
}
