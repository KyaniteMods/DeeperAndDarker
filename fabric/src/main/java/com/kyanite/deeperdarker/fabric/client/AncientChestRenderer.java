package com.kyanite.deeperdarker.fabric.client;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.block.AncientChestModel;
import com.kyanite.deeperdarker.registry.blocks.custom.AncientChestBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AncientChestRenderer extends GeoBlockRenderer<AncientChestEntity> {
    public AncientChestRenderer() {
        super(new AncientChestModel());
    }

    @Override
    public ResourceLocation getTextureResource(AncientChestEntity entity) {
        return entity.getBlockState().getValue(AncientChestBlock.POLISHED) ?
                new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/block/ancient_chest_polished.png") :
                new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/block/ancient_chest.png");
    }

    @Override
    public RenderType getRenderType(AncientChestEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }
}
