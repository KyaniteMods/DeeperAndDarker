package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.ShriekWorm;
import com.kyanite.deeperdarker.content.entities.animations.ShriekWormAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@SuppressWarnings("NullableProblems")
public class ShriekWormModel extends HierarchicalModel<ShriekWorm> {
	private final ModelPart root;

	public ShriekWormModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 136).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(48, 138).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segment_1 = base.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(0, 118).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 122).addBox(-2.0F, -8.0F, 3.75F, 4.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(45, 113).addBox(0.0F, -12.0F, 6.0F, 0.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(0, 101).addBox(-4.5F, -10.0F, -3.5F, 9.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(32, 106).addBox(-2.0F, -10.0F, 3.5F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.5F));
		PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(0, 84).addBox(-5.5F, -10.0F, -3.5F, 11.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(36, 89).addBox(-2.0F, -10.0F, 3.5F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(49, 88).addBox(0.0F, -10.0F, 5.5F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.5F));

		PartDefinition rib_1 = segment_3.addOrReplaceChild("rib_1", CubeListBuilder.create().texOffs(102, 113).addBox(-5.5F, -2.0F, 0.25F, 11.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(146, 109).addBox(-10.46F, -2.0F, -8.69F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(146, 109).addBox(8.46F, -2.0F, -8.69F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(102, 97).addBox(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 3.5F));
		rib_1.addOrReplaceChild("rib_1_r1", CubeListBuilder.create().texOffs(162, 113).mirror().addBox(-3.42F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 39.0F, -2.25F, 0.0F, -0.7854F, 0.0F));
		rib_1.addOrReplaceChild("rib_1_r2", CubeListBuilder.create().texOffs(128, 113).addBox(0.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 39.0F, -4.25F, 0.0F, 0.7854F, 0.0F));
		rib_1.addOrReplaceChild("rib_1_r3", CubeListBuilder.create().texOffs(162, 113).addBox(-3.58F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 39.0F, -2.25F, 0.0F, 0.7854F, 0.0F));
		rib_1.addOrReplaceChild("rib_1_r4", CubeListBuilder.create().texOffs(128, 113).mirror().addBox(-7.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 39.0F, -4.25F, 0.0F, -0.7854F, 0.0F));

		PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(0, 67).addBox(-6.5F, -10.0F, -3.25F, 13.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(40, 72).addBox(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(53, 69).addBox(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.25F));

		PartDefinition rib_2 = segment_4.addOrReplaceChild("rib_2", CubeListBuilder.create().texOffs(102, 103).addBox(-6.5F, -2.0F, 0.25F, 13.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(150, 97).addBox(-11.46F, -2.0F, -10.69F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(150, 97).addBox(9.46F, -2.0F, -10.69F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(102, 97).addBox(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 3.25F));
		rib_2.addOrReplaceChild("rib_2_r1", CubeListBuilder.create().texOffs(170, 103).mirror().addBox(-3.42F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(132, 103).mirror().addBox(-7.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 39.0F, -4.25F, 0.0F, -0.7854F, 0.0F));
		rib_2.addOrReplaceChild("rib_2_r2", CubeListBuilder.create().texOffs(132, 103).addBox(0.0F, -41.0F, 7.2F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(170, 103).addBox(-3.58F, -41.0F, -12.72F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 39.0F, -4.25F, 0.0F, 0.7854F, 0.0F));

		PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(0, 50).addBox(-7.5F, -10.0F, -3.25F, 15.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(44, 55).addBox(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(57, 51).addBox(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.5F));

		PartDefinition rib_3 = segment_5.addOrReplaceChild("rib_3", CubeListBuilder.create().texOffs(154, 83).addBox(-12.46F, -2.0F, -12.69F, 2.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(154, 83).addBox(10.46F, -2.0F, -12.69F, 2.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(102, 91).addBox(-7.5F, -2.0F, 0.25F, 15.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 97).addBox(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 3.25F));
		rib_3.addOrReplaceChild("rib_3_r1", CubeListBuilder.create().texOffs(178, 91).mirror().addBox(-3.78F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(136, 91).mirror().addBox(-7.36F, -52.0F, 8.26F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 50.0F, -4.75F, 0.0F, -0.7854F, 0.0F));
		rib_3.addOrReplaceChild("rib_3_r2", CubeListBuilder.create().texOffs(136, 91).addBox(0.36F, -52.0F, 8.26F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(178, 91).addBox(-3.22F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.0F, -4.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(0, 33).addBox(-9.0F, -10.0F, -3.25F, 18.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(50, 38).addBox(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(63, 31).addBox(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition rib_4 = segment_6.addOrReplaceChild("rib_4", CubeListBuilder.create().texOffs(162, 68).addBox(-14.26F, -2.0F, -13.99F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(162, 68).addBox(12.26F, -2.0F, -13.99F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(102, 77).addBox(-9.0F, -2.0F, 0.25F, 18.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(102, 83).addBox(-2.5F, -1.5F, 2.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 3.25F));
		rib_4.addOrReplaceChild("rib_4_r1", CubeListBuilder.create().texOffs(188, 77).mirror().addBox(-3.78F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, 50.0F, -6.05F, 0.0F, -0.7854F, 0.0F));
		rib_4.addOrReplaceChild("rib_4_r2", CubeListBuilder.create().texOffs(142, 77).addBox(-0.14F, -52.0F, 8.26F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 50.0F, -4.75F, 0.0F, 0.7854F, 0.0F));
		rib_4.addOrReplaceChild("rib_4_r3", CubeListBuilder.create().texOffs(142, 77).mirror().addBox(-7.86F, -52.0F, 8.26F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 50.0F, -4.75F, 0.0F, -0.7854F, 0.0F));
		rib_4.addOrReplaceChild("rib_4_r4", CubeListBuilder.create().texOffs(188, 77).addBox(-3.22F, -52.0F, -14.42F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 50.0F, -6.05F, 0.0F, 0.7854F, 0.0F));

		PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(0, 16).addBox(-10.0F, -10.0F, -3.25F, 20.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(54, 21).addBox(-2.0F, -10.0F, 3.25F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(67, 13).addBox(0.0F, -10.0F, 5.25F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition segment_8 = segment_7.addOrReplaceChild("segment_8", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.0F, -3.0F, 16.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(44, 4).addBox(-2.0F, -10.0F, 3.0F, 4.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(57, -4).mirror().addBox(0.0F, -10.0F, 5.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -10.0F, -0.25F));

		PartDefinition head = segment_8.addOrReplaceChild("head", CubeListBuilder.create().texOffs(102, 52).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition flaps = head.addOrReplaceChild("flaps", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition front_flap = flaps.addOrReplaceChild("front_flap", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition front_bottom_flap = front_flap.addOrReplaceChild("front_bottom_flap", CubeListBuilder.create().texOffs(130, 0).addBox(-6.0F, -12.0F, -2.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition front_middle_flap = front_bottom_flap.addOrReplaceChild("front_middle_flap", CubeListBuilder.create().texOffs(102, 22).addBox(-6.0F, -8.0F, -1.0F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -1.0F));
		front_middle_flap.addOrReplaceChild("front_top_flap", CubeListBuilder.create().texOffs(106, 0).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition right_flap = flaps.addOrReplaceChild("right_flap", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, 0.0F));
		PartDefinition right_bottom_flap = right_flap.addOrReplaceChild("right_bottom_flap", CubeListBuilder.create().texOffs(130, 14).addBox(-2.0F, -12.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_middle_flap = right_bottom_flap.addOrReplaceChild("right_middle_flap", CubeListBuilder.create().texOffs(102, 32).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -12.0F, 0.0F));
		right_middle_flap.addOrReplaceChild("right_top_flap", CubeListBuilder.create().texOffs(106, 8).addBox(-1.0F, -6.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition left_flap = flaps.addOrReplaceChild("left_flap", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));
		PartDefinition left_bottom_flap = left_flap.addOrReplaceChild("left_bottom_flap", CubeListBuilder.create().texOffs(158, 14).addBox(0.0F, -12.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_middle_flap = left_bottom_flap.addOrReplaceChild("left_middle_flap", CubeListBuilder.create().texOffs(102, 32).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -12.0F, 0.0F));
		left_middle_flap.addOrReplaceChild("left_top_flap", CubeListBuilder.create().texOffs(106, 8).addBox(-1.0F, -6.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition back_flap = flaps.addOrReplaceChild("back_flap", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 6.0F));
		PartDefinition back_bottom_flap = back_flap.addOrReplaceChild("back_bottom_flap", CubeListBuilder.create().texOffs(158, 0).addBox(-6.0F, -12.0F, 0.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition back_middle_flap = back_bottom_flap.addOrReplaceChild("back_middle_flap", CubeListBuilder.create().texOffs(102, 22).addBox(-6.0F, -8.0F, -1.0F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 1.0F));
		back_middle_flap.addOrReplaceChild("back_top_flap", CubeListBuilder.create().texOffs(106, 0).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		return LayerDefinition.create(mesh, 256, 256);
	}

	@Override
	public void setupAnim(ShriekWorm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleState, ShriekWormAnimation.IDLE, ageInTicks);
		this.animate(entity.attackState, ShriekWormAnimation.ATTACK, ageInTicks);
		this.animate(entity.asleepState, ShriekWormAnimation.ASLEEP, ageInTicks);
		this.animate(entity.emergeState, ShriekWormAnimation.EMERGE, ageInTicks);
		this.animate(entity.descendState, ShriekWormAnimation.DESCEND, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		root.getChild("root").render(poseStack, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
