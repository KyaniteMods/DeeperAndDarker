package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.AnglerFishModel;
import com.kyanite.deeperdarker.content.entities.AnglerFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class AnglerFishRenderer extends MobRenderer<AnglerFish, AnglerFishModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("angler_fish_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/angler_fish.png");

    public AnglerFishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AnglerFishModel(pContext.bakeLayer(MODEL)), 0.4f);
        this.addLayer(new AnglerFishGlowRenderer(this));
    }


    @Override
    public ResourceLocation getTextureLocation(AnglerFish pEntity) {
        return TEXTURE;
    }

    @Override
    protected void setupRotations(AnglerFish pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pPoseStack, pAgeInTicks, pRotationYaw, pPartialTicks);
        float f = 1f;
        float f1 = 1f;
        if (!pEntityLiving.isInWater()) {
            f = 1.3f;
            f1 = 1.7f;
        }

        float f2 = f * 4.3f * Mth.sin(f1 * 0.6f * pAgeInTicks);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(f2));
        pPoseStack.translate(0, 0, -0.4f);
        if (!pEntityLiving.isInWater()) {
            pPoseStack.translate(0.2f, 0.1f, 0f);
            pPoseStack.mulPose(Axis.ZP.rotationDegrees(90f));
        }
    }
}
