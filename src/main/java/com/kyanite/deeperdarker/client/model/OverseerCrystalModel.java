package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.overseer.OverseerCrystal;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class OverseerCrystalModel<T extends OverseerCrystal> extends EntityModel<T> {
	private final ModelPart crystal;

	public OverseerCrystalModel(ModelPart root) {
		crystal = root.getChild("crystal");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition parts = mesh.getRoot();

		parts.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE), PartPose.ZERO);

		return LayerDefinition.create(mesh, 16, 16);
	}

	@Override
	public void setupAnim(OverseerCrystal entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float factor = 1.0f / 2.0f;
        crystal.yRot = Mth.DEG_TO_RAD * (entity.tickCount + ageInTicks) * factor;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}