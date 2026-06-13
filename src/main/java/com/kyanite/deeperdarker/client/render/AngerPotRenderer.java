package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.AngerPotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class AngerPotRenderer extends MobRenderer<OvercastPot, LivingEntityRenderState, AngerPotModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/anger_pot.png");

    public AngerPotRenderer(EntityRendererProvider.Context context) {
        super(context, new AngerPotModel(context.bakeLayer(ModModelLayers.ANGER_POT)), 0.6f);
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
