package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.IcicleShard;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class IcicleShardRenderer extends EntityRenderer<IcicleShard> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/icicle_shard.png");

    public IcicleShardRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(IcicleShard entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        poseStack.pushPose();
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
        poseStack.translate(-0.5f, -0.5f, -0.5f);
        renderFlatFace(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), 0xFFFFFFFF, 0.0f, 0.0f, 8.0f, 16, 16, 0, 0, 16, 16, light, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);
    }

    private static void renderFlatFace(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float x, float y, float z, float width, float height, float u, float v, int spriteWidth, int spriteHeight, int light, int overlay) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        float x1 = x / 16.0f;
        float y1 = y / 16.0f;
        float z1 = z / 16.0f;

        float x2 = x1 + width / 16.0f;
        float y2 = y1 + height / 16.0f;

        float v1 = v + height / spriteHeight;

        float u2n = u + width / spriteWidth;

        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z1, u2n, u, v1, v, light, overlay);
    }

    private static void renderQuad(Matrix4f pose, Matrix3f normal, VertexConsumer vertexConsumer, int color, float y2, float y1, float x1, float z1, float x2, float z2, float u2, float u1, float v1, float v2, int light, int overlay) {
        addVertex(pose, normal, vertexConsumer, color, y1, x1, z1, u1, v1, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y2, x1, z1, u1, v2, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y2, x2, z2, u2, v2, light, overlay);
        addVertex(pose, normal, vertexConsumer, color, y1, x2, z2, u2, v1, light, overlay);
    }

    private static void addVertex(Matrix4f pose, Matrix3f normal, VertexConsumer vertexConsumer, int color, float y, float x, float z, float u, float v, int light, int overlay) {
        vertexConsumer.vertex(pose, x, y, z).color(color >>> 16 & 0xFF, (color >>> 8) & 0xFF, color & 0xFF, (color >>> 24) & 0xFF).uv(u, v).overlayCoords(overlay).uv2(light).normal(normal, 0.0f, 1.0f, 0.0f).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(IcicleShard entity) {
        return TEXTURE;
    }
}
