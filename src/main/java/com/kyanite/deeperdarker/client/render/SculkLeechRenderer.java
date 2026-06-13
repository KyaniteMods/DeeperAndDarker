package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.SculkLeechModel;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class SculkLeechRenderer extends MobRenderer<SculkLeech, LivingEntityRenderState, SculkLeechModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/sculk_leech.png");

    public SculkLeechRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkLeechModel(context.bakeLayer(ModModelLayers.SCULK_LEECH)), 0.4f);
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
