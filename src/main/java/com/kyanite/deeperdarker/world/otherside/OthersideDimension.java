package com.kyanite.deeperdarker.world.otherside;

import com.google.common.collect.ImmutableSet;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

public class OthersideDimension {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));

    public static void init() {
        DeeperDarker.LOGGER.debug("Otherside loaded");
    }
}
