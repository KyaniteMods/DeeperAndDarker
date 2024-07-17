package com.kyanite.deeperdarker.util;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DDConfig extends ConfigWrapper<com.kyanite.deeperdarker.util.DDConfigModel> {

    public final Keys keys = new Keys();

    private final Option<java.lang.Float> server_spawnSomethingFromAncientVaseChance = this.optionForKey(this.keys.server_spawnSomethingFromAncientVaseChance);
    private final Option<java.lang.Double> server_sculkLeechesFromAncientVaseChance = this.optionForKey(this.keys.server_sculkLeechesFromAncientVaseChance);
    private final Option<java.lang.Boolean> server_geysersApplySlowFalling = this.optionForKey(this.keys.server_geysersApplySlowFalling);
    private final Option<java.lang.Float> server_geyserLaunchVelocity = this.optionForKey(this.keys.server_geyserLaunchVelocity);
    private final Option<java.lang.Integer> server_portalMinWidth = this.optionForKey(this.keys.server_portalMinWidth);
    private final Option<java.lang.Integer> server_portalMinHeight = this.optionForKey(this.keys.server_portalMinHeight);
    private final Option<java.lang.Integer> server_portalMaxWidth = this.optionForKey(this.keys.server_portalMaxWidth);
    private final Option<java.lang.Integer> server_portalMaxHeight = this.optionForKey(this.keys.server_portalMaxHeight);
    private final Option<java.lang.Integer> server_portalMinSearchHeight = this.optionForKey(this.keys.server_portalMinSearchHeight);
    private final Option<java.lang.Integer> server_portalMaxSearchHeight = this.optionForKey(this.keys.server_portalMaxSearchHeight);
    private final Option<java.lang.Integer> server_generatedPortalWidth = this.optionForKey(this.keys.server_generatedPortalWidth);
    private final Option<java.lang.Integer> server_generatedPortalHeight = this.optionForKey(this.keys.server_generatedPortalHeight);
    private final Option<java.lang.Float> server_sonorousStaffDamage = this.optionForKey(this.keys.server_sonorousStaffDamage);
    private final Option<java.lang.Double> server_sonorousStaffKnockback = this.optionForKey(this.keys.server_sonorousStaffKnockback);
    private final Option<java.lang.Integer> server_sonorousStaffCooldown = this.optionForKey(this.keys.server_sonorousStaffCooldown);
    private final Option<java.lang.Integer> server_soulElytraCooldown = this.optionForKey(this.keys.server_soulElytraCooldown);
    private final Option<java.lang.Double> server_soulElytraBoostStrength = this.optionForKey(this.keys.server_soulElytraBoostStrength);
    private final Option<java.lang.Boolean> client_renderWardenHelmetHorns = this.optionForKey(this.keys.client_renderWardenHelmetHorns);
    private final Option<java.lang.Boolean> client_wardenHeartPulses = this.optionForKey(this.keys.client_wardenHeartPulses);
    private final Option<java.lang.Boolean> client_changePhantomTextures = this.optionForKey(this.keys.client_changePhantomTextures);
    private final Option<java.lang.Boolean> client_paintingFix = this.optionForKey(this.keys.client_paintingFix);

    private DDConfig() {
        super(com.kyanite.deeperdarker.util.DDConfigModel.class);
    }

    private DDConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(com.kyanite.deeperdarker.util.DDConfigModel.class, janksonBuilder);
    }

    public static DDConfig createAndLoad() {
        var wrapper = new DDConfig();
        wrapper.load();
        return wrapper;
    }

    public static DDConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new DDConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public final Server_ server = new Server_();
    public class Server_ implements Server {
        public float spawnSomethingFromAncientVaseChance() {
            return server_spawnSomethingFromAncientVaseChance.value();
        }

        public void spawnSomethingFromAncientVaseChance(float value) {
            server_spawnSomethingFromAncientVaseChance.set(value);
        }

        public double sculkLeechesFromAncientVaseChance() {
            return server_sculkLeechesFromAncientVaseChance.value();
        }

        public void sculkLeechesFromAncientVaseChance(double value) {
            server_sculkLeechesFromAncientVaseChance.set(value);
        }

        public boolean geysersApplySlowFalling() {
            return server_geysersApplySlowFalling.value();
        }

        public void geysersApplySlowFalling(boolean value) {
            server_geysersApplySlowFalling.set(value);
        }

        public float geyserLaunchVelocity() {
            return server_geyserLaunchVelocity.value();
        }

        public void geyserLaunchVelocity(float value) {
            server_geyserLaunchVelocity.set(value);
        }

        public int portalMinWidth() {
            return server_portalMinWidth.value();
        }

        public void portalMinWidth(int value) {
            server_portalMinWidth.set(value);
        }

        public int portalMinHeight() {
            return server_portalMinHeight.value();
        }

        public void portalMinHeight(int value) {
            server_portalMinHeight.set(value);
        }

        public int portalMaxWidth() {
            return server_portalMaxWidth.value();
        }

        public void portalMaxWidth(int value) {
            server_portalMaxWidth.set(value);
        }

        public int portalMaxHeight() {
            return server_portalMaxHeight.value();
        }

        public void portalMaxHeight(int value) {
            server_portalMaxHeight.set(value);
        }

        public int portalMinSearchHeight() {
            return server_portalMinSearchHeight.value();
        }

        public void portalMinSearchHeight(int value) {
            server_portalMinSearchHeight.set(value);
        }

        public int portalMaxSearchHeight() {
            return server_portalMaxSearchHeight.value();
        }

        public void portalMaxSearchHeight(int value) {
            server_portalMaxSearchHeight.set(value);
        }

        public int generatedPortalWidth() {
            return server_generatedPortalWidth.value();
        }

        public void generatedPortalWidth(int value) {
            server_generatedPortalWidth.set(value);
        }

        public int generatedPortalHeight() {
            return server_generatedPortalHeight.value();
        }

        public void generatedPortalHeight(int value) {
            server_generatedPortalHeight.set(value);
        }

        public float sonorousStaffDamage() {
            return server_sonorousStaffDamage.value();
        }

        public void sonorousStaffDamage(float value) {
            server_sonorousStaffDamage.set(value);
        }

        public double sonorousStaffKnockback() {
            return server_sonorousStaffKnockback.value();
        }

        public void sonorousStaffKnockback(double value) {
            server_sonorousStaffKnockback.set(value);
        }

        public int sonorousStaffCooldown() {
            return server_sonorousStaffCooldown.value();
        }

        public void sonorousStaffCooldown(int value) {
            server_sonorousStaffCooldown.set(value);
        }

        public int soulElytraCooldown() {
            return server_soulElytraCooldown.value();
        }

        public void soulElytraCooldown(int value) {
            server_soulElytraCooldown.set(value);
        }

        public double soulElytraBoostStrength() {
            return server_soulElytraBoostStrength.value();
        }

        public void soulElytraBoostStrength(double value) {
            server_soulElytraBoostStrength.set(value);
        }

    }
    public final Client_ client = new Client_();
    public class Client_ implements Client {
        public boolean renderWardenHelmetHorns() {
            return client_renderWardenHelmetHorns.value();
        }

        public void renderWardenHelmetHorns(boolean value) {
            client_renderWardenHelmetHorns.set(value);
        }

        public boolean wardenHeartPulses() {
            return client_wardenHeartPulses.value();
        }

        public void wardenHeartPulses(boolean value) {
            client_wardenHeartPulses.set(value);
        }

        public boolean changePhantomTextures() {
            return client_changePhantomTextures.value();
        }

        public void changePhantomTextures(boolean value) {
            client_changePhantomTextures.set(value);
        }

        public boolean paintingFix() {
            return client_paintingFix.value();
        }

        public void paintingFix(boolean value) {
            client_paintingFix.set(value);
        }

    }
    public interface Server {
        float spawnSomethingFromAncientVaseChance();
        void spawnSomethingFromAncientVaseChance(float value);
        double sculkLeechesFromAncientVaseChance();
        void sculkLeechesFromAncientVaseChance(double value);
        boolean geysersApplySlowFalling();
        void geysersApplySlowFalling(boolean value);
        float geyserLaunchVelocity();
        void geyserLaunchVelocity(float value);
        int portalMinWidth();
        void portalMinWidth(int value);
        int portalMinHeight();
        void portalMinHeight(int value);
        int portalMaxWidth();
        void portalMaxWidth(int value);
        int portalMaxHeight();
        void portalMaxHeight(int value);
        int portalMinSearchHeight();
        void portalMinSearchHeight(int value);
        int portalMaxSearchHeight();
        void portalMaxSearchHeight(int value);
        int generatedPortalWidth();
        void generatedPortalWidth(int value);
        int generatedPortalHeight();
        void generatedPortalHeight(int value);
        float sonorousStaffDamage();
        void sonorousStaffDamage(float value);
        double sonorousStaffKnockback();
        void sonorousStaffKnockback(double value);
        int sonorousStaffCooldown();
        void sonorousStaffCooldown(int value);
        int soulElytraCooldown();
        void soulElytraCooldown(int value);
        double soulElytraBoostStrength();
        void soulElytraBoostStrength(double value);
    }
    public interface Client {
        boolean renderWardenHelmetHorns();
        void renderWardenHelmetHorns(boolean value);
        boolean wardenHeartPulses();
        void wardenHeartPulses(boolean value);
        boolean changePhantomTextures();
        void changePhantomTextures(boolean value);
        boolean paintingFix();
        void paintingFix(boolean value);
    }
    public static class Keys {
        public final Option.Key server_spawnSomethingFromAncientVaseChance = new Option.Key("server.spawnSomethingFromAncientVaseChance");
        public final Option.Key server_sculkLeechesFromAncientVaseChance = new Option.Key("server.sculkLeechesFromAncientVaseChance");
        public final Option.Key server_geysersApplySlowFalling = new Option.Key("server.geysersApplySlowFalling");
        public final Option.Key server_geyserLaunchVelocity = new Option.Key("server.geyserLaunchVelocity");
        public final Option.Key server_portalMinWidth = new Option.Key("server.portalMinWidth");
        public final Option.Key server_portalMinHeight = new Option.Key("server.portalMinHeight");
        public final Option.Key server_portalMaxWidth = new Option.Key("server.portalMaxWidth");
        public final Option.Key server_portalMaxHeight = new Option.Key("server.portalMaxHeight");
        public final Option.Key server_portalMinSearchHeight = new Option.Key("server.portalMinSearchHeight");
        public final Option.Key server_portalMaxSearchHeight = new Option.Key("server.portalMaxSearchHeight");
        public final Option.Key server_generatedPortalWidth = new Option.Key("server.generatedPortalWidth");
        public final Option.Key server_generatedPortalHeight = new Option.Key("server.generatedPortalHeight");
        public final Option.Key server_sonorousStaffDamage = new Option.Key("server.sonorousStaffDamage");
        public final Option.Key server_sonorousStaffKnockback = new Option.Key("server.sonorousStaffKnockback");
        public final Option.Key server_sonorousStaffCooldown = new Option.Key("server.sonorousStaffCooldown");
        public final Option.Key server_soulElytraCooldown = new Option.Key("server.soulElytraCooldown");
        public final Option.Key server_soulElytraBoostStrength = new Option.Key("server.soulElytraBoostStrength");
        public final Option.Key client_renderWardenHelmetHorns = new Option.Key("client.renderWardenHelmetHorns");
        public final Option.Key client_wardenHeartPulses = new Option.Key("client.wardenHeartPulses");
        public final Option.Key client_changePhantomTextures = new Option.Key("client.changePhantomTextures");
        public final Option.Key client_paintingFix = new Option.Key("client.paintingFix");
    }
}

