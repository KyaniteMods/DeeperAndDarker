    package com.kyanite.deeperdarker.fabric.client.elytra;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.items.DDItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ArmorStandArmorModel;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;

    @Environment(EnvType.CLIENT)
public class SoulElytraArmorStandLayer extends ElytraLayer<ArmorStand, ArmorStandArmorModel>  {
    private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/soul_elytra.png");
    private final ElytraModel elytraModel;

    public SoulElytraArmorStandLayer(ArmorStandRenderer rendererIn, EntityModelSet modelSet) {
        super(rendererIn, modelSet);
        this.elytraModel = new ElytraModel(modelSet.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, ArmorStand livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if(itemStack.is(DDItems.SOUL_ELYTRA.get())) {
            poseStack.pushPose();
            poseStack.translate(0.0, 0.0, 0.125);
            this.getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(multiBufferSource, RenderType.armorCutoutNoCull(TEXTURE_ELYTRA), false, itemStack.hasFoil());
            this.elytraModel.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
}
