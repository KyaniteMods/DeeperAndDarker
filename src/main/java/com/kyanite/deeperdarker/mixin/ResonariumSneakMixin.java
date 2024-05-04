package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.warden.Sniffing;
import net.minecraft.world.entity.monster.warden.Warden;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sniffing.class)
public class ResonariumSneakMixin {
    @Inject(method = "method_42159", at = @At(value = "HEAD"), cancellable = true)
    private static void deeperdarker$doNotDetectResonarium(Warden warden, LivingEntity livingEntity, CallbackInfo ci) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (!slot.isArmor()) continue;
            if (!livingEntity.getItemBySlot(slot).is(DDTags.Items.AVOIDS_SNIFFING)) {
                return;
            }
        }
        ci.cancel();
    }
}
