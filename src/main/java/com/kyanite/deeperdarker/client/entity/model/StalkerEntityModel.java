package com.kyanite.deeperdarker.client.entity.model;

import com.kyanite.deeperdarker.client.entity.animation.StalkerAnimation;
import com.kyanite.deeperdarker.entities.StalkerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class StalkerEntityModel extends SinglePartEntityModel<StalkerEntity> {
    private final ModelPart root;
    private final ModelPart head;


    public StalkerEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("root").getChild("waist");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData mesh = new ModelData();
        ModelPartData parts = mesh.getRoot();

        ModelPartData root = parts.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData waist = root.addChild("waist", ModelPartBuilder.create().uv(18, 46).cuboid(-6.5F, -2.0F, -3.0F, 7.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(44, 46).cuboid(0.5F, -2.0F, -3.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -29.0F, 0.5F));

        ModelPartData body = waist.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        body.addChild("body_top", ModelPartBuilder.create().uv(24, 9).cuboid(-7.0F, -4.0F, -3.5F, 14.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));
        body.addChild("body_right", ModelPartBuilder.create().uv(24, 20).cuboid(-3.0F, -4.5F, -3.5F, 3.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -7.5F, 0.0F));
        body.addChild("body_left", ModelPartBuilder.create().uv(44, 20).cuboid(0.0F, -4.5F, -3.5F, 3.0F, 9.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -7.5F, 0.0F));
        body.addChild("body_bottom", ModelPartBuilder.create().uv(24, 36).cuboid(-7.0F, 0.0F, -3.5F, 14.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -24.0F, -3.0F, 6.0F, 24.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -16.0F, 0.0F));
        head.addChild("right_ear", ModelPartBuilder.create().uv(24, 0).cuboid(-4.98F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.02F, -18.5F, 0.0F));
        head.addChild("left_ear", ModelPartBuilder.create().uv(42, 1).cuboid(-0.02F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.02F, -16.5F, 0.0F));

        ModelPartData arms = body.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -13.0F, 0.0F));
        arms.addChild("right_arm", ModelPartBuilder.create().uv(0, 30).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 31.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -0.5F));
        arms.addChild("left_arm", ModelPartBuilder.create().uv(0, 66).cuboid(0.0F, -2.0F, -2.5F, 5.0F, 22.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, 0.0F, 0.0F));

        ModelPartData teeth = body.addChild("teeth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.5F, -3.5F));
        teeth.addChild("upper_right_tooth", ModelPartBuilder.create().uv(66, 2).cuboid(-1.3536F, -1.1465F, -5.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.3964F, -5.6035F, 0.0F));
        teeth.addChild("upper_left_tooth", ModelPartBuilder.create().uv(80, 0).cuboid(-1.3536F, -0.8535F, -7.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(5.1036F, -4.8965F, 0.0F));
        teeth.addChild("lower_right_tooth", ModelPartBuilder.create().uv(66, 9).cuboid(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.75F, 5.25F, 0.0F));
        teeth.addChild("lower_left_tooth", ModelPartBuilder.create().uv(84, 9).cuboid(-1.0F, -1.5F, -6.0F, 2.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(4.75F, 5.25F, 0.0F));

        ModelPartData back = body.addChild("back", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 31.0F, -0.5F));
        back.addChild("upper_back", ModelPartBuilder.create().uv(68, 18).cuboid(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -44.5F, 4.0F));
        back.addChild("middle_back", ModelPartBuilder.create().uv(68, 29).cuboid(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -38.0F, 4.0F));
        back.addChild("lower_back", ModelPartBuilder.create().uv(68, 44).cuboid(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, -33.5F, 4.0F));
        back.addChild("vase", ModelPartBuilder.create().uv(72, 58).cuboid(-4.0F, -16.0F, -3.9167F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(64, 69).cuboid(-6.0F, -13.0F, -5.9167F, 12.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(68, 93).cuboid(-5.0F, -1.0F, -4.9167F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -38.5F, 15.4167F, 1.5708F, 0.0F, 0.0F));

        ModelPartData legs = waist.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        legs.addChild("right_leg", ModelPartBuilder.create().uv(24, 54).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 29.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, 0.0F, 0.0F));
        legs.addChild("left_leg", ModelPartBuilder.create().uv(44, 55).cuboid(-2.5F, 0.0F, -2.5F, 5.0F, 28.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(3.5F, 1.0F, 0.0F));

        root.addChild("fake_vase", ModelPartBuilder.create().uv(72, 58).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(64, 69).cuboid(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(68, 93).cuboid(-5.0F, 6.0F, -5.0F, 10.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        return TexturedModelData.of(mesh, 128, 128);
    }

    @Override
    public void setAngles(StalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.traverse().forEach(ModelPart::resetTransform);
        applyHeadRotation(netHeadYaw, headPitch);
        this.animateMovement(StalkerAnimation.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleState, StalkerAnimation.IDLE, ageInTicks);
        this.updateAnimation(entity.attackState, StalkerAnimation.ATTACK, ageInTicks);
        this.updateAnimation(entity.ringAttackState, StalkerAnimation.RING_ATTACK, ageInTicks);
        this.updateAnimation(entity.emergeState, StalkerAnimation.EMERGE, ageInTicks);
    }

    private void applyHeadRotation(float netHeadYaw, float headPitch) {
        netHeadYaw = MathHelper.clamp(netHeadYaw, -30, 30);
        headPitch = MathHelper.clamp(headPitch, -25, 45);
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180f);
        this.head.pitch = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.getChild("root").render(matrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}