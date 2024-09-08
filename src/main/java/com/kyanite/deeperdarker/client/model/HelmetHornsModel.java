package com.kyanite.deeperdarker.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class HelmetHornsModel<T extends LivingEntity> extends EntityModel<T> implements HeadedModel {
    private final ModelPart head;
    private final ModelPart leftHorn;
    private final ModelPart rightHorn;

    public HelmetHornsModel(ModelPart head) {
        this.head = head;
        this.leftHorn = head.getChild("left_horn");
        this.rightHorn = head.getChild("right_horn");
    }

    public static MeshDefinition getModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        modelPartData.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(0, 10).addBox(4.0f, 0.0f, 0.0f, 8.0f, 10.0f, 0.0f), PartPose.ZERO);
        modelPartData.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0f, 0.0f, 0.0f, 8.0f, 10.0f, 0.0f), PartPose.ZERO);
        return modelData;
    }

    public static LayerDefinition getTexturedModelData() {
        return LayerDefinition.create(getModelData(), 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
        this.head.render(poseStack, vertexConsumer, i, j, f, g, h, k);
    }

    @Override
    public void setupAnim(T entity, float f, float g, float h, float i, float j) {
        this.head.yRot = i * 0.017453292F;
        this.head.xRot = j * 0.017453292F;
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }
}