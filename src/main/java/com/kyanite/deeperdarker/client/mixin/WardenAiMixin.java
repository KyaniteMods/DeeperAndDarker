package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.warden.WardenAi;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WardenAi.class)
public class WardenAiMixin {
    @Inject(method = "isTarget", at = @At("HEAD"), cancellable = true)
    private static void isTarget(Warden warden, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if(entity instanceof Player player) {
            if(player.isCreative()) return;

            if(player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get())) {
                cir.setReturnValue(false);
            }
        }
    }
}
