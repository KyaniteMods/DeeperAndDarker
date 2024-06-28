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
    public void setupAnim(E pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30, 30);
        pHeadPitch = Mth.clamp(pHeadPitch, -25, 45);
        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180f);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, int pColor) {
        head.getChild("root").render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pColor);
    }

    @Override
    public ModelPart getHead() {
        return this.head;
    }
}
