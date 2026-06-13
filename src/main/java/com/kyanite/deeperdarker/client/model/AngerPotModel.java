package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.animations.OvercastPotAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

@SuppressWarnings("NullableProblems")
public class AngerPotModel extends EntityModel<LivingEntityRenderState> {
    private final KeyframeAnimation walkAnimation;

    public AngerPotModel(ModelPart root) {
        super(root);
        this.walkAnimation = OvercastPotAnimation.ANGER_WALK.bake(root);
    }

    public static LayerDefinition createModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(52, 35).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(30, 35).addBox(-7.0F, -3.0F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -5.5F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -3.0F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -5.5F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(LivingEntityRenderState state) {
        super.setupAnim(state);
        this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 1f, 5f);
    }
}
