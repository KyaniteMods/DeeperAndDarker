package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.content.blocks.DarkFountainBlock;
import com.kyanite.deeperdarker.content.entities.blocks.DarkFountainBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
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

    public static LayerDefinition createModel() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("beam", CubeListBuilder.create().texOffs(0, 0).addBox(7.0f, 0.0f, 7.0f, 2.0f, 16.0f, 2.0f), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    @Override
    public void render(DarkFountainBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        if (blockEntity.getBlockState().hasProperty(DarkFountainBlock.HAS_BEAM) && !blockEntity.getBlockState().getValue(DarkFountainBlock.HAS_BEAM)) return;
        float animationTime = (float)Math.floorMod(blockEntity.hasLevel() ? blockEntity.getLevel().getGameTime() : 0, 360) + f;
        float lightScale = 2.25f + Mth.sin(Mth.DEG_TO_RAD * animationTime * 8.0f) * 0.25f;

        for (int i = -blockEntity.getBeamBlocksDown(); i <= blockEntity.getBeamBlocksUp(); i++) {
            poseStack.pushPose();
            poseStack.translate(0.5f, i + 0.5f, 0.5f);
            poseStack.scale(lightScale, 1.0f, lightScale);
            poseStack.mulPose(Axis.YP.rotation((float) Mth.atan2(blockEntity.getBlockPos().getCenter().x() - entityRenderDispatcher.camera.getPosition().x(), blockEntity.getBlockPos().getCenter().z() - entityRenderDispatcher.camera.getPosition().z())));
            poseStack.translate(-0.5f, -0.5f, -0.5f);
            renderFlatFace(poseStack, multiBufferSource.getBuffer(RenderType.beaconBeam(LIGHT_TEXTURE, true)), 0xFFFFFFFF, 7.0f, 0, 8.0f, 2.0f, 16.0f, 0.0f, 2.0f / 32.0f, 32, 32);
            poseStack.popPose();
        }

        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(animationTime - 45.0F));
        poseStack.translate(-0.5f, -0.5f, -0.5f);

        for (int i = -blockEntity.getBeamBlocksDown(); i <= blockEntity.getBeamBlocksUp(); i++) {
            poseStack.pushPose();
            poseStack.translate(0.0f, i, 0.0f);
            renderCuboidSides(poseStack, multiBufferSource.getBuffer(RenderType.beaconBeam(TEXTURE, false)), 0xFFFFFFFF, 7.0f, 0, 7.0f, 2.0f, 16.0f, 2.0f, 0.0f, 0.0f, 32, 32);
            poseStack.popPose();
        }
    }

    private static void renderFlatFace(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float x, float y, float z, float width, float height, float u, float v, int spriteWidth, int spriteHeight) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        float x1 = x / 16.0f;
        float y1 = y / 16.0f;
        float z1 = z / 16.0f;

        float x2 = x1 + width / 16.0f;
        float y2 = y1 + height / 16.0f;
        float z2 = z1;

        float v2 = v;
        float v1 = v2 + height / spriteHeight;

        float u1w = u;
        float u1n = u1w;
        float u1e = u1n + width / spriteWidth;
        float u1s = u1e;

        float u2w = u1w;
        float u2n = u1n + width / spriteWidth;
        float u2e = u1e;
        float u2s = u1s + width / spriteWidth;

        // NORTH
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z1, u2n, u1n, v1, v2);
        // SOUTH
//        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z2, x1, z2, u2s, u1s, v1, v2);
        // WEST
//        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z2, x1, z1, u2w, u1w, v1, v2);
        // EAST
//        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z1, x2, z2, u2e, u1e, v1, v2);

//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x, z, x2, z2, u + depth + width / spriteWidth, u, v + depth, v + depth + height / spriteHeight);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x4, z4, x3, z3, u + depth + width / spriteWidth, u + depth, v + depth, v2);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x2, z2, x3, z3, u + depth + width / spriteWidth, u + depth, v + depth, v2);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x4, z4, x, z, u + depth + width / spriteWidth, u + depth, v + depth, v2);
    }

    private static void renderCuboidSides(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float x, float y, float z, float width, float height, float depth, float u, float v, int spriteWidth, int spriteHeight) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        float x1 = x / 16.0f;
        float y1 = y / 16.0f;
        float z1 = z / 16.0f;

        float x2 = x1 + width / 16.0f;
        float y2 = y1 + height / 16.0f;
        float z2 = z1 + depth / 16.0f;

        float v2 = v + depth / spriteHeight;
        float v1 = v2 + height / spriteHeight;

        float u1w = u;
        float u1n = u1w + depth / spriteWidth;
        float u1e = u1n + width / spriteWidth;
        float u1s = u1e + depth / spriteWidth;

        float u2w = u1w + depth / spriteWidth;
        float u2n = u1n + width / spriteWidth;
        float u2e = u1e + depth / spriteWidth;
        float u2s = u1s + width / spriteWidth;

        // NORTH
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z1, u2n, u1n, v1, v2);
        // SOUTH
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z2, x1, z2, u2s, u1s, v1, v2);
        // WEST
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z2, x1, z1, u2w, u1w, v1, v2);
        // EAST
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z1, x2, z2, u2e, u1e, v1, v2);

//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x, z, x2, z2, u + depth + width / spriteWidth, u, v + depth, v + depth + height / spriteHeight);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x4, z4, x3, z3, u + depth + width / spriteWidth, u + depth, v + depth, v2);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x2, z2, x3, z3, u + depth + width / spriteWidth, u + depth, v + depth, v2);
//        renderQuad(pose, normal, vertexConsumer, color, y2, y, x4, z4, x, z, u + depth + width / spriteWidth, u + depth, v + depth, v2);
    }

    private static void renderPart(PoseStack poseStack, VertexConsumer vertexConsumer, int color, float y2, float y1, float x1, float z1, float x2, float z2, float x3, float z3, float x4, float z4, float u2, float u1, float v1, float v2) {
        PoseStack.Pose last = poseStack.last();
        Matrix4f pose = last.pose();
        Matrix3f normal = last.normal();

        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x1, z1, x2, z2, u2, u1, v1, v2);
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x4, z4, x3, z3, u2, u1, v1, v2);
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x2, z2, x3, z3, u2, u1, v1, v2);
        renderQuad(pose, normal, vertexConsumer, color, y2, y1, x4, z4, x1, z1, u2, u1, v1, v2);
    }

    private static void renderQuad(Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer vertexConsumer, int color, float y2, float y1, float x1, float z1, float x2, float z2, float u2, float u1, float v1, float v2) {
        addVertex(matrix4f, matrix3f, vertexConsumer, color, y1, x1, z1, u1, v1);
        addVertex(matrix4f, matrix3f, vertexConsumer, color, y2, x1, z1, u1, v2);
        addVertex(matrix4f, matrix3f, vertexConsumer, color, y2, x2, z2, u2, v2);
        addVertex(matrix4f, matrix3f, vertexConsumer, color, y1, x2, z2, u2, v1);
    }

    private static void addVertex(Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer vertexConsumer, int color, float y, float x, float z, float u, float v) {
        vertexConsumer.vertex(matrix4f, x, y, z).color(color >>> 16 & 0xFF, (color >>> 8) & 0xFF, color & 0xFF, (color >>> 24) & 0xFF).uv(u, v).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(0xF000F0).normal(matrix3f, 0.0f, 1.0f, 0.0f).endVertex();
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
