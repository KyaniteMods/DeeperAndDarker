package com.kyanite.deeperdarker.world.otherside;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

public class OthersideDimension {
    public static final ResourceKey<Level> OTHERSIDE_LEVEL = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));
    public static final ResourceKey<DimensionType> OTHERSIDE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, "otherside"));

    public static void bootstrap(BootstapContext<DimensionType> context) {
        context.register(OTHERSIDE, new DimensionType(OptionalLong.of(18000L), false, true, false, true, 1, true, false, 0, 128, 128, DDTags.Blocks.INFINIBURN_OTHERSIDE, BuiltinDimensionTypes.NETHER_EFFECTS, 0.05f, new DimensionType.MonsterSettings(true, false, ConstantInt.of(7), 15)));
    }
}