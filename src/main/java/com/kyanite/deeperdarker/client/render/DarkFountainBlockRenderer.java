package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.DarkFountainBlock;
import com.kyanite.deeperdarker.content.entities.blocks.DarkFountainBlockEntity;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
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
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.function.IntFunction;

public class DarkFountainBlockRenderer implements BlockEntityRenderer<DarkFountainBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/dark_fountain/beam.png");
    private static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/dark_fountain/beam_light.png");

    private final EntityRenderDispatcher entityRenderDispatcher;

    public DarkFountainBlockRenderer(BlockEntityRendererProvider.Context context) {
        entityRenderDispatcher = context.getEntityRenderer();
    }

    @Override
    public void render(DarkFountainBlockEntity blockEntity, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        if (blockEntity.getBlockState().hasProperty(DarkFountainBlock.HAS_BEAM) && !blockEntity.getBlockState().getValue(DarkFountainBlock.HAS_BEAM)) return;

        float fadeOutTime = 10.0f;
        float alpha = blockEntity.getFountainTicksLeft() > fadeOutTime ? 1.0f : (Mth.lerp(tickDelta, Math.min(fadeOutTime, blockEntity.getFountainTicksLeftOld()), blockEntity.getFountainTicksLeft())) / 10.0f;
        int color = 0x00FFFFFF | ((int) (alpha * 255.0f) << 24);

        final BlockPos.MutableBlockPos mutableBlockPos = blockEntity.getBlockPos().mutable();
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.5f, 0.5f);
        renderFountainBeam(poseStack, multiBufferSource, blockEntity.getBlockPos().getCenter(), entityRenderDispatcher.camera.getPosition(), blockEntity.hasLevel() ? blockEntity.getLevel().getGameTime() : 0L, tickDelta, offsetY ->
            blockEntity.hasLevel() ? LevelRenderer.getLightColor(blockEntity.getLevel(), mutableBlockPos.setY(blockEntity.getBlockPos().getY() + offsetY)) : 0xFFFFFF, overlay, color, blockEntity.getBeamBlocksDown(), blockEntity.getBeamBlocksUp());
        poseStack.popPose();
    }

    public static void renderFountainBeam(PoseStack poseStack, MultiBufferSource multiBufferSource, Vec3 center, Vec3 cameraPos, long gameTime, float tickDelta, Int2IntFunction lightFunction, int overlay, int color, int blocksDown, int blocksUp) {
        VertexConsumer vertexConsumerLight = multiBufferSource.getBuffer(RenderType.entityTranslucentCull(LIGHT_TEXTURE));
        VertexConsumer vertexConsumerBeam = multiBufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE));

        renderFountainBeam(poseStack, center, cameraPos, gameTime, tickDelta, lightFunction, overlay, color, vertexConsumerLight, vertexConsumerBeam, blocksDown, blocksUp);
    }

    public static void renderFountainBeam(PoseStack poseStack, Vec3 center, Vec3 cameraPos, long gameTime, float tickDelta, Int2IntFunction lightFunction, int overlay, int color, VertexConsumer vertexConsumerLight, VertexConsumer vertexConsumerBeam, int blocksDown, int blocksUp) {
        float rotation = (float) Mth.atan2(center.x() - cameraPos.x(), center.z() - cameraPos.z());
        float animationTime = (float)Math.floorMod(gameTime, 360) + tickDelta;
        float lightScale = 2.25f + Mth.sin(Mth.DEG_TO_RAD * animationTime * 8.0f) * 0.25f;

        for (int offsetY = -blocksDown; offsetY <= blocksUp; offsetY++) {
            poseStack.pushPose();
            poseStack.translate(0.0f, offsetY, 0.0f);
            renderFountainBeam(poseStack, rotation, animationTime, lightScale, lightFunction.applyAsInt(offsetY), overlay, color, vertexConsumerLight, vertexConsumerBeam);
            poseStack.popPose();
        }
    }

    public static void renderFountainBeam(PoseStack poseStack, float rotation, float animationTime, float lightScale, int light, int overlay, int color, VertexConsumer vertexConsumerLight, VertexConsumer vertexConsumerBeam) {
        poseStack.pushPose();

        poseStack.scale(lightScale, 1.0f, lightScale);
        poseStack.mulPose(Axis.YP.rotation(rotation));

        poseStack.translate(-0.5f, -0.5f, -0.5f);
        DDUtil.renderFlatFace(poseStack, vertexConsumerLight, color, 7.0f, 0, 8.0f, 2.0f, 16.0f, 0.0f, 2.0f / 32.0f, 32, 32, light, overlay);

        poseStack.popPose();

        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(animationTime - 45.0F));

        poseStack.translate(-0.5f, -0.5f, -0.5f);
        DDUtil.renderCuboidSides(poseStack, vertexConsumerBeam, color, 7.0f, 0, 7.0f, 2.0f, 16.0f, 2.0f, 0.0f, 0.0f, 32, 32, light, overlay);
        poseStack.popPose();
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
