package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
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
    public void setLivingAnimations(StalkerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        IBone fakeVase = this.getBone("FakeVase");
        IBone vase = this.getBone("Vase");
        IBone upperBody = this.getBone("Body");
        IBone head = this.getBone("Head");

        fakeVase.setHidden(entity.getCurrentState() != StalkerEntity.EMERGE);
        vase.setHidden(!entity.hasVase());

        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        upperBody.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
    }
}