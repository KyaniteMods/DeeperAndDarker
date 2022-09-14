package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ShriekWormEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShriekWormModel extends AnimatedGeoModel<ShriekWormEntity> {
    @Override
    public ResourceLocation getModelResource(ShriekWormEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/shriek_worm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShriekWormEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/shriek_worm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShriekWormEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/shriek_worm.animations.json");
    }
}
