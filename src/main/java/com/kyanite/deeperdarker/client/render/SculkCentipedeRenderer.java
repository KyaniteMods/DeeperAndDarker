package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.SculkCentipedeModel;
import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class SculkCentipedeRenderer extends MobRenderer<SculkCentipede, LivingEntityRenderState, SculkCentipedeModel> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/sculk_centipede.png");

    public SculkCentipedeRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkCentipedeModel(context.bakeLayer(ModModelLayers.SCULK_CENTIPEDE)), 0.6f);
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
