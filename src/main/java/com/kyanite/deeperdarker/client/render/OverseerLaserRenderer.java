package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.entities.overseer.OverseerLaser;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class OverseerLaserRenderer<T extends OverseerLaser> extends EntityRenderer<T> {
    public OverseerLaserRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(T entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

    @Override
    public void render(T entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);

        float scale = Mth.lerp(tickDelta, entity.oldDespawnTime, entity.getDespawnTime()) / (float) OverseerLaser.MAX_DESPAWN_TIME;

        poseStack.pushPose();
        poseStack.scale(scale, 1.0f, scale);

        final BlockPos.MutableBlockPos mutableBlockPos = entity.blockPosition().mutable();
        DarkFountainBlockRenderer.renderFountainBeam(poseStack, multiBufferSource, entity.position(), entityRenderDispatcher.camera.getPosition(), entity.level().getGameTime(), tickDelta, offsetY ->
                LevelRenderer.getLightColor(entity.level(), mutableBlockPos.setY(entity.blockPosition().getY() + offsetY)), OverlayTexture.NO_OVERLAY, 0xFFFFFFFF, 256, 256);
        poseStack.popPose();

        entity.oldDespawnTime = entity.getDespawnTime();
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double d, double e, double f) {
        return true;
    }
}
