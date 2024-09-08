package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public class DDLootItemFunctions {
    public static final LootItemFunctionType SET_PAINTING_VARIANT = register("set_painting_variant", SetPaintingVariantFunction.CODEC);

    private static LootItemFunctionType register(String string, Codec<? extends LootItemFunction> codec) {
        return Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, new ResourceLocation(DeeperDarker.MOD_ID, string), new LootItemFunctionType(codec));
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering loot item functions");
    }
}
