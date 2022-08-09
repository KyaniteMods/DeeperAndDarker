package com.kyanite.deeperdarker.client.mixin;

import com.kyanite.deeperdarker.miscellaneous.DDMobTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Phantom.class)
public class PhantomMixin extends FlyingMob {

    protected PhantomMixin(EntityType<? extends FlyingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public MobType getMobType() {
        return DDMobTypes.SCULK;
    }
}
