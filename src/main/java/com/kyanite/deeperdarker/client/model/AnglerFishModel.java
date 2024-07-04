package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.AnglerFish;
import com.kyanite.deeperdarker.content.entities.animations.AnglerFishAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class AnglerFishModel extends HierarchicalModel<AnglerFish> {
	private final ModelPart root;

	public AnglerFishModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 8.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.0F));
		head.addOrReplaceChild("hook", CubeListBuilder.create().texOffs(24, -8).addBox(0.0F, -5.0F, -7.0F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -3.5F));
		head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(16, 23).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 28).addBox(-2.0F, -1.5F, -4.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -3.0F));
		body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(24, 7).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 2.0F));
		body.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(19, 18).mirror().addBox(2.0F, -1.0F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 2.5F, 1.0F));
		body.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(19, 18).addBox(-7.0F, -1.0F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.5F, 1.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));
		tail.addOrReplaceChild("leftTail", CubeListBuilder.create().texOffs(19, 18).mirror().addBox(-0.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, 2.5F));
		tail.addOrReplaceChild("rightTail", CubeListBuilder.create().texOffs(19, 18).addBox(-4.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 2.5F));
		tail.addOrReplaceChild("caudalFin", CubeListBuilder.create().texOffs(24, 1).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(mesh, 48, 48);
	}

	@Override
	public void setupAnim(AnglerFish pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		float f = 1;
		float f1 = 1;
		if (!pEntity.isInWater()) {
			f = 1.3f;
			f1 = 1.7f;
		}

		this.root.getChild("root").getChild("body").yRot = -f * 0.25f * Mth.sin(f1 * 0.6f * pAgeInTicks);
		this.animate(pEntity.attackState, AnglerFishAnimation.BITE, pAgeInTicks);
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
