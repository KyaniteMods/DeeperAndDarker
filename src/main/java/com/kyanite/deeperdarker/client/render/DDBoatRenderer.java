package com.kyanite.deeperdarker.client.render;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.DDBoatLike;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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

import java.util.Map;

@SuppressWarnings("NullableProblems")
public class DDBoatRenderer<T extends Entity> extends EntityRenderer<T> {
    private final boolean HAS_CHEST;

    private final Map<String, ListModel<Boat>> BOAT_RESOURCES;
    private final Map<String, ModelLayerLocation> chestBoatModels;
    private final Map<String, ModelLayerLocation> boatModels;

    public DDBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext);
        this.HAS_CHEST = pChestBoat;
        this.chestBoatModels = Map.of(DDBlocks.ECHO.name(), DDModelLayers.ECHO_CHEST_BOAT, DDBlocks.BLOOM.name(), DDModelLayers.BLOOM_CHEST_BOAT);
        this.boatModels = Map.of(DDBlocks.ECHO.name(), DDModelLayers.ECHO_BOAT, DDBlocks.BLOOM.name(), DDModelLayers.BLOOM_BOAT);
        this.BOAT_RESOURCES = ImmutableMap.of(
                DDBlocks.ECHO.name(), this.createBoatModel(pContext, DDBlocks.ECHO.name()),
                DDBlocks.BLOOM.name(), this.createBoatModel(pContext, DDBlocks.BLOOM.name())
        );
    }

    private static String getTexture(String type, boolean chest) {
        if (chest) {
            return "textures/entity/chest_boat/" + type + ".png";
        }
        return "textures/entity/boat/" + type + ".png";
    }

    private static ResourceLocation getTextureId(String type, boolean chest) {
        return DeeperDarker.rl(getTexture(type, chest));
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, String type) {
        ModelLayerLocation entityModelLayer = this.HAS_CHEST ? this.chestBoatModels.get(type) :
                this.boatModels.get(type);
        ModelPart modelPart = context.bakeLayer(entityModelLayer);
        return this.HAS_CHEST ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
    }

    @Override
    public void render(T entity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        Boat boatEntity = (Boat)entity;
        ListModel<Boat> model = this.BOAT_RESOURCES.get(((DDBoatLike)boatEntity).getWoodType());
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
        model.setupAnim(boatEntity, g, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(model.renderType(getTextureId(ResourceLocation.parse(((DDBoatLike)boatEntity).getWoodType()).getPath(), HAS_CHEST)));
        model.renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
            if (!boatEntity.isUnderWater()) {
            VertexConsumer vertexConsumer2 = multiBufferSource.getBuffer(RenderType.waterMask());
            if (model instanceof WaterPatchModel waterPatchModel) {
                waterPatchModel.waterPatch().render(poseStack, vertexConsumer2, i, OverlayTexture.NO_OVERLAY);
            }
        }
        poseStack.popPose();
        super.render(entity, f, g, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return getTextureId((entity instanceof DDBoatLike boat) ? boat.getWoodType() : "echo", HAS_CHEST);
    }
}
