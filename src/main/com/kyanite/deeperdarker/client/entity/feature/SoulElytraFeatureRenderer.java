package com.kyanite.deeperdarker.client.entity.feature;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.items.DeeperDarkerItems;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class SoulElytraFeatureRenderer<E extends LivingEntity, M extends EntityModel<E>> extends ElytraFeatureRenderer<E, M> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/soul_elytra.png");
    private final ElytraEntityModel<E> model;

    public SoulElytraFeatureRenderer(FeatureRendererContext<E, M> context, EntityModelLoader loader) {
        super(context, loader);
        this.model = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int packedLight, E livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if(itemStack.isOf(DeeperDarkerItems.SOUL_ELYTRA)) {
            matrixStack.push();
            matrixStack.translate(0.0f, 0.0f, 0.125f);
            this.getContextModel().copyStateTo(this.model);
            this.model.setAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(TEXTURE), false, itemStack.hasGlint());
            this.model.render(matrixStack, vertexConsumer, packedLight, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
            matrixStack.pop();
        }
    }
}