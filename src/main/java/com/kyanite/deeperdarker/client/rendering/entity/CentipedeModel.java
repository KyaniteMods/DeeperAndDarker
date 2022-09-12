package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.entities.custom.SculkCentipedeEntity;
import com.kyanite.deeperdarker.registry.entities.custom.SculkLeechEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CentipedeModel extends AnimatedGeoModel<SculkCentipedeEntity> {
    @Override
    public ResourceLocation getModelResource(SculkCentipedeEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "geo/sculk_centipede.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SculkCentipedeEntity object) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "textures/entity/sculk_centipede.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SculkCentipedeEntity animatable) {
        return new ResourceLocation(DeeperAndDarker.MOD_ID, "animations/sculk_centipede.animation.json");
    }

    @Override
    public void setLivingAnimations(SculkCentipedeEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        getBone("Head").setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        getBone("Head").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        getBone("Seg2").setRotationX(extraData.headPitch * ((float)Math.PI / 180F));
        getBone("Seg2").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));

        getBone("Seg5").setRotationY(extraData.netHeadYaw * ((float)Math.PI / 180F));
    }
}
