package com.kyanite.deeperdarker.client.rendering.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DDBoatModels {
    public static final Map<ModelLayerLocation, Supplier<LayerDefinition>> layerDefinitions = new HashMap<>();
    public static ModelLayerLocation boat;
    public static ModelLayerLocation boatChest;
}
