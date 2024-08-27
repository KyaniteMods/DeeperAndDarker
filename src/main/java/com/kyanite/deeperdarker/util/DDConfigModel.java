package com.kyanite.deeperdarker.util;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "deeperdarker")
@Config(name = "deeperdarker", wrapperName = "DDConfig")
public class DDConfigModel {
    @Nest
    public Server server = new Server();

    public static class Server {
        @RangeConstraint(min = 0.0, max = 1.0)
        public float spawnSomethingFromAncientVaseChance = 0.16f;

        @RangeConstraint(min = 0.0, max = 1.0)
        public double sculkLeechesFromAncientVaseChance = 0.7;

        public boolean geysersApplySlowFalling = false;

        @RangeConstraint(min = 0.0, max = 20.0)
        public float geyserLaunchVelocity = 2.5f;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int portalMinWidth = 2;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int portalMinHeight = 2;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int portalMaxWidth = 48;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int portalMaxHeight = 24;

        @RangeConstraint(min = 0.0, max = 127.0)
        public int portalMinSearchHeight = 2;

        @RangeConstraint(min = 0.0, max = 127.0)
        public int portalMaxSearchHeight = 122;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int generatedPortalWidth = 8;

        @RangeConstraint(min = 1.0, max = 128.0)
        public int generatedPortalHeight = 4;

        @RangeConstraint(min = 1.0, max = 128.0)
        public float sonorousStaffDamage = 10.0f;

        @RangeConstraint(min = 1.0, max = 128.0)
        public double sonorousStaffKnockback = 1.0;

        @RangeConstraint(min = 1.0, max = 32767.0)
        public int sonorousStaffCooldown = 40;

        @RangeConstraint(min = -1.0, max = 32767.0)
        public int soulElytraCooldown = 600;

        @RangeConstraint(min = 1.0, max = 128.0)
        public double soulElytraBoostStrength = 2.0;

        @RangeConstraint(min = -1.0, max = 32.0)
        public int snapperDropLimit = 8;
    }

    @Nest
    public Client client = new Client();

    public static class Client {
        public boolean renderWardenHelmetHorns = true;

        public boolean wardenHeartPulses = true;

        public boolean changePhantomTextures = true;

        public boolean paintingFix = true;
    }
}
