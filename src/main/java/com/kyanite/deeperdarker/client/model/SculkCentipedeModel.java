package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import com.kyanite.deeperdarker.content.entities.animations.SculkCentipedeAnimation;
import com.kyanite.deeperdarker.content.entities.animations.SculkSnapperAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class SculkCentipedeModel extends HierarchicalModel<SculkCentipede> {
	private final ModelPart root;
	private final ModelPart segments;
	private final ModelPart head;
	private final ModelPart segment_1;
	private final ModelPart segment_1_legs_right;
	private final ModelPart segment_1_legs_left;
	private final ModelPart segment_2;
	private final ModelPart segment_2_legs_right;
	private final ModelPart segment_2_legs_left;
	private final ModelPart segment_3;
	private final ModelPart segment_3_legs_left;
	private final ModelPart segment_3_legs_right;
	private final ModelPart segment_4;
	private final ModelPart segment_4_legs_left;
	private final ModelPart segment_4_legs_right;
	private final ModelPart segment_5;
	private final ModelPart segment_5_legs_right;
	private final ModelPart segment_5_legs_left;
	private final ModelPart segment_6;
	private final ModelPart segment_6_legs_left;
	private final ModelPart segment_6_legs_right;
	private final ModelPart segment_7;
	private final ModelPart segment_7_legs_left;
	private final ModelPart segment_7_legs_right;

	public SculkCentipedeModel(ModelPart root) {
		this.root = root;
		this.segments = root.getChild("segments");
		this.head = this.segments.getChild("head");
		this.segment_1 = this.segments.getChild("segment_1");
		this.segment_1_legs_right = this.segment_1.getChild("segment_1_legs_right");
		this.segment_1_legs_left = this.segment_1.getChild("segment_1_legs_left");
		this.segment_2 = this.segment_1.getChild("segment_2");
		this.segment_2_legs_right = this.segment_2.getChild("segment_2_legs_right");
		this.segment_2_legs_left = this.segment_2.getChild("segment_2_legs_left");
		this.segment_3 = this.segment_2.getChild("segment_3");
		this.segment_3_legs_left = this.segment_3.getChild("segment_3_legs_left");
		this.segment_3_legs_right = this.segment_3.getChild("segment_3_legs_right");
		this.segment_4 = this.segment_3.getChild("segment_4");
		this.segment_4_legs_left = this.segment_4.getChild("segment_4_legs_left");
		this.segment_4_legs_right = this.segment_4.getChild("segment_4_legs_right");
		this.segment_5 = this.segment_4.getChild("segment_5");
		this.segment_5_legs_right = this.segment_5.getChild("segment_5_legs_right");
		this.segment_5_legs_left = this.segment_5.getChild("segment_5_legs_left");
		this.segment_6 = this.segment_5.getChild("segment_6");
		this.segment_6_legs_left = this.segment_6.getChild("segment_6_legs_left");
		this.segment_6_legs_right = this.segment_6.getChild("segment_6_legs_right");
		this.segment_7 = this.segment_6.getChild("segment_7");
		this.segment_7_legs_left = this.segment_7.getChild("segment_7_legs_left");
		this.segment_7_legs_right = this.segment_7.getChild("segment_7_legs_right");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition segments = partdefinition.addOrReplaceChild("segments", CubeListBuilder.create(), PartPose.offset(0.0F, 21.5F, 3.0F));

		PartDefinition head = segments.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 8).addBox(-3.0F, -2.5F, -6.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 48).addBox(-2.0F, -6.5F, -9.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(2.0F, -6.5F, -9.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -21.0F));

		PartDefinition segment_1 = segments.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -21.0F));

		PartDefinition segment_1_legs_right = segment_1.addOrReplaceChild("segment_1_legs_right", CubeListBuilder.create().texOffs(48, 42).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_1_legs_left = segment_1.addOrReplaceChild("segment_1_legs_left", CubeListBuilder.create().texOffs(56, 42).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(24, 41).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_2_legs_right = segment_2.addOrReplaceChild("segment_2_legs_right", CubeListBuilder.create().texOffs(48, 36).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_2_legs_left = segment_2.addOrReplaceChild("segment_2_legs_left", CubeListBuilder.create().texOffs(56, 36).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(0, 19).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_3_legs_left = segment_3.addOrReplaceChild("segment_3_legs_left", CubeListBuilder.create().texOffs(56, 30).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_3_legs_right = segment_3.addOrReplaceChild("segment_3_legs_right", CubeListBuilder.create().texOffs(48, 30).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(24, 8).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_4_legs_left = segment_4.addOrReplaceChild("segment_4_legs_left", CubeListBuilder.create().texOffs(56, 24).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_4_legs_right = segment_4.addOrReplaceChild("segment_4_legs_right", CubeListBuilder.create().texOffs(48, 24).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(24, 19).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_5_legs_right = segment_5.addOrReplaceChild("segment_5_legs_right", CubeListBuilder.create().texOffs(48, 18).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_5_legs_left = segment_5.addOrReplaceChild("segment_5_legs_left", CubeListBuilder.create().texOffs(56, 18).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(24, 30).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_6_legs_left = segment_6.addOrReplaceChild("segment_6_legs_left", CubeListBuilder.create().texOffs(56, 12).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_6_legs_right = segment_6.addOrReplaceChild("segment_6_legs_right", CubeListBuilder.create().texOffs(48, 12).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(0, 41).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, 0.0F, 6.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition segment_7_legs_left = segment_7.addOrReplaceChild("segment_7_legs_left", CubeListBuilder.create().texOffs(56, 6).addBox(0.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition segment_7_legs_right = segment_7.addOrReplaceChild("segment_7_legs_right", CubeListBuilder.create().texOffs(48, 6).addBox(-4.0F, -0.5F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(SculkCentipede entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		this.animateWalk(SculkCentipedeAnimation.CRAWL, limbSwing, limbSwingAmount, 2f, 2.5f);
		animate(entity.damageState, SculkCentipedeAnimation.DAMAGE, ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		segments.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
