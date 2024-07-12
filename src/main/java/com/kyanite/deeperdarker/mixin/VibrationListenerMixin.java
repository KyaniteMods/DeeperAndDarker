package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Holder;
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
    public void deeperdarker_handleGameEvent(ServerLevel level, Holder<GameEvent> gameEvent, GameEvent.Context context, Vec3 pos, CallbackInfoReturnable<Boolean> cir) {
        if(context.sourceEntity() instanceof LivingEntity entity) {
            if(entity.getType().is(DDTags.Misc.SCULK)) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY)) cir.setReturnValue(false);
            if(entity.getItemBySlot(EquipmentSlot.CHEST).is(DDTags.Items.DAMPENS_VIBRATIONS) && gameEvent.is(DDTags.Misc.CHEST_VIBRATIONS)) cir.setReturnValue(false);
            if(entity.getItemBySlot(EquipmentSlot.FEET).is(DDTags.Items.DAMPENS_VIBRATIONS) && gameEvent.is(DDTags.Misc.FEET_VIBRATIONS)) cir.setReturnValue(false);
        }
    }
}
