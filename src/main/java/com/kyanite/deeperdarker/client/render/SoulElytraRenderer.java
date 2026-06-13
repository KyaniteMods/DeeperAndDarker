package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.equipment.ElytraModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.WingsLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

@SuppressWarnings("NullableProblems")
public class SoulElytraRenderer<S extends HumanoidRenderState, M extends EntityModel<S>> extends WingsLayer<S, M> {
    private static final Identifier TEXTURE = DeeperDarker.rl("textures/entity/soul_elytra.png");
    private final ElytraModel elytraModel;
    private final ElytraModel elytraBabyModel;

    public SoulElytraRenderer(RenderLayerParent<S, M> renderer, EntityModelSet modelSet, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, modelSet, equipmentRenderer);
        this.elytraModel = new ElytraModel(modelSet.bakeLayer(ModelLayers.ELYTRA));
        this.elytraBabyModel = new ElytraModel(modelSet.bakeLayer(ModelLayers.ELYTRA_BABY));
    }
}
