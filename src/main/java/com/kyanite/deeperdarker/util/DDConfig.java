package com.kyanite.deeperdarker.util;

import com.google.gson.GsonBuilder;
import com.kyanite.deeperdarker.DeeperDarker;
import dev.isxander.yacl.config.ConfigEntry;
import dev.isxander.yacl.config.GsonConfigInstance;

import java.nio.file.Path;

public class DDConfig {
    public static GsonConfigInstance<DDConfig> HANDLER = new GsonConfigInstance<>(DDConfig.class, Path.of("config/deeperdarker.json"), new GsonBuilder().setPrettyPrinting());

    public static void saveHandler() {
        HANDLER.save();
        DeeperDarker.PORTAL_LINK.portalSearchYBottom = HANDLER.getConfig().portalMinSearchHeight;
        DeeperDarker.PORTAL_LINK.portalSearchYTop = HANDLER.getConfig().portalMaxSearchHeight;
    }

    public static void loadHandler() {
        HANDLER.load();
        DeeperDarker.PORTAL_LINK.portalSearchYBottom = HANDLER.getConfig().portalMinSearchHeight;
        DeeperDarker.PORTAL_LINK.portalSearchYTop = HANDLER.getConfig().portalMaxSearchHeight;
    }

    @ConfigEntry
    public float spawnSomethingFromAncientVaseChance = 0.16f;

    @ConfigEntry
    public double sculkLeechesFromAncientVaseChance = 0.7;

    @ConfigEntry
    public boolean renderWardenHelmetHorns = true;

    @ConfigEntry
    public boolean geysersApplySlowFalling = false;

    @ConfigEntry
    public float geyserLaunchVelocity = 2.5f;

    @ConfigEntry
    public int portalMinWidth = 8;

    @ConfigEntry
    public int portalMinHeight = 4;

    @ConfigEntry
    public int portalMaxWidth = 48;

    @ConfigEntry
    public int portalMaxHeight = 24;

    @ConfigEntry
    public int portalMinSearchHeight = 2;

    @ConfigEntry
    public int portalMaxSearchHeight = 122;

    @ConfigEntry
    public int generatedPortalWidth = 8;

    @ConfigEntry
    public int generatedPortalHeight = 4;

    @ConfigEntry
    public boolean wardenHeartPulses = true;

    @ConfigEntry
    public boolean changePhantomTextures = true;
}
