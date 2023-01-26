package com.kyanite.deeperdarker.config;

import com.kyanite.paragon.api.ConfigGroup;
import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.interfaces.Config;
import com.kyanite.paragon.api.interfaces.Description;

public class DDConfig implements Config {
    // Armor Options
    public static final ConfigOption<Integer> WARDEN_ARMOR_DURABILITY = new ConfigOption<>("warden_armor_durability", 45);
    public static final ConfigOption<Double> WARDEN_ARMOR_TOUGHNESS = new ConfigOption<>("warden_armor_toughness", 3.0d);
    public static final ConfigOption<Double> WARDEN_ARMOR_KNOCKBACK_RESISTANCE = new ConfigOption<>("warden_armor_knockback_resistance", 0.5d);
    @Description("How much strength/armor you get from the Soul Elytra")
    public static final ConfigOption<Double> SOUL_ELYTRA_ARMOR_MODIFIER = new ConfigOption<>("soul_elytra_armor_modifier", 4.0d);

    public static final ConfigGroup WARDEN_ARMOR = new ConfigGroup("warden_armor", WARDEN_ARMOR_DURABILITY, WARDEN_ARMOR_TOUGHNESS, WARDEN_ARMOR_KNOCKBACK_RESISTANCE, SOUL_ELYTRA_ARMOR_MODIFIER);

    // Tool Options
    public static final ConfigOption<Integer> WARDEN_TOOLS_DURABILITY = new ConfigOption<>("warden_tools_durability", 2464);
    public static final ConfigOption<Double> WARDEN_TOOLS_SPEED = new ConfigOption<>("warden_tools_speed", 11d);
    public static final ConfigOption<Double> WARDEN_TOOLS_DAMAGE = new ConfigOption<>("warden_tools_damage", 7d);

    public static final ConfigGroup WARDEN_TOOLS = new ConfigGroup("warden_tools", WARDEN_TOOLS_DURABILITY, WARDEN_TOOLS_SPEED, WARDEN_TOOLS_DAMAGE);


    public static final ConfigOption<Double> TRANSMITTER_DAMAGE = new ConfigOption<>("transmitter_damage", 10d);
    public static final ConfigOption<Integer> TRANSMITTER_COOLDOWN = new ConfigOption<>("transmitter_cooldown", 15);
    // Mob Spawning Options
    public static final ConfigOption<Boolean> SHATTERED_SPAWNING = new ConfigOption<>("shattered_spawning", true);
    public static final ConfigOption<Boolean> PHANTOM_SPAWNING = new ConfigOption<>("phantom_spawning", true);
    public static final ConfigOption<Boolean> SNAPPER_SPAWNING = new ConfigOption<>("sculk_snapper_spawning", true);
    public static final ConfigOption<Boolean> CENTIPEDE_SPAWNING = new ConfigOption<>("sculk_centipede_spawning", true);

    // Otherside Decoration Options
    @Description("Whether Sculk Blocks can spawn in the Otherside or not (Sculk Sensor, Sculk Vein, and Sculk Catalyst)")
    public static final ConfigOption<Boolean> SCULK_BLOCKS_IN_OTHERSIDE = new ConfigOption<>("sculk_blocks_in_otherside", true);

    public static final ConfigGroup OTHERSIDE = new ConfigGroup("otherside", SHATTERED_SPAWNING, PHANTOM_SPAWNING, SNAPPER_SPAWNING, CENTIPEDE_SPAWNING, SCULK_BLOCKS_IN_OTHERSIDE);

    // Other
    @Description("Whether the Sculk Jaw can eat items or not (eating an item will cause it to disappear forever)")
    public static final ConfigOption<Boolean> SCULK_JAW_EATS_ITEMS = new ConfigOption<>("sculk_jaw_eats_items", false);
}
