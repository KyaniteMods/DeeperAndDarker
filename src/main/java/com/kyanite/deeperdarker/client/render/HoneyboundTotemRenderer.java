package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.HoneyboundTotemModel;
import com.kyanite.deeperdarker.client.model.SculkCentipedeModel;
import com.kyanite.deeperdarker.content.entities.HoneyboundTotem;
import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class HoneyboundTotemRenderer<T extends HoneyboundTotem> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/honeybound_totem/honeybound_totem.png");
    private final HoneyboundTotemModel<T> model;

    public HoneyboundTotemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new HoneyboundTotemModel<>(pContext.bakeLayer(DDModelLayers.HONEYBOUND_TOTEM));
    }

    @Override
    public ResourceLocation getTextureLocation(HoneyboundTotem entity) {
        return TEXTURE;
    }

    public ResourceLocation getHoneyTextureLocation(HoneyboundTotem entity) {
        return new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/honeybound_totem/honeybound_totem_stage" + entity.getHoneyAmount() + ".png");
    }

    @Override
    public void render(T entity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        poseStack.pushPose();
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.translate(0.0f, (float)-(Math.sin(entity.getHoneyTime() / 20.0 - Math.PI / 2.0) + 1.0f) / 16.0f, 0.0f);
        float h = Mth.rotLerp(g, entity.yRotO, entity.getYRot());
        float j = Mth.lerp(g, entity.xRotO, entity.getXRot());
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(this.getTextureLocation(entity)));
        this.model.setupAnim(entity, h, j);
        this.model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (entity.getHoneyAmount() > 0) {
            VertexConsumer honeyVertexConsumer = multiBufferSource.getBuffer(this.model.renderType(this.getHoneyTextureLocation(entity)));
            this.model.renderToBuffer(poseStack, honeyVertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        poseStack.popPose();
        super.render(entity, f, g, poseStack, multiBufferSource, i);
    }
}
