package com.kyanite.deeperdarker.registries.blocks.vegetation;

import com.kyanite.deeperdarker.registries.DDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SculkTendrilsPlantBlock extends GrowingPlantBodyBlock {
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public SculkTendrilsPlantBlock(Properties pProperties) {
        super(pProperties, Direction.UP, SHAPE, false);
    }

    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.SCULK_TENDRILS.get();
    }
}
