package com.kyanite.deeperdarker.client.render;

import com.google.common.collect.ImmutableMap;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.entities.DDBoat;
import com.kyanite.deeperdarker.content.entities.DDChestBoat;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;

@SuppressWarnings("NullableProblems")
public class DDBoatRenderer extends BoatRenderer {
    public static final ModelLayerLocation ECHO_CHEST_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "chest_boat/echo"), "main");
    public static final ModelLayerLocation ECHO_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "boat/echo"), "main");
    public static final ModelLayerLocation BLOOM_CHEST_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "chest_boat/bloom"), "main");
    public static final ModelLayerLocation BLOOM_BOAT_MODEL = new ModelLayerLocation(new ResourceLocation(DeeperDarker.MOD_ID, "boat/bloom"), "main");
    private final boolean HAS_CHEST;
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final Map<String, ModelLayerLocation> chestBoatModels;
    private final Map<String, ModelLayerLocation> boatModels;

    public DDBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.HAS_CHEST = pChestBoat;
        this.chestBoatModels = Map.of(DDBlocks.ECHO.name(), ECHO_CHEST_BOAT_MODEL, DDBlocks.BLOOM.name(), BLOOM_CHEST_BOAT_MODEL);
        this.boatModels = Map.of(DDBlocks.ECHO.name(), ECHO_BOAT_MODEL, DDBlocks.BLOOM.name(), BLOOM_BOAT_MODEL);
        this.BOAT_RESOURCES = ImmutableMap.of(DDBlocks.ECHO.name(), Pair.of(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + DDBlocks.ECHO.name() + ".png"), this.createBoatModel(pContext, DDBlocks.ECHO.name())),
                DDBlocks.BLOOM.name(), Pair.of(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + DDBlocks.BLOOM.name() + ".png"), this.createBoatModel(pContext, DDBlocks.BLOOM.name())));
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, String boatType) {
        ModelPart modelPart = context.bakeLayer(HAS_CHEST ? this.chestBoatModels.get(boatType) : this.boatModels.get(boatType));
        return HAS_CHEST ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        Pair<ResourceLocation, ListModel<Boat>> model = null;
        if(boat instanceof DDBoat ddBoat) model = BOAT_RESOURCES.get(ddBoat.getWoodType());
        if(boat instanceof DDChestBoat ddChestBoat) model = BOAT_RESOURCES.get(ddChestBoat.getWoodType());
        return model == null ? BOAT_RESOURCES.get("bloom") : model;
    }
}
