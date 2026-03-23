package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

public class OvercastVesselModel extends HierarchicalModel<OvercastVessel> {
	private final ModelPart root;
	private final ModelPart opening;

	public OvercastVesselModel(ModelPart root) {
		this.root = root;
		this.opening = root.getChild("opening");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.texOffs(0, 0).addBox(-24.0F, -24.0F, -24.0F, 48.0F, 48.0F, 48.0F, CubeDeformation.NONE), PartPose.ZERO);
		parts.addOrReplaceChild("opening", CubeListBuilder.create().texOffs(0, 0)
				.texOffs(0, 96).addBox(-17.0F, -31.0F, -17.0F, 34.0F, 7.0F, 34.0F, CubeDeformation.NONE), PartPose.ZERO);

		return LayerDefinition.create(mesh, 256, 256);
	}

	@Override
	public @NotNull ModelPart root() {
		return root;
	}

	@Override
	public void setupAnim(@NotNull OvercastVessel entity, float f, float g, float h, float i, float j) {
		opening.visible = !entity.isCracked(Direction.UP);
	}
}