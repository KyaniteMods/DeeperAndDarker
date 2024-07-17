package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.ShatteredModel;
import com.kyanite.deeperdarker.content.entities.Shattered;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class ShatteredRenderer extends MobRenderer<Shattered, ShatteredModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("shattered_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/shattered.png");

    public ShatteredRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShatteredModel(pContext.bakeLayer(MODEL)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Shattered pEntity) {
        return TEXTURE;
    }
}
