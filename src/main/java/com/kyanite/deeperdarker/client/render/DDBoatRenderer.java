package com.kyanite.deeperdarker.client.render;

import com.ibm.icu.impl.coll.BOCSU;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.WaterPatchModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class DDBoatRenderer extends EntityRenderer {
    private  ListModel<Boat> MODEL;
    private final boolean HAS_CHEST;

    public DDBoatRenderer(EntityRendererProvider.Context ctx, boolean chest) {
        super(ctx);
        this.MODEL = createBoatModel(ctx, chest);
        this.HAS_CHEST = chest;
    }

    private static String getTexture(boolean chest) {
        if (chest) {
            return "textures/entity/chest_boat/echo.png";
        }
        return "textures/entity/boat/chest/echo.png";
    }

    private static ResourceLocation getTextureId(boolean chest) {
        return new ResourceLocation(DeeperDarker.MOD_ID, getTexture(chest));
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, boolean chestBoat) {
        ModelLayerLocation entityModelLayer = chestBoat ? DDModelLayers.ECHO_CHEST_BOAT :
                DDModelLayers.ECHO_BOAT;
        ModelPart modelPart = context.bakeLayer(entityModelLayer);
        return chestBoat ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
    }

    @Override
    public void render(Entity entity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        Boat boatEntity = (Boat)entity;
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.375f, 0.0f);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f - f));
        float h = (float)boatEntity.getHurtTime() - g;
        float j = boatEntity.getDamage() - g;
        if (j < 0.0f) {
            j = 0.0f;
        }
        if (h > 0.0f) {
            poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(h) * h * j / 10.0f * (float)boatEntity.getHurtDir()));
        }
        if (!Mth.equal(boatEntity.getBubbleAngle(g), 0.0f)) {
            poseStack.mulPose(new Quaternionf().setAngleAxis(boatEntity.getBubbleAngle(g) * ((float)Math.PI / 180), 1.0f, 0.0f, 1.0f));
        }
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
        MODEL.setupAnim(boatEntity, g, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(MODEL.renderType(getTextureId(HAS_CHEST)));
        MODEL.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
            if (!boatEntity.isUnderWater()) {
            VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.waterMask());
            if (MODEL instanceof WaterPatchModel waterPatchModel) {
                waterPatchModel.waterPatch().render(poseStack, vertexConsumer2, i, OverlayTexture.NO_OVERLAY);
            }
        }
        poseStack.popPose();
        super.render(entity, f, g, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return getTextureId(HAS_CHEST);
    }
}
