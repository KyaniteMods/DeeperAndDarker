package com.kyanite.deeperdarker.mixin.misc;

import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(VibrationListener.class)
public class VibrationListenerMixin {
    @Shadow
    @Nullable
    protected VibrationListener.ReceivingEvent receivingEvent;

    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void handle(ServerLevel level, GameEvent.Message message, CallbackInfoReturnable<Boolean> cir) {
        if(message.context().sourceEntity() instanceof Player player && message.gameEvent().equals(GameEvent.STEP)) {
            if(player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).is(DDItems.WARDEN_BOOTS.get())) {
                cir.cancel();
            }
        }

        if(this.receivingEvent != null || message.context().sourceEntity() == null || message.context() == null)
            return;

        if(message.context().sourceEntity() instanceof Player plr) {
            if(plr.hasEffect(DDEffects.SCULK_AFFINITY.get())) cir.setReturnValue(false);
        }
    }
}
