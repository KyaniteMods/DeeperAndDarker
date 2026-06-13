package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.ShriekWormModel;
import com.kyanite.deeperdarker.client.render.state.ShriekWormRenderState;
import com.kyanite.deeperdarker.content.entities.ShriekWorm;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class ShriekWormRenderer extends MobRenderer<ShriekWorm, ShriekWormRenderState, ShriekWormModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/shriek_worm.png");

    public ShriekWormRenderer(EntityRendererProvider.Context context) {
        super(context, new ShriekWormModel(context.bakeLayer(ModModelLayers.SHRIEK_WORM)), 1.2f);
    }

    @Override
    public ShriekWormRenderState createRenderState() {
        return new ShriekWormRenderState();
    }

    @Override
    public void extractRenderState(ShriekWorm entity, ShriekWormRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackState);
        state.asleepAnimationState.copyFrom(entity.asleepState);
        state.descendAnimationState.copyFrom(entity.descendState);
        state.emergeAnimationState.copyFrom(entity.emergeState);
        state.idleAnimationState.copyFrom(entity.idleState);
    }

    @Override
    public Identifier getTextureLocation(ShriekWormRenderState state) {
        return TEXTURE;
    }
}
