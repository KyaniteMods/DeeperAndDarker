package com.kyanite.deeperdarker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DDConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.ConfigValue<Double> WARDEN_TOOLS_DAMAGE;
    public static final ForgeConfigSpec.ConfigValue<Double> WARDEN_TOOLS_SPEED;
    public static final ForgeConfigSpec.ConfigValue<Integer> WARDEN_TOOLS_USES;

    static {
        BUILDER.push("Deeper and Darker Configuration");

        WARDEN_TOOLS_DAMAGE = BUILDER.comment("Base attack damage for Warden tools").define("Attack Damage", 6.0d);
        WARDEN_TOOLS_SPEED = BUILDER.comment("Base attack speed for Warden tools").define("Attack Speed", 10.0d);
        WARDEN_TOOLS_USES = BUILDER.comment("Base uses (how many uses before breaking) for Warden tools").define("Max Uses", 2480);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
