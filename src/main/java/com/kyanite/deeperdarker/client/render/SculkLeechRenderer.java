package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SculkLeechModel;
import com.kyanite.deeperdarker.content.entities.SculkLeech;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkLeechRenderer extends MobRenderer<SculkLeech, SculkLeechModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_leech.png");

    public SculkLeechRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SculkLeechModel(pContext.bakeLayer(DDModelLayers.SCULK_LEECH)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkLeech pEntity) {
        return TEXTURE;
    }
}
