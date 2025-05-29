package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.AngerPotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class AngerPotRenderer extends MobRenderer<OvercastPot, AngerPotModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("anger_pot_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/anger_pot.png");

    public AngerPotRenderer(EntityRendererProvider.Context context) {
        super(context, new AngerPotModel(context.bakeLayer(MODEL)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
