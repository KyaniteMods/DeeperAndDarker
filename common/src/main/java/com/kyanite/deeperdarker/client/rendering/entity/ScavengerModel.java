package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ScavengerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ScavengerModel extends GeoModel<ScavengerEntity> {
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
    public void setCustomAnimations(ScavengerEntity animatable, long instanceId, AnimationState<ScavengerEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        GeoBone head = getBone("Glare").get();
        head.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        head.setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));
    }
}
