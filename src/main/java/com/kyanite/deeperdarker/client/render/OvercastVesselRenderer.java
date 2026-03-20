package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.BloomingGolemModel;
import com.kyanite.deeperdarker.client.model.OvercastVesselModel;
import com.kyanite.deeperdarker.content.entities.BloomingGolem;
import com.kyanite.deeperdarker.content.entities.OvercastVessel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class OvercastVesselRenderer extends MobRenderer<OvercastVessel, OvercastVesselModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_vessel/overcast_vessel.png");

    public OvercastVesselRenderer(EntityRendererProvider.Context context) {
        super(context, new OvercastVesselModel(context.bakeLayer(DDModelLayers.OVERCAST_VESSEL)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastVessel entity) {
        return TEXTURE;
    }
}
