package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.class)
public class VibrationListenerMixin {
    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void handleGameEvent(ServerLevel level, GameEvent.Message message, CallbackInfoReturnable<? super Boolean> cir) {
        if(message.context().sourceEntity() instanceof LivingEntity entity) {
            if((message.gameEvent().equals(GameEvent.STEP) || message.gameEvent().equals(GameEvent.HIT_GROUND) || message.gameEvent().equals(GameEvent.SWIM) || message.gameEvent().equals(GameEvent.SPLASH)) && hasArmorThatDampensVibrations(entity)) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY)) cir.setReturnValue(false);
            if(entity.getMobType().equals(DDMobType.SCULK)) cir.setReturnValue(false);
        }
    }

    private boolean hasArmorThatDampensVibrations(LivingEntity entity) {
        for (ItemStack itemStack : entity.getArmorSlots()) {
            if (itemStack.is(DDTags.Items.DAMPENS_VIBRATIONS)) {
                return true;
            }
        }
        return false;
    }
}
