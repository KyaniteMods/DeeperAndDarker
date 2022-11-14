package com.kyanite.deeperdarker.forge.client.warden_armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.util.GeoUtils;

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

    @Override
    public ResourceLocation getTextureLocation(WardenArmorItem instance) {
        return getGeoModelProvider().getTextureResource(instance);
    }

    @Override
    public void fitToBiped() {
        super.fitToBiped();
        IBone bodyBone = this.getGeoModelProvider().getBone("armorWaist");
        GeoUtils.copyRotations(body, bodyBone);
        bodyBone.setPositionX(body.x);
        bodyBone.setPositionY(-body.y);
        bodyBone.setPositionZ(body.z);
    }

    @Override
    public void render(float partialTicks, PoseStack stack, VertexConsumer bufferIn, int packedLightIn) {
        super.render(partialTicks, stack, bufferIn, packedLightIn);
        IBone waistBone = getAndHideBone("armorWaist");
        waistBone.setHidden(armorSlot != EquipmentSlot.LEGS);
    }
}
