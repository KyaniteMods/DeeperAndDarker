package com.kyanite.deeperdarker.forge.client.warden_armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib3.util.GeoUtils;

public class WardenArmorRenderer extends GeoArmorRenderer<WardenArmorItem> {
    public WardenArmorRenderer() {
        super(new WardenArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(WardenArmorItem instance) {
        return getGeoModel().getTextureResource(instance);
    }

    @Override
    public void fitToBiped() {
        super.fitToBiped();
        GeoBone bodyBone = this.getGeoModel().getBone("armorWaist").get();
        GeoUtils.copyRotations(body, bodyBone);
        bodyBone.setPosX(body.x);
        bodyBone.setPosY(-body.y);
        bodyBone.setPosZ(body.z);
    }

    @Override
    public void actuallyRender(PoseStack poseStack, WardenArmorItem animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        setBoneVisible(getGeoModel().getBone("armorWaist").get(), false);
        getGeoModel().getBone("armorWaist").get().setHidden(currentSlot != EquipmentSlot.LEGS);
    }
}
