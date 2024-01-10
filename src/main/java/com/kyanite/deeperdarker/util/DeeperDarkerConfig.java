package com.kyanite.deeperdarker.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class DeeperDarkerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue WARDEN_HEART_PULSES = BUILDER.comment("Heart of the Deep beats like a heart", "Default: true").define("wardenHeartPulses", true);
    private static final ForgeConfigSpec.DoubleValue FAKE_VASE_CHANCE = BUILDER.comment("Chance of a vase being fake", "Default: 0.16").defineInRange("fakeVaseChance", 0.16, 0, 1);
    private static final ForgeConfigSpec.DoubleValue STALKER_SPAWN_CHANCE = BUILDER.comment("Chance of a Stalker spawning when a fake vase is broken", "Default: 0.3125").defineInRange("stalkerSpawnChance", 0.3125, 0, 1);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
    public static boolean wardenHeartPulses;
    public static double fakeVaseChance;
    public static double stalkerSpawnChance;

    public static void loadConfigs(final ModConfigEvent event) {
        wardenHeartPulses = WARDEN_HEART_PULSES.get();
        fakeVaseChance = FAKE_VASE_CHANCE.get();
        stalkerSpawnChance = STALKER_SPAWN_CHANCE.get();
    }
}
