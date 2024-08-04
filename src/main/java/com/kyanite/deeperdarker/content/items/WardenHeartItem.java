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
    public WardenHeartItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level().dimension() == OthersideDimension.OTHERSIDE_LEVEL || context.getPlayer().level().dimension() == Level.OVERWORLD) {
                BlockPos clickedPos = context.getClickedPos().relative(context.getClickedFace());

                if(DDBlocks.OTHERSIDE_PORTAL.get().spawnPortal(context.getLevel(), clickedPos)) {
                    context.getLevel().playSound(context.getPlayer(), clickedPos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 6f, 0.8f);
                    if(!context.getPlayer().isCreative()) context.getPlayer().setItemInHand(context.getHand(), ItemStack.EMPTY);
                    return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
                } else return InteractionResult.FAIL;
            }
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(DeeperDarkerConfig.wardenHeartPulses && RandomSource.create().nextFloat() < 0.012f) {
            level.playSound(entity, entity.blockPosition(), SoundEvents.WARDEN_HEARTBEAT, SoundSource.AMBIENT, 1.7f, 1f);
        }
    }
}
