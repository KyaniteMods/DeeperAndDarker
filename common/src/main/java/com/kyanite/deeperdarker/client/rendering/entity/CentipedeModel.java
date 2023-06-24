package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.SculkCentipedeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CentipedeModel extends GeoModel<SculkCentipedeEntity> {
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
    public void setCustomAnimations(SculkCentipedeEntity animatable, long instanceId, AnimationState<SculkCentipedeEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        EntityModelData extraData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        getBone("Head").get().setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        getBone("Head").get().setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));

        getBone("Seg2").get().setRotX(extraData.headPitch() * ((float)Math.PI / 180F));
        getBone("Seg2").get().setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));

        getBone("Seg5").get().setRotY(extraData.netHeadYaw() * ((float)Math.PI / 180F));
    }
}
