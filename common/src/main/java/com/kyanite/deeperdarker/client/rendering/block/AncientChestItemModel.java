package com.kyanite.deeperdarker.client.rendering.block;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.custom.AncientChestBlock;
import com.kyanite.deeperdarker.registry.items.custom.AncientChestItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientChestItemModel extends AnimatedGeoModel<AncientChestItem> {

    @Override
    public ResourceLocation getModelResource(AncientChestItem item) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/ancient_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AncientChestItem item) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, item.getBlock().defaultBlockState().getValue(AncientChestBlock.POLISHED) ? "textures/block/ancient_chest_polished.png" : "textures/block/ancient_chest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AncientChestItem item) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/ancient_chest.animation.json");
    }
}
