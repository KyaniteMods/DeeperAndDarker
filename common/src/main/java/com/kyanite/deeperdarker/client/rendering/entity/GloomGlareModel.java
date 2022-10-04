package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.GloomGlareEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkSnapperEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GloomGlareModel extends AnimatedGeoModel<GloomGlareEntity> {
    @Override
    public ResourceLocation getModelResource(GloomGlareEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/glare.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GloomGlareEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/glare.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GloomGlareEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/glare.animation.json");
    }

    @Override
    public void setLivingAnimations(GloomGlareEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        IBone head = getBone("Glare");
        head.setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
