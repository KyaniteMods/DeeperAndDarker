package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class StalkerModel extends AnimatedGeoModel<StalkerEntity> {
    @Override
    public ResourceLocation getModelResource(StalkerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/stalker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StalkerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/stalker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StalkerEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/stalker.animation.json");
    }

    @Override
    public void setCustomAnimations(StalkerEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        IBone fakeVase = this.getBone("FakeVase");
        IBone vase = this.getBone("Vase");
        IBone upperBody = this.getBone("Body");
        IBone head = this.getBone("Head");

        fakeVase.setHidden(animatable.getCurrentState() != StalkerEntity.EMERGE);
        vase.setHidden(!animatable.hasVase());

        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        upperBody.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
    }
}
