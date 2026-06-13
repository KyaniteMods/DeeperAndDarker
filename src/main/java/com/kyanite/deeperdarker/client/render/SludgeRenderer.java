package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.SludgeModel;
import com.kyanite.deeperdarker.content.entities.Sludge;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class SludgeRenderer extends MobRenderer<Sludge, SlimeRenderState, SludgeModel> {
    public static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/sludge.png");

    public SludgeRenderer(EntityRendererProvider.Context context) {
        super(context, new SludgeModel(context.bakeLayer(ModModelLayers.SLUDGE)), 0.25f);
        this.addLayer(new SludgeOuterLayer(this, context.getModelSet()));
    }

    @Override
    public SlimeRenderState createRenderState() {
        return new SlimeRenderState();
    }

    @Override
    public void extractRenderState(Sludge entity, SlimeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.squish = Mth.lerp(partialTicks, entity.oSquish, entity.squish);
        state.size = entity.getSize();
    }

    @Override
    protected float getShadowRadius(SlimeRenderState state) {
        return state.size * 0.25f;
    }

    @Override
    protected void scale(SlimeRenderState state, PoseStack poseStack) {
        float s = 0.999f;
        poseStack.scale(s, s, s);
        poseStack.translate(0f, 0.001f, 0f);
        float size = state.size;
        float ss = state.squish / (size * 0.5f + 1);
        float w = 1f / (ss + 1);
        poseStack.scale(w * size, 1f / w * size, w * size);
    }

    @Override
    public Identifier getTextureLocation(SlimeRenderState state) {
        return TEXTURE;
    }
}
