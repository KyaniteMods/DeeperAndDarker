package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.SculkLeechEntityModel;
import com.kyanite.deeperdarker.entities.SculkLeechEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SculkLeechEntityRenderer extends MobEntityRenderer<SculkLeechEntity, SculkLeechEntityModel> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/sculk_leech.png");

    public SculkLeechEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SculkLeechEntityModel(context.getPart(DeeperDarkerModelLayers.SCULK_LEECH)), 0.4f);
    }

    @Override
    public Identifier getTexture(SculkLeechEntity entity) {
        return TEXTURE;
    }
}
