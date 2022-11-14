package com.kyanite.deeperdarker.fabric.mixin;

import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerTickMixin {
    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    public void tick(CallbackInfo ci) {
        Player plr = (Player) (Object) this;
        if(!plr.level.isClientSide()) {
            if(plr.getLevel().dimension() == DDDimensions.OTHERSIDE_LEVEL) {
                if(!plr.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !plr.isCreative() && !plr.isSpectator()) {
                    plr.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, 0));
                }
            }
        }
    }
}
