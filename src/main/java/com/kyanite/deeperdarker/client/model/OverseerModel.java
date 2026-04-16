package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.Overseer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class OverseerModel<T extends Overseer> extends EntityModel<T> {
	private final ModelPart cube;
	private final ModelPart eye;

	public OverseerModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.cube = root.getChild("cube");
		this.eye = root.getChild("eye");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cube = partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(64, 0).addBox(16.0F, -16.0F, -16.0F, -32.0F, 32.0F, 32.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition eye = partdefinition.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Overseer entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Entity camera = Minecraft.getInstance().getCameraEntity();
		if (camera != null) {
			eye.yRot = Mth.PI / 180.0f * camera.getYRot();
			eye.xRot = -Mth.PI / 180.0f * camera.getXRot();
		} else {
			eye.yRot = 0.0f;
			eye.xRot = 0.0f;
		}
		float angle = Mth.DEG_TO_RAD * (entity.tickCount + ageInTicks);
		cube.xRot = angle * 3.0f / 4.0f;
		cube.yRot = angle;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cube.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}