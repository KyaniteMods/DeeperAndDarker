package com.kyanite.deeperdarker.config;

import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.enums.ConfigSide;
import com.kyanite.paragon.api.interfaces.configtypes.JSONModConfig;

public class DDClientConfig implements JSONModConfig {
    public static final ConfigOption<Boolean> SHOW_START_SCREEN = new ConfigOption<>("show_start_screen", true);

    @Override
    public ConfigSide configSide() {
        return ConfigSide.CLIENT;
    }

    @Override
    public String getModId() {
        return "deeperdarker";
    }
}
