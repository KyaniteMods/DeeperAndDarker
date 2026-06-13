package com.kyanite.deeperdarker.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class SludgeModel extends EntityModel<LivingEntityRenderState> {
	public SludgeModel(ModelPart root) {
        super(root);
	}

	public static LayerDefinition createInnerModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0)
				.texOffs(0, 16).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).addBox(-3.25F, -6.0F, -3.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(32, 4).addBox(1.25F, -6.0F, -3.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}

	public static LayerDefinition createOuterModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}
}