package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.PotModel;
import com.kyanite.deeperdarker.client.model.PottyModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class PottyRenderer extends MobRenderer<OvercastPot, HierarchicalModel<OvercastPot>> {
    private static final ResourceLocation TEXTURE = DeeperDarker.id("textures/entity/overcast_pot/potty.png");

    public PottyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PottyModel(pContext.bakeLayer(DDModelLayers.POTTY)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
