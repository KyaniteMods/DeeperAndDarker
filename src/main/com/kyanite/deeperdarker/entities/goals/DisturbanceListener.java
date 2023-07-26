package com.kyanite.deeperdarker.entities.goals;

import net.minecraft.util.math.BlockPos;

public interface DisturbanceListener {
    BlockPos getDisturbanceLocation();

    void setDisturbanceLocation(BlockPos disturbancePos);
}
