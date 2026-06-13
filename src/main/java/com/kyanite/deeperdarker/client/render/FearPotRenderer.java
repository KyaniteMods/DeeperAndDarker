package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.FearPotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class FearPotRenderer extends MobRenderer<OvercastPot, LivingEntityRenderState, FearPotModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/fear_pot.png");

    public FearPotRenderer(EntityRendererProvider.Context context) {
        super(context, new FearPotModel(context.bakeLayer(ModModelLayers.FEAR_POT)), 0.35f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
