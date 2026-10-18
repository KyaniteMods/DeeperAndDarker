package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.Stalker;
import com.kyanite.deeperdarker.content.entities.animations.StalkerAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class StalkerModel extends HierarchicalModel<Stalker> {
	private final ModelPart root;
	private final ModelPart waist;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart ancient_vase;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public StalkerModel(ModelPart root) {
		this.root = root;
		this.waist = root.getChild("waist");
		this.head = this.waist.getChild("head");
		this.body = this.waist.getChild("body");
		this.ancient_vase = this.body.getChild("ancient_vase");
		this.right_arm = this.waist.getChild("right_arm");
		this.left_arm = this.waist.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition waist = partdefinition.addOrReplaceChild("waist", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition head = waist.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(48, 40).addBox(3.0F, -15.0F, -1.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(32, 48).addBox(-8.0F, -14.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));

		PartDefinition body = waist.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -15.0F, -3.0F, 10.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(50, 48).addBox(-3.0F, -12.0F, -5.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(50, 58).addBox(-4.5F, -9.0F, -5.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ancient_vase = body.addOrReplaceChild("ancient_vase", CubeListBuilder.create().texOffs(64, 11).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(64, 35).addBox(-5.0F, 7.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 4.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition right_arm = waist.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 23).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -12.0F, 0.0F, -0.2618F, 0.0F, 0.0436F));

		PartDefinition left_arm = waist.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 23).addBox(0.0F, -2.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -12.0F, 0.0F, -0.2618F, 0.0F, -0.0436F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 29.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -5.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 29.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Stalker entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		this.animateWalk(StalkerAnimation.WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
		this.animate(entity.idleState, StalkerAnimation.IDLE, ageInTicks);
		this.animate(entity.attackState, StalkerAnimation.ATTACK, ageInTicks);
		this.animate(entity.ringAttackState, StalkerAnimation.ATTACK, ageInTicks);
		this.animate(entity.emergeState, StalkerAnimation.EMERGE, ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
