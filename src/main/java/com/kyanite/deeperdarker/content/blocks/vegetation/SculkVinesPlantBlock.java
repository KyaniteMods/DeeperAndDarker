package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SculkVinesPlantBlock extends GrowingPlantBodyBlock {
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);
    public static final MapCodec<SculkVinesPlantBlock> CODEC = simpleCodec(SculkVinesPlantBlock::new);

    public SculkVinesPlantBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) DDBlocks.SCULK_VINES;
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}
