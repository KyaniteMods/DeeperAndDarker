package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.OverseerModel;
import com.kyanite.deeperdarker.content.entities.overseer.Overseer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.Optional;

@SuppressWarnings("NullableProblems")
public class OverseerRenderer<T extends Overseer> extends MobRenderer<T, OverseerModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overseer/overseer.png");
    private static final ResourceLocation TEXTURE_PURIFYING = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overseer/overseer_purifying.png");
    private static final ResourceLocation TEXTURE_BEAM = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overseer/overseer_beam.png");
    private static final RenderType BEAM = RenderType.entitySmoothCutout(TEXTURE_BEAM);

    public OverseerRenderer(EntityRendererProvider.Context context) {
        super(context, new OverseerModel<>(context.bakeLayer(DDModelLayers.OVERSEER)), 2.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }

    @Override
    protected void setupRotations(Overseer vessel, PoseStack poseStack, float f, float g, float h) {
    }

    @Override
    public void render(T mob, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        super.render(mob, yaw, tickDelta, poseStack, multiBufferSource, i);
        Optional<GlobalPos> pos = mob.getOriginPos();
        if (pos.isPresent()) {
            poseStack.pushPose();
            float targetX = (float) pos.get().pos().getX() + 0.5f;
            float targetY = (float) pos.get().pos().getY() + 0.5f;
            float targetZ = (float) pos.get().pos().getZ() + 0.5f;
            float dx = (float) ((double) targetX - mob.getX());
            float dy = (float) ((double) targetY - mob.getY());
            float dz = (float) ((double) targetZ - mob.getZ());
            Vector3f vec3f = new Vector3f(dx, dy, dz).normalize().mul(2.0f);
            poseStack.translate(dx, dy, dz);
            renderBeams(-dx + vec3f.x(), -dy + vec3f.y() + mob.getBbHeight() / 2.0f, -dz + vec3f.z(), tickDelta, mob.tickCount, poseStack, multiBufferSource, i);
            poseStack.popPose();
        }
    }

    public static void renderBeams(float dx, float dy, float dz, float tickDelta, int tickCount, PoseStack poseStack, MultiBufferSource multiBufferSource, int k) {
        float l = Mth.sqrt(dx * dx + dz * dz);
        float m = Mth.sqrt(dx * dx + dy * dy + dz * dz);
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotation((float)(-Math.atan2(dz, dx)) - 1.5707964f));
        poseStack.mulPose(Axis.XP.rotation((float)(-Math.atan2(l, dy)) - 1.5707964f));
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(BEAM);
        float n = 0.0f - ((float)tickCount + tickDelta) * 0.01f;
        float o = Mth.sqrt(dx * dx + dy * dy + dz * dz) / 32.0f - ((float)tickCount + tickDelta) * 0.01f;
        float q = 0.0f;
        float r = 0.75f;
        float s = 0.0f;
        PoseStack.Pose pose = poseStack.last();
        Matrix4f matrix4f = pose.pose();
        Matrix3f matrix3f = pose.normal();
        for (int t = 1; t <= 8; ++t) {
            float u = Mth.sin((float)t * ((float)Math.PI * 2) / 8.0f) * 0.75f;
            float v = Mth.cos((float)t * ((float)Math.PI * 2) / 8.0f) * 0.75f;
            float w = (float)t / 8.0f;
            vertexConsumer.vertex(matrix4f, q * 0.2f, r * 0.2f, 0.0f).color(0, 0, 0, 255).uv(s, n).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(k).normal(matrix3f, 0.0f, -1.0f, 0.0f).endVertex();
            vertexConsumer.vertex(matrix4f, q, r, m).color(255, 255, 255, 255).uv(s, o).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(k).normal(matrix3f, 0.0f, -1.0f, 0.0f).endVertex();
            vertexConsumer.vertex(matrix4f, u, v, m).color(255, 255, 255, 255).uv(w, o).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(k).normal(matrix3f, 0.0f, -1.0f, 0.0f).endVertex();
            vertexConsumer.vertex(matrix4f, u * 0.2f, v * 0.2f, 0.0f).color(0, 0, 0, 255).uv(w, n).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(k).normal(matrix3f, 0.0f, -1.0f, 0.0f).endVertex();
            q = u;
            r = v;
            s = w;
        }
        poseStack.popPose();
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public boolean shouldRender(T mob, Frustum frustum, double d, double e, double f) {
        return true;
    }
}
