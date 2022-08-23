package com.kyanite.deeperdarker.registry.entities.custom.ai;

import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.Nullable;

public interface IDisturbanceListener {
    public abstract BlockPos getDisturbanceLocation();
    @Nullable public abstract void setDisturbanceLocation(BlockPos disturbanceLocation);
}
