package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.entities.blocks.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;

public class CrystallizedAmberBlockRenderer implements BlockEntityRenderer<CrystallizedAmberBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;
    private final ItemRenderer itemRenderer;

    public CrystallizedAmberBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CrystallizedAmberBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if(!pBlockEntity.getBlockState().getValue(CrystallizedAmberBlock.FOSSILIZED)) return;

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.5f, 0.5f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(-40f));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.rotation));
        if(pBlockEntity.fossilizedEntity) {
            pPoseStack.scale(0.9f, 0.9f, 0.9f);
            SculkLeech leech = new SculkLeech(DDEntities.SCULK_LEECH, pBlockEntity.getLevel());
            entityRenderer.render(leech, 0, 0, 0, 0, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        } else {
            pPoseStack.scale(0.6f, 0.6f, 0.6f);
            itemRenderer.renderStatic(pBlockEntity.getFossilizedLoot(), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1);
        }

        pPoseStack.popPose();
    }
}
