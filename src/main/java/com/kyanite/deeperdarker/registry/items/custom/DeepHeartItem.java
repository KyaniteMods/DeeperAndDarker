package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.world.dimension.DDDimensions;
import com.kyanite.deeperdarker.util.DDCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class DeepHeartItem extends Item {
    public DeepHeartItem() {
        super(new Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getPlayer() != null) {
            if(pContext.getPlayer().level.dimension() == DDDimensions.OTHERSIDE_LEVEL || pContext.getPlayer().level.dimension() == Level.OVERWORLD) {
                /*
                    What's going on here?

                    clickedFace is a direction, so it's either DOWN, UP, NORTH, SOUTH, WEST, EAST
                    clickedPos is the BlockPos of the block in the direction of clickedFace

                    the if statement only results in true when clickedFace is UP in clickedPos; any other direction, it's a failed InteractionResult
                 */

                Direction clickedFace = pContext.getClickedFace();
                BlockPos clickedPos = pContext.getClickedPos().relative(clickedFace);
//                BlockPos test = clickedPos.relative(clickedFace, 1);
                System.out.println("clicked in: " + clickedPos + "\non face: " + clickedFace);

                if(DDBlocks.OTHERSIDE_PORTAL.get().spawnPortal(pContext.getLevel(), clickedPos)) {
                    System.out.println("creating portal");
                    pContext.getLevel().playSound(pContext.getPlayer(), clickedPos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 6f, 0.8f);
                    return InteractionResult.sidedSuccess(pContext.getLevel().isClientSide);
                } else return InteractionResult.FAIL;
            }
        }

        return InteractionResult.FAIL;
    }
}
