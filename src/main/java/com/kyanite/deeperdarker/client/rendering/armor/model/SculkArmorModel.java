package com.kyanite.deeperdarker.client.rendering.armor.model;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.SculkArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SculkArmorModel extends AnimatedGeoModel<SculkArmorItem> {

    @Override
    public ResourceLocation getModelResource(SculkArmorItem object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/sculk_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkArmorItem object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/models/armor/sculk_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkArmorItem animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/sculk_armor_animations.json");
    }
}