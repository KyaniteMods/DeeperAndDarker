package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.Vibrations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Vibrations.VibrationListener.class)
public abstract class WardenBootsOccludeVibrationsMixin {
    @Inject(method = "listen(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/event/GameEvent;Lnet/minecraft/world/event/GameEvent$Emitter;Lnet/minecraft/util/math/Vec3d;)Z", at = @At("HEAD"), cancellable = true)
    private void listen(ServerWorld world, GameEvent event, GameEvent.Emitter emitter, Vec3d emitterPos,
                        CallbackInfoReturnable<Boolean> cir) {
        if (emitter.sourceEntity() instanceof LivingEntity livingEntity) {
            if ((event.equals(GameEvent.STEP) || event.equals(GameEvent.HIT_GROUND) || event.equals(GameEvent.SWIM) || event.equals(GameEvent.SPLASH)) && livingEntity.getEquippedStack(
                    EquipmentSlot.FEET).isOf(DeeperDarkerItems.WARDEN_BOOTS)) {
                cir.setReturnValue(false);
            }
        }
    }
}
