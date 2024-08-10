package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.AnglerFishModel;
import com.kyanite.deeperdarker.content.entities.AnglerFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class AnglerFishRenderer extends MobRenderer<AnglerFish, AnglerFishModel> implements RenderLayerParent<AnglerFish, AnglerFishModel> {
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/angler_fish/angler_fish.png");
    private static final ResourceLocation EMISSIVE_TEXTURE = DeeperDarker.rl("textures/entity/angler_fish/angler_fish_bioluminescent_layer.png");

    public AnglerFishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AnglerFishModel(pContext.bakeLayer(DDModelLayers.ANGLER_FISH)), 0.4f);
        this.addLayer(new AnglerFishEmissiveLayer<>(this, EMISSIVE_TEXTURE));
    }


    @Override
    public ResourceLocation getTextureLocation(AnglerFish pEntity) {
        return TEXTURE;
    }

    @Override
    protected void setupRotations(AnglerFish pEntityLiving, PoseStack pPoseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(pEntityLiving, pPoseStack, bob, yBodyRot, partialTick, scale);
        float f = 1f;
        float f1 = 1f;
        if (!pEntityLiving.isInWater()) {
            f = 1.3f;
            f1 = 1.7f;
        }

        float f2 = f * 4.3f * Mth.sin(f1 * 0.6f * pEntityLiving.tickCount);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(f2));
        pPoseStack.translate(0, 0, -0.4f);
        if (!pEntityLiving.isInWater()) {
            pPoseStack.translate(0.2f, 0.1f, 0f);
            pPoseStack.mulPose(Axis.ZP.rotationDegrees(90f));
        }
    }
}
