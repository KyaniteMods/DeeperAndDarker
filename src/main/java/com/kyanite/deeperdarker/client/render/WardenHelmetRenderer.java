package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.ModModelLayers;
import com.kyanite.deeperdarker.client.model.WardenHelmetModel;
import com.kyanite.deeperdarker.content.DDItems;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("NullableProblems")
public class WardenHelmetRenderer<S extends HumanoidRenderState, M extends HumanoidModel<S>> extends RenderLayer<S, M> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/models/armor/warden_layer_3.png");
    private final WardenHelmetModel<S> model;

    public WardenHelmetRenderer(RenderLayerParent<S, M> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new WardenHelmetModel<>(modelSet.bakeLayer(ModModelLayers.WARDEN_HELMET));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, S state, float yRot, float xRot) {
        ItemStack stack = state.headEquipment;
        if(stack.is(DDItems.WARDEN_HELMET.get())) {
            poseStack.pushPose();

            poseStack.scale(1, 1, 1);
            this.getParentModel().getHead().translateAndRotate(poseStack);
            submitNodeCollector.submitModel(model, state, poseStack, RenderTypes.armorCutoutNoCull(TEXTURE), lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor, null);
        }
    }
}
