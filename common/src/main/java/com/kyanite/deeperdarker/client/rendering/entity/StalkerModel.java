package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class StalkerModel extends GeoModel<StalkerEntity> {
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
    public void setCustomAnimations(StalkerEntity animatable, long instanceId, AnimationState<StalkerEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);

        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        GeoBone fakeVase = this.getBone("FakeVase").get();
        GeoBone vase = this.getBone("Vase").get();
        GeoBone upperBody = this.getBone("Body").get();
        GeoBone head = this.getBone("Head").get();

        fakeVase.setHidden(animatable.getCurrentState() != StalkerEntity.EMERGE);
        vase.setHidden(!animatable.hasVase());

        head.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        head.setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));

        upperBody.setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
    }
}
