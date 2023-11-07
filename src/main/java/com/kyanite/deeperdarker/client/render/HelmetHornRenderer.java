package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.HelmetHornsModel;
import com.kyanite.deeperdarker.compat.ShowMeYourSkinCompat;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HelmetHornRenderer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/models/armor/warden_horns.png");

    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    private final EntityModelSet modelLoader;

    public HelmetHornRenderer(LivingEntityRenderer<?, ?> context, EntityModelSet loader) {
        this((RenderLayerParent<T, M>) context, loader, 1.0f, 1.0f, 1.0f);
    }

    public HelmetHornRenderer(RenderLayerParent<T, M> context, EntityModelSet loader, float scaleX, float scaleY, float scaleZ) {
        super(context);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.modelLoader = loader;
    }

    public void render(PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int light, T livingEntity, float f, float g, float h, float j, float k, float l) {
        if (!DDConfig.HANDLER.instance().renderWardenHelmetHorns) return;
        boolean hasShowMeYourSkin = FabricLoader.getInstance().isModLoaded("showmeyourskin");
        if (hasShowMeYourSkin) ShowMeYourSkinCompat.captureContext(EquipmentSlot.HEAD, livingEntity);
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if (!itemStack.isEmpty()) {
            Item item = itemStack.getItem();
            matrixStack.pushPose();
            matrixStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            boolean bl = livingEntity instanceof ZombieVillager;
            if (livingEntity.isBaby()) {
                matrixStack.translate(0.0F, 0.03125F, 0.0F);
                matrixStack.scale(0.7F, 0.7F, 0.7F);
                matrixStack.translate(0.0F, 1.0F, 0.0F);
            }

            ((HeadedModel)this.getParentModel()).getHead().translateAndRotate(matrixStack);
            if (item == DDItems.WARDEN_HELMET) {
                if (livingEntity.isBaby()) {
                    matrixStack.scale(1.3425f, 1.3425f, 1.3425f);
                    matrixStack.translate(0.0f, -0.803125f, 0.0f);
                } else {
                    matrixStack.scale(1.25f, 1.25f, 1.25f);
                    matrixStack.translate(0.0f, -0.825f, 0.0f);
                }
                if (bl) {
                    matrixStack.translate(0.0f, -0.1f, 0.0f);
                }
                HelmetHornsModel<T> hornsModel = new HelmetHornsModel<T>(this.modelLoader.bakeLayer(DDModelLayers.WARDEN_HELMET));
                if (hasShowMeYourSkin && ShowMeYourSkinCompat.armorTransparency(matrixStack, vertexConsumerProvider, light, hornsModel, TEXTURE, 1.0f, 1.0f, 1.0f)) return;
                RenderType renderLayer = RenderType.armorCutoutNoCull(TEXTURE);
                RenderType glintRenderLayer = RenderType.armorEntityGlint();
                hornsModel.renderToBuffer(matrixStack, vertexConsumerProvider.getBuffer(renderLayer), light, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
                if (isFoil(item, itemStack, hasShowMeYourSkin)) {
                    hornsModel.renderToBuffer(matrixStack, vertexConsumerProvider.getBuffer(glintRenderLayer), light, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
                }
            }
            matrixStack.popPose();
        }
    }

    private static boolean isFoil(Item item, ItemStack itemStack, boolean hasShowMeYourSkin) {
        boolean itemIsFoil = item.isFoil(itemStack);
        if (!hasShowMeYourSkin) {
            return itemIsFoil;
        }
        return ShowMeYourSkinCompat.isFoil(item, itemStack);
    }
}