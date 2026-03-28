package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.fluids.EntityInAcid;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class AcidLivingEntityMixin {
    @Shadow
    protected abstract void jumpInLiquid(TagKey<Fluid> tagKey);

    @Shadow
    protected abstract boolean isAffectedByFluids();

    @WrapOperation(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInWater()Z", ordinal = 0))
    private boolean deeperdarker$acidAiStep(LivingEntity instance, Operation<Boolean> original) {
        boolean isInWater = original.call(instance);
        if (isInWater) return true;
        if (!((EntityInAcid) this).deeperdarker$isInAcid()) return original.call(instance);
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!entity.onGround() || entity.getFluidHeight(DDTags.Fluids.ACID) > entity.getFluidJumpThreshold()) {
            jumpInLiquid(DDTags.Fluids.ACID);
            return false;
        }
        return isInWater;
    }

    @WrapOperation(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;onGround()Z", ordinal = 2))
    private boolean deeperdarker$cancelJump(LivingEntity instance, Operation<Boolean> original) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (((EntityInAcid) this).deeperdarker$isInAcid() && entity.getFluidHeight(DDTags.Fluids.ACID) > entity.getFluidJumpThreshold()) return false;
        return original.call(instance);
    }

    @WrapOperation(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInLava()Z", ordinal = 0))
    private boolean deeperdarker$acidTravel(LivingEntity instance, Operation<Boolean> original, @Local(argsOnly = true) Vec3 vec3, @Local double d, @Local boolean bl, @Local FluidState state) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (((EntityInAcid) this).deeperdarker$isInAcid() && isAffectedByFluids() && !entity.canStandOnFluid(state)) {
            Vec3 vec34;
            double e = entity.getY();
            entity.moveRelative(0.02f, vec3);
            entity.move(MoverType.SELF, entity.getDeltaMovement());
            if (entity.getFluidHeight(DDTags.Fluids.ACID) <= entity.getFluidJumpThreshold()) {
                entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.6, 0.9, 0.6));
                vec34 = entity.getFluidFallingAdjustedMovement(d, bl, entity.getDeltaMovement());
                entity.setDeltaMovement(vec34);
            } else {
                entity.setDeltaMovement(entity.getDeltaMovement().scale(0.5));
            }
            if (!entity.isNoGravity()) {
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, -d / 4.0, 0.0));
            }
            vec34 = entity.getDeltaMovement();
            if (entity.horizontalCollision && entity.isFree(vec34.x, vec34.y + (double)0.6f - entity.getY() + e, vec34.z)) {
                entity.setDeltaMovement(vec34.x, 0.3f, vec34.z);
            }
            return true;
        }
        return original.call(instance);
    }

    @Inject(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getY()D", ordinal = 2), cancellable = true)
    private void deeperdarker$cancelLavaTravel(Vec3 vec3, CallbackInfo ci, @Local FluidState state) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (((EntityInAcid) this).deeperdarker$isInAcid() && isAffectedByFluids() && !entity.canStandOnFluid(state)) {
            ci.cancel();
        }
    }
}
