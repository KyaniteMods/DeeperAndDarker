package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.EchoerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EchoerModel extends GeoModel<EchoerEntity> {
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
    public void setCustomAnimations(EchoerEntity animatable, long instanceId, AnimationState<EchoerEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        GeoBone head = getBone("head").get();
        head.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        head.setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));
    }
}
