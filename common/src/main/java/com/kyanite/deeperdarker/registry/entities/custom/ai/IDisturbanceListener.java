package com.kyanite.deeperdarker.registry.entities.custom.ai;

import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public interface IDisturbanceListener {
    BlockPos getDisturbanceLocation();
    @Nullable
    void setDisturbanceLocation(BlockPos disturbanceLocation);
}