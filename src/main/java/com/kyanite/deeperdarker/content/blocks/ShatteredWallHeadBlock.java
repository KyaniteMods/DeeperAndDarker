package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.entities.blocks.DDSkullBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.jetbrains.annotations.NotNull;

public class ShatteredWallHeadBlock extends WallSkullBlock {
    public static final MapCodec<ShatteredWallHeadBlock> CODEC = simpleCodec(ShatteredWallHeadBlock::new);

    public ShatteredWallHeadBlock(Properties properties) {
        super(ShatteredHeadBlock.SHATTERED, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DDSkullBlockEntity(pos, state);
    }
}
