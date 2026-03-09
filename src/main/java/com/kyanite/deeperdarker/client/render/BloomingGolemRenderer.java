package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.BloomingGolemModel;
import com.kyanite.deeperdarker.client.model.SludgeModel;
import com.kyanite.deeperdarker.content.entities.BloomingGolem;
import com.kyanite.deeperdarker.content.entities.Sludge;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class BloomingGolemRenderer extends MobRenderer<BloomingGolem, BloomingGolemModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/blooming_golem.png");

    public BloomingGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new BloomingGolemModel(context.bakeLayer(DDModelLayers.BLOOMING_GOLEM)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(BloomingGolem entity) {
        return TEXTURE;
    }
}
