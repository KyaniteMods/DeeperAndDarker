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
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "warden"), "3");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DeeperDarker.MOD_ID, "textures/models/armor/warden_layer_3.png");
    private final EntityModelSet model;

    public WardenHelmetRenderer(RenderLayerParent<E, M> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = modelSet;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, E pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if(stack.is(DDItems.WARDEN_HELMET.get())) {
            pPoseStack.pushPose();

            pPoseStack.scale(1, 1, 1);
            this.getParentModel().getHead().translateAndRotate(pPoseStack);
            WardenHelmetModel<E> helmetModel = new WardenHelmetModel<>(this.model.bakeLayer(MODEL));
            helmetModel.renderToBuffer(pPoseStack, pBuffer.getBuffer(RenderType.armorCutoutNoCull(TEXTURE)), pPackedLight, OverlayTexture.NO_OVERLAY);

            pPoseStack.popPose();
        }
    }
}
