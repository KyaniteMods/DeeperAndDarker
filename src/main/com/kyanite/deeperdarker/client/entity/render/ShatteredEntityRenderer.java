package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.ShatteredEntityModel;
import com.kyanite.deeperdarker.entities.ShatteredEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ShatteredEntityRenderer extends MobEntityRenderer<ShatteredEntity, ShatteredEntityModel> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/shattered.png");

    public ShatteredEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ShatteredEntityModel(context.getPart(DeeperDarkerModelLayers.SHATTERED)), 0.5f);
    }

    @Override
    public Identifier getTexture(ShatteredEntity entity) {
        return TEXTURE;
    }
}
