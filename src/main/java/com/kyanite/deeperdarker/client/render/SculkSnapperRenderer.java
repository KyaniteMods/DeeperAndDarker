package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SculkSnapperModel;
import com.kyanite.deeperdarker.content.entities.SculkSnapper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkSnapperRenderer extends MobRenderer<SculkSnapper, SculkSnapperModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sculk_snapper.png");

    public SculkSnapperRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SculkSnapperModel(pContext.bakeLayer(DDModelLayers.SCULK_SNAPPER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkSnapper pEntity) {
        return TEXTURE;
    }
}
