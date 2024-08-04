package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.SculkSnapperModel;
import com.kyanite.deeperdarker.content.entities.SculkSnapper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkSnapperRenderer extends MobRenderer<SculkSnapper, SculkSnapperModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("sculk_snapper_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/sculk_snapper.png");

    public SculkSnapperRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkSnapperModel(context.bakeLayer(MODEL)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SculkSnapper entity) {
        return TEXTURE;
    }
}
