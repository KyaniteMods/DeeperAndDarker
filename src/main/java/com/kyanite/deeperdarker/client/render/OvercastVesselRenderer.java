package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.OvercastVesselModel;
import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVessel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class OvercastVesselRenderer extends MobRenderer<OvercastVessel, OvercastVesselModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_vessel/overcast_vessel.png");
    private static final ResourceLocation TEXTURE_SLEEPING = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/overcast_vessel/overcast_vessel_sleeping.png");

    public OvercastVesselRenderer(EntityRendererProvider.Context context) {
        super(context, new OvercastVesselModel(context.bakeLayer(DDModelLayers.OVERCAST_VESSEL)), 1.0f);
        addLayer(new OvercastVesselCrackLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastVessel entity) {
        return entity.isGolemSleeping() ? TEXTURE_SLEEPING : TEXTURE;
    }
}
