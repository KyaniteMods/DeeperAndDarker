package com.kyanite.deeperdarker.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ShatteredHeadModel extends SkullModelBase {
    private final ModelPart root;
    private final ModelPart head;

    public ShatteredHeadModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
    }

    public static LayerDefinition createHeadModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        parts.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-12.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(40, 0).mirror().addBox(4.0F, -11.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public void setupAnim(float f, float yaw, float pitch) {
        this.head.yRot = yaw * ((float)Math.PI / 180);
        this.head.xRot = pitch * ((float)Math.PI / 180);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        this.root.render(poseStack, vertexConsumer, light, overlay, color);
    }
}
