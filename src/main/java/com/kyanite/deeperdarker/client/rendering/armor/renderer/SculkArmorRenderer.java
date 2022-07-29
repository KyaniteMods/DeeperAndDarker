package com.kyanite.deeperdarker.client.rendering.armor.renderer;

import com.kyanite.deeperdarker.client.rendering.armor.model.SculkArmorModel;
import com.kyanite.deeperdarker.registry.items.SculkArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SculkArmorRenderer extends GeoArmorRenderer<SculkArmorItem> {
    public SculkArmorRenderer() {
        super(new SculkArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
