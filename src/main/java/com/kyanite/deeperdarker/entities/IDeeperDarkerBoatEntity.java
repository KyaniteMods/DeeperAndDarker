package com.kyanite.deeperdarker.entities;

import net.minecraft.block.WoodType;

public interface IDeeperDarkerBoatEntity {
    DeeperDarkerBoatTypes getWoodType();
    void setWoodType(String woodType);
    void setWoodType(DeeperDarkerBoatTypes boatType);
    void setWoodType(WoodType woodType);
}
