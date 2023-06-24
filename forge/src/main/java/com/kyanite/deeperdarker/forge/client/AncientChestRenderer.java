package com.kyanite.deeperdarker.forge.client;

import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AncientChestRenderer extends GeoBlockRenderer<AncientChestEntity> {
    public AncientChestRenderer(GeoModel<AncientChestEntity> model) {
        super(model);
    }

    @Override
    public RenderType getRenderType(AncientChestEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
