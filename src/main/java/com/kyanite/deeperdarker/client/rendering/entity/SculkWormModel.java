package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkWormEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SculkWormModel extends AnimatedGeoModel<SculkWormEntity> {
    @Override
    public ResourceLocation getModelResource(SculkWormEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/sculk_worm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkWormEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_worm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkWormEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/sculk_worm.animations.json");
    }
}