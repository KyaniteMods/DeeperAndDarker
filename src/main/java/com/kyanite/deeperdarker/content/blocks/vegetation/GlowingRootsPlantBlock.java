package com.kyanite.deeperdarker.content.blocks.vegetation;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class GlowingRootsPlantBlock extends GrowingPlantBodyBlock {
    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 16, 13);
    private static final MapCodec<GlowingRootsPlantBlock> CODEC = simpleCodec(GlowingRootsPlantBlock::new);

    public GlowingRootsPlantBlock(Properties pProperties) {
        super(pProperties, Direction.UP, SHAPE, false);
    }

    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) DDBlocks.GLOWING_ROOTS;
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}