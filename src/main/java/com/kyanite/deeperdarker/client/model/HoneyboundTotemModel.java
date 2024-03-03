package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.HoneyboundTotem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class HoneyboundTotemModel<T extends HoneyboundTotem> extends Model {
    private final ModelPart bone;

    public HoneyboundTotemModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.bone = root.getChild(PartNames.BONE);
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild(PartNames.BONE, CubeListBuilder.create().texOffs(0, 48).addBox(-8.0F, -32.0F, -8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox("outer_layer", -8.0F, -32.0F, -8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.25F)), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setupAnim(T entity, float netHeadYaw, float headPitch) {
        this.bone.xRot = headPitch * ((float)Math.PI / 180f);
        this.bone.yRot = netHeadYaw * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}