package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.registry.entities.custom.EchoerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class EchoerRenderer extends GeoEntityRenderer<EchoerEntity> {
    public EchoerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new EchoerModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public ResourceLocation getTextureLocation(EchoerEntity entity) {
        return this.getGeoModel().getTextureResource(entity);
    }
}
