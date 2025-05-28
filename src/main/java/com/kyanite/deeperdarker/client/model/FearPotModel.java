package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.OvercastPot;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class FearPotModel extends HierarchicalModel<OvercastPot> {
    private final ModelPart root;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;

    public FearPotModel(ModelPart root) {
        this.root = root;
        this.rightFrontLeg = root.getChild("root").getChild("right_front_leg");
        this.leftFrontLeg = root.getChild("root").getChild("left_front_leg");
        this.rightHindLeg = root.getChild("root").getChild("right_hind_leg");
        this.leftHindLeg = root.getChild("root").getChild("left_hind_leg");
    }

    public static LayerDefinition createModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        PartDefinition root = parts.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 13).addBox(-3.0F, -26.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 40).addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -2.0F, -5.0F));
        root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -2.0F, -5.0F));
        root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(20, 40).addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -2.0F, 5.0F));
        root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -2.0F, 5.0F));

        return LayerDefinition.create(mesh, 128, 128);
    }

    @Override
    public void setupAnim(OvercastPot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        root.getChild("root").render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
