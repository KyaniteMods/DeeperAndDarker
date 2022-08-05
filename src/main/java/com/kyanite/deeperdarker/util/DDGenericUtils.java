package com.kyanite.deeperdarker.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DDGenericUtils {
    public static boolean isBlockBeside(BlockGetter level, Block targetBlock, BlockPos origin) {
        if(level.getBlockState(origin.north()).is(targetBlock) ||
                level.getBlockState(origin.east()).is(targetBlock) ||
                level.getBlockState(origin.south()).is(targetBlock) ||
                level.getBlockState(origin.west()).is(targetBlock))
            return true;

        return false;
    }

    public static boolean noSpace(BlockGetter getter, BlockPos origin, int distance) {
        for(int i = 0; i < distance; i++) {
            if(!getter.getBlockState(origin.above(i)).is(Blocks.AIR)) {
                return true;
            }
        }

        return false;
    }
}
