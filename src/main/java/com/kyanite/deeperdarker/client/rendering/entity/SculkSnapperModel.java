package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SculkSnapperModel extends AnimatedGeoModel<SculkSnapperEntity> {
    @Override
    public ResourceLocation getModelResource(SculkSnapperEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/sculk_snapper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkSnapperEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_snapper.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkSnapperEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/sculk_snapper.animations.json");
    }
}