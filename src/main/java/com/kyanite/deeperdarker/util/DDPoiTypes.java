package com.kyanite.deeperdarker.util;

import com.google.common.collect.ImmutableSet;
import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDPoiTypes {
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<PoiType> OTHERSIDE_PORTAL = POI.register("otherside_portal", () -> new PoiType(ImmutableSet.copyOf(DDBlocks.OTHERSIDE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}