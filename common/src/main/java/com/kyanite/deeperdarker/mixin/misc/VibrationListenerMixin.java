package com.kyanite.deeperdarker.mixin.misc;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.effects.DDEffects;
import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(VibrationSystem.Listener.class)
public class VibrationListenerMixin {
    @Shadow
    @Nullable
    protected VibrationSystem.Listener system;

    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void handle(ServerLevel level, GameEvent.Context message, CallbackInfoReturnable<? super Boolean> cir) {
        if(message.sourceEntity() instanceof LivingEntity entity && message.equals(GameEvent.STEP) && entity.getItemBySlot(EquipmentSlot.FEET).getItem().equals(DDItems.WARDEN_BOOTS.get())) cir.setReturnValue(false);
        if(message.sourceEntity() instanceof LivingEntity entity && entity.hasEffect(DDEffects.SCULK_AFFINITY.get())) cir.setReturnValue(false);
        if(message.sourceEntity() instanceof LivingEntity entity && entity.getType().is(DDTags.Entities.SCULK)) cir.setReturnValue(false);
        if(system != null || message.sourceEntity() == null || message == null) cir.setReturnValue(false);
    }
}
