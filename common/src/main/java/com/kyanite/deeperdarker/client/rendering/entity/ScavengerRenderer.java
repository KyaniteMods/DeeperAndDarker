package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.ScavengerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ScavengerRenderer extends GeoEntityRenderer<ScavengerEntity> {
    public ScavengerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ScavengerModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(ScavengerEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
