package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SludgeModel;
import com.kyanite.deeperdarker.content.entities.Sludge;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class SludgeRenderer extends MobRenderer<Sludge, SludgeModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sludge.png");

    public SludgeRenderer(EntityRendererProvider.Context context) {
        super(context, new SludgeModel(context.bakeLayer(DDModelLayers.SLUDGE)), 0.25f);
        this.addLayer(new SludgeOuterLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(Sludge entity) {
        return TEXTURE;
    }

    @Override
    public void render(Sludge entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25f * entity.getSize();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected void scale(Sludge livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.999f, 0.999f, 0.999f);
        poseStack.translate(0f, 0.001f, 0f);
        int size = livingEntity.getSize();
        float lerpSize = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / (size / 2f + 1);
        float inv = 1f / (lerpSize + 1);
        poseStack.scale(inv * size, 1f / inv * size, inv * size);
    }
}
