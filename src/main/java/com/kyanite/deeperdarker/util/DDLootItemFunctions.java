package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public class DDLootItemFunctions {
    public static final LootItemFunctionType<SetPaintingVariantFunction> SET_PAINTING_VARIANT = register("set_painting_variant", SetPaintingVariantFunction.CODEC);

    private static <T extends LootItemFunction> LootItemFunctionType<T> register(String string, MapCodec<T> mapCodec) {
        return Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, DeeperDarker.id(string), new LootItemFunctionType<>(mapCodec));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering loot item functions");
    }
}