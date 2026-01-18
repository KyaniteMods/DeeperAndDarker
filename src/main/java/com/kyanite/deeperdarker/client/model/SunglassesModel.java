package com.kyanite.deeperdarker.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

public class SunglassesModel extends Model {
    private final ModelPart sunglasses;

    public SunglassesModel(ModelPart modelPart) {
        super(RenderType::entityTranslucent);
        this.sunglasses = modelPart.getChild("sunglasses");
    }

    public static LayerDefinition createModel() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("sunglasses", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    public void setupAnim(float yRot, float xRot) {
        sunglasses.yRot = yRot * Mth.DEG_TO_RAD;
        sunglasses.xRot = xRot * Mth.DEG_TO_RAD;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        poseStack.translate(0.0f, -0.25f, 0.0f);
        poseStack.scale(1.3f, 1.3f, 1.3f);
        poseStack.translate(0.0f, 0.25f, 0.0f);
        sunglasses.render(poseStack, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
