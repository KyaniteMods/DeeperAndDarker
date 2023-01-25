package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.OvercasterEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
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
    public void setLivingAnimations(OvercasterEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("Head");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
