package com.kyanite.deeperdarker.client.rendering.block;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientChestModel extends AnimatedGeoModel<AncientChestEntity> {
    @Override
    public ResourceLocation getModelResource(AncientChestEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/ancient_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AncientChestEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/block/ancient_chest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AncientChestEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/ancient_chest.animation.json");
    }

    @Override
    public void setLivingAnimations(AncientChestEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        float percentage = Math.max(entity.closeTicks -62.5f, -180) * ((float)Math.PI / 365f) - 3;
       // getBone("lid").setRotationX(percentage);
      //  DeeperAndDarker.LOGGER.info(String.valueOf(percentage));
    }
}
