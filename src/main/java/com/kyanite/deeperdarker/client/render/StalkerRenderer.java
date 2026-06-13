package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.StalkerModel;
import com.kyanite.deeperdarker.client.render.state.StalkerRenderState;
import com.kyanite.deeperdarker.content.entities.Stalker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class StalkerRenderer extends MobRenderer<Stalker, StalkerRenderState, StalkerModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/stalker.png");

    public StalkerRenderer(EntityRendererProvider.Context context) {
        super(context, new StalkerModel(context.bakeLayer(ModModelLayers.STALKER)), 1);
    }

    @Override
    public StalkerRenderState createRenderState() {
        return new StalkerRenderState();
    }

    @Override
    public void extractRenderState(Stalker entity, StalkerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackState);
        state.emergeAnimationState.copyFrom(entity.emergeState);
        state.idleAnimationState.copyFrom(entity.idleState);
        state.ringAnimationState.copyFrom(entity.ringAttackState);
    }

    @Override
    public Identifier getTextureLocation(StalkerRenderState state) {
        return TEXTURE;
    }
}
