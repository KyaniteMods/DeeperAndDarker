package com.kyanite.deeperdarker.fabric.client.warden_armor;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WardenArmorModel extends AnimatedGeoModel<WardenArmorItem> {
    @Override
    public ResourceLocation getModelResource(WardenArmorItem object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/warden_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WardenArmorItem object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/models/armor/warden_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WardenArmorItem animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/warden_armor_animations.json");
    }
}
