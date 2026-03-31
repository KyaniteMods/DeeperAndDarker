package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.AcidSpriteModel;
import com.kyanite.deeperdarker.content.entities.AcidSprite;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class AcidSpriteRenderer extends MobRenderer<AcidSprite, AcidSpriteModel<AcidSprite>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/acid_sprite.png");

    public AcidSpriteRenderer(EntityRendererProvider.Context context) {
        super(context, new AcidSpriteModel<>(context.bakeLayer(DDModelLayers.ACID_SPRITE)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(AcidSprite entity) {
        return TEXTURE;
    }
}
