package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.entities.blocks.DDSkullBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ShatteredHeadBlock extends SkullBlock {
    public static final Type SHATTERED = new Type(){};

    public ShatteredHeadBlock(Properties properties) {
        super(SHATTERED, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DDSkullBlockEntity(pos, state);
    }
}
