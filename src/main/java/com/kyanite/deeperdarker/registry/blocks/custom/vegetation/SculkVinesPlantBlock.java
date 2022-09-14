package com.kyanite.deeperdarker.registry.blocks.custom.vegetation;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkVinesPlantBlock extends GrowingPlantBodyBlock {
    public static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public SculkVinesPlantBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.SCULK_VINES.get();
    }
}
