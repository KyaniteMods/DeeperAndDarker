package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkCentipedeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CentipedeRenderer extends GeoEntityRenderer<SculkCentipedeEntity> {
    public CentipedeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CentipedeModel());
        this.addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(SculkCentipedeEntity entity) {
        // TODO: Gloom Variant? via entity.getType?
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_centipede.png");
    }
}
