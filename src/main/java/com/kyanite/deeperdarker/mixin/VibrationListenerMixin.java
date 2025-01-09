package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDEffects;
import com.kyanite.deeperdarker.content.DDPoiTypes;
import com.kyanite.deeperdarker.content.entities.DDMobType;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
    public void handleGameEvent(ServerLevel level, GameEvent event, GameEvent.Context context, Vec3 vec3, CallbackInfoReturnable<Boolean> cir) {
        if(context.sourceEntity() instanceof LivingEntity entity) {
            if(event.is(DDTags.GameEvents.FEET_VIBRATIONS) && hasArmorThatDampensVibrations(entity)) cir.setReturnValue(false);
            if(entity.hasEffect(DDEffects.SCULK_AFFINITY)) cir.setReturnValue(false);
            if(entity.getMobType().equals(DDMobType.SCULK)) cir.setReturnValue(false);
        }
    }

    @Inject(method = "isOccluded", at = @At("RETURN"), cancellable = true)
    private static void deeperdarker$occludeByNoiseCanceler(Level level, Vec3 vec3, Vec3 vec32, CallbackInfoReturnable<Boolean> cir) {
        if (level.isClientSide()) return;
        if (((ServerLevel) level).getPoiManager().findClosestWithType(holder -> holder.value() == DDPoiTypes.NOISE_CANCELER, new BlockPos((int) vec3.x(), (int) vec3.y(), (int) vec3.z()), DeeperDarker.CONFIG.server.noiseCancelerRadius(), PoiManager.Occupancy.ANY).isPresent()) cir.setReturnValue(true);
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
