package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;

public class CrystallizedAmberBlockRenderer implements BlockEntityRenderer<CrystallizedAmberBlockEntity> {
    private final EntityRenderDispatcher entityRenderer;
    private final ItemRenderer itemRenderer;

    public CrystallizedAmberBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.getEntityRenderer();
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CrystallizedAmberBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if(!blockEntity.getBlockState().getValue(CrystallizedAmberBlock.FOSSILIZED)) return;

        poseStack.pushPose();
        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.XP.rotationDegrees(-40f));
        RandomSource random = RandomSource.create(blockEntity.getBlockPos().asLong() / (blockEntity.getBlockPos().getX() + blockEntity.getBlockPos().getZ()));
        poseStack.mulPose(Axis.YP.rotationDegrees(random.nextFloat() * 180f));
        if(blockEntity.fossilizedEntity) {
            poseStack.scale(0.9f, 0.9f, 0.9f);
            SculkLeech leech = new SculkLeech(DDEntities.SCULK_LEECH.get(), blockEntity.getLevel());
            entityRenderer.render(leech, 0, 0, 0, 0, partialTick, poseStack, bufferSource, packedLight);
        } else {
            poseStack.scale(0.6f, 0.6f, 0.6f);
            itemRenderer.renderStatic(blockEntity.getLoot(), ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);
        }

        poseStack.popPose();
    }
}
