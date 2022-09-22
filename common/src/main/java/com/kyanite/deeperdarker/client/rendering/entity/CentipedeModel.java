package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkCentipedeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CentipedeModel extends AnimatedGeoModel<SculkCentipedeEntity> {
    @Override
    public ResourceLocation getModelResource(SculkCentipedeEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/sculk_centipede.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkCentipedeEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_centipede.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkCentipedeEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/sculk_centipede.animation.json");
    }

    @Override
    public void setLivingAnimations(SculkCentipedeEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        getBone("Head").setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        getBone("Head").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        getBone("Seg2").setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        getBone("Seg2").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        getBone("Seg5").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
