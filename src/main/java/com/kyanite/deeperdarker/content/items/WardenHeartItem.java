package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarkerConfig;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.world.otherside.OthersideDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

@SuppressWarnings("NullableProblems")
public class WardenHeartItem extends Item {
    public WardenHeartItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getPlayer() != null) {
            if(pContext.getPlayer().level().dimension() == OthersideDimension.OTHERSIDE_LEVEL || pContext.getPlayer().level().dimension() == Level.OVERWORLD) {
                BlockPos clickedPos = pContext.getClickedPos().relative(pContext.getClickedFace());

                if(DDBlocks.OTHERSIDE_PORTAL.get().spawnPortal(pContext.getLevel(), clickedPos)) {
                    pContext.getLevel().playSound(pContext.getPlayer(), clickedPos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 6f, 0.8f);
                    if(!pContext.getPlayer().isCreative()) pContext.getPlayer().setItemInHand(pContext.getHand(), ItemStack.EMPTY);
                    return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide);
                } else return InteractionResult.FAIL;
            }
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(DeeperDarkerConfig.wardenHeartPulses && RandomSource.create().nextFloat() < 0.012f) {
            pLevel.playSound(pEntity, pEntity.blockPosition(), SoundEvents.WARDEN_HEARTBEAT, SoundSource.AMBIENT, 1.7f, 1f);
        }
    }
}
