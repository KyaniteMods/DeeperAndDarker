package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.DDModelLayers;
import com.kyanite.deeperdarker.client.model.SunglassesModel;
import com.kyanite.deeperdarker.content.items.SunglassesItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class SunglassesRenderer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/sunglasses.png");
    private final SunglassesModel model;

    public SunglassesRenderer(RenderLayerParent<T, M> renderLayerParent, EntityModelSet pModelSet) {
        super(renderLayerParent);
        this.model = new SunglassesModel(pModelSet.bakeLayer(DDModelLayers.SUNGLASSES));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float yRot, float xRot) {
        if (SunglassesItem.isWearingSunglasses(entity)) {
            ((HeadedModel)this.getParentModel()).getHead().translateAndRotate(poseStack);
            model.renderToBuffer(poseStack, multiBufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), light, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
