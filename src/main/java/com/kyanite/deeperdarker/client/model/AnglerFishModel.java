package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.client.render.state.AnglerFishRenderState;
import com.kyanite.deeperdarker.content.entities.animations.AnglerFishAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class AnglerFishModel extends EntityModel<AnglerFishRenderState> {
	private final ModelPart body;
	private final KeyframeAnimation attackAnimation;

	public AnglerFishModel(ModelPart root) {
		super(root);
		this.body = root.getChild("root").getChild("body");
		this.attackAnimation = AnglerFishAnimation.BITE.bake(root);
	}

	public static LayerDefinition createModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 8.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.0F));
		head.addOrReplaceChild("hook", CubeListBuilder.create().texOffs(24, -8).addBox(0.0F, -5.0F, -7.0F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -3.5F));
		head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(16, 23).addBox(-2.0F, -0.5F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 28).addBox(-2.0F, -1.5F, -4.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -5.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -3.0F));
		body.addOrReplaceChild("dorsal_fin", CubeListBuilder.create().texOffs(24, 7).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 2.0F));
		body.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(19, 18).addBox(-7.0F, -1.0F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.5F, 1.0F));
		body.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(19, 18).mirror().addBox(2.0F, -1.0F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 2.5F, 1.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));
		tail.addOrReplaceChild("right_tail", CubeListBuilder.create().texOffs(19, 18).addBox(-4.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 2.5F));
		tail.addOrReplaceChild("left_tail", CubeListBuilder.create().texOffs(19, 18).mirror().addBox(-0.5F, 0.0F, -2.5F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, 2.5F));
		tail.addOrReplaceChild("caudal_fin", CubeListBuilder.create().texOffs(24, 1).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(mesh, 48, 48);
	}

	@Override
	public void setupAnim(AnglerFishRenderState state) {
		super.setupAnim(state);
		float f = 1f;
		float f1 = 1f;
		if (!state.isInWater) {
			f = 1.3f;
			f1 = 1.7f;
		}

		this.body.yRot = -f * 0.25f * Mth.sin(f1 * 0.6f * state.ageInTicks);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks);
	}
}
