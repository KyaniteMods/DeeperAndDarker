package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.PotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class OvercastPotRenderer extends MobRenderer<OvercastPot, HierarchicalModel<OvercastPot>> {
    private static final ResourceLocation POTTY_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_pot/potty.png");
    private static final ResourceLocation POT_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_pot/pot.png");
    private static final ResourceLocation POTTER_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_pot/potter.png");

    public OvercastPotRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PotModel(pContext.bakeLayer(DDModelLayers.POT)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return POT_TEXTURE;
    }
}
