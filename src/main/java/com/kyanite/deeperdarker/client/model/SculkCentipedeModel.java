package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import com.kyanite.deeperdarker.content.entities.animations.SculkCentipedeAnimation;
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
	private final ModelPart head;

	public SculkCentipedeModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("root").getChild("centipede").getChild("body").getChild("body_1").getChild("body_2").getChild("body_3");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition centipede = root.addOrReplaceChild("centipede", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -15.0F));
		PartDefinition body = centipede.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 18.0F));
		PartDefinition body1 = body.addOrReplaceChild("body_1", CubeListBuilder.create().texOffs(0, 27).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		body1.addOrReplaceChild("left_feet_1", CubeListBuilder.create().texOffs(12, 27).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, -3.0F));
		body1.addOrReplaceChild("right_feet_1", CubeListBuilder.create().texOffs(12, 27).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, -3.0F));

		PartDefinition body2 = body1.addOrReplaceChild("body_2", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));
		body2.addOrReplaceChild("left_feet_2", CubeListBuilder.create().texOffs(12, 18).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, -3.0F));
		body2.addOrReplaceChild("right_feet_2", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, -3.0F));

		PartDefinition body3 = body2.addOrReplaceChild("body_3", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));
		body3.addOrReplaceChild("left_feet_3", CubeListBuilder.create().texOffs(12, 9).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, -3.0F));
		body3.addOrReplaceChild("right_feet_3", CubeListBuilder.create().texOffs(12, 9).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, -3.0F));

		PartDefinition head = body3.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.5F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition frontJaw = head.addOrReplaceChild("front_jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -6.0F));
		frontJaw.addOrReplaceChild("front_left_jaw", CubeListBuilder.create().texOffs(13, 1).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, 0.0F));
		frontJaw.addOrReplaceChild("front_right_jaw", CubeListBuilder.create().texOffs(13, 1).mirror().addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 0.0F, 0.0F));

		PartDefinition tendrils = head.addOrReplaceChild("tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -4.5F));
		tendrils.addOrReplaceChild("left_tendril", CubeListBuilder.create().texOffs(24, 24).addBox(0.0F, -3.0F, -7.5F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, 0.0F, 0.0F));
		tendrils.addOrReplaceChild("right_tendril", CubeListBuilder.create().texOffs(24, 24).addBox(0.0F, -3.0F, -7.5F, 0.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, 0.0F, 0.0F));

		PartDefinition tail = centipede.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 18.0F));
		PartDefinition tail1 = tail.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		tail1.addOrReplaceChild("left_feet_4", CubeListBuilder.create().texOffs(12, 18).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, 3.0F));
		tail1.addOrReplaceChild("right_feet_4", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, 3.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(24, 9).addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));
		tail2.addOrReplaceChild("left_feet_5", CubeListBuilder.create().texOffs(12, 27).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, 3.0F));
		tail2.addOrReplaceChild("right_feet_5", CubeListBuilder.create().texOffs(12, 27).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, 3.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(24, 18).addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));
		tail3.addOrReplaceChild("left_feet_6", CubeListBuilder.create().texOffs(20, 27).addBox(-0.25F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.4F, 3.0F));
		tail3.addOrReplaceChild("right_feet_6", CubeListBuilder.create().texOffs(20, 27).mirror().addBox(-3.75F, 0.0F, -3.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.4F, 3.0F));

		PartDefinition backJaw = tail3.addOrReplaceChild("back_jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 6.0F));
		backJaw.addOrReplaceChild("back_right_jaw", CubeListBuilder.create().texOffs(-10, 36).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));
		backJaw.addOrReplaceChild("back_left_jaw", CubeListBuilder.create().texOffs(-10, 36).mirror().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 48, 48);
	}

	@Override
	public void setupAnim(SculkCentipede entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		applyHeadRotation(netHeadYaw, headPitch);
		this.animateWalk(SculkCentipedeAnimation.CRAWL, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		root.getChild("root").render(poseStack, buffer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}
