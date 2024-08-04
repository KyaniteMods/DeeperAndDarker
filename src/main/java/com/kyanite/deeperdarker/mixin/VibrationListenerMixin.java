package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationSystem.Listener.class)
public class VibrationListenerMixin {
    @Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    public void deeperdarker_handleGameEvent(ServerLevel level, Holder<GameEvent> gameEvent, GameEvent.Context context, Vec3 pos, CallbackInfoReturnable<Boolean> cir) {
        if(context.sourceEntity() instanceof LivingEntity entity) {
            if(gameEvent.is(DDTags.GameEvents.FEET_VIBRATIONS) && hasArmorThatDampensVibrations(entity)) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY)) cir.setReturnValue(false);
            if(entity.getType().is(DDTags.EntityTypes.SCULK)) cir.setReturnValue(false);
        }
    }

    @Unique
    private boolean hasArmorThatDampensVibrations(LivingEntity entity) {
        for (ItemStack itemStack : entity.getArmorSlots()) {
            if (itemStack.is(DDTags.Items.DAMPENS_VIBRATIONS)) {
                return true;
            }
        }
        return false;
    }
}
