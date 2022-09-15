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
    public void onSignalReceive(ServerLevel level, GameEventListener listener, BlockPos pos, GameEvent gameEvent, Entity entity1, Entity entity2, float f, CallbackInfo ci) {
        if(entity1 instanceof Player player && gameEvent.equals(GameEvent.STEP)) {
            if(player.getInventory().getArmor(EquipmentSlot.FEET.getIndex()).is(DDItems.WARDEN_BOOTS)) {
                ci.cancel();
            }
        }
    }
}
