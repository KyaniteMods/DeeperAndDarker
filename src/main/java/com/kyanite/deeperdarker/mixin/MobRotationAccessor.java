package com.kyanite.deeperdarker.mixin;

import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Mob.class)
public interface MobRotationAccessor {
    @Invoker("rotlerp")
    float deeperdarker$rotlerpAccessor(float f, float g, float h);
}
