package com.kyanite.deeperdarker.content.entities.goals;

import net.minecraft.core.BlockPos;

public interface DisturbanceListener {
    BlockPos getDisturbanceLocation();

    void setDisturbanceLocation(BlockPos disturbancePos);
}
