package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.GloomGlareEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.layer.LayerGlowingAreasGeo;

public class GloomGlareRenderer extends GeoEntityRenderer<GloomGlareEntity> {
    public GloomGlareRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GloomGlareModel());
        this.addLayer(new LayerGlowingAreasGeo<>(this, getGeoModelProvider()::getTextureResource, getGeoModelProvider()::getModelResource, RenderType::entityTranslucentEmissive));
    }

    public ResourceLocation getTextureLocation(GloomGlareEntity entity) {
        return this.getGeoModelProvider().getTextureResource(entity);
    }

    @Override
    public RenderType getRenderType(GloomGlareEntity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(1f, 1f, 1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
