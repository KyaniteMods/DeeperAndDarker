package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class OvercastVesselCrackLayer<E extends OvercastVessel, M extends EntityModel<E>> extends RenderLayer<E, M> {
    public static final ResourceLocation TEXTURE = DeeperDarker.id("textures/entity/overcast_vessel/overcast_vessel_crack.png");

    public OvercastVesselCrackLayer(RenderLayerParent<E, M> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int light, E entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        for (Direction direction : entity.getCrackDirections()) {
            poseStack.pushPose();
            if (direction == Direction.NORTH) {
                poseStack.translate(1.5f, -1.5f, 1.5f);
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
            }
            if (direction == Direction.SOUTH) {
                poseStack.translate(-1.5f, -1.5f, -1.5f);
            }
            if (direction == Direction.EAST) {
                poseStack.translate(1.5f, -1.5f, -1.5f);
                poseStack.mulPose(Axis.YN.rotationDegrees(90.0f));
            }
            if (direction == Direction.WEST) {
                poseStack.translate(-1.5f, -1.5f, 1.5f);
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
            }
            if (direction == Direction.UP) {
                poseStack.translate(-1.5f, -1.5f, 1.5f);
                poseStack.mulPose(Axis.XN.rotationDegrees(90.0f));
            }
            if (direction == Direction.DOWN) {
                poseStack.translate(-1.5f, 1.5f, -1.5f);
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
            }
            DDUtil.renderFlatFace(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCullZOffset(TEXTURE)), 0xFFFFFFFF, 0, 0, 0, 48, 48, 0, 0, 48, 48, light, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
