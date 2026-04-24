package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.OverseerCrystalModel;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystal;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fabricmc.fabric.impl.client.rendering.FabricShaderProgram;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.joml.Vector3f;

import java.io.IOException;

@SuppressWarnings("NullableProblems")
public class OverseerCrystalRenderer<T extends OverseerCrystal> extends EntityRenderer<T> {
    public static final ResourceLocation SHADER = new ResourceLocation("rendertype_deeperdarker_overseer_crystal_trail");
    public static final RenderStateShard.ShaderStateShard PROGRAM;
    static {
        PROGRAM = new RenderStateShard.ShaderStateShard(() -> {
            try {
                return new FabricShaderProgram(Minecraft.getInstance().getResourceManager(), SHADER, DefaultVertexFormat.NEW_ENTITY);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static final RenderType RENDER_LAYER = RenderType.create(
            DeeperDarker.MOD_ID + "_overseer_crystal_trail",
            DefaultVertexFormat.NEW_ENTITY,
            VertexFormat.Mode.QUADS,
            256,
            false,
            true,
            RenderType.CompositeState.builder()
                    .setShaderState(PROGRAM)
                    .setCullState(RenderStateShard.NO_CULL)
                    .setLayeringState(RenderStateShard.VIEW_OFFSET_Z_LAYERING)
                    .createCompositeState(false));

    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overseer/overseer_crystal.png");
    private final EntityModel<T> model;

    public OverseerCrystalRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new OverseerCrystalModel<>(context.bakeLayer(DDModelLayers.OVERSEER_CRYSTAL));
    }

    @Override
    public ResourceLocation getTextureLocation(OverseerCrystal entity) {
        return TEXTURE;
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public void render(T entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);
        poseStack.pushPose();
        poseStack.translate(0.0f, entity.getBbHeight() / 2.0f, 0.0f);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        model.setupAnim(entity, tickDelta, 0.0f, 0.0f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(model.renderType(getTextureLocation(entity)));
        model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
        Entity owner = entity.getOwner();
        if (owner != null) {
            poseStack.pushPose();
            float targetX = (float) entity.getX();
            float targetY = (float) entity.getY();
            float targetZ = (float) entity.getZ();
            float dx = (float) ((double) targetX - (owner.getX()));
            float dy = (float) ((double) targetY - (owner.getY() + owner.getBbHeight() / 2.0f));
            float dz = (float) ((double) targetZ - (owner.getZ()));
            Vector3f crystalDistance = new Vector3f(dx, dy, dz).normalize().mul(0.5f).add(0.0f, -entity.getBbHeight() / 2.0f, 0.0f);
            dx -= crystalDistance.x();
            dy -= crystalDistance.y();
            dz -= crystalDistance.z();
            poseStack.translate(-crystalDistance.x(), -crystalDistance.y(), -crystalDistance.z());
            Vector3f overseerDistance = new Vector3f(dx, dy, dz).normalize().mul(2.0f);
            OverseerRenderer.renderBeams(-dx + overseerDistance.x(), -dy + overseerDistance.y(), -dz + overseerDistance.z(), 0, 0, poseStack, multiBufferSource, light, RENDER_LAYER, 1.0f, 0.2f);
            poseStack.popPose();
        }
    }

    @Override
    public boolean shouldRender(T entity, Frustum frustum, double d, double e, double f) {
        return entity.getOwner() != null || super.shouldRender(entity, frustum, d, e, f);
    }
}
