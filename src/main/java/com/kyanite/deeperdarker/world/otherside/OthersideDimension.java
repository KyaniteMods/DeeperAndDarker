package com.kyanite.deeperdarker.world.otherside;

import com.google.common.collect.ImmutableSet;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.OptionalLong;

public class OthersideDimension {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registries.DIMENSION, DeeperDarker.rl("otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registries.DIMENSION_TYPE, DeeperDarker.rl("otherside"));
    public static final ResourceLocation OTHERSIDE_EFFECTS = DeeperDarker.rl("otherside_effects");

    public static void bootstrap(BootstrapContext<DimensionType> context) {
        context.register(OTHERSIDE, new DimensionType(OptionalLong.of(18000L), false, true, false, true, 1, true, false, 0, 128, 128, DDTags.Blocks.INFINIBURN_OTHERSIDE, OTHERSIDE_EFFECTS, 0.05f, new DimensionType.MonsterSettings(true, false, ConstantInt.of(7), 15)));
    }

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, DeeperDarker.MOD_ID);
    public static final DeferredHolder<PoiType, PoiType> OTHERSIDE_PORTAL = POI.register("otherside_portal", () -> new PoiType(ImmutableSet.copyOf(DDBlocks.OTHERSIDE_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}
