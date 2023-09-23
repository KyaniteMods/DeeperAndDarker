package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.class)
public class VibrationListenerMixin {
    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void handleGameEvent(ServerLevel level, GameEvent.Message message, CallbackInfoReturnable<Boolean> cir) {
        if(message.context().sourceEntity() instanceof LivingEntity entity) {
            if(entity.getMobType().equals(DDMobType.SCULK)) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY.get())) cir.setReturnValue(false);
            if(entity.getItemBySlot(EquipmentSlot.FEET).is(DDTags.Items.DAMPENS_VIBRATIONS) && (message.gameEvent().equals(GameEvent.STEP) || message.gameEvent().equals(GameEvent.HIT_GROUND) || message.gameEvent().equals(GameEvent.SWIM) || message.gameEvent().equals(GameEvent.SPLASH))) cir.setReturnValue(false);
            if(entity.getItemBySlot(EquipmentSlot.CHEST).is(DDTags.Items.DAMPENS_VIBRATIONS) && (message.gameEvent().equals(GameEvent.BLOCK_PLACE) || message.gameEvent().equals(GameEvent.BLOCK_DESTROY) || message.gameEvent().equals(GameEvent.BLOCK_OPEN) || message.gameEvent().equals(GameEvent.BLOCK_CLOSE) || message.gameEvent().equals(GameEvent.CONTAINER_OPEN) || message.gameEvent().equals(GameEvent.CONTAINER_CLOSE) || message.gameEvent().equals(GameEvent.BLOCK_ACTIVATE))) cir.setReturnValue(false);
        }
    }
}
