package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow public abstract boolean isCreative();

    @Shadow @Final private Inventory inventory;

    public PlayerMixin(EntityType<?> entityType, Level level) {
        super((EntityType<? extends LivingEntity>) entityType, level);
    }

    // This mixin adds darkness to the player when they are in the dimension.

    @Inject(method = "tick", at = @At("TAIL"))
    public void player_tickTail(CallbackInfo ci) {
        if(!this.level.isClientSide) {
            if(this.level.dimension() == DDDimensions.OTHERSIDE_LEVEL) {
                if(!this.inventory.getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get()) && !this.isCreative() && !this.isSpectator()) {
                    this.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 25, 0));
                }
            }
        }
    }
}
