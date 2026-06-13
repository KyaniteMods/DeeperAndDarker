package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.AnglerFishModel;
import com.kyanite.deeperdarker.client.render.state.AnglerFishRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import org.jspecify.annotations.NonNull;

public class AnglerFishGlowRenderer extends EyesLayer<AnglerFishRenderState, AnglerFishModel> {
    private static final RenderType FISH_GLOW = RenderTypes.entityTranslucentEmissive(DeeperDarker.rl("textures/entity/angler_fish_glow.png"));

    public AnglerFishGlowRenderer(RenderLayerParent<AnglerFishRenderState, AnglerFishModel> renderer) {
        super(renderer);
    }

    @Override
    public @NonNull RenderType renderType() {
        return FISH_GLOW;
    }
}
