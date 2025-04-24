package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

@SuppressWarnings("NullableProblems, DataFlowIssue")
public class SculkTransmitterItem extends Item {
    public SculkTransmitterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockPos clickedPos = context.getClickedPos();

        if(level.getBlockState(clickedPos).is(Blocks.WATER_CAULDRON)) {
            stack.remove(DataComponents.DYED_COLOR);
            return InteractionResult.SUCCESS;
        }

        if (isLinked(stack)) return transmit(level, player, stack, clickedPos);
        if (!canConnect(level, clickedPos)) {
            tryConnect(null, stack, player, null, "not_transmittable", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        tryConnect(Transmitter.empty(), stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if (isLinked(stack)) {
            transmit(level, player, stack, null);
            return InteractionResultHolder.success(stack);
        }
        return super.use(level, player, usedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack stack, BlockPos clickedPos) {
        Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
        if (transmitter.linkedPos().isEmpty()) {
            return InteractionResult.FAIL;
        }

        if (player.isCrouching()) {
            if (clickedPos != null && canConnect(level, clickedPos)) {
                tryConnect(transmitter, stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
                return InteractionResult.SUCCESS;
            }

            tryConnect(transmitter, stack, player, null, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            return InteractionResult.FAIL;
        }

        if(level.isClientSide()) return InteractionResult.sidedSuccess(true);
        ServerLevel linkedLevel = player.getServer().getLevel(transmitter.linkedPos().get().dimension());
        BlockPos linkedPos = transmitter.linkedPos().get().pos();

        if (!linkedLevel.isLoaded(linkedPos)) {
            ChunkPos chunkPos = new ChunkPos(linkedPos);
            linkedLevel.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
        }

        if (!canConnect(linkedLevel, linkedPos)) {
            tryConnect(transmitter, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        linkedLevel.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));
        MenuProvider menu = linkedLevel.getBlockState(linkedPos).getMenuProvider(linkedLevel, linkedPos);
        if (menu != null) {
            player.playNotifySound(DDSounds.TRANSMITTER_OPEN.get(), SoundSource.NEUTRAL, 1, 1);
            if (player instanceof ServerPlayer serverPlayer) serverPlayer.openMenu(menu);
            if (linkedLevel.getBlockEntity(linkedPos) instanceof Container container) container.startOpen(player);
        }

        return InteractionResult.SUCCESS;
    }

    public static boolean isLinked(ItemStack stack) {
        return stack.is(DDItems.SCULK_TRANSMITTER) && stack.has(DDDataComponents.TRANSMITTER) && stack.get(DDDataComponents.TRANSMITTER).linkedPos().isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void tryConnect(Transmitter transmitter, ItemStack stack, Player player, BlockPos pos, String key, DeferredHolder<SoundEvent, SoundEvent> sound) {
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        player.playNotifySound(sound.get(), SoundSource.NEUTRAL, 1, 1);

        if (transmitter != null) {
            transmitter = transmitter.newConnection(player.level(), pos);
            stack.set(DDDataComponents.TRANSMITTER, transmitter);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (isLinked(stack)) {
            Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
            BlockPos pos = transmitter.linkedPos().get().pos();

            tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(transmitter.savedBlock())).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos.getX(), pos.getY(), pos.getZ()).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location_level", transmitter.linkedPos().get().dimension().location().toString()).withStyle(ChatFormatting.GRAY));
        } else {
            tooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public static class Color implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int tintIndex) {
            if(stack.getItem() instanceof SculkTransmitterItem && tintIndex <= 0) {
                return DyedItemColor.getOrDefault(stack, 0x29dfeb - 0xffffff);
            }
            return -1;
        }
    }
}
