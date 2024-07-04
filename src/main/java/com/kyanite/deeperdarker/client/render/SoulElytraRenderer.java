package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.compat.ShowMeYourSkinCompat;
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
    private static final ResourceLocation TEXTURE = DeeperDarker.id("textures/entity/soul_elytra.png");
    private final ElytraModel<E> model;

    public SoulElytraRenderer(RenderLayerParent<E, M> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer, pModelSet);
        this.model = new ElytraModel<>(pModelSet.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, E pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (DeeperDarker.SHOW_ME_YOUR_SKIN && ShowMeYourSkinCompat.hideSoulElytra(pLivingEntity)) return;
        ItemStack itemStack = pLivingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if(itemStack.is(DDItems.SOUL_ELYTRA)) {
            pMatrixStack.pushPose();
            pMatrixStack.translate(0, 0, 0.125f);
            this.getParentModel().copyPropertiesTo(this.model);
            this.model.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
            VertexConsumer vertexConsumer;
            if (DeeperDarker.SHOW_ME_YOUR_SKIN) {
                vertexConsumer = ShowMeYourSkinCompat.enableElytraTransparency1(pBuffer, TEXTURE, false, itemStack.hasFoil(), pLivingEntity);
            } else {
                vertexConsumer = ItemRenderer.getArmorFoilBuffer(pBuffer, RenderType.armorCutoutNoCull(TEXTURE), itemStack.hasFoil());
            }
            float transparency = DeeperDarker.SHOW_ME_YOUR_SKIN ? ShowMeYourSkinCompat.getElytraTransparency(1.0f, pLivingEntity) : 1.0f;
            this.model.renderToBuffer(pMatrixStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, (((int)(transparency * 255.0f)) << 24) | 0xFFFFFF);
            pMatrixStack.popPose();
        }
    }
}
