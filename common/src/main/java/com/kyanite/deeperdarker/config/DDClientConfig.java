package com.kyanite.deeperdarker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DDClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Deeper and Darker Configuration");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
