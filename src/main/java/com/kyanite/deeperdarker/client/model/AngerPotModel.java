package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.OvercastPot;
import com.kyanite.deeperdarker.content.entities.animations.OvercastPotAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

@SuppressWarnings("NullableProblems")
public class AngerPotModel extends HierarchicalModel<OvercastPot> {
    private final ModelPart root;

    public AngerPotModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(52, 35).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(30, 35).addBox(-7.0F, -3.0F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -5.5F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -3.0F, -4.0F, 7.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -5.5F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(OvercastPot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root.getAllParts().forEach(ModelPart::resetPose);
        this.animateWalk(OvercastPotAnimation.ANGER_WALK, limbSwing, limbSwingAmount, 1f, 2.5f);
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
