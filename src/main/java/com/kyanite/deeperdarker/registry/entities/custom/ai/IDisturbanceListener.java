package com.kyanite.deeperdarker.registry.entities.custom.ai;

import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.Nullable;

public interface IDisturbanceListener {
    BlockPos getDisturbanceLocation();
    @Nullable void setDisturbanceLocation(BlockPos disturbanceLocation);
}
