package com.kyanite.deeperdarker.registry.entities.custom.ai;

import net.minecraft.core.BlockPos;

public interface IDisturbanceListener {
    BlockPos getDisturbanceLocation();

    void setDisturbanceLocation(BlockPos disturbanceLocation);
}
