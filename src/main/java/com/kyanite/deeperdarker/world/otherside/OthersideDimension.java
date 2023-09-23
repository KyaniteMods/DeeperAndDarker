package com.kyanite.deeperdarker.world.otherside;

import com.google.common.collect.ImmutableSet;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OthersideDimension {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DeeperDarker.MOD_ID);
    public static final RegistryObject<PoiType> OTHERSIDE_PORTAL = POI.register("otherside_portal", () -> new PoiType(ImmutableSet.copyOf(DDBlocks.OTHERSIDE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
