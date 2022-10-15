package com.kyanite.deeperdarker.miscellaneous;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;

public class DDUtils {
    public static int secondsToTicks(float seconds) {
        return (int) (20 * seconds);
    }
    public static BlockPos getNearestStructure(BlockPos pos, ServerLevel level) {
        return level.findNearestMapStructure(DDTags.Others.ALL_STRUCTURES, pos, 150, false);
    }
}