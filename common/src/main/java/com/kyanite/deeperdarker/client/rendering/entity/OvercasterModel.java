package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.OvercasterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OvercasterModel extends AnimatedGeoModel<OvercasterEntity> {
    @Override
    public ResourceLocation getModelResource(OvercasterEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/overcaster.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OvercasterEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/overcaster.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OvercasterEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/overcaster.animations.json");
    }

    @Override
    public void setCustomAnimations(OvercasterEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("Head");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
