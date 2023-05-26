package com.kyanite.deeperdarker.forge.client;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.client.rendering.entity.DDBoatModels;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ForgeBoatModels {
    private static boolean isInitialized = false;

    private static void initialize() {
        if(isInitialized) return;
        isInitialized = true;

        DDBoatModels.boat = addModel("boat", () -> BoatModel.createBodyModel(false), r -> new BoatModel(r, false));
        DDBoatModels.boatChest = addModel("boat_chest", () -> BoatModel.createBodyModel(true), r -> new BoatModel(r, true));
    }

    private static ModelLayerLocation addModel(String name, Supplier<LayerDefinition> supplier, Function<ModelPart, EntityModel<?>> modelConstructor) {
        return addLayer(name, supplier);
    }

    private static ModelLayerLocation addLayer(String name, Supplier<LayerDefinition> supplier) {
        ModelLayerLocation location = new ModelLayerLocation(new ResourceLocation(DeeperAndDarker.MOD_ID, name), "main");
        DDBoatModels.layerDefinitions.put(location, supplier);
        return location;
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        initialize();

        for(ModelLayerLocation location : DDBoatModels.layerDefinitions.keySet()) {
            event.registerLayerDefinition(location, DDBoatModels.layerDefinitions.get(location));
        }
    }
}
