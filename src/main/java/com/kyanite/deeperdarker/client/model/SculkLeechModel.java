package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.SculkLeech;
import com.kyanite.deeperdarker.content.entities.animations.SculkLeechAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@SuppressWarnings("NullableProblems")
public class SculkLeechModel extends HierarchicalModel<SculkLeech> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;

	public SculkLeechModel(ModelPart root) {
		this.root = root;
		body = root.getChild("body");
		head = body.getChild("head");
	}

	public static LayerDefinition createBodyModel() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(12, 15).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 8).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(0.0F, -5.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(-4, 21).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(SculkLeech entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root.getAllParts().forEach(ModelPart::resetPose);
		animate(entity.idleState, SculkLeechAnimation.IDLE, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}
