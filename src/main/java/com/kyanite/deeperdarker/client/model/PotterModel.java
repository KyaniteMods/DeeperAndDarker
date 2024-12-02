package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.OvercastPot;
import com.kyanite.deeperdarker.content.entities.animations.PotterAnimation;
import com.kyanite.deeperdarker.content.entities.animations.ShatteredAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PotterModel extends HierarchicalModel<OvercastPot> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;

    public PotterModel(ModelPart root) {
        this.root = root;
        this.body = this.root.getChild("root").getChild("body");
        this.rightArm = this.root.getChild("root").getChild("right_arm");
        this.leftArm = this.root.getChild("root").getChild("left_arm");
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(52, 35).addBox(-3.0F, -13.5F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.0F, -11.5F, -10.0F, 20.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(30, 35).addBox(-7.0F, -6.5F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -5.5F, 0.0F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -6.5F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -5.5F, 0.0F));

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
        this.animateWalk(PotterAnimation.WALK, limbSwing, limbSwingAmount, 1.0f, 2.5f);
    }
}
