package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.blocks.vegetation.IceLilyBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class LilyFlowerItem extends ItemNameBlockItem {
    public LilyFlowerItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = level.getBlockState(pos);
        if (state.is(DDBlocks.ICE_LILY.get()) && !state.getValue(IceLilyBlock.HAS_FLOWER)) {
            level.setBlock(pos, state.setValue(IceLilyBlock.HAS_FLOWER, true), 3);
            pContext.getItemInHand().shrink(1);
            level.playSound(pContext.getPlayer(), pos, SoundEvents.LILY_PAD_PLACE, SoundSource.BLOCKS);
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.useOn(pContext);
    }
}
