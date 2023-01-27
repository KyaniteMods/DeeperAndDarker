package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.EchoerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EchoerModel extends AnimatedGeoModel<EchoerEntity> {
    @Override
    public ResourceLocation getModelResource(EchoerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/echoer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EchoerEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/echoer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EchoerEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/echoer.animations.json");
    }

    @Override
    public void setLivingAnimations(EchoerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("head");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
