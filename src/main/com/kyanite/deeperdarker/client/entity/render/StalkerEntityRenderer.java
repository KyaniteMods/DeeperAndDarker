package com.kyanite.deeperdarker.client.entity.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.entity.model.DeeperDarkerModelLayers;
import com.kyanite.deeperdarker.client.entity.model.StalkerEntityModel;
import com.kyanite.deeperdarker.entities.StalkerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class StalkerEntityRenderer extends MobEntityRenderer<StalkerEntity, StalkerEntityModel> {
    private static final Identifier TEXTURE = new Identifier(DeeperDarker.MOD_ID, "textures/entity/stalker.png");

    public StalkerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new StalkerEntityModel(context.getPart(DeeperDarkerModelLayers.STALKER)), 1.0f);
    }

    @Override
    public Identifier getTexture(StalkerEntity entity) {
        return TEXTURE;
    }
}