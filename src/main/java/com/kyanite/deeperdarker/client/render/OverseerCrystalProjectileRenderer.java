package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.OverseerCrystalModel;
import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystalProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class OverseerCrystalProjectileRenderer<T extends OverseerCrystalProjectile> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = DeeperDarker.id("textures/entity/overseer/overseer_crystal.png");
    private final EntityModel<T> model;

    public OverseerCrystalProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new OverseerCrystalModel<>(context.bakeLayer(DDModelLayers.OVERSEER_CRYSTAL));
    }

    @Override
    public ResourceLocation getTextureLocation(OverseerCrystalProjectile entity) {
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
    }
}
