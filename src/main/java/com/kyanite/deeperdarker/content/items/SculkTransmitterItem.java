package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

@SuppressWarnings("NullableProblems, DataFlowIssue")
public class SculkTransmitterItem extends Item {
    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();
        BlockPos clickedPos = pContext.getClickedPos();

        if(isLinked(stack)) return transmit(level, player, stack, clickedPos);
        if(!canConnect(level, clickedPos)) {
            actionBarMessage(player, "not_transmittable", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        actionBarMessage(player, "linked", DDSounds.TRANSMITTER_LINK);
        formConnection(level, stack, clickedPos);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(isLinked(pPlayer.getMainHandItem())) transmit(pLevel, pPlayer, pPlayer.getMainHandItem(), null);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack transmitter, BlockPos clickedPos) {
        if(player.isCrouching()) {
            if(clickedPos != null && canConnect(level, clickedPos)) {
                actionBarMessage(player, "linked", DDSounds.TRANSMITTER_LINK);
                formConnection(level, transmitter, clickedPos);
                return InteractionResult.SUCCESS;
            }

            actionBarMessage(player, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            formConnection(level, transmitter, null);
            return InteractionResult.FAIL;
        }

        if (!transmitter.has(DataComponents.CUSTOM_DATA)) return InteractionResult.FAIL;
        int[] pos = transmitter.get(DataComponents.CUSTOM_DATA).copyTag().getIntArray("blockPos");
        BlockPos linkedPos = new BlockPos(pos[0], pos[1], pos[2]);

        if(!level.isLoaded(linkedPos)) {
            actionBarMessage(player, "not_found", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        if(!canConnect(level, linkedPos)) {
            actionBarMessage(player, "not_found", DDSounds.TRANSMITTER_ERROR);
            formConnection(level, transmitter, null);
            return InteractionResult.FAIL;
        }

        level.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));

        MenuProvider menu = level.getBlockState(linkedPos).getMenuProvider(level, linkedPos);
        if(menu != null) {
            player.playSound(DDSounds.TRANSMITTER_OPEN, 1, 1);
            if(player instanceof ServerPlayer serverPlayer) serverPlayer.openMenu(menu);
            if(level.getBlockEntity(linkedPos) instanceof ChestBlockEntity chest) chest.startOpen(player);
        }

        return InteractionResult.SUCCESS;
    }

    public static boolean isLinked(ItemStack stack) {
        return stack.has(DataComponents.CUSTOM_DATA) && stack.get(DataComponents.CUSTOM_DATA).copyTag().contains("blockPos");
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void formConnection(Level level, ItemStack stack, BlockPos pos) {
        CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).copyTag();
        if(pos == null) {
            tag.remove("block");
            tag.remove("blockPos");
        } else {
            tag.putString("block", level.getBlockState(pos).getBlock().getDescriptionId());
            tag.putIntArray("blockPos", List.of(pos.getX(), pos.getY(), pos.getZ()));
        }
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    public static void actionBarMessage(Player player, String key, SoundEvent sound) {
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        player.playSound(sound);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(isLinked(pStack)) {
            CompoundTag tag = pStack.get(DataComponents.CUSTOM_DATA).copyTag();
            int[] pos = tag.getIntArray("blockPos");
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(tag.getString("block"))).withStyle(ChatFormatting.GRAY));
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos[0], pos[1], pos[2]).withStyle(ChatFormatting.GRAY));
        }
        else pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}