package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ScavengerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ScavengerModel extends AnimatedGeoModel<ScavengerEntity> {
    @Override
    public ResourceLocation getModelResource(ScavengerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/scavenger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScavengerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/scavenger.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScavengerEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/scavenger.animation.json");
    }

    @Override
    public void setCustomAnimations(ScavengerEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("Glare");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
