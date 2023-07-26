package com.kyanite.deeperdarker.client.entity.model;

import ModelPart;
import TexturedModelData;
import com.kyanite.deeperdarker.client.entity.animation.SculkSnapperAnimation;
import com.kyanite.deeperdarker.entities.SculkSnapperEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class SculkSnapperEntityModel extends SinglePartEntityModel<SculkSnapperEntity> {
    private final ModelPart root;
    private final ModelPart head;

    public SculkSnapperEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("root").getChild("body").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData mesh = new ModelData();
        ModelPartData parts = mesh.getRoot();

        ModelPartData root = parts.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.75F, -1.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 39).cuboid(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.5F, 1.5F));
        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 13).cuboid(-4.5F, -3.0F, -6.0F, 9.0F, 3.0F, 10.0F, new Dilation(0.0F))
                .uv(28, 3).cuboid(-4.0F, -5.0F, -5.75F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(28, -5).cuboid(4.25F, -5.0F, -5.0F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(28, -5).cuboid(-4.25F, -5.0F, -5.0F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -0.5F));
        head.addChild("tongue", ModelPartBuilder.create().uv(-8, 13).cuboid(-1.5F, 0.0F, -8.0F, 3.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.36F, 3.0F));
        ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -3.0F, -9.0F, 9.0F, 3.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 26).cuboid(-4.5F, -3.0F, -9.0F, 9.0F, 3.0F, 10.0F, new Dilation(0.3F))
                .uv(28, -8).cuboid(4.0F, 0.0F, -8.5F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(28, 0).cuboid(-4.0F, 0.0F, -8.5F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(28, -8).cuboid(-4.0F, 0.0F, -8.5F, 0.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 3.0F));
        jaw.addChild("tendril", ModelPartBuilder.create().uv(33, 37).cuboid(0.0F, -6.0F, -3.0F, 0.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

        ModelPartData legs = root.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 2.0F));
        legs.addChild("left_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-1.8F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.75F, -3.4F, -2.75F));
        legs.addChild("right_front_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-0.2F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.75F, -3.4F, -2.75F));
        legs.addChild("left_back_leg", ModelPartBuilder.create().uv(0, 0).cuboid(3.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.75F, -3.4F, 1.75F));
        legs.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 0).cuboid(-5.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.75F, -3.4F, 1.75F));

        return TexturedModelData.of(mesh, 48, 48);
    }

    @Override
    public void setAngles(SculkSnapperEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.traverse().forEach(ModelPart::resetTransform);
        applyHeadRotation(netHeadYaw, headPitch);
        this.animateMovement(SculkSnapperAnimation.WALK, limbSwing, limbSwingAmount, 2.0f, 2.5f);
        this.updateAnimation(entity.idleState, SculkSnapperAnimation.IDLE, ageInTicks);
        this.updateAnimation(entity.attackState, SculkSnapperAnimation.BITE, ageInTicks);
        this.updateAnimation(entity.sniffState, SculkSnapperAnimation.SNIFF, ageInTicks);
        this.updateAnimation(entity.digState, SculkSnapperAnimation.DIG, ageInTicks);
        this.updateAnimation(entity.emergeState, SculkSnapperAnimation.EMERGE, ageInTicks);
    }

    private void applyHeadRotation(float netHeadYaw, float headPitch) {
        netHeadYaw = MathHelper.clamp(netHeadYaw, -30, 30);
        headPitch = MathHelper.clamp(headPitch, -25, 45);
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180f);
        this.head.pitch = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.getChild("root").render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}
