package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.Shattered;
import com.kyanite.deeperdarker.content.entities.animations.ShatteredAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class ShatteredModel extends HierarchicalModel<Shattered> {
	private final ModelPart root;
	private final ModelPart head;

	public ShatteredModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("root").getChild("body");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -13.0F, -2.0F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(37, 6).mirror().addBox(0.0F, -11.0F, 2.0F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -13.0F, 0.0F));
		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).addBox(-12.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).mirror().addBox(4.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));
		arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(43, 8).addBox(-4.0F, 11.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));
		arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(44, 27).addBox(1.0F, 5.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
		legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(4, 41).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));
		legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(Shattered entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		this.animateWalk(limbSwing, limbSwingAmount);
		this.animate(entity.idleState, ShatteredAnimation.IDLE, ageInTicks);
		this.animate(entity.attackState, ShatteredAnimation.ATTACK, ageInTicks);
	}

	private void animateWalk(float pLimbSwing, float pLimbSwingAmount) {
		long i = (long)(pLimbSwing * 50 * 2);
		float f = Math.min(pLimbSwingAmount * 2.5f, 1f);
		KeyframeAnimations.animate(this, ShatteredAnimation.WALK, i, f, new Vector3f());
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.getChild("root").render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}