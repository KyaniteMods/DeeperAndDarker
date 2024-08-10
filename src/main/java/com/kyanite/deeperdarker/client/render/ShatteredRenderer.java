package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.ShatteredModel;
import com.kyanite.deeperdarker.content.entities.Shattered;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class ShatteredRenderer extends MobRenderer<Shattered, ShatteredModel> {
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/shattered.png");

    public ShatteredRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShatteredModel(pContext.bakeLayer(DDModelLayers.SHATTERED)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Shattered pEntity) {
        return TEXTURE;
    }
}
