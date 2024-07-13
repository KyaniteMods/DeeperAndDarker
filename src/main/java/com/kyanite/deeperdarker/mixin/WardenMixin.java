package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Warden.class)
public class WardenMixin extends Monster {
    public WardenMixin(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "canTargetEntity", at = @At("HEAD"), cancellable = true)
    public void canTargetEntity(Entity target, CallbackInfoReturnable<Boolean> cir) {
        if(target instanceof LivingEntity entity && entity.getType().is(DDTags.Misc.SCULK)) cir.setReturnValue(false);
    }
}
