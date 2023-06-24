package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class StalkerRenderer extends GeoEntityRenderer<StalkerEntity> {
    public StalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StalkerModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(StalkerEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
