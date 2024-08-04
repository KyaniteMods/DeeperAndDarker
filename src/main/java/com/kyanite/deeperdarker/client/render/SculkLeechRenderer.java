package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.SculkLeechModel;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkLeechRenderer extends MobRenderer<SculkLeech, SculkLeechModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("sculk_leech_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/sculk_leech.png");

    public SculkLeechRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkLeechModel(context.bakeLayer(MODEL)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkLeech entity) {
        return TEXTURE;
    }
}
