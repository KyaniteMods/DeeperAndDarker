package com.kyanite.deeperdarker.registry.world.dimension;

import com.google.common.collect.ImmutableSet;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.function.Supplier;

public class DDDimensions {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DeeperAndDarker.MOD_ID, "otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, OTHERSIDE_LEVEL.registry());
    public static final Supplier<PoiType> OTHERSIDE_PORTAL = RegistryHelper.registerPOI("otherside_portal", () -> new PoiType(ImmutableSet.copyOf(DDBlocks.OTHERSIDE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

    public static void registerDimensions() {}
}
