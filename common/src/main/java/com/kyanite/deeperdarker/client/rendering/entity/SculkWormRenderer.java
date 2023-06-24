package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class SculkWormRenderer extends GeoEntityRenderer<SculkWormEntity> {
    public SculkWormRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SculkWormModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(SculkWormEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
