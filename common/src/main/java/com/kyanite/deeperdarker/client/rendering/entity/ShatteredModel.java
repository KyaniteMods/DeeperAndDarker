package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ShatteredModel extends GeoModel<ShatteredEntity> {
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
    public void setCustomAnimations(ShatteredEntity animatable, long instanceId, AnimationState<ShatteredEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        GeoBone head = this.getBone("Head").get();
        head.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        head.setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));
    }
}
