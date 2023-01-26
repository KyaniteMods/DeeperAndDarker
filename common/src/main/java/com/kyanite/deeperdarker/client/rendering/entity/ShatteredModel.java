package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ShatteredModel extends AnimatedGeoModel<ShatteredEntity> {
    @Override
    public ResourceLocation getModelResource(ShatteredEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/shattered.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShatteredEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/shattered.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShatteredEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/shattered.animation.json");
    }

    @Override
    public void setCustomAnimations(ShatteredEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = this.getBone("Head");

        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
