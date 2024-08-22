package com.kyanite.deeperdarker.content.blocks;

import com.kyanite.deeperdarker.content.entities.blocks.DDSkullBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.jetbrains.annotations.NotNull;

public class ShatteredHeadBlock extends SkullBlock {
    public static final MapCodec<ShatteredHeadBlock> CODEC = simpleCodec(ShatteredHeadBlock::new);
    public static final Type SHATTERED = new Type() {
        {
            TYPES.put("shattered", SHATTERED);
        }

        @Override
        public @NotNull String getSerializedName() {
            return "shattered";
        }
    };
    public static final NoteBlockInstrument INSTRUMENT = NoteBlockInstrument.valueOf("DEEPERDARKER_SHATTERED");

    public ShatteredHeadBlock(Properties properties) {
        super(SHATTERED, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DDSkullBlockEntity(pos, state);
    }
}
