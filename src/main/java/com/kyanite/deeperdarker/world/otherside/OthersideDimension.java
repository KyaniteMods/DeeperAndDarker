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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalLong;

public class OthersideDimension {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(OTHERSIDE, new DimensionType(OptionalLong.of(18000L), false, true, false, true, 1, true, false, 0, 128, 128, BlockTags.INFINIBURN_NETHER, BuiltinDimensionTypes.NETHER_EFFECTS, 0.05f, new DimensionType.MonsterSettings(true, false, ConstantInt.of(7), 9)));
    }

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, DeeperDarker.MOD_ID);
    public static final RegistryObject<PoiType> OTHERSIDE_PORTAL = POI.register("otherside_portal", () -> new PoiType(ImmutableSet.copyOf(DDBlocks.OTHERSIDE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
