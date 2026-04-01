package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import net.minecraft.util.AbortableIterationConsumer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Predicate;

@Mixin(Level.class)
public class OvercastVesselLevelMixin {
    @Inject(method = "method_31593", at = @At("HEAD"))
    private static void deeperdarker$getOvercastVesselParts1(Entity entity, Predicate<? super Entity> predicate, List<Entity> list, Entity entity2, CallbackInfo ci) {
        if (entity2 instanceof OvercastVessel vessel) {
            for (OvercastVesselPart part : vessel.getSubEntities()) {
                if (entity2 == entity || !predicate.test(part)) continue;
                list.add(part);
            }
        }
    }

    @Inject(method = "method_47576", at = @At(value = "RETURN", ordinal = 2), cancellable = true)
    private static void deeperdarker$getOvercastVesselParts2(Predicate predicate, List list, int i, EntityTypeTest<Entity, ?> entityTypeTest, Entity entity, CallbackInfoReturnable<AbortableIterationConsumer.Continuation> cir) {
        if (entity instanceof OvercastVessel vessel) {
            for (OvercastVesselPart part : vessel.getSubEntities()) {
                Entity entity2 = entityTypeTest.tryCast(part);
                if (entity2 == null || !predicate.test(entity2)) continue;
                list.add(entity2);
                if (list.size() < i) continue;
                cir.setReturnValue(AbortableIterationConsumer.Continuation.ABORT);
            }
        }
    }
}
