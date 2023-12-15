package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class WardenHelmetImmunityMixin {
    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot var1);

    @Inject(method = "canBeAffected", at = @At("RETURN"), cancellable = true)
    private void canBeAffected(MobEffectInstance mobEffectInstance, CallbackInfoReturnable<Boolean> cir) {
        if (this.getItemBySlot(EquipmentSlot.HEAD).is(DDItems.WARDEN_HELMET) && (mobEffectInstance.getEffect() == MobEffects.DARKNESS || mobEffectInstance.getEffect() == MobEffects.BLINDNESS)) cir.setReturnValue(false);
    }
}
