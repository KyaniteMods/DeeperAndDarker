package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SculkMillipedeModel;
import com.kyanite.deeperdarker.content.entities.SculkMillipede;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SculkMillipedeRenderer<T extends SculkMillipede> extends MobRenderer<T, EntityModel<T>> {
    private static final ResourceLocation TEXTURE = DeeperDarker.id("textures/entity/sculk_millipede/sculk_millipede_body.png");
    private static final ResourceLocation HEAD_TEXTURE = DeeperDarker.id("textures/entity/sculk_millipede/sculk_millipede_head.png");

    public SculkMillipedeRenderer(EntityRendererProvider.Context context) {
        super(context, new SculkMillipedeModel<>(context.bakeLayer(DDModelLayers.SCULK_MILLIPEDE)), 0.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return !entity.isBody() ? HEAD_TEXTURE : TEXTURE;
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) {
        return 15;
    }
}
