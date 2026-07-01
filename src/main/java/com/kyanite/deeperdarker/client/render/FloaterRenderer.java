package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.BubbloxModel;
import com.kyanite.deeperdarker.client.model.FloaterModel;
import com.kyanite.deeperdarker.content.entities.Bubblox;
import com.kyanite.deeperdarker.content.entities.Floater;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class FloaterRenderer<T extends Floater> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/floater.png");
    private final EntityModel<T> model;

    public FloaterRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new FloaterModel<>(context.bakeLayer(DDModelLayers.FLOATER));
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) {
        return 15;
    }

    @Override
    public void render(T entity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        super.render(entity, f, g, poseStack, multiBufferSource, i);
        poseStack.pushPose();
        poseStack.translate(0.0f, entity.getBbHeight() / 2.0f, 0.0f);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        model.setupAnim(entity, g, 0.0f, 0.0f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(model.renderType(getTextureLocation(entity)));
        model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
    }
}
