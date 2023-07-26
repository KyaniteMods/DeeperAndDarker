package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.ShriekWormEntityModel;
import com.kyanite.deeperdarker.entities.ShriekWormEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ShriekWormEntityRenderer extends MobEntityRenderer<ShriekWormEntity, ShriekWormEntityModel> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/shriek_worm.png");

    public ShriekWormEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ShriekWormEntityModel(context.getPart(DeeperDarkerModelLayers.SHRIEK_WORM)), 1.4f);
    }

    @Override
    public Identifier getTexture(ShriekWormEntity entity) {
        return TEXTURE;
    }
}