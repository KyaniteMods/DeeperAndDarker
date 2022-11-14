package com.kyanite.deeperdarker.client.rendering.entity;

import com.google.common.collect.Maps;
import com.ibm.icu.impl.Pair;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.custom.DDBoat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class DDBoatRenderer<T extends DDBoat> extends EntityRenderer<T> {
    private final Map<DDBoat.Type, Pair<ResourceLocation, BoatModel>> boatResources = Maps.newHashMap();

    public DDBoatRenderer(EntityRendererProvider.Context pContext, boolean hasChest) {
        super(pContext);
        for(DDBoat.Type type : DDBoat.Type.values()) {
            String folder = hasChest ? "chest_boat" : "boat";
            ResourceLocation texture = new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/" + folder + "/" + type.getName() + ".png");
            BoatModel model = new BoatModel(pContext.bakeLayer(hasChest ? DDBoatModels.boatChest : DDBoatModels.boat), hasChest);

            boatResources.put(type, Pair.of(texture, model));
        }
    }

    @Override
    public void render(T boat, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();
        matrixStack.translate(0.0, 0.375, 0.0);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0f - entityYaw));

        float f = (float) boat.getHurtTime() - partialTicks;
        float g = boat.getDamage() - partialTicks;
        if(g < 0.0f) g = 0.0f;
        if(f > 0.0f)
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * g / 10.0f * (float) boat.getHurtDir()));

        if(!Mth.equal(boat.getBubbleAngle(partialTicks), 0.0f)) {
            matrixStack.mulPose(new Quaternion(new Vector3f(1.0f, 0.0f, 1.0f), boat.getBubbleAngle(partialTicks), true));
        }

        Pair<ResourceLocation, BoatModel> pair = this.boatResources.get(boat.getWoodType());
        ResourceLocation resourceLocation = pair.first;
        BoatModel boatModel = pair.second;
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(90.0f));
        boatModel.setupAnim(boat, partialTicks, 0.0f, -0.1f, 0.0f, 0.0f);

        VertexConsumer vertexConsumer = buffer.getBuffer(boatModel.renderType(resourceLocation));
        boatModel.renderToBuffer(matrixStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);

        if(!boat.isUnderWater()) {
            VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.waterMask());
            boatModel.waterPatch().render(matrixStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY);
        }

        matrixStack.popPose();

        super.render(boat, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DDBoat boat) {
        return boatResources.get(boat.getWoodType()).first;
    }
}
