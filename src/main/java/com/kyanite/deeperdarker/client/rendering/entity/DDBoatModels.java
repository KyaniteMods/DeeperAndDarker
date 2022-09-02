package com.kyanite.deeperdarker.client.rendering.entity;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class DDBoatModels {
    public static final Map<ModelLayerLocation, Supplier<LayerDefinition>> layerDefinitions = new HashMap<>();

    public static ModelLayerLocation boat;
    public static ModelLayerLocation boatChest;

    private static boolean isInitialized = false;

    private static void initialize() {
        if(isInitialized) return;
        isInitialized = true;

        boat = addModel("boat", () -> BoatModel.createBodyModel(false), r -> new BoatModel(r, false));
        boatChest = addModel("boat_chest", () -> BoatModel.createBodyModel(true), r -> new BoatModel(r, true));
    }

    private static ModelLayerLocation addModel(String name, Supplier<LayerDefinition> supplier, Function<ModelPart, EntityModel<?>> modelConstructor) {
        return addLayer(name, supplier);
    }

    private static ModelLayerLocation addLayer(String name, Supplier<LayerDefinition> supplier) {
        ModelLayerLocation location = new ModelLayerLocation(new ResourceLocation(DeeperAndDarker.MOD_ID, name), "main");
        layerDefinitions.put(location, supplier);
        return location;
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        initialize();

        for(ModelLayerLocation location : layerDefinitions.keySet()) {
            event.registerLayerDefinition(location, layerDefinitions.get(location));
        }
    }
}
