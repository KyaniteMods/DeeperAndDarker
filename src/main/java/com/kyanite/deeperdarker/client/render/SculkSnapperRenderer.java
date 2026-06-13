package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.SculkSnapperModel;
import com.kyanite.deeperdarker.client.render.state.SculkSnapperRenderState;
import com.kyanite.deeperdarker.content.entities.SculkSnapper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class SculkSnapperRenderer extends MobRenderer<SculkSnapper, SculkSnapperRenderState, SculkSnapperModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/sculk_snapper.png");

    public SculkSnapperRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkSnapperModel(context.bakeLayer(ModModelLayers.SCULK_SNAPPER)), 0.5f);
    }

    @Override
    public SculkSnapperRenderState createRenderState() {
        return new SculkSnapperRenderState();
    }

    @Override
    public void extractRenderState(SculkSnapper entity, SculkSnapperRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackState);
        state.idleAnimationState.copyFrom(entity.idleState);
        state.sitAnimationState.copyFrom(entity.sitState);
    }

    @Override
    public Identifier getTextureLocation(SculkSnapperRenderState state) {
        return TEXTURE;
    }
}
