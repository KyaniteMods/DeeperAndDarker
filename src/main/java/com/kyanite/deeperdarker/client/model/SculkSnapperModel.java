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
	private final ModelPart root;
	private final ModelPart head;

	public SculkSnapperModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("root").getChild("body").getChild("head");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.75F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 39).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 1.5F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-4.5F, -3.0F, -6.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(28, 3).addBox(-4.0F, -5.0F, -5.75F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(28, -5).addBox(4.25F, -5.0F, -5.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(28, -5).addBox(-4.25F, -5.0F, -5.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -0.5F));
		head.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(-8, 13).addBox(-1.5F, 0.0F, -8.0F, 3.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.36F, 3.0F));
		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -3.0F, -9.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(-4.5F, -3.0F, -9.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.3F))
				.texOffs(28, -8).addBox(4.0F, 0.0F, -8.5F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-4.0F, 0.0F, -8.5F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(28, -8).addBox(-4.0F, 0.0F, -8.5F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));
		jaw.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(33, 37).addBox(0.0F, -6.0F, -3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));
		legs.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.8F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -3.4F, -2.75F));
		legs.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, -3.4F, -2.75F));
		legs.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 0).addBox(3.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, -3.4F, 1.75F));
		legs.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-5.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -3.4F, 1.75F));

		return LayerDefinition.create(mesh, 48, 48);
	}

	@Override
	public void setupAnim(SculkSnapper entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		this.animateWalk(SculkSnapperAnimation.WALK, limbSwing, limbSwingAmount, 2.5f, 2.5f);
		this.animate(entity.idleState, SculkSnapperAnimation.IDLE, ageInTicks);
		this.animate(entity.attackState, SculkSnapperAnimation.BITE, ageInTicks);
		this.animate(entity.sitState, SculkSnapperAnimation.SIT, ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
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
