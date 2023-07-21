package com.kyanite.deeperdarker.client.entity.model;

import com.kyanite.deeperdarker.client.entity.animation.ShriekWormAnimation;
import com.kyanite.deeperdarker.entities.ShriekWormEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ShriekWormEntityModel extends SinglePartEntityModel<ShriekWormEntity> {
    private final ModelPart root;

    public ShriekWormEntityModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData mesh = new ModelData();
        ModelPartData parts = mesh.getRoot();

        ModelPartData root = parts.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 11.0F, 0.0F));

        ModelPartData base = root.addChild("base", ModelPartBuilder.create().uv(0, 136).cuboid(-6.0F, -5.0F, -6.0F, 12.0F, 18.0F, 12.0F, new Dilation(0.0F))
                .uv(48, 138).cuboid(-5.0F, -6.0F, -5.0F, 10.0F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData segment_1 = base.addChild("segment_1", ModelPartBuilder.create().uv(0, 118).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 122).cuboid(-2.0F, -8.0F, 3.75F, 4.0F, 12.0F, 2.0F, new Dilation(0.0F))
                .uv(45, 113).cuboid(0.0F, -12.0F, 6.0F, 0.0F, 16.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));
        ModelPartData segment_2 = segment_1.addChild("segment_2", ModelPartBuilder.create().uv(0, 101).cuboid(-4.5F, -10.0F, -3.5F, 9.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(32, 106).cuboid(-2.0F, -10.0F, 3.5F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.5F));
        ModelPartData segment_3 = segment_2.addChild("segment_3", ModelPartBuilder.create().uv(0, 84).cuboid(-5.5F, -10.0F, -3.5F, 11.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(36, 89).cuboid(-2.0F, -10.0F, 3.5F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(49, 88).cuboid(0.0F, -10.0F, 5.5F, 0.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.5F));

        ModelPartData rib_1 = segment_3.addChild("rib_1", ModelPartBuilder.create().uv(102, 113).cuboid(-5.5F, -2.0F, 0.25F, 11.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(146, 109).cuboid(-10.46F, -2.0F, -8.69F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(146, 109).cuboid(8.46F, -2.0F, -8.69F, 2.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(102, 97).cuboid(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.5F, 3.5F));
        rib_1.addChild("rib_1_r1", ModelPartBuilder.create().uv(162, 113).mirrored().cuboid(-3.42F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 39.0F, -2.25F, 0.0F, -0.7854F, 0.0F));
        rib_1.addChild("rib_1_r2", ModelPartBuilder.create().uv(128, 113).cuboid(0.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 39.0F, -4.25F, 0.0F, 0.7854F, 0.0F));
        rib_1.addChild("rib_1_r3", ModelPartBuilder.create().uv(162, 113).cuboid(-3.58F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 39.0F, -2.25F, 0.0F, 0.7854F, 0.0F));
        rib_1.addChild("rib_1_r4", ModelPartBuilder.create().uv(128, 113).mirrored().cuboid(-7.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, 39.0F, -4.25F, 0.0F, -0.7854F, 0.0F));

        ModelPartData segment_4 = segment_3.addChild("segment_4", ModelPartBuilder.create().uv(0, 67).cuboid(-6.5F, -10.0F, -3.25F, 13.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(40, 72).cuboid(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(53, 69).cuboid(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.25F));

        ModelPartData rib_2 = segment_4.addChild("rib_2", ModelPartBuilder.create().uv(102, 103).cuboid(-6.5F, -2.0F, 0.25F, 13.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(150, 97).cuboid(-11.46F, -2.0F, -10.69F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(150, 97).cuboid(9.46F, -2.0F, -10.69F, 2.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(102, 97).cuboid(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 3.25F));
        rib_2.addChild("rib_2_r1", ModelPartBuilder.create().uv(170, 103).mirrored().cuboid(-3.42F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(132, 103).mirrored().cuboid(-7.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 39.0F, -4.25F, 0.0F, -0.7854F, 0.0F));
        rib_2.addChild("rib_2_r2", ModelPartBuilder.create().uv(132, 103).cuboid(0.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(170, 103).cuboid(-3.58F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 39.0F, -4.25F, 0.0F, 0.7854F, 0.0F));

        ModelPartData segment_5 = segment_4.addChild("segment_5", ModelPartBuilder.create().uv(0, 50).cuboid(-7.5F, -10.0F, -3.25F, 15.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(44, 55).cuboid(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(57, 51).cuboid(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.5F));

        ModelPartData rib_3 = segment_5.addChild("rib_3", ModelPartBuilder.create().uv(154, 83).cuboid(-12.46F, -2.0F, -12.69F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(154, 83).cuboid(10.46F, -2.0F, -12.69F, 2.0F, 4.0F, 10.0F, new Dilation(0.0F))
                .uv(102, 91).cuboid(-7.5F, -2.0F, 0.25F, 15.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(102, 97).cuboid(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 3.25F));
        rib_3.addChild("rib_3_r1", ModelPartBuilder.create().uv(178, 91).mirrored().cuboid(-3.78F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(136, 91).mirrored().cuboid(-7.36F, -52.0F, 8.26F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 50.0F, -4.75F, 0.0F, -0.7854F, 0.0F));
        rib_3.addChild("rib_3_r2", ModelPartBuilder.create().uv(136, 91).cuboid(0.36F, -52.0F, 8.26F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(178, 91).cuboid(-3.22F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 50.0F, -4.75F, 0.0F, 0.7854F, 0.0F));

        ModelPartData segment_6 = segment_5.addChild("segment_6", ModelPartBuilder.create().uv(0, 33).cuboid(-9.0F, -10.0F, -3.25F, 18.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(50, 38).cuboid(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(63, 31).cuboid(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));

        ModelPartData rib_4 = segment_6.addChild("rib_4", ModelPartBuilder.create().uv(162, 68).cuboid(-14.26F, -2.0F, -13.99F, 2.0F, 4.0F, 11.0F, new Dilation(0.0F))
                .uv(162, 68).cuboid(12.26F, -2.0F, -13.99F, 2.0F, 4.0F, 11.0F, new Dilation(0.0F))
                .uv(102, 77).cuboid(-9.0F, -2.0F, 0.25F, 18.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(102, 83).cuboid(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 3.25F));
        rib_4.addChild("rib_4_r1", ModelPartBuilder.create().uv(188, 77).mirrored().cuboid(-3.78F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.8F, 50.0F, -6.05F, 0.0F, -0.7854F, 0.0F));
        rib_4.addChild("rib_4_r2", ModelPartBuilder.create().uv(142, 77).cuboid(-0.14F, -52.0F, 8.26F, 8.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 50.0F, -4.75F, 0.0F, 0.7854F, 0.0F));
        rib_4.addChild("rib_4_r3", ModelPartBuilder.create().uv(142, 77).mirrored().cuboid(-7.86F, -52.0F, 8.26F, 8.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.5F, 50.0F, -4.75F, 0.0F, -0.7854F, 0.0F));
        rib_4.addChild("rib_4_r4", ModelPartBuilder.create().uv(188, 77).cuboid(-3.22F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.8F, 50.0F, -6.05F, 0.0F, 0.7854F, 0.0F));

        ModelPartData segment_7 = segment_6.addChild("segment_7", ModelPartBuilder.create().uv(0, 16).cuboid(-10.0F, -10.0F, -3.25F, 20.0F, 10.0F, 7.0F, new Dilation(0.0F))
                .uv(54, 21).cuboid(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(67, 13).cuboid(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));
        ModelPartData segment_8 = segment_7.addChild("segment_8", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -10.0F, -3.0F, 16.0F, 10.0F, 6.0F, new Dilation(0.0F))
                .uv(44, 4).cuboid(-2.0F, -10.0F, 3.0F, 4.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(57, -4).mirrored().cuboid(0.0F, -10.0F, 5.0F, 0.0F, 10.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -10.0F, -0.25F));

        ModelPartData head = segment_8.addChild("head", ModelPartBuilder.create().uv(102, 52).cuboid(-6.0F, -4.0F, -6.0F, 12.0F, 4.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));
        ModelPartData flaps = head.addChild("flaps", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData front_flap = flaps.addChild("front_flap", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -6.0F));
        ModelPartData front_bottom_flap = front_flap.addChild("front_bottom_flap", ModelPartBuilder.create().uv(130, 0).cuboid(-6.0F, -12.0F, -2.0F, 12.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData front_middle_flap = front_bottom_flap.addChild("front_middle_flap", ModelPartBuilder.create().uv(102, 22).cuboid(-6.0F, -8.0F, -1.0F, 12.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, -1.0F));
        front_middle_flap.addChild("front_top_flap", ModelPartBuilder.create().uv(106, 0).cuboid(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData right_flap = flaps.addChild("right_flap", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, 0.0F, 0.0F));
        ModelPartData right_bottom_flap = right_flap.addChild("right_bottom_flap", ModelPartBuilder.create().uv(130, 14).cuboid(-2.0F, -12.0F, -6.0F, 2.0F, 12.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData right_middle_flap = right_bottom_flap.addChild("right_middle_flap", ModelPartBuilder.create().uv(102, 32).cuboid(-1.0F, -8.0F, -6.0F, 2.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -12.0F, 0.0F));
        right_middle_flap.addChild("right_top_flap", ModelPartBuilder.create().uv(106, 8).cuboid(-1.0F, -6.0F, -4.0F, 2.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData left_flap = flaps.addChild("left_flap", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, 0.0F, 0.0F));
        ModelPartData left_bottom_flap = left_flap.addChild("left_bottom_flap", ModelPartBuilder.create().uv(158, 14).cuboid(0.0F, -12.0F, -6.0F, 2.0F, 12.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData left_middle_flap = left_bottom_flap.addChild("left_middle_flap", ModelPartBuilder.create().uv(102, 32).cuboid(-1.0F, -8.0F, -6.0F, 2.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -12.0F, 0.0F));
        left_middle_flap.addChild("left_top_flap", ModelPartBuilder.create().uv(106, 8).cuboid(-1.0F, -6.0F, -4.0F, 2.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData back_flap = flaps.addChild("back_flap", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
        ModelPartData back_bottom_flap = back_flap.addChild("back_bottom_flap", ModelPartBuilder.create().uv(158, 0).cuboid(-6.0F, -12.0F, 0.0F, 12.0F, 12.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData back_middle_flap = back_bottom_flap.addChild("back_middle_flap", ModelPartBuilder.create().uv(102, 22).cuboid(-6.0F, -8.0F, -1.0F, 12.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 1.0F));
        back_middle_flap.addChild("back_top_flap", ModelPartBuilder.create().uv(106, 0).cuboid(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        return TexturedModelData.of(mesh, 256, 256);
    }

    @Override
    public void setAngles(ShriekWormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.traverse().forEach(ModelPart::resetTransform);
        this.updateAnimation(entity.idleState, ShriekWormAnimation.IDLE, ageInTicks);
        this.updateAnimation(entity.attackState, ShriekWormAnimation.ATTACK, ageInTicks);
        this.updateAnimation(entity.asleepState, ShriekWormAnimation.ASLEEP, ageInTicks);
        this.updateAnimation(entity.emergeState, ShriekWormAnimation.EMERGE, ageInTicks);
        this.updateAnimation(entity.descendState, ShriekWormAnimation.DESCEND, ageInTicks);
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