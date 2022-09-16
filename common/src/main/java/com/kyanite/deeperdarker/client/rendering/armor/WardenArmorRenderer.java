package com.kyanite.deeperdarker.client.rendering.armor;

import com.kyanite.deeperdarker.registry.items.custom.WardenArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WardenArmorRenderer extends GeoArmorRenderer<WardenArmorItem> {
    public WardenArmorRenderer() {
        super(new WardenArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}