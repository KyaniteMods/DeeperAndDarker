package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.SculkLeechEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class SculkLeechRenderer extends GeoEntityRenderer<SculkLeechEntity> {
    public SculkLeechRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SculkLeechModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(SculkLeechEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
