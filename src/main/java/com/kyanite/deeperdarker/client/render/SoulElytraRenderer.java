package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("NullableProblems")
public class SoulElytraRenderer<E extends LivingEntity, M extends EntityModel<E>> extends ElytraLayer<E, M> {
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/soul_elytra.png");
    private final ElytraModel<E> model;

    public SoulElytraRenderer(RenderLayerParent<E, M> renderer, EntityModelSet modelSet) {
        super(renderer, modelSet);
        this.model = new ElytraModel<>(modelSet.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, E livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if(itemStack.is(DDItems.SOUL_ELYTRA.get())) {
            poseStack.pushPose();
            poseStack.translate(0, 0, 0.125f);
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(TEXTURE), false);
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
