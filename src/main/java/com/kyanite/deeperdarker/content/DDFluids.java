package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.fluids.AcidFluid;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class DDFluids {
    public static final FlowingFluid ACID = register("acid", new AcidFluid.Source());
    public static final FlowingFluid FLOWING_ACID = register("flowing_acid", new AcidFluid.Flowing());

    private static <T extends Fluid> T register(String id, T fluid) {
        return Registry.register(BuiltInRegistries.FLUID, new ResourceLocation(DeeperDarker.MOD_ID, id), fluid);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering fluids");
    }
}
