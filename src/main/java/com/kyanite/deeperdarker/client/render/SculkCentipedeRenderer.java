package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.SculkCentipedeModel;
import com.kyanite.deeperdarker.content.entities.SculkCentipede;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkCentipedeRenderer extends MobRenderer<SculkCentipede, SculkCentipedeModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "sculk_centipede_layer"), "main");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_centipede.png");

    public SculkCentipedeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SculkCentipedeModel(pContext.bakeLayer(MODEL)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkCentipede pEntity) {
        return TEXTURE;
    }
}
