package com.kyanite.deeperdarker.fabric.client.warden_armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.cache.object.GeoBone;

public class WardenArmorRenderer extends ArmorRenderer<WardenArmorItem> {
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
    public void fitToBiped() {
        super.fitToBiped();
        GeoBone bodyBone = this.getGeoModel().getBone("armorWaist").get();
//        GeoUtils.copyRotations(baseModel.body, bodyBone);
        bodyBone.setPosX(baseModel.body.x);
        bodyBone.setPosY(-baseModel.body.y);
        bodyBone.setPosZ(baseModel.body.z);
    }

    @Override
    public void render(float partialTicks, PoseStack stack, VertexConsumer bufferIn, int packedLightIn) {
        super.render(partialTicks, stack, bufferIn, packedLightIn);
        GeoBone waistBone = getAndHideBone("armorWaist");
        waistBone.setHidden(armorSlot != EquipmentSlot.LEGS);
    }
}
