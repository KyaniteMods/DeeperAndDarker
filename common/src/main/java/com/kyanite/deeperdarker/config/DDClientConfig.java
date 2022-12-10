package com.kyanite.deeperdarker.config;

import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.enums.ConfigSide;
import com.kyanite.paragon.api.interfaces.Config;

public class DDClientConfig implements Config {
    public static final ConfigOption<Boolean> SHOW_START_SCREEN = new ConfigOption<>("show_start_screen", false);

    @Override
    public ConfigSide configSide() {
        return ConfigSide.CLIENT;
    }
}
