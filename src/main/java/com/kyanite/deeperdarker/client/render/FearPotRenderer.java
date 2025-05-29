package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.FearPotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class FearPotRenderer extends MobRenderer<OvercastPot, FearPotModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("fear_pot_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/fear_pot.png");

    public FearPotRenderer(EntityRendererProvider.Context context) {
        super(context, new FearPotModel(context.bakeLayer(MODEL)), 0.35f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
