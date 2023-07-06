package com.kyanite.deeperdarker.util.render;

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
    private final Map<String, Pair<ResourceLocation, ListModel<Boat>>> BOAT_RESOURCES;
    private final boolean HAS_CHEST;

    public DDBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.BOAT_RESOURCES = ImmutableMap.of(DDBlocks.ECHO.name(), Pair.of(new ResourceLocation(DeeperDarker.MOD_ID, "textures/entity/" + (pChestBoat ? "chest_boat" : "boat") + "/" + DDBlocks.ECHO.name() + ".png"), this.createBoatModel(pContext, pChestBoat)));
        this.HAS_CHEST = pChestBoat;
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, boolean chestBoat) {
        ModelLayerLocation modellayerlocation = chestBoat ?
                new ModelLayerLocation(new ResourceLocation("minecraft", "chest_boat/oak"), "main") :
                new ModelLayerLocation(new ResourceLocation("minecraft", "boat/oak"), "main");
        ModelPart modelpart = context.bakeLayer(modellayerlocation);
        return chestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    @Override
    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(HAS_CHEST) return BOAT_RESOURCES.get(((DDChestBoat) boat).getWoodType());
        return BOAT_RESOURCES.get(((DDBoat) boat).getWoodType());
    }
}
