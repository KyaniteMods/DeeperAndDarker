package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class DeepHeartItem extends Item {
    public DeepHeartItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getPlayer() != null) {
            if(pContext.getPlayer().level.dimension() == DDDimensions.OTHERSIDE_LEVEL || pContext.getPlayer().level.dimension() == Level.OVERWORLD) {
                BlockPos clickedPos = pContext.getClickedPos().relative(pContext.getClickedFace());

                if(DDBlocks.OTHERSIDE_PORTAL.get().spawnPortal(pContext.getLevel(), clickedPos)) {
                    pContext.getLevel().playSound(pContext.getPlayer(), clickedPos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 6f, 0.8f);
                    return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide);
                } else return InteractionResult.FAIL;
            }
        }

        return InteractionResult.FAIL;
    }
}
