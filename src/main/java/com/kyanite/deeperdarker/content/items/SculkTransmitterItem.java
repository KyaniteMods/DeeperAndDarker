package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
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

        if (isLinked(stack)) return transmit(level, player, stack, clickedPos);
        if (!canConnect(level, clickedPos)) {
            tryConnect(null, stack, player, null, "not_transmittable", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        tryConnect(Transmitter.empty(), stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (isLinked(pPlayer.getItemInHand(pUsedHand))) transmit(pLevel, pPlayer, pPlayer.getItemInHand(pUsedHand), null);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack stack, BlockPos clickedPos) {
        Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
        if (transmitter.linkedPos().isEmpty()) return InteractionResult.FAIL;
        BlockPos linkedPos = transmitter.linkedPos().get().pos();

        if (player.isCrouching()) {
            if (clickedPos != null && canConnect(level, clickedPos)) {
                tryConnect(transmitter, stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
                return InteractionResult.SUCCESS;
            }

            tryConnect(transmitter, stack, player, null, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            return InteractionResult.FAIL;
        }

        if (!level.isLoaded(linkedPos)) {
            tryConnect(null, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        if (!canConnect(level, linkedPos)) {
            tryConnect(transmitter, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        level.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));
        MenuProvider menu = level.getBlockState(linkedPos).getMenuProvider(level, linkedPos);
        if (menu != null) {
            player.playSound(DDSounds.TRANSMITTER_OPEN, 1, 1);
            if (player instanceof ServerPlayer serverPlayer) serverPlayer.openMenu(menu);
            if (level.getBlockEntity(linkedPos) instanceof ChestBlockEntity chest) chest.startOpen(player);
        }

        return InteractionResult.SUCCESS;
    }

    public static boolean isLinked(ItemStack stack) {
        return stack.is(DDItems.SCULK_TRANSMITTER) && stack.has(DDDataComponents.TRANSMITTER) && stack.get(DDDataComponents.TRANSMITTER).linkedPos().isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void tryConnect(Transmitter transmitter, ItemStack stack, Player player, BlockPos pos, String key, SoundEvent sound) {
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        player.playSound(sound);
        if (transmitter != null) {
            transmitter = transmitter.newConnection(player.level(), pos);
            stack.set(DDDataComponents.TRANSMITTER, transmitter);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (isLinked(pStack)) {
            Transmitter transmitter = pStack.get(DDDataComponents.TRANSMITTER);
            BlockPos pos = transmitter.linkedPos().get().pos();
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(transmitter.savedBlock())).withStyle(ChatFormatting.GRAY));
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos.getX(), pos.getY(), pos.getZ()).withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
