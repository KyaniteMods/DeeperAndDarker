package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.layer.LayerGlowingAreasGeo;

public class StalkerRenderer extends GeoEntityRenderer<StalkerEntity> {
    public StalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StalkerModel());
        this.addLayer(new LayerGlowingAreasGeo<>(this, getGeoModelProvider()::getTextureResource, getGeoModelProvider()::getModelResource, RenderType::entityTranslucentEmissive));
    }

    public ResourceLocation getTextureLocation(StalkerEntity entity) {
        return this.getGeoModelProvider().getTextureResource(entity);
    }

    @Override
    public RenderType getRenderType(StalkerEntity animatable, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(1, 1, 1);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
