package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.BubbloxModel;
import com.kyanite.deeperdarker.client.model.FloaterModel;
import com.kyanite.deeperdarker.content.entities.Bubblox;
import com.kyanite.deeperdarker.content.entities.Floater;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

@SuppressWarnings("NullableProblems")
public class FloaterRenderer<T extends Floater> extends MobRenderer<T, EntityModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/floater/floater.png");
    private static final ResourceLocation SPECIAL_TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/floater/special_floater.png");

    public FloaterRenderer(EntityRendererProvider.Context context) {
        super(context, new FloaterModel<>(context.bakeLayer(DDModelLayers.FLOATER)), 0.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return entity.isSpecial() ? SPECIAL_TEXTURE : TEXTURE;
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) {
        return 15;
    }
}
