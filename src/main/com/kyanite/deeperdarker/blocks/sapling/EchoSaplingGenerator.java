package com.kyanite.deeperdarker.blocks.sapling;

import com.kyanite.deeperdarker.world.gen.feature.DeeperDarkerConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class EchoSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return DeeperDarkerConfiguredFeatures.ECHO_TREE;
    }
}
