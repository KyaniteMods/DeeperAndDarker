package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.SculkSnapper;
import com.kyanite.deeperdarker.content.entities.animations.SculkSnapperAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class SculkSnapperModel extends HierarchicalModel<SculkSnapper> {
	private final ModelPart body;
	private final ModelPart backRightLeg;
	private final ModelPart backLeftLeg;
	private final ModelPart frontRightLeg;
	private final ModelPart frontLeftLeg;
	private final ModelPart head;
	private final ModelPart lowerJaw;
	private final ModelPart upperJaw;

	public SculkSnapperModel(ModelPart root) {
		this.body = root.getChild("body");
		this.backRightLeg = this.body.getChild("back_right_leg");
		this.backLeftLeg = this.body.getChild("back_left_leg");
		this.frontRightLeg = this.body.getChild("front_right_leg");
		this.frontLeftLeg = this.body.getChild("front_left_leg");
		this.head = this.body.getChild("head");
		this.lowerJaw = this.head.getChild("lower_jaw");
		this.upperJaw = this.head.getChild("upper_jaw");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 34).addBox(-3.0F, -2.99F, -4.0F, 6.0F, 2.0F, 8.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 23.0F, 0.0F));

		body.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(36, 34).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-2.0F, -1.0F, 4.0F));

		body.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(28, 34).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(2.0F, -1.0F, 4.0F));

		body.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(28, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(-2.0F, -1.0F, -2.0F));

		body.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(36, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(2.0F, -1.0F, -2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 4.0F));

		head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 17).addBox(-5.0F, -2.0F, -12.0F, 10.0F, 5.0F, 12.0F, CubeDeformation.NONE)
				.texOffs(0, 56).addBox(-4.5F, -2.0F, -11.5F, 9.0F, 2.0F, 11.0F, CubeDeformation.NONE)
				.texOffs(-1, 44).addBox(-5.0F, 0.0F, -12.0F, 10.0F, 0.0F, 12.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 0.0F, 0.0F));

		head.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -12.0F, 10.0F, 5.0F, 12.0F, new CubeDeformation(0.1F))
				.texOffs(40, 56).addBox(-4.5F, -2.0F, -11.5F, 9.0F, 2.0F, 11.0F, CubeDeformation.NONE)
				.texOffs(19, 44).addBox(-5.0F, -2.0F, -12.0F, 10.0F, 0.0F, 12.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(SculkSnapper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		body.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		animateWalk(SculkSnapperAnimation.WALK, limbSwing, limbSwingAmount, 2.5f, 2.5f);
		animate(entity.idleState, SculkSnapperAnimation.IDLE, ageInTicks);
		animate(entity.attackState, SculkSnapperAnimation.BITE, ageInTicks);
		animate(entity.sitState, SculkSnapperAnimation.SIT, ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}
}
