package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.client.render.state.SculkSnapperRenderState;
import com.kyanite.deeperdarker.content.entities.animations.SculkSnapperAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class SculkSnapperModel extends EntityModel<SculkSnapperRenderState> {
	private final ModelPart head;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation attackAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation sitAnimation;

	public SculkSnapperModel(ModelPart root) {
        super(root);
		this.head = root.getChild("root").getChild("body").getChild("head");
		this.walkAnimation = SculkSnapperAnimation.WALK.bake(this.root);
		this.attackAnimation = SculkSnapperAnimation.BITE.bake(this.root);
		this.idleAnimation = SculkSnapperAnimation.IDLE.bake(this.root);
		this.sitAnimation = SculkSnapperAnimation.SIT.bake(this.root);
	}

	public static LayerDefinition createModel() {
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
		legs.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, -3.4F, -2.75F));
		legs.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.8F, -0.35F, -0.74F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -3.4F, -2.75F));
		legs.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-5.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -3.4F, 1.75F));
		legs.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(3.7F, -0.35F, -1.26F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.75F, -3.4F, 1.75F));

		return LayerDefinition.create(mesh, 48, 48);
	}

	@Override
	public void setupAnim(SculkSnapperRenderState state) {
		super.setupAnim(state);
		applyHeadRotation(state.yRot, state.xRot);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.5f, 2.5f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
		this.sitAnimation.apply(state.sitAnimationState, state.ageInTicks);
	}

	private void applyHeadRotation(float yRot, float xRot) {
		yRot = Mth.clamp(yRot, -30, 30);
		xRot = Mth.clamp(xRot, -25, 45);
		this.head.yRot = yRot * ((float)Math.PI / 180f);
		this.head.xRot = xRot * ((float)Math.PI / 180f);
	}
}
