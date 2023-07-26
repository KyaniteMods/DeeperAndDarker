package com.kyanite.deeperdarker.client.entity.model;

import ModelPart;
import TexturedModelData;
import com.kyanite.deeperdarker.client.entity.animation.SculkLeechAnimation;
import com.kyanite.deeperdarker.entities.SculkLeechEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SculkLeechEntityModel extends SinglePartEntityModel<SculkLeechEntity> {
    private final ModelPart root;

    public SculkLeechEntityModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData parts = data.getRoot();

        ModelPartData root = parts.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.75F, -1.0F));

        root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, -1).cuboid(1.0F, -0.5F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(-1, 0).cuboid(-1.0F, 1.5F, -4.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -0.5F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(-1, 1).cuboid(-1.0F, -1.5F, -4.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(9, -2).cuboid(-0.5F, -3.5F, -3.0F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -0.25F, -3.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 6).cuboid(-1.5F, -1.25F, -0.25F, 2.0F, 2.75F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -0.25F, -3.0F));
        body.addChild("body_tendrils", ModelPartBuilder.create().uv(-3, 12).cuboid(-3.0F, 0.0F, -0.85F, 6.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.25F, 0.85F));
        body.addChild("body_fin", ModelPartBuilder.create().uv(7, 4).cuboid(0.0F, -2.0F, -0.85F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.25F, 0.85F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 15).cuboid(-1.4F, -1.15F, 0.0F, 1.8F, 2.25F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.25F, 2.75F));
        tail.addChild("tail_tendrils", ModelPartBuilder.create().uv(-3, 21).cuboid(-3.0F, 0.0F, -1.0F, 6.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.0F, 1.0F));
        tail.addChild("tail_fin", ModelPartBuilder.create().uv(7, 12).cuboid(0.0F, -2.05F, -0.85F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -1.1F, 0.85F));
        ModelPartData backTail = tail.addChild("back_tail", ModelPartBuilder.create().uv(15, 1).cuboid(-1.15F, -0.9F, 0.0F, 1.3F, 1.9F, 4.0F, new Dilation(0.0F))
                .uv(8, 7).cuboid(-3.5F, 0.0F, 0.0F, 6.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 3.0F));
        backTail.addChild("back_tail_fin", ModelPartBuilder.create().uv(23, 0).cuboid(0.0F, -2.05F, -0.5F, 0.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, -0.85F, 1.5F));

        return TexturedModelData.of(data, 32, 32);
    }

    @Override
    public void setAngles(SculkLeechEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(SculkLeechAnimation.MOVE, limbSwing, limbSwingAmount, 2.0f, 2.5f);
    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.getChild("root").render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}