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

    public AnglerFishRenderer(EntityRendererProvider.Context context) {
        super(context, new AnglerFishModel(context.bakeLayer(MODEL)), 0.4f);
        this.addLayer(new AnglerFishGlowRenderer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(AnglerFish entity) {
        return TEXTURE;
    }

    @Override
    protected void setupRotations(AnglerFish entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        float f = 1f;
        float f1 = 1f;
        if (!entity.isInWater()) {
            f = 1.3f;
            f1 = 1.7f;
        }

        float f2 = f * 4.3f * Mth.sin(f1 * 0.6f * bob);
        poseStack.mulPose(Axis.YP.rotationDegrees(f2));
        poseStack.translate(0, 0, -0.4f);
        if (!entity.isInWater()) {
            poseStack.translate(0.2f, 0.1f, 0f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90f));
        }
    }
}
