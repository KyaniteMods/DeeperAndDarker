package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.BloomingGolem;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class BloomingGolemModel extends HierarchicalModel<BloomingGolem> {
	private final ModelPart root;

	public BloomingGolemModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0)
				.texOffs(0, 0).addBox(-24.0F, -24.0F, -24.0F, 48.0F, 48.0F, 48.0F, CubeDeformation.NONE), PartPose.ZERO);

		return LayerDefinition.create(mesh, 256, 256);
	}

	@Override
	public @NotNull ModelPart root() {
		return root;
	}

	@Override
	public void setupAnim(@NotNull BloomingGolem entity, float f, float g, float h, float i, float j) {

	}
}