package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.ShatteredModel;
import com.kyanite.deeperdarker.client.render.state.ShatteredRenderState;
import com.kyanite.deeperdarker.content.entities.Shattered;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class ShatteredRenderer extends MobRenderer<Shattered, ShatteredRenderState, ShatteredModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/shattered.png");

    public ShatteredRenderer(EntityRendererProvider.Context context) {
        super(context, new ShatteredModel(context.bakeLayer(ModModelLayers.SHATTERED)), 0.5f);
    }

    @Override
    public ShatteredRenderState createRenderState() {
        return new ShatteredRenderState();
    }

    @Override
    public void extractRenderState(Shattered entity, ShatteredRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackState);
        state.idleAnimationState.copyFrom(entity.idleState);
    }

    @Override
    public Identifier getTextureLocation(ShatteredRenderState state) {
        return TEXTURE;
    }
}
