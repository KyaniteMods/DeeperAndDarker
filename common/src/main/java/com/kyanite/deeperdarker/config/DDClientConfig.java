package com.kyanite.deeperdarker.config;

import com.kyanite.paragon.api.enums.ConfigSide;
import com.kyanite.paragon.api.interfaces.Config;

public class DDClientConfig implements Config {

    @Override
    public ConfigSide configSide() {
        return ConfigSide.CLIENT;
    }
}
