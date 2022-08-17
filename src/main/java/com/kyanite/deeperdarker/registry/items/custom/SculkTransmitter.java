package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.miscellaneous.DDTags;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SculkTransmitter extends Item {
    public SculkTransmitter(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) != null) {
            if(pPlayer.isCrouching()) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return super.use(pLevel, pPlayer, pUsedHand);
            }

            if(pPlayer.totalExperience < 1) return super.use(pLevel, pPlayer, pUsedHand);
            
            BlockState state = pLevel.getBlockState(getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(state == null || getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)) == null) {
                setBlock(pPlayer.getItemInHand(pUsedHand), pPlayer, pUsedHand, null);
                return super.use(pLevel, pPlayer, pUsedHand);
            }

            pPlayer.playSound(DDSounds.SCULK_TRANSMIT.get(), 0.5f, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
            if(pLevel.isClientSide) return super.use(pLevel, pPlayer, pUsedHand);

            if(!pPlayer.isCreative()) pPlayer.giveExperiencePoints(-1);

            pLevel.gameEvent(GameEvent.ENTITY_INTERACT, pPlayer.blockPosition(), GameEvent.Context.of(pPlayer));

            MenuProvider menuProvider = state.getMenuProvider(pLevel, getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand)));
            if(menuProvider != null) {
                ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
                serverPlayer.openMenu(state.getMenuProvider(pLevel, getLinkedBlockPos(pPlayer.getItemInHand(pUsedHand))));
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().getBlockState(pContext.getClickedPos()).is(DDTags.Blocks.TRANSMITTABLE)) {
            pContext.getPlayer().displayClientMessage(Component.literal("This block cannot be transmitted!"), true);
            return InteractionResult.FAIL;
        }

        if(pContext.getItemInHand().hasTag()) {
            if(!pContext.getItemInHand().getTag().contains("linked")) {
                pContext.getPlayer().playSound(DDSounds.SCULK_LINK.get(), 0.5f, pContext.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
                setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
                return InteractionResult.SUCCESS;
            }
        } else {
            pContext.getPlayer().playSound(DDSounds.SCULK_LINK.get(), 0.5f, pContext.getLevel().getRandom().nextFloat() * 0.4F + 0.8F);
            setBlock(pContext.getItemInHand(), pContext.getPlayer(), pContext.getHand(), pContext.getClickedPos());
            return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    @Nullable
    public BlockPos getLinkedBlockPos(ItemStack itemStack) {
        if(!itemStack.hasTag()) return null;
        if(itemStack.getTag().contains("linked")) {
            return new BlockPos(
                    itemStack.getTag().getIntArray("linked")[0],
                    itemStack.getTag().getIntArray("linked")[1],
                    itemStack.getTag().getIntArray("linked")[2]
            );
        }

        return null;
    }

    public void setModelData(ItemStack itemStack, Player plr, InteractionHand hand, int data) {
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putInt("CustomModelData", data);
        plr.getItemInHand(hand).setTag(tag);
    }

    public void setBlock(ItemStack itemStack, Player player, InteractionHand hand, BlockPos pos) {
        CompoundTag tag = itemStack.getOrCreateTag();
        if(pos == null) {
            setModelData(itemStack, player, hand, 0);
            tag.remove("linked");
            player.getItemInHand(hand).setTag(tag);
            return;
        }

        tag.putIntArray("linked", new int[]{ pos.getX(), pos.getY(), pos.getZ() });
        setModelData(itemStack, player, hand, 1);

        player.getItemInHand(hand).setTag(tag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()) {
            if(getLinkedBlockPos(pStack) != null) pTooltipComponents.add(Component.literal("§bLinked"));
            else pTooltipComponents.add(Component.literal("Not Linked"));
        } else pTooltipComponents.add(Component.literal("Not Linked"));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
