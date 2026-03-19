package com.kyanite.deeperdarker.mixin;

import net.minecraft.world.entity.projectile.Projectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Projectile.class)
public interface ProjectileAccessor {
    @Accessor("hasBeenShot")
    void setHasBeenShot(boolean value);
}
