package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;

public class OvercastVesselItemRenderer extends EntityRenderer<OvercastVesselItem> {
    private final EntityRenderDispatcher entityRenderDispatcher;
    private final ItemRenderer itemRenderer;

    public OvercastVesselItemRenderer(EntityRendererProvider.Context context) {
        super(context);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(OvercastVesselItem entity, float yaw, float tickDelta, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        poseStack.pushPose();
        ItemStack stack = entity.getItem();
        int seed = stack.isEmpty() ? 187 : Item.getId(stack.getItem()) + stack.getDamageValue();
        entity.level().getRandom().setSeed(seed);
        BakedModel bakedModel = this.itemRenderer.getModel(stack, entity.level(), null, entity.getId());
        float m = bakedModel.getTransforms().getTransform(ItemDisplayContext.GUI).scale.y();
        poseStack.translate(0.0f, 0.5f * m, 0.0f);
        poseStack.mulPose(Axis.ZP.rotation(entity.getTilt(tickDelta)));

        Camera camera = entityRenderDispatcher.camera;
        poseStack.mulPose(new Quaternionf().rotationYXZ((float)Math.PI - (float)Math.PI / 180 * camera.getYRot(), (float)(-Math.PI) / 180 * camera.getXRot(), 0.0f));

        this.itemRenderer.render(stack, ItemDisplayContext.GUI, false, poseStack, multiBufferSource, light, OverlayTexture.NO_OVERLAY, bakedModel);
        poseStack.popPose();
        super.render(entity, yaw, tickDelta, poseStack, multiBufferSource, light);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastVesselItem display) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
