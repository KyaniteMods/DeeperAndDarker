package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public abstract class RenderOvercastVesselHitboxMixin {
    @Inject(method = "renderHitbox", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;renderLineBox(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/world/phys/AABB;FFFF)V", ordinal = 0))
    private static void deeperdarker$renderOvercastVesselPartHitbox(PoseStack poseStack, VertexConsumer vertexConsumer, Entity entity, float f, CallbackInfo ci) {
        if (entity instanceof OvercastVessel overcastVessel) {
            double entityX = -Mth.lerp(f, entity.xOld, entity.getX());
            double entityY = -Mth.lerp(f, entity.yOld, entity.getY());
            double entityZ = -Mth.lerp(f, entity.zOld, entity.getZ());
            for (OvercastVesselPart part : overcastVessel.getSubEntities()) {
                poseStack.pushPose();
                double partX = entityX + Mth.lerp(f, part.xOld, part.getX());
                double partY = entityY + Mth.lerp(f, part.yOld, part.getY());
                double partZ = entityZ + Mth.lerp(f, part.zOld, part.getZ());
                poseStack.translate(partX, partY, partZ);
                LevelRenderer.renderLineBox(poseStack, vertexConsumer, part.getBoundingBox().move(-part.getX(), -part.getY(), -part.getZ()), 0.25f, 1.0f, 0.0f, 1.0f);
                poseStack.popPose();
            }
        }
    }
}
