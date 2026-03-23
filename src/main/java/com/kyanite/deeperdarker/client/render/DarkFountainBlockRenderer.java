package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.DarkFountainBlock;
import com.kyanite.deeperdarker.content.entities.blocks.DarkFountainBlockEntity;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class DarkFountainBlockRenderer implements BlockEntityRenderer<DarkFountainBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/dark_fountain/beam.png");
    private static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/dark_fountain/beam_light.png");

    private final EntityRenderDispatcher entityRenderDispatcher;

    public DarkFountainBlockRenderer(BlockEntityRendererProvider.Context context) {
        entityRenderDispatcher = context.getEntityRenderer();
    }

    @Override
    public void render(DarkFountainBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        if (blockEntity.getBlockState().hasProperty(DarkFountainBlock.HAS_BEAM) && !blockEntity.getBlockState().getValue(DarkFountainBlock.HAS_BEAM)) return;
        float animationTime = (float)Math.floorMod(blockEntity.hasLevel() ? blockEntity.getLevel().getGameTime() : 0, 360) + f;
        float lightScale = 2.25f + Mth.sin(Mth.DEG_TO_RAD * animationTime * 8.0f) * 0.25f;

        float fadeOutTime = 10.0f;
        float alpha = blockEntity.getFountainTicksLeft() > fadeOutTime ? 1.0f : (Mth.lerp(f, Math.min(fadeOutTime, blockEntity.getFountainTicksLeftOld()), blockEntity.getFountainTicksLeft())) / 10.0f;
        int color = 0x00FFFFFF | ((int) (alpha * 255.0f) << 24);

        for (int i = -blockEntity.getBeamBlocksDown(); i <= blockEntity.getBeamBlocksUp(); i++) {
            int light1 = blockEntity.hasLevel() ? LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos().relative(Direction.Axis.Y, i)) : 0xFFFFFF;
            poseStack.pushPose();
            poseStack.translate(0.5f, i + 0.5f, 0.5f);
            poseStack.scale(lightScale, 1.0f, lightScale);
            poseStack.mulPose(Axis.YP.rotation((float) Mth.atan2(blockEntity.getBlockPos().getCenter().x() - entityRenderDispatcher.camera.getPosition().x(), blockEntity.getBlockPos().getCenter().z() - entityRenderDispatcher.camera.getPosition().z())));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
            DDUtil.renderFlatFace(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(LIGHT_TEXTURE)), color, 7.0f, 0, 8.0f, 2.0f, 16.0f, 0.0f, 2.0f / 32.0f, 32, 32, light1, overlay);
            poseStack.popPose();
        }

        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(animationTime - 45.0F));
        poseStack.translate(-0.5f, -0.5f, -0.5f);

        for (int i = -blockEntity.getBeamBlocksDown(); i <= blockEntity.getBeamBlocksUp(); i++) {
            int light1 = blockEntity.hasLevel() ? LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos().relative(Direction.Axis.Y, i)) : 0xFFFFFF;
            poseStack.pushPose();
            poseStack.translate(0.0f, i, 0.0f);
            DDUtil.renderCuboidSides(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), color, 7.0f, 0, 7.0f, 2.0f, 16.0f, 2.0f, 0.0f, 0.0f, 32, 32, light1, overlay);
            poseStack.popPose();
        }
    }



    @Override
    public boolean shouldRenderOffScreen(DarkFountainBlockEntity blockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 16;
    }

    @Override
    public boolean shouldRender(DarkFountainBlockEntity blockEntity, Vec3 vec3) {
        return Vec3.atCenterOf(blockEntity.getBlockPos()).multiply(1.0, 0.0, 1.0).closerThan(vec3.multiply(1.0, 0.0, 1.0), this.getViewDistance());
    }
}
