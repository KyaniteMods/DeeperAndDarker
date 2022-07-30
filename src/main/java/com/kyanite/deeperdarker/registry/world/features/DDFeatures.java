package com.kyanite.deeperdarker.registry.world.features;

import com.kyanite.deeperdarker.DeeperAndDarker;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DDFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<SculkGleamFeature> SCULK_GLEAM_FEATURE = registerFeature("sculk_gleam_feature", () -> new SculkGleamFeature(NoneFeatureConfiguration.CODEC));

    private static <T extends Feature<?>> RegistryObject<T> registerFeature(final String name, final Supplier<T> sup) {
        return FEATURES.register(name, sup);
    }
}
