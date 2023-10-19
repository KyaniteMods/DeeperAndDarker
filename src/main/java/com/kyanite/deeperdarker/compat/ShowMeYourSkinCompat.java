package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.client.model.HelmetHornsModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import nl.enjarai.showmeyourskin.config.HideableEquipment;
import nl.enjarai.showmeyourskin.config.ModConfig;
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
                    VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(vertexConsumers, RenderType.entityTranslucent(texture), false, true);
                    model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY, red, green, blue, t);
                }

                matrices.popPose();
                return true;
            }
        }
        return false;
    }

    public static boolean hideSoulElytra(LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            return ModConfig.INSTANCE.getApplicablePieceTransparency(player.getUUID(), HideableEquipment.ELYTRA) <= 0;
        }
        return false;
    }

    public static boolean hideSoulElytraGlint(boolean original, LivingEntity entity) {
        if (entity instanceof Player player) {
            return original && ModConfig.INSTANCE.getApplicableGlintTransparency(player.getUUID(), HideableEquipment.ELYTRA) > 0;
        }

        return original;
    }

    public static VertexConsumer enableElytraTransparency1(MultiBufferSource buffer, ResourceLocation texture, boolean solid, boolean hasGlint, LivingEntity entity) {
        if (entity instanceof Player player) {
            float transparency = ModConfig.INSTANCE.getApplicablePieceTransparency(player.getUUID(), HideableEquipment.ELYTRA);
            if (transparency < 1) {
                return ItemRenderer.getFoilBufferDirect(buffer, enableElytraTransparency2(texture, entity), solid, hideSoulElytraGlint(hasGlint, entity));
            }
        }

        return ItemRenderer.getArmorFoilBuffer(buffer, enableElytraTransparency2(texture, entity), solid, hideSoulElytraGlint(hasGlint, entity));
    }

    public static RenderType enableElytraTransparency2(ResourceLocation texture, LivingEntity entity) {
        if (entity instanceof Player player) {
            float transparency = ModConfig.INSTANCE.getApplicablePieceTransparency(player.getUUID(), HideableEquipment.ELYTRA);
            if (transparency < 1) {
                return RenderType.entityTranslucent(texture);
            }
        }

        return RenderType.armorCutoutNoCull(texture);
    }

    public static float getElytraTransparency(float original, LivingEntity entity) {
        if (entity instanceof Player player) {
            float transparency = ModConfig.INSTANCE.getApplicablePieceTransparency(player.getUUID(), HideableEquipment.ELYTRA);
            if (transparency < 1.0f) {
                return transparency;
            }
        }

        return original;
    }
}
