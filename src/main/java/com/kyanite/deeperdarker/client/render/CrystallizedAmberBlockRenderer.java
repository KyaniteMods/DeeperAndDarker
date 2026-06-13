package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.client.render.state.CrystallizedAmberRenderState;
import com.kyanite.deeperdarker.content.DDEntities;
import com.kyanite.deeperdarker.content.blocks.CrystallizedAmberBlock;
import com.kyanite.deeperdarker.content.blocks.entity.CrystallizedAmberBlockEntity;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.HashCommon;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("NullableProblems")
public class CrystallizedAmberBlockRenderer implements BlockEntityRenderer<CrystallizedAmberBlockEntity, CrystallizedAmberRenderState> {
    private final EntityRenderDispatcher entityRenderer;
    private final ItemModelResolver itemModelResolver;

    public CrystallizedAmberBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = context.entityRenderer();
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public CrystallizedAmberRenderState createRenderState() {
        return new CrystallizedAmberRenderState();
    }

    @Override
    public void extractRenderState(CrystallizedAmberBlockEntity blockEntity, CrystallizedAmberRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.fossilized = blockEntity.getBlockState().getValue(CrystallizedAmberBlock.FOSSILIZED);
        state.hasLeech = blockEntity.hasLeech();
        if(state.hasLeech) {
            SculkLeech leech = new SculkLeech(DDEntities.SCULK_LEECH.get(), blockEntity.getLevel());
            state.displayEntity = entityRenderer.extractEntity(leech, partialTicks);
        }
        if(!blockEntity.getLoot().isEmpty()) {
            state.item = new ItemStackRenderState();
            int seed = HashCommon.long2int(blockEntity.getBlockPos().asLong());
            this.itemModelResolver.updateForTopItem(state.item, blockEntity.getLoot(), ItemDisplayContext.FIXED, blockEntity.getLevel(), blockEntity, seed);
        }
    }

    @Override
    public void submit(CrystallizedAmberRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if(!state.fossilized) return;

        poseStack.pushPose();
        poseStack.translate(0.5f, 0.5f, 0.5f);
        RandomSource random = new XoroshiroRandomSource(state.blockPos.asLong());
        random.nextFloat();
        poseStack.mulPose(Axis.XP.rotationDegrees(random.nextFloat() * 180f - 90));
        poseStack.mulPose(Axis.YP.rotationDegrees(random.nextFloat() * 180f));
        if(state.hasLeech) {
            poseStack.scale(0.9f, 0.9f, 0.9f);
            entityRenderer.submit(state.displayEntity, camera, 0, 0, 0, poseStack, submitNodeCollector);
        } else {
            poseStack.scale(0.6f, 0.6f, 0.6f);
            state.item.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        }

        poseStack.popPose();
    }
}
