package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.AnglerFishModel;
import com.kyanite.deeperdarker.client.render.state.AnglerFishRenderState;
import com.kyanite.deeperdarker.content.entities.AnglerFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

@SuppressWarnings("NullableProblems")
public class AnglerFishRenderer extends MobRenderer<AnglerFish, AnglerFishRenderState, AnglerFishModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("angler_fish_layer"), "main");
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/angler_fish.png");

    public AnglerFishRenderer(EntityRendererProvider.Context context) {
        super(context, new AnglerFishModel(context.bakeLayer(MODEL)), 0.4f);
        this.addLayer(new AnglerFishGlowRenderer(this));
    }

    @Override
    public AnglerFishRenderState createRenderState() {
        return new AnglerFishRenderState();
    }

    @Override
    public void extractRenderState(AnglerFish entity, AnglerFishRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackState);
    }

    @Override
    protected void setupRotations(AnglerFishRenderState state, PoseStack poseStack, float bodyRot, float entityScale) {
        super.setupRotations(state, poseStack, bodyRot, entityScale);
        float f = 1f;
        float f1 = 1f;
        if (!state.isInWater) {
            f = 1.3f;
            f1 = 1.7f;
        }

        float f2 = f * 4.3f * Mth.sin(f1 * 0.6f * state.ageInTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(f2));
        poseStack.translate(0, 0, -0.4f);
        if (!state.isInWater) {
            poseStack.translate(0.2f, 0.1f, 0f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90f));
        }
    }

    @Override
    public Identifier getTextureLocation(AnglerFishRenderState state) {
        return TEXTURE;
    }
}
