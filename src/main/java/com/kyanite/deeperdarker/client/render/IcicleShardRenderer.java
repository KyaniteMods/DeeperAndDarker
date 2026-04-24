package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.entities.IcicleShard;
import com.kyanite.deeperdarker.util.DDUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class IcicleShardRenderer extends EntityRenderer<IcicleShard> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/icicle_shard.png");

    public IcicleShardRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(IcicleShard entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        poseStack.pushPose();
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.translate(-0.5f, -0.5f, -0.5f);
        DDUtil.renderFlatFace(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucentCull(TEXTURE)), 0xFFFFFFFF, 0.0f, 0.0f, 8.0f, 16, 16, 0, 16, 16, -16, light, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);
    }

    @Override
    public ResourceLocation getTextureLocation(IcicleShard entity) {
        return TEXTURE;
    }
}
