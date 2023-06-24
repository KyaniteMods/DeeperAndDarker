package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ShatteredRenderer extends GeoEntityRenderer<ShatteredEntity> {
    public ShatteredRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShatteredModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(ShatteredEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
