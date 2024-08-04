package com.kyanite.deeperdarker.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

@SuppressWarnings("NullableProblems")
public class WardenHelmetModel<E extends LivingEntity> extends EntityModel<E> implements HeadedModel {
    private final ModelPart head;

    public WardenHelmetModel(ModelPart head) {
        this.head = head;
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();
        parts.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-11.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(3.95F, -13.25F, 0.0F, 8.0F, 10.0F, 0.05F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.5F, 0.0F));

        return LayerDefinition.create(mesh, 16, 16);
    }

    @Override
    public void setupAnim(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        netHeadYaw = Mth.clamp(netHeadYaw, -30, 30);
        headPitch = Mth.clamp(headPitch, -25, 45);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        head.getChild("root").render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }
}
