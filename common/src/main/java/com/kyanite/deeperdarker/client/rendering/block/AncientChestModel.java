package com.kyanite.deeperdarker.client.rendering.block;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.custom.AncientChestBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.entity.AncientChestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientChestModel extends AnimatedGeoModel<AncientChestEntity> {
    @Override
    public ResourceLocation getModelResource(AncientChestEntity entity) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/ancient_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AncientChestEntity entity) {
        return entity.getBlockState().getValue(AncientChestBlock.POLISHED) ? new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/block/ancient_chest_polished.png") : new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/block/ancient_chest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AncientChestEntity entity) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/ancient_chest.animation.json");
    }
}
