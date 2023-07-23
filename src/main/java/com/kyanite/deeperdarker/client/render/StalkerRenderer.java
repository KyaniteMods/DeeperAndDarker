package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.StalkerModel;
import com.kyanite.deeperdarker.content.entities.Stalker;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class StalkerRenderer extends MobRenderer<Stalker, StalkerModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "stalker_layer"), "main");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/stalker.png");

    public StalkerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new StalkerModel(pContext.bakeLayer(MODEL)), 1);
    }

    @Override
    public ResourceLocation getTextureLocation(Stalker pEntity) {
        return TEXTURE;
    }
}
