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
	private final ModelPart base;
	private final ModelPart segment_1;
	private final ModelPart segment_1_tendrils;
	private final ModelPart segment_2;
	private final ModelPart segment_2_tendrils;
	private final ModelPart segment_3;
	private final ModelPart segment_3_tendrils;
	private final ModelPart segment_4;
	private final ModelPart segment_4_tendrils;
	private final ModelPart segment_5;
	private final ModelPart segment_5_tendrils;
	private final ModelPart segment_6;
	private final ModelPart segment_6_tendrils;
	private final ModelPart segment_7;
	private final ModelPart segment_7_tendrils;
	private final ModelPart segment_8;
	private final ModelPart segment_8_tendrils;
	private final ModelPart head;
	private final ModelPart flap_front;
	private final ModelPart medium_flap_front;
	private final ModelPart small_flap_front;
	private final ModelPart flap_back;
	private final ModelPart medium_flap_back;
	private final ModelPart small_flap_back;
	private final ModelPart flap_left;
	private final ModelPart medium_flap_left;
	private final ModelPart small_flap_left;
	private final ModelPart flap_right;
	private final ModelPart medium_flap_right;
	private final ModelPart small_flap_right;

	public ShriekWormModel(ModelPart root) {
		this.root = root;
		this.base = root.getChild("base");
		this.segment_1 = this.base.getChild("segment_1");
		this.segment_1_tendrils = this.segment_1.getChild("segment_1_tendrils");
		this.segment_2 = this.segment_1.getChild("segment_2");
		this.segment_2_tendrils = this.segment_2.getChild("segment_2_tendrils");
		this.segment_3 = this.segment_2.getChild("segment_3");
		this.segment_3_tendrils = this.segment_3.getChild("segment_3_tendrils");
		this.segment_4 = this.segment_3.getChild("segment_4");
		this.segment_4_tendrils = this.segment_4.getChild("segment_4_tendrils");
		this.segment_5 = this.segment_4.getChild("segment_5");
		this.segment_5_tendrils = this.segment_5.getChild("segment_5_tendrils");
		this.segment_6 = this.segment_5.getChild("segment_6");
		this.segment_6_tendrils = this.segment_6.getChild("segment_6_tendrils");
		this.segment_7 = this.segment_6.getChild("segment_7");
		this.segment_7_tendrils = this.segment_7.getChild("segment_7_tendrils");
		this.segment_8 = this.segment_7.getChild("segment_8");
		this.segment_8_tendrils = this.segment_8.getChild("segment_8_tendrils");
		this.head = this.segment_8.getChild("head");
		this.flap_front = this.head.getChild("flap_front");
		this.medium_flap_front = this.flap_front.getChild("medium_flap_front");
		this.small_flap_front = this.medium_flap_front.getChild("small_flap_front");
		this.flap_back = this.head.getChild("flap_back");
		this.medium_flap_back = this.flap_back.getChild("medium_flap_back");
		this.small_flap_back = this.medium_flap_back.getChild("small_flap_back");
		this.flap_left = this.head.getChild("flap_left");
		this.medium_flap_left = this.flap_left.getChild("medium_flap_left");
		this.small_flap_left = this.medium_flap_left.getChild("small_flap_left");
		this.flap_right = this.head.getChild("flap_right");
		this.medium_flap_right = this.flap_right.getChild("medium_flap_right");
		this.small_flap_right = this.medium_flap_right.getChild("small_flap_right");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(54, 88).addBox(-4.0F, -8.0F, -6.0F, 10.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, 1.0F));

		PartDefinition segment_1 = base.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(0, 106).addBox(-4.0F, -9.0F, -3.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(38, 89).addBox(-2.0F, -11.0F, 1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition segment_1_tendrils = segment_1.addOrReplaceChild("segment_1_tendrils", CubeListBuilder.create().texOffs(140, 32).addBox(0.0F, -6.5F, 0.0F, 0.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 5.0F));

		PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(94, 100).addBox(-5.0F, -12.0F, -4.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(44, 128).addBox(-2.0F, -14.0F, 0.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -9.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition segment_2_tendrils = segment_2.addOrReplaceChild("segment_2_tendrils", CubeListBuilder.create().texOffs(132, 128).addBox(0.0F, -7.0F, 0.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 4.0F));

		PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(84, 23).addBox(-6.0F, -14.0F, -3.0F, 12.0F, 14.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(16, 124).addBox(-2.0F, -16.0F, 1.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -1.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition segment_3_tendrils = segment_3.addOrReplaceChild("segment_3_tendrils", CubeListBuilder.create().texOffs(130, 52).addBox(0.0F, -9.0F, 0.0F, 0.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 5.0F));

		PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(84, 0).addBox(-7.0F, -16.0F, -4.0F, 14.0F, 16.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(100, 118).addBox(-2.0F, -18.0F, 1.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segment_4_tendrils = segment_4.addOrReplaceChild("segment_4_tendrils", CubeListBuilder.create().texOffs(32, 124).addBox(0.0F, -18.0F, 0.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(-11.0F, -10.0F, -20.0F, 22.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(0, 64).addBox(-9.0F, -16.0F, -5.0F, 18.0F, 16.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(116, 118).addBox(-2.0F, -18.0F, 2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-11.0F, -9.0F, -14.0F, 22.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -1.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition segment_5_tendrils = segment_5.addOrReplaceChild("segment_5_tendrils", CubeListBuilder.create().texOffs(126, 0).addBox(0.0F, -10.0F, 0.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 6.0F));

		PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(54, 64).addBox(-9.0F, -16.0F, -3.0F, 18.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 121).addBox(-2.0F, -18.0F, 3.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.001F))
				.texOffs(0, 44).addBox(-11.0F, -5.0F, -11.0F, 22.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition segment_6_tendrils = segment_6.addOrReplaceChild("segment_6_tendrils", CubeListBuilder.create().texOffs(128, 26).addBox(0.0F, -10.0F, 0.0F, 0.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 7.0F));

		PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(80, 44).addBox(-8.0F, -12.0F, -3.0F, 16.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(60, 128).addBox(-2.0F, -14.0F, 3.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition segment_7_tendrils = segment_7.addOrReplaceChild("segment_7_tendrils", CubeListBuilder.create().texOffs(76, 134).addBox(0.0F, -14.0F, 0.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition segment_8 = segment_7.addOrReplaceChild("segment_8", CubeListBuilder.create().texOffs(0, 89).addBox(-6.0F, -10.0F, -3.0F, 12.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(132, 110).addBox(-2.0F, -10.0F, 2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition segment_8_tendrils = segment_8.addOrReplaceChild("segment_8_tendrils", CubeListBuilder.create().texOffs(88, 134).addBox(0.0F, -10.0F, 0.0F, 0.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition head = segment_8.addOrReplaceChild("head", CubeListBuilder.create().texOffs(94, 88).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition flap_front = head.addOrReplaceChild("flap_front", CubeListBuilder.create().texOffs(126, 100).addBox(-5.0F, -8.0F, -2.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition medium_flap_front = flap_front.addOrReplaceChild("medium_flap_front", CubeListBuilder.create().texOffs(134, 86).addBox(-5.0F, -6.0F, -1.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition small_flap_front = medium_flap_front.addOrReplaceChild("small_flap_front", CubeListBuilder.create().texOffs(134, 94).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition flap_back = head.addOrReplaceChild("flap_back", CubeListBuilder.create().texOffs(130, 76).addBox(-5.0F, -8.0F, 0.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition medium_flap_back = flap_back.addOrReplaceChild("medium_flap_back", CubeListBuilder.create().texOffs(138, 0).addBox(-5.0F, -6.0F, -1.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition small_flap_back = medium_flap_back.addOrReplaceChild("small_flap_back", CubeListBuilder.create().texOffs(106, 82).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition flap_left = head.addOrReplaceChild("flap_left", CubeListBuilder.create().texOffs(28, 106).addBox(0.0F, -8.0F, -5.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition medium_flap_left = flap_left.addOrReplaceChild("medium_flap_left", CubeListBuilder.create().texOffs(52, 112).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition small_flap_left = medium_flap_left.addOrReplaceChild("small_flap_left", CubeListBuilder.create().texOffs(138, 8).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition flap_right = head.addOrReplaceChild("flap_right", CubeListBuilder.create().texOffs(106, 64).addBox(-2.0F, -8.0F, -5.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition medium_flap_right = flap_right.addOrReplaceChild("medium_flap_right", CubeListBuilder.create().texOffs(76, 118).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition small_flap_right = medium_flap_right.addOrReplaceChild("small_flap_right", CubeListBuilder.create().texOffs(140, 20).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(ShriekWorm entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleState, ShriekWormAnimation.IDLE, ageInTicks);
		this.animate(entity.attackState, ShriekWormAnimation.ATTACK, ageInTicks);
		this.animate(entity.emergeState, ShriekWormAnimation.EMERGE, ageInTicks);
		this.animate(entity.descendState, ShriekWormAnimation.DESCEND, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
