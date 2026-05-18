package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.Shattered;
import com.kyanite.deeperdarker.content.entities.animations.ShatteredAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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
		head = root.getChild("waist").getChild("head");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition waist = partdefinition.addOrReplaceChild("waist", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		waist.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE)
				.texOffs(16, 32).addBox(-9.0F, -10.0F, 0.0F, 8.0F, 8.0F, 0.0F, CubeDeformation.NONE)
				.texOffs(32, 32).addBox(1.0F, -10.0F, 0.0F, 8.0F, 8.0F, 0.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		waist.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(0.0F, -6.0F, 0.0F));

		waist.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(24, 16).addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(4.0F, -12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		waist.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-4.0F, -12.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, CubeDeformation.NONE), PartPose.offset(2.0F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, CubeDeformation.NONE), PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Shattered entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		animateWalk(ShatteredAnimation.WALK, limbSwing, limbSwingAmount, 1.0f, 2.5f);
		animate(entity.idleState, ShatteredAnimation.IDLE, ageInTicks);
		animate(entity.attackState, ShatteredAnimation.ATTACK, ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}
