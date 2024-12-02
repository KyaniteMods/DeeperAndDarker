package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.PotterModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class PotterRenderer extends MobRenderer<OvercastPot, HierarchicalModel<OvercastPot>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_pot/potter.png");

    public PotterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PotterModel(pContext.bakeLayer(DDModelLayers.POTTER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
