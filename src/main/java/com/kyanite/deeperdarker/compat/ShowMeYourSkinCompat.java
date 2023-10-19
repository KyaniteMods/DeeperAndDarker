package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.HelmetHornsModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import nl.enjarai.showmeyourskin.client.ModRenderLayers;
import nl.enjarai.showmeyourskin.config.HideableEquipment;
import nl.enjarai.showmeyourskin.util.ArmorContext;
import nl.enjarai.showmeyourskin.util.MixinContext;

public class ShowMeYourSkinCompat {
    public static boolean isFoil(Item item, ItemStack itemStack) {
        boolean itemIsFoil = item.isFoil(itemStack);
        ArmorContext ctx = MixinContext.ARMOR.getContext();

        if (ctx != null) {
            float applicableGlintTransparency = ctx.getApplicableGlintTransparency();

            if (ctx.shouldModify()) {
                return itemIsFoil && applicableGlintTransparency > 0;
            }
        }
        return itemIsFoil;
    }

    public static void captureContext(EquipmentSlot slot, LivingEntity entity) {
        MixinContext.ARMOR.setContext(new ArmorContext(HideableEquipment.fromSlot(slot), entity));
    }

    public static boolean armorTransparency(PoseStack matrices, MultiBufferSource vertexConsumers, int light, HelmetHornsModel<?> model, ResourceLocation texture, float red, float green, float blue) {
        ArmorContext ctx = MixinContext.ARMOR.getContext();
        if (ctx == null) throw new IllegalStateException("ArmorContext is null");

        if (ctx.shouldModify()) {
            float t = ctx.getApplicablePieceTransparency();

            if (t < 1) {
                if (t > 0) {
                    VertexConsumer vertexConsumer = vertexConsumers.getBuffer(
                            ModRenderLayers.ARMOR_TRANSLUCENT_NO_CULL.apply(texture));
                    model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY, red, green, blue, t);
                }

                matrices.popPose();
                return true;
            }
        }
        return false;
    }
}
