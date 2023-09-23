package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.kyanite.deeperdarker.content.entities.animations.SculkLeechAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@SuppressWarnings("NullableProblems")
public class SculkLeechModel extends HierarchicalModel<SculkLeech> {
	private final ModelPart root;

	public SculkLeechModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 22.75F, -1.0F));

		root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, -1).addBox(1.0F, -0.5F, -4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 0).addBox(-1.0F, 1.5F, -4.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -0.5F, -4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 1).addBox(-1.0F, -1.5F, -4.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, -2).addBox(-0.5F, -3.5F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.25F, -3.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -1.25F, -0.25F, 2.0F, 2.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.25F, -3.0F));
		body.addOrReplaceChild("body_tendrils", CubeListBuilder.create().texOffs(-3, 12).addBox(-3.0F, 0.0F, -0.85F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.25F, 0.85F));
		body.addOrReplaceChild("body_fin", CubeListBuilder.create().texOffs(7, 4).addBox(0.0F, -2.0F, -0.85F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.25F, 0.85F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 15).addBox(-1.4F, -1.15F, 0.0F, 1.8F, 2.25F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 2.75F));
		tail.addOrReplaceChild("tail_tendrils", CubeListBuilder.create().texOffs(-3, 21).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 1.0F));
		tail.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(7, 12).addBox(0.0F, -2.05F, -0.85F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.1F, 0.85F));
		PartDefinition backTail = tail.addOrReplaceChild("back_tail", CubeListBuilder.create().texOffs(15, 1).addBox(-1.15F, -0.9F, 0.0F, 1.3F, 1.9F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 7).addBox(-3.5F, 0.0F, 0.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));
		backTail.addOrReplaceChild("back_tail_fin", CubeListBuilder.create().texOffs(23, 0).addBox(0.0F, -2.05F, -0.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.85F, 1.5F));

		return LayerDefinition.create(mesh, 32, 32);
	}

	@Override
	public void setupAnim(SculkLeech entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(limbSwing, limbSwingAmount);
	}

	private void animateWalk(float pLimbSwing, float pLimbSwingAmount) {
		long i = (long)(pLimbSwing * 50 * 2);
		float f = Math.min(pLimbSwingAmount * 2.5f, 1f);
		KeyframeAnimations.animate(this, SculkLeechAnimation.MOVE, i, f, new Vector3f());
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.getChild("root").render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}