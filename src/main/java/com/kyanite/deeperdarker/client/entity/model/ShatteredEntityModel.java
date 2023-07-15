package com.kyanite.deeperdarker.client.entity.model;

import com.kyanite.deeperdarker.client.entity.animation.ShatteredAnimation;
import com.kyanite.deeperdarker.entities.ShatteredEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ShatteredEntityModel extends SinglePartEntityModel<ShatteredEntity> {
    private final ModelPart root;
    private final ModelPart head;

    public ShatteredEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("root");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData mesh = new ModelData();
        ModelPartData parts = mesh.getRoot();

        ModelPartData root = parts.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -13.0F, -2.0F, 8.0F, 13.0F, 4.0F, new Dilation(0.0F))
                .uv(37, 6).mirrored().cuboid(0.0F, -11.0F, 2.0F, 0.0F, 11.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -13.0F, 0.0F));
        body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-12.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(40, 0).mirrored().cuboid(4.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -13.0F, 0.0F));

        ModelPartData arms = body.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -11.0F, 0.0F));
        arms.addChild("right_arm", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F))
                .uv(43, 8).cuboid(-4.0F, 11.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));
        arms.addChild("left_arm", ModelPartBuilder.create().uv(40, 16).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(44, 27).cuboid(1.0F, 5.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

        ModelPartData legs = root.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -13.0F, 0.0F));
        legs.addChild("right_leg", ModelPartBuilder.create().uv(0, 33).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(4, 41).cuboid(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 47).cuboid(-2.0F, 8.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, 0.0F));
        legs.addChild("left_leg", ModelPartBuilder.create().uv(16, 33).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

        return TexturedModelData.of(mesh, 64, 64);
    }

    @Override
    public void setAngles(ShatteredEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.traverse().forEach(ModelPart::resetTransform);
        applyHeadRotation(netHeadYaw, headPitch);
        this.animateMovement(ShatteredAnimation.WALK, limbSwing, limbSwingAmount, 5.5f, 2.5f);
        this.updateAnimation(entity.idleState, ShatteredAnimation.IDLE, ageInTicks);
        this.updateAnimation(entity.attackState, ShatteredAnimation.ATTACK, ageInTicks);
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
