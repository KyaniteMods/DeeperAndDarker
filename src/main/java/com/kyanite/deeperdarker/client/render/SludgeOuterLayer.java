package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.SludgeModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;

@SuppressWarnings("NullableProblems")
public class SludgeOuterLayer extends RenderLayer<SlimeRenderState, SludgeModel> {
    private final SludgeModel model;

    public SludgeOuterLayer(RenderLayerParent<SlimeRenderState, SludgeModel> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new SludgeModel(modelSet.bakeLayer(ModModelLayers.SLUDGE_OUTER));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, SlimeRenderState state, float yRot, float xRot) {
        boolean appearsGlowingWithInvisibility = state.appearsGlowing() && state.isInvisible;
        if(!state.isInvisible || appearsGlowingWithInvisibility) {
            int overlayCoords = LivingEntityRenderer.getOverlayCoords(state, 0.0F);
            if(appearsGlowingWithInvisibility) {
                submitNodeCollector.order(1).submitModel(this.model, state, poseStack, RenderTypes.outline(SludgeRenderer.TEXTURE), lightCoords, overlayCoords, state.outlineColor, null);
            } else {
                submitNodeCollector.order(1).submitModel(this.model, state, poseStack, RenderTypes.entityTranslucent(SludgeRenderer.TEXTURE), lightCoords, overlayCoords, state.outlineColor, null);
            }
        }
    }
}
