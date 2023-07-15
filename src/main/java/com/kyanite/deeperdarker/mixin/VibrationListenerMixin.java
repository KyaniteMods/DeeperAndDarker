package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationSystem.Listener.class)
public class VibrationListenerMixin {
    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void handleGameEvent(ServerLevel level, GameEvent event, GameEvent.Context context, Vec3 vec3, CallbackInfoReturnable<? super Boolean> cir) {
        if(context.sourceEntity() instanceof LivingEntity entity) {
            if((event.equals(GameEvent.STEP) || event.equals(GameEvent.HIT_GROUND) || event.equals(GameEvent.SWIM) || event.equals(GameEvent.SPLASH)) && entity.getItemBySlot(EquipmentSlot.FEET).is(DDItems.WARDEN_BOOTS.get())) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY.get())) cir.setReturnValue(false);
            if(entity.getMobType().equals(DDMobType.SCULK)) cir.setReturnValue(false);
        }
    }
}
