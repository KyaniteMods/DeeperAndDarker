package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.util.DDMobTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.AngerLevel;
import net.minecraft.world.entity.monster.warden.AngerManagement;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.warden.WardenAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(Warden.class)
public abstract class WardenMixin extends Monster {
    @Shadow
    public abstract Brain<Warden> getBrain();

    @Shadow
    public abstract AngerLevel getAngerLevel();

    @Shadow
    private AngerManagement angerManagement;

    @Shadow public abstract Optional<LivingEntity> getEntityAngryAt();

    @Shadow public abstract AngerManagement getAngerManagement();

    @Shadow public abstract boolean canTargetEntity(@Nullable Entity p_219386_);

    @Shadow protected abstract void playListeningSound();

    @Shadow protected abstract int getActiveAnger();

    public WardenMixin(EntityType<Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "canTargetEntity", at = @At("HEAD"), cancellable = true)
    public void canTarget(Entity p_219386_, CallbackInfoReturnable<Boolean> cir) {
        if(p_219386_ instanceof Player) {
            Player plr = (Player) p_219386_;
            if(plr.getInventory().getArmor(EquipmentSlot.CHEST.getIndex()).is(DDItems.WARDEN_CHESTPLATE.get())) {
                if(getActiveAnger() != 0) return;

                cir.setReturnValue(false);
            }
        }
    }
    @Inject(method = "increaseAngerAt(Lnet/minecraft/world/entity/Entity;IZ)V",  at = @At("HEAD"), cancellable = true)
    public void increaseAngerAt(Entity p_219388_, int p_219389_, boolean p_219390_, CallbackInfo ci) {
        ci.cancel();
        if (!this.isNoAi()) {
            WardenAi.setDigCooldown(this);
            boolean flag = !(this.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse((LivingEntity)null) instanceof Player);
            int i = this.angerManagement.increaseAnger(p_219388_, p_219389_);
            if (p_219388_ instanceof Player && flag && AngerLevel.byAnger(i).isAngry()) {
                this.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
            }

            if (p_219390_) {
                this.playListeningSound();
            }
        }
    }
    @Override
    public MobType getMobType() {
        return DDMobTypes.SCULK;
    }

    @Inject(method = "createAttributes", at = @At("RETURN"), cancellable = true)
    private static void createAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        cir.setReturnValue(Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 350).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_KNOCKBACK, 1.5D).add(Attributes.ATTACK_DAMAGE, 15));
    }
}