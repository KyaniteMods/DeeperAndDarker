package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.entities.blocks.SculkAltarBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class SculkAltarBlockRenderer implements BlockEntityRenderer<SculkAltarBlockEntity> {
    private final ItemRenderer itemRenderer;

    public SculkAltarBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(SculkAltarBlockEntity blockEntity, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        int amount = blockEntity.getItems().size();
        float itemSpanningAngle = 360.0f / amount;

        poseStack.pushPose();
        poseStack.translate(0.5f, 1.0f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(blockEntity.getRotationDegrees(tickDelta) + itemSpanningAngle / 2.0f));

        float scale = 0.25f;
        float distanceFromCenter = 0.4f;
        if (amount > 1) {
            poseStack.translate(distanceFromCenter, 0.0f, 0.0f);
        }
        float itemRotation = blockEntity.getItemRotationDegrees(tickDelta);
        for (int i = 0; i < amount; i++) {
            ItemStack stack = blockEntity.getItems().get(i);
            poseStack.mulPose(Axis.YP.rotationDegrees(itemRotation + 71 * i));
            poseStack.scale(scale, scale, scale);
            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, light, overlay, poseStack, multiBufferSource, blockEntity.getLevel(), 0);
            poseStack.scale(1.0f / scale, 1.0f / scale, 1.0f / scale);
            poseStack.mulPose(Axis.YN.rotationDegrees(itemRotation + 71 * i));
            if (amount > 1) {
                poseStack.translate(-distanceFromCenter, 0.0f, 0.0f);
                poseStack.mulPose(Axis.YP.rotationDegrees(360.0f / amount));
                poseStack.translate(distanceFromCenter, 0.0f, 0.0f);
            }
        }

        poseStack.popPose();
    }
}
