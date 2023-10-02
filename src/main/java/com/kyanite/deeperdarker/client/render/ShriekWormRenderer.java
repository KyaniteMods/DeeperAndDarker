package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.ShriekWormModel;
import com.kyanite.deeperdarker.content.entities.ShriekWorm;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class ShriekWormRenderer extends MobRenderer<ShriekWorm, ShriekWormModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "shriek_worm"), "main");
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/shriek_worm.png");

    public ShriekWormRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ShriekWormModel(pContext.bakeLayer(MODEL)), 1.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShriekWorm pEntity) {
        return TEXTURE;
    }
}
