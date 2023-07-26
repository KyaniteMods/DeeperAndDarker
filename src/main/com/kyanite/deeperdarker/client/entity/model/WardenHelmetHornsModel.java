package com.kyanite.deeperdarker.client.entity.model;

import ModelData;
import ModelPart;
import TexturedModelData;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class WardenHelmetHornsModel<T extends LivingEntity> extends net.minecraft.client.model.EntityModel<T> implements ModelWithHead {
    private final ModelPart head;
    private final ModelPart leftHorn;
    private final ModelPart rightHorn;

    public WardenHelmetHornsModel(ModelPart head) {
        this.head = head;
        this.leftHorn = head.getChild("left_horn");
        this.rightHorn = head.getChild("right_horn");
    }

    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("left_horn", ModelPartBuilder.create().uv(0, 10).cuboid(4.0f, 0.0f, 0.0f, 8.0f, 10.0f, 0.0f), ModelTransform.NONE);
        modelPartData.addChild("right_horn", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0f, 0.0f, 0.0f, 8.0f, 10.0f, 0.0f), ModelTransform.NONE);
        return modelData;
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getModelData(), 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
                       float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
                          float headPitch) {
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }
}