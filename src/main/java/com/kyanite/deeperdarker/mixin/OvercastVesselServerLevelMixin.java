package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.overcastvessel.IServerLevelMap;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerLevel.class)
public abstract class OvercastVesselServerLevelMixin implements IServerLevelMap {
    @Unique
    final Int2ObjectMap<OvercastVesselPart> overcastVesselParts = new Int2ObjectOpenHashMap<>();

    @ModifyReturnValue(method = "getEntityOrPart(I)Lnet/minecraft/world/entity/Entity;", at = @At("RETURN"))
    private Entity deeperdarker$returnOvercastVesselPart(Entity original, @Local(argsOnly = true) int i) {
        return original == null ? overcastVesselParts.get(i) : original;
    }

    @Override
    public Int2ObjectMap<OvercastVesselPart> deeperdarker$getOvercastVesselParts() {
        return overcastVesselParts;
    }

    @Mixin(ServerLevel.EntityCallbacks.class)
    public static abstract class EntityCallbacksMixin {
        @WrapOperation(method = "onTrackingStart(Lnet/minecraft/world/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getChunkSource()Lnet/minecraft/server/level/ServerChunkCache;"))
        private ServerChunkCache deeperdarker$startTrackingOvercastVesselPart(ServerLevel instance, Operation<ServerChunkCache> original, @Local(argsOnly = true) Entity entity) {
            if (entity instanceof OvercastVessel vessel) {
                for (OvercastVesselPart part : vessel.getSubEntities()) {
                    ((IServerLevelMap) instance).deeperdarker$getOvercastVesselParts().put(part.getId(), part);
                }
            }
            return original.call(instance);
        }

        @WrapOperation(method = "onTrackingEnd(Lnet/minecraft/world/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getChunkSource()Lnet/minecraft/server/level/ServerChunkCache;"))
        private ServerChunkCache deeperdarker$stopTrackingOvercastVesselPart(ServerLevel instance, Operation<ServerChunkCache> original, @Local(argsOnly = true) Entity entity) {
            if (entity instanceof OvercastVessel vessel) {
                for (OvercastVesselPart part : vessel.getSubEntities()) {
                    ((IServerLevelMap) instance).deeperdarker$getOvercastVesselParts().remove(part.getId());
                }
            }
            return original.call(instance);
        }
    }
}
