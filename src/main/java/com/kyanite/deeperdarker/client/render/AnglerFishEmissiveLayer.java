package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.entities.AnglerFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class AnglerFishEmissiveLayer<T extends AnglerFish, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final ResourceLocation texture;

    public AnglerFishEmissiveLayer(RenderLayerParent<T, M> renderLayerParent, ResourceLocation texture) {
        super(renderLayerParent);
        this.texture = texture;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityTranslucentEmissive(this.texture));
        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, i, LivingEntityRenderer.getOverlayCoords(entity, 0.0f), 0xFFFFFFFF);

    }
}
