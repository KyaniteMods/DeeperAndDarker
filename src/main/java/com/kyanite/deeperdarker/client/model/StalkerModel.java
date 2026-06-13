package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.client.render.state.StalkerRenderState;
import com.kyanite.deeperdarker.content.entities.animations.StalkerAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class StalkerModel extends EntityModel<StalkerRenderState> {
	private final ModelPart head;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation attackAnimation;
	private final KeyframeAnimation emergeAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation ringAnimation;

	public StalkerModel(ModelPart root) {
        super(root);
		this.head = root.getChild("root").getChild("waist").getChild("body").getChild("head");
		this.walkAnimation = StalkerAnimation.WALK.bake(this.root);
		this.attackAnimation = StalkerAnimation.ATTACK.bake(this.root);
		this.emergeAnimation = StalkerAnimation.EMERGE.bake(this.root);
		this.idleAnimation = StalkerAnimation.IDLE.bake(this.root);
		this.ringAnimation = StalkerAnimation.RING_ATTACK.bake(this.root);
	}

	public static LayerDefinition createModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition waist = root.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(18, 46).addBox(-6.5F, -2.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(44, 46).addBox(0.5F, -2.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -29.0F, 0.5F));

		PartDefinition body = waist.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 0.0F));
		body.addOrReplaceChild("body_top", CubeListBuilder.create().texOffs(24, 9).addBox(-7.0F, -4.0F, -3.5F, 14.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		body.addOrReplaceChild("body_right", CubeListBuilder.create().texOffs(24, 20).addBox(-3.0F, -4.5F, -3.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -7.5F, 0.0F));
		body.addOrReplaceChild("body_left", CubeListBuilder.create().texOffs(44, 20).addBox(0.0F, -4.5F, -3.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -7.5F, 0.0F));
		body.addOrReplaceChild("body_bottom", CubeListBuilder.create().texOffs(24, 36).addBox(-7.0F, 0.0F, -3.5F, 14.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -16.0F, 0.0F));
		head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(24, 0).addBox(-4.98F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.02F, -18.5F, 0.0F));
		head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(42, 1).addBox(-0.02F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.02F, -16.5F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
		arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 31.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, -0.5F));
		arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 66).addBox(0.0F, -2.0F, -2.5F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, 0.0F));

		PartDefinition teeth = body.addOrReplaceChild("teeth", CubeListBuilder.create(), PartPose.offset(0.0F, -7.5F, -3.5F));
		teeth.addOrReplaceChild("upper_right_tooth", CubeListBuilder.create().texOffs(66, 2).addBox(-1.3536F, -1.1465F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.3964F, -5.6035F, 0.0F));
		teeth.addOrReplaceChild("upper_left_tooth", CubeListBuilder.create().texOffs(80, 0).addBox(-1.3536F, -0.8535F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.1036F, -4.8965F, 0.0F));
		teeth.addOrReplaceChild("lower_right_tooth", CubeListBuilder.create().texOffs(66, 9).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, 5.25F, 0.0F));
		teeth.addOrReplaceChild("lower_left_tooth", CubeListBuilder.create().texOffs(84, 9).addBox(-1.0F, -1.5F, -6.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.75F, 5.25F, 0.0F));

		PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 31.0F, -0.5F));
		back.addOrReplaceChild("upper_back", CubeListBuilder.create().texOffs(68, 18).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -44.5F, 4.0F));
		back.addOrReplaceChild("middle_back", CubeListBuilder.create().texOffs(68, 29).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -38.0F, 4.0F));
		back.addOrReplaceChild("lower_back", CubeListBuilder.create().texOffs(68, 44).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -33.5F, 4.0F));
		back.addOrReplaceChild("vase", CubeListBuilder.create().texOffs(72, 58).addBox(-4.0F, -16.0F, -3.9167F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, 69).addBox(-6.0F, -13.0F, -5.9167F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(68, 93).addBox(-5.0F, -1.0F, -4.9167F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -38.5F, 15.4167F, 1.5708F, 0.0F, 0.0F));

		PartDefinition legs = waist.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 54).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 0.0F, 0.0F));
		legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(44, 55).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 1.0F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

	@Override
	public void setupAnim(StalkerRenderState state) {
		super.setupAnim(state);
		applyHeadRotation(state.yRot, state.xRot);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 3f, 2.5f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks);
		this.emergeAnimation.apply(state.emergeAnimationState, state.ageInTicks);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
		this.ringAnimation.apply(state.ringAnimationState, state.ageInTicks);
	}

	private void applyHeadRotation(float yRot, float xRot) {
		yRot = Mth.clamp(yRot, -30, 30);
		xRot = Mth.clamp(xRot, -25, 45);
		this.head.yRot = yRot * ((float)Math.PI / 180f);
		this.head.xRot = xRot * ((float)Math.PI / 180f);
	}
}
