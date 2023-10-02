package com.kyanite.deeperdarker.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Phantom.class)
public class PhantomMixin extends FlyingMob {
    public PhantomMixin(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public @NotNull MobType getMobType() {
        return MobType.UNDEAD;
        //return this.level.dimension() == OthersideDimension.OTHERSIDE_LEVEL ? DDMobType.SCULK : MobType.UNDEAD;
    }
}
