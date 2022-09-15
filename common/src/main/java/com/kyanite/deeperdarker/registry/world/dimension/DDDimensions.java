package com.kyanite.deeperdarker.registry.world.dimension;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class DDDimensions {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"));

    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, OTHERSIDE_LEVEL.registry());

    public static void dimension() {

    }
}
