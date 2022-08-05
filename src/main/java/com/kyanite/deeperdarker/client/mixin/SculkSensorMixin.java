package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.items.DDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.SculkSensorBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkSensorBlockEntity.class)
public class SculkSensorMixin {
    @Inject(method = "onSignalReceive", at = @At("HEAD"), cancellable = true)
    public void onSignalReceive(ServerLevel p_222803_, GameEventListener p_222804_, BlockPos p_222805_, GameEvent p_222806_, Entity p_222807_, Entity p_222808_, float p_222809_, CallbackInfo ci) {
        if(p_222807_ instanceof Player plr && p_222806_.equals(GameEvent.STEP)) {
            if(plr.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).is(DDItems.WARDEN_BOOTS.get())) {
                ci.cancel();
            }
        }
    }
}
