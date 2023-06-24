package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class SculkSnapperRenderer extends GeoEntityRenderer<SculkSnapperEntity> {
    public SculkSnapperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SculkSnapperModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(SculkSnapperEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
