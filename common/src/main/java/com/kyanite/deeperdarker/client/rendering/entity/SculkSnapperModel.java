package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SculkSnapperModel extends GeoModel<SculkSnapperEntity> {
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
    public void setCustomAnimations(SculkSnapperEntity animatable, long instanceId, AnimationState<SculkSnapperEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        GeoBone head = getBone("Head").get();
        head.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        head.setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));
    }
}
