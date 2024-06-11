package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SculkTendrilsPlantBlock extends GrowingPlantBodyBlock {
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    public static final MapCodec<SculkTendrilsPlantBlock> CODEC = simpleCodec(SculkTendrilsPlantBlock::new);

    public SculkTendrilsPlantBlock(Properties pProperties) {
        super(pProperties, Direction.UP, SHAPE, false);
    }

    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) DDBlocks.SCULK_TENDRILS;
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}
