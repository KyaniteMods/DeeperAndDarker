package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SculkCentipedeModel;
import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkCentipedeRenderer extends MobRenderer<SculkCentipede, SculkCentipedeModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_centipede.png");

    public SculkCentipedeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SculkCentipedeModel(pContext.bakeLayer(DDModelLayers.SCULK_CENTIPEDE)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkCentipede pEntity) {
        return TEXTURE;
    }
}
