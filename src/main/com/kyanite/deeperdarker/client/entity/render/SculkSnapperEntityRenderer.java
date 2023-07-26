package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.SculkSnapperEntityModel;
import com.kyanite.deeperdarker.entities.SculkSnapperEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SculkSnapperEntityRenderer extends MobEntityRenderer<SculkSnapperEntity, SculkSnapperEntityModel> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/sculk_snapper.png");

    public SculkSnapperEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SculkSnapperEntityModel(context.getPart(DeeperDarkerModelLayers.SCULK_SNAPPER)), 0.5f);
    }

    @Override
    public Identifier getTexture(SculkSnapperEntity entity) {
        return TEXTURE;
    }
}
