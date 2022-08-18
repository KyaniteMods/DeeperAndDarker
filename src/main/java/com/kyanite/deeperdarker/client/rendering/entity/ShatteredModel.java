package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.ShatteredEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShatteredModel extends AnimatedGeoModel<ShatteredEntity> {
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
}
