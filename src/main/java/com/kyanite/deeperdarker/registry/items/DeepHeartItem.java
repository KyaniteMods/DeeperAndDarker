package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.custom.OthersidePortalBlock;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
            if(pContext.getPlayer().level.dimension() == DDDimensions.OTHERSIDE_KEY || pContext.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = pContext.getClickedPos().relative(direction);
                    if(DDBlocks.OTHERSIDE_PORTAL.get().spawnPortal(pContext.getLevel(), framePos)) {
                        pContext.getLevel().playSound(pContext.getPlayer(), framePos, SoundEvents.WARDEN_SONIC_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide);
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
