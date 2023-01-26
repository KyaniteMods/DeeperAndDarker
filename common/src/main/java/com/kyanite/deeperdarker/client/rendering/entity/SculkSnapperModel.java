package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setCustomAnimations(SculkSnapperEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("Head");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
