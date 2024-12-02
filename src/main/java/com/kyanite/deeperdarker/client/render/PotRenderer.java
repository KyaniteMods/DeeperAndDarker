package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.PotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class PotRenderer extends MobRenderer<OvercastPot, HierarchicalModel<OvercastPot>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_pot/pot.png");

    public PotRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PotModel(pContext.bakeLayer(DDModelLayers.POT)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
