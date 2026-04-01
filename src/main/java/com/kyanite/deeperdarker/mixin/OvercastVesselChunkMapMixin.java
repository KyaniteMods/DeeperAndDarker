package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChunkMap.class)
public abstract class OvercastVesselChunkMapMixin {
    @Inject(method = "addEntity(Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$overcastVesselPartEarlyReturn(Entity entity, CallbackInfo ci) {
        if (entity instanceof OvercastVesselPart) {
            ci.cancel();
        }
    }
}
