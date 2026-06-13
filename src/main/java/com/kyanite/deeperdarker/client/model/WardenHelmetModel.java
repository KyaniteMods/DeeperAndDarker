package com.kyanite.deeperdarker.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class WardenHelmetModel<E extends LivingEntityRenderState> extends EntityModel<E> implements HeadedModel {
    public WardenHelmetModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();
        parts.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-11.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(3.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.5F, 0.0F));

        return LayerDefinition.create(mesh, 16, 16);
    }

    @Override
    public void setupAnim(E state) {
        super.setupAnim(state);
        this.root.yRot = Mth.clamp(state.yRot, -30, 30) * ((float)Math.PI / 180f);
        this.root.xRot = Mth.clamp(state.xRot, -25, 45) * ((float)Math.PI / 180f);
    }

    @Override
    public ModelPart getHead() {
        return this.root;
    }
}
