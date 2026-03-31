package com.kyanite.deeperdarker.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FloatGoal.class)
public abstract class AcidFloatGoalMixin {
    @Shadow
    @Final
    private Mob mob;

    @WrapOperation(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Mob;isInLava()Z"))
    private boolean deeperdarker$floatInAcid(Mob instance, Operation<Boolean> original) {
        return original.call(instance) || mob.deeperdarker$isInAcid();
    }
}
