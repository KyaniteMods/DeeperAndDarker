package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.DDMobType;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Phantom.class)
public class PhantomMixin extends FlyingMob {
    public PhantomMixin(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @ModifyReturnValue(method = "getMobType", at = @At("RETURN"))
    public @NotNull MobType deeperdarker$phantomMobType(MobType original) {
        return this.level().dimension() == OthersideDimension.OTHERSIDE_LEVEL ? DDMobType.SCULK : original;
    }
}
