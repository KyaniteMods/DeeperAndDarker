package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.AnglerFishModel;
import com.kyanite.deeperdarker.content.entities.AnglerFish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AnglerFishGlowRenderer extends EyesLayer<AnglerFish, AnglerFishModel> {
    private static final RenderType FISH_GLOW = RenderType.entityTranslucentEmissive(ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "textures/entity/angler_fish_glow.png"));

    public AnglerFishGlowRenderer(RenderLayerParent<AnglerFish, AnglerFishModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public @NotNull RenderType renderType() {
        return FISH_GLOW;
    }
}
