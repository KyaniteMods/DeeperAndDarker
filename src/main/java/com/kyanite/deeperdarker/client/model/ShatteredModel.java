package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.client.render.state.ShatteredRenderState;
import com.kyanite.deeperdarker.content.entities.animations.ShatteredAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class ShatteredModel extends EntityModel<ShatteredRenderState> {
	private final ModelPart head;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation attackAnimation;
	private final KeyframeAnimation idleAnimation;

	public ShatteredModel(ModelPart root) {
        super(root);
		this.head = root.getChild("root").getChild("body");
		this.walkAnimation = ShatteredAnimation.WALK.bake(this.root);
		this.attackAnimation = ShatteredAnimation.ATTACK.bake(this.root);
		this.idleAnimation = ShatteredAnimation.IDLE.bake(this.root);
	}

	public static LayerDefinition createModel() {
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
	public void setupAnim(ShatteredRenderState state) {
		super.setupAnim(state);
		applyHeadRotation(state.yRot, state.xRot);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
	}

	private void applyHeadRotation(float netHeadYaw, float headPitch) {
		netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
		headPitch = Mth.clamp(headPitch, -25, 45);
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
		this.head.xRot = headPitch * ((float)Math.PI / 180f);
	}
}
