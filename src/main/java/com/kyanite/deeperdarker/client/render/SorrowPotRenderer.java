package com.kyanite.deeperdarker.client.render;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.client.model.SorrowPotModel;
import com.kyanite.deeperdarker.content.entities.OvercastPot;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class SorrowPotRenderer extends MobRenderer<OvercastPot, SorrowPotModel> {
    public static final ModelLayerLocation MODEL = new ModelLayerLocation(DeeperDarker.rl("sorrow_pot_layer"), "main");
    private static final ResourceLocation TEXTURE = DeeperDarker.rl("textures/entity/sorrow_pot.png");

    public SorrowPotRenderer(EntityRendererProvider.Context context) {
        super(context, new SorrowPotModel(context.bakeLayer(MODEL)), 0.35f);
    }

    @Override
    public ResourceLocation getTextureLocation(OvercastPot entity) {
        return TEXTURE;
    }
}
