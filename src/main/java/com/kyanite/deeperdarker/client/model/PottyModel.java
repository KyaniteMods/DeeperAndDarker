package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.OvercastPot;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class PottyModel extends HierarchicalModel<OvercastPot> {
    private final ModelPart root;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftBackLeg;
    private final ModelPart body;

    public PottyModel(ModelPart root) {
        this.root = root;
        this.leftFrontLeg = this.root.getChild("root").getChild("left_front_leg");
        this.rightFrontLeg = this.root.getChild("root").getChild("right_front_leg");
        this.rightBackLeg = this.root.getChild("root").getChild("right_back_leg");
        this.leftBackLeg = this.root.getChild("root").getChild("left_back_leg");
        this.body = this.root.getChild("root").getChild("body");
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.0F));

        PartDefinition leftFrontLeg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -2.0F, -5.0F));

        PartDefinition rightFrontLeg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 40).addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -2.0F, -5.0F));

        PartDefinition rightBackLeg = root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(20, 40).addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -2.0F, 5.0F));

        PartDefinition leftBackLeg = root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -2.0F, 5.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 13).addBox(-3.0F, -26.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -24.0F, -6.0F, 12.0F, 28.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.getChild("root").render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(OvercastPot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
