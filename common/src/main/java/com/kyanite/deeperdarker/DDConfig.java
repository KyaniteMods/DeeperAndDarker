package com.kyanite.deeperdarker;

import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.interfaces.ModConfig;

import java.util.List;

public class DDConfig implements ModConfig {

    // Armor Options
    public static final ConfigOption<Integer> WARDEN_ARMOR_DURABILITY = new ConfigOption<>("warden_armor_durability", 45);
    public static final ConfigOption<Double> WARDEN_ARMOR_TOUGHNESS = new ConfigOption<>("warden_armor_toughness", 3.0d);
    public static final ConfigOption<Double> WARDEN_ARMOR_KNOCKBACK_RESISTANCE = new ConfigOption<>("warden_armor_knockback_resistance", 0.5d);

    // Tool Options
    public static final ConfigOption<Integer> WARDEN_TOOLS_DURABILITY = new ConfigOption<>("warden_tools_durability", 2464);
    public static final ConfigOption<Double> WARDEN_TOOLS_SPEED = new ConfigOption<>("warden_tools_speed", 11d);
    public static final ConfigOption<Double> WARDEN_TOOLS_DAMAGE = new ConfigOption<>("warden_tools_damage", 7d);
    // Mob Spawning Options
    public static final ConfigOption<Boolean> SHATTERED_SPAWNING = new ConfigOption<>("shattered_spawning", true);
    public static final ConfigOption<Boolean> PHANTOM_SPAWNING = new ConfigOption<>("phantom_spawning", true);
    public static final ConfigOption<Boolean> SNAPPER_SPAWNING = new ConfigOption<>("sculk_snapper_spawning", true);
    public static final ConfigOption<Boolean> CENTIPEDE_SPAWNING = new ConfigOption<>("sculk_centipede_spawning", true);

    // Otherside Decoration Options
    public static final ConfigOption<Boolean> SCULK_BLOCKS_IN_OTHERSIDE = new ConfigOption<>("sculk_blocks_in_otherside", true);

    @Override
    public List<ConfigOption> configOptions() {
        return List.of(
                WARDEN_ARMOR_DURABILITY, WARDEN_ARMOR_TOUGHNESS, WARDEN_ARMOR_KNOCKBACK_RESISTANCE,
                WARDEN_TOOLS_DURABILITY, WARDEN_TOOLS_SPEED, WARDEN_TOOLS_DAMAGE,
                SHATTERED_SPAWNING, PHANTOM_SPAWNING, SNAPPER_SPAWNING, CENTIPEDE_SPAWNING,
                SCULK_BLOCKS_IN_OTHERSIDE);
    }
}
