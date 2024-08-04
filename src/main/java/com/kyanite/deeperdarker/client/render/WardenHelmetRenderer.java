package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.WardenHelmetModel;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("NullableProblems")
public class WardenHelmetRenderer<E extends LivingEntity, M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("warden"), "3");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/models/armor/warden_layer_3.png");
    private final EntityModelSet model;

    public WardenHelmetRenderer(RenderLayerParent<E, M> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = modelSet;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, E livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if(stack.is(DDItems.WARDEN_HELMET.get())) {
            poseStack.pushPose();

            poseStack.scale(1, 1, 1);
            this.getParentModel().getHead().translateAndRotate(poseStack);
            WardenHelmetModel<E> helmetModel = new WardenHelmetModel<>(this.model.bakeLayer(MODEL));
            helmetModel.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.armorCutoutNoCull(TEXTURE)), packedLight, OverlayTexture.NO_OVERLAY);

            poseStack.popPose();
        }
    }
}
