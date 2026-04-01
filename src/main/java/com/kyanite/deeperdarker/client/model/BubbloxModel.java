package com.kyanite.deeperdarker.client.model;

import com.kyanite.deeperdarker.content.entities.Bubblox;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.NotNull;

public class BubbloxModel<T extends Bubblox> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart[] sizes;
    private final ModelPart smallSize;
    private final ModelPart mediumSize;
    private final ModelPart largeSize;

    public BubbloxModel(ModelPart root) {
        super(RenderType::entityTranslucentCull);
        this.root = root;
        smallSize = root.getChild("small");
        mediumSize = root.getChild("medium");
        largeSize = root.getChild("large");
        sizes = new ModelPart[]{smallSize, mediumSize, largeSize};
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition parts = mesh.getRoot();

        parts.addOrReplaceChild("small", CubeListBuilder.create()
                .texOffs(0, 40).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, CubeDeformation.NONE), PartPose.ZERO);
        parts.addOrReplaceChild("medium", CubeListBuilder.create()
                .texOffs(0, 24).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, CubeDeformation.NONE), PartPose.ZERO);
        parts.addOrReplaceChild("large", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, CubeDeformation.NONE), PartPose.ZERO);

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    public @NotNull ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        for (int i = 0; i < sizes.length; i++) {
            sizes[i].visible = entity.getSize() == i;
        }
    }
}
