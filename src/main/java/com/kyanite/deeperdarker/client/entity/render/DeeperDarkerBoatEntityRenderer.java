package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.entities.DeeperDarkerBoatEntity;
import com.kyanite.deeperdarker.entities.DeeperDarkerBoatTypes;
import com.kyanite.deeperdarker.entities.DeeperDarkerChestBoatEntity;
import com.kyanite.deeperdarker.entities.IDeeperDarkerBoatEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionf;

import java.util.HashMap;
import java.util.Map;


public class DeeperDarkerBoatEntityRenderer extends EntityRenderer<BoatEntity> {
    private final Map<DeeperDarkerBoatTypes, Pair<Identifier, CompositeEntityModel<BoatEntity>>> texturesAndModels = new HashMap<>();
    private final boolean HAS_CHEST;

    public DeeperDarkerBoatEntityRenderer(EntityRendererFactory.Context ctx, boolean chest) {
        super(ctx);
        this.texturesAndModels.put(
                DeeperDarkerBoatTypes.ECHO, new Pair<>(getTextureId(DeeperDarkerBoatTypes.ECHO.getName(), chest), this.createBoatModel(ctx, chest)));
        this.HAS_CHEST = chest;
    }

    private static String getTexture(String type, boolean chest) {
        if (chest) {
            return "textures/entity/chest_boat/" + type + ".png";
        }
        return "textures/entity/boat/" + type + ".png";
    }

    private static Identifier getTextureId(String type, boolean chest) {
        return new Identifier(DeeperDarker.MOD_ID, getTexture(type, chest));
    }

    private CompositeEntityModel<BoatEntity> createBoatModel(EntityRendererFactory.Context context, boolean chestBoat) {
        EntityModelLayer entityModelLayer = chestBoat ? DeeperDarkerModelLayers.ECHO_CHEST_BOAT :
                DeeperDarkerModelLayers.ECHO_BOAT;
        ModelPart modelPart = context.getPart(entityModelLayer);
        return chestBoat ? new ChestBoatEntityModel(modelPart) : new BoatEntityModel(modelPart);
    }

    @Override
    public void render(BoatEntity boatEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0f, 0.375f, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - f));
        float h = (float)boatEntity.getDamageWobbleTicks() - g;
        float j = boatEntity.getDamageWobbleStrength() - g;
        if (j < 0.0f) {
            j = 0.0f;
        }
        if (h > 0.0f) {
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.sin(h) * h * j / 10.0f * (float)boatEntity.getDamageWobbleSide()));
        }
        if (!MathHelper.approximatelyEquals(boatEntity.interpolateBubbleWobble(g), 0.0f)) {
            matrixStack.multiply(new Quaternionf().setAngleAxis(boatEntity.interpolateBubbleWobble(g) * ((float)Math.PI / 180), 1.0f, 0.0f, 1.0f));
        }
        Pair<Identifier, CompositeEntityModel<BoatEntity>> pair = this.texturesAndModels.get(((IDeeperDarkerBoatEntity)boatEntity).getWoodType());
        Identifier identifier = pair.getLeft();
        CompositeEntityModel<BoatEntity> compositeEntityModel = pair.getRight();
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0f));
        compositeEntityModel.setAngles(boatEntity, g, 0.0f, -0.1f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(compositeEntityModel.getLayer(identifier));
        compositeEntityModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        if (!boatEntity.isSubmergedInWater()) {
            VertexConsumer vertexConsumer2 = vertexConsumerProvider.getBuffer(RenderLayer.getWaterMask());
            if (compositeEntityModel instanceof ModelWithWaterPatch) {
                ModelWithWaterPatch modelWithWaterPatch = (ModelWithWaterPatch)((Object)compositeEntityModel);
                modelWithWaterPatch.getWaterPatch().render(matrixStack, vertexConsumer2, i, OverlayTexture.DEFAULT_UV);
            }
        }
        matrixStack.pop();
        super.render(boatEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(BoatEntity boat) {
        return texturesAndModels.get(((IDeeperDarkerBoatEntity)boat).getWoodType()).getLeft();
    }
}
