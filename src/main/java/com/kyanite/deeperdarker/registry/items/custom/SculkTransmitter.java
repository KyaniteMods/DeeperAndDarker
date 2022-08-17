package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class SculkTransmitter extends Item {
    public SculkTransmitter(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) != null) {
            BlockState state = pLevel.getBlockState(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) == null) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return super.use(pLevel, pPlayer, pUsedHand);
            }

            MenuProvider menu = state.getMenuProvider(pLevel, getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(menu != null) pPlayer.openMenu(menu);
            else setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().getBlockState(pContext.getClickedPos()).is(DDTags.Blocks.TRANSMITTABLE)) {
            pContext.getPlayer().displayClientMessage(Component.literal("This block cannot be transmitted!"), true);
            return InteractionResult.FAIL;
        }

        if (!pContext.getItemInHand().hasTag()) { // If the transmitter has no tag (which means no data has been added meaning no block pos)
            setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    public BlockPos getLinkedBlockPos(ItemStack stack) {
        if(!stack.hasTag()) return null;
        if(stack.getTag().contains("linked")) {
            return new BlockPos(
                    stack.getTag().getIntArray("linked")[0],
                    stack.getTag().getIntArray("linked")[1],
                    stack.getTag().getIntArray("linked")[2]
            );
        }

        return null;
    }

    public void setBlock(ItemStack itemStack, Player player, InteractionHand hand, BlockPos pos) {
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putIntArray("linked", new int[]{ pos.getX(), pos.getY(), pos.getZ() });
        player.getItemInHand(hand).setTag(tag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            if(getLinkedBlockPos(pStack) != null) {
                pTooltipComponents.add(Component.literal("§bLinked"));
            }
        } else pTooltipComponents.add(Component.literal("Not Linked"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
