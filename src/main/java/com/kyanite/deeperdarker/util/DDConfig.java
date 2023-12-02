package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public class DDConfig {
    public static ConfigClassHandler<DDConfig> HANDLER = ConfigClassHandler.createBuilder(DDConfig.class)
            .id(new ResourceLocation(DeeperDarker.MOD_ID, "deeperdarker"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("deeperdarker.json5"))
                    .setJson5(true)
                    .build())
            .build();

    public static void saveHandler() {
        HANDLER.save();
        DeeperDarker.PORTAL_LINK.portalSearchYBottom = HANDLER.instance().portalMinSearchHeight;
        DeeperDarker.PORTAL_LINK.portalSearchYTop = HANDLER.instance().portalMaxSearchHeight;
    }

    public static void loadHandler() {
        HANDLER.load();
        DeeperDarker.PORTAL_LINK.portalSearchYBottom = HANDLER.instance().portalMinSearchHeight;
        DeeperDarker.PORTAL_LINK.portalSearchYTop = HANDLER.instance().portalMaxSearchHeight;
    }

    @SerialEntry(comment = "Chance of either sculk leeches or stalkers spawning.")
    public float spawnSomethingFromAncientVaseChance = 0.16f;

    @SerialEntry(comment = "Chance of sculk leeches spawning. This is only used if something should spawn in the first place, as per `spawnSomethingFromAncientVaseChance`. If sculk leeches do not spawn, a stalker will be spawned instead.")
    public double sculkLeechesFromAncientVaseChance = 0.7;

    @SerialEntry
    public boolean renderWardenHelmetHorns = true;

    @SerialEntry
    public boolean geysersApplySlowFalling = false;

    @SerialEntry
    public float geyserLaunchVelocity = 2.5f;

    @SerialEntry(comment = "The minimum inner width (not counting the frame) of the Otherside portal in order to light it successfully")
    public int portalMinWidth = 8;

    @SerialEntry(comment = "The minimum inner height (not counting the frame) of the Otherside portal in order to light it successfully")
    public int portalMinHeight = 4;

    @SerialEntry(comment = "The maximum inner width (not counting the frame) of the Otherside portal in order to light it successfully")
    public int portalMaxWidth = 48;

    @SerialEntry(comment = "The maximum inner height (not counting the frame) of the Otherside portal in order to light it successfully")
    public int portalMaxHeight = 24;

    @SerialEntry(comment = "The lowest Y coordinate to search to generate an Otherside portal")
    public int portalMinSearchHeight = 2;

    @SerialEntry(comment = "The highest Y coordinate to search to generate an Otherside portal")
    public int portalMaxSearchHeight = 126 - this.portalMinHeight;

    @SerialEntry(comment = "The width of Otherside portals generated when traveling through dimensions and no portal is available")
    public int generatedPortalWidth = 8;

    @SerialEntry(comment = "The height of Otherside portals generated when traveling through dimensions and no portal is available")
    public int generatedPortalHeight = 4;

    @SerialEntry
    public int sonorousStaffRange = 40;

    @SerialEntry
    public float sonorousStaffDamage = 10.0f;

    @SerialEntry
    public double sonorousStaffKnockback = 1.0;

    @SerialEntry
    public boolean wardenHeartPulses = true;

    @SerialEntry
    public boolean changePhantomTextures = true;
}
