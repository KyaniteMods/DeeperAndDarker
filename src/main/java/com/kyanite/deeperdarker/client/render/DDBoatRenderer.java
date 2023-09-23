package com.kyanite.deeperdarker.client.render;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;

@SuppressWarnings("NullableProblems")
public class DDBoatRenderer extends BoatRenderer {
    public static final ModelLayerLocation ECHO_CHEST_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "chest_boat/echo"), "main");
    public static final ModelLayerLocation ECHO_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "boat/echo"), "main");
    private final boolean HAS_CHEST;
    private final Map<String, Pair<ResourceLocation, BoatModel>> BOAT_RESOURCES;

    public DDBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.HAS_CHEST = pChestBoat;
        this.BOAT_RESOURCES = ImmutableMap.of(DDBlocks.ECHO.name(), Pair.of(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + DDBlocks.ECHO.name() + ".png"), this.createBoatModel(pContext)));
    }

    private BoatModel createBoatModel(EntityRendererProvider.Context context) {
        return new BoatModel(context.bakeLayer(HAS_CHEST ? ECHO_CHEST_BOAT_MODEL : ECHO_BOAT_MODEL), HAS_CHEST);
    }

    @Override
    public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat) {
        return BOAT_RESOURCES.get("echo");
    }
}
