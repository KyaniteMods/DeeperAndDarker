package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.OvercastVesselModel;
import com.kyanite.deeperdarker.content.entities.OvercastVessel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Quaternionf;

@SuppressWarnings("NullableProblems")
public class OvercastVesselRenderer extends MobRenderer<OvercastVessel, OvercastVesselModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_vessel/overcast_vessel.png");

    public OvercastVesselRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OvercastVesselModel(pContext.bakeLayer(DDModelLayers.OVERCAST_VESSEL)), 2.0f);
    }

    @Override
    public void render(OvercastVessel mob, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        super.render(mob, f, g, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastVessel pEntity) {
        return TEXTURE;
    }
}
