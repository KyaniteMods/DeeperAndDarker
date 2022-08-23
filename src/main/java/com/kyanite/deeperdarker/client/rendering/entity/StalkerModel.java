package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import com.kyanite.deeperdarker.registry.entities.custom.StalkerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

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
    public void setLivingAnimations(StalkerEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        this.getBone("FakeVase").setHidden(entity.getCurrentState() == StalkerEntity.EMERGE ? false : true);
        if(entity.getTarget() != null) {
            this.getBone("Head").setRotationX(entity.getRandom().nextInt(0, 365));
        }
    }
}
