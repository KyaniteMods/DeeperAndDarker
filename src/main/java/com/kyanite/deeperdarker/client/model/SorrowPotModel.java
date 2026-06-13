package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.animations.OvercastPotAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

@SuppressWarnings("NullableProblems")
public class SorrowPotModel extends EntityModel<LivingEntityRenderState> {
    private final KeyframeAnimation walkAnimation;

    public SorrowPotModel(ModelPart root) {
        super(root);
        this.walkAnimation = OvercastPotAnimation.SORROW_WALK.bake(root);
    }

    public static LayerDefinition createModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -7.0F, -6.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(20, 26).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(19, 33).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(1, 27).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.5f, 2.5f);
    }
}
