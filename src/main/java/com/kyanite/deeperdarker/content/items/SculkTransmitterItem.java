package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.items.components.DDDataComponents;
import com.kyanite.deeperdarker.content.items.components.TransmitterData;
import com.kyanite.deeperdarker.network.LinkTransmitterPayload;
import com.kyanite.deeperdarker.network.UnlinkTransmitterPayload;
import com.kyanite.deeperdarker.util.DDTags;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@SuppressWarnings("NullableProblems, DataFlowIssue")
public class SculkTransmitterItem extends Item {
    public static final Map<ItemStack, Pair<CooldownType, Long>> COOLDOWNS = new HashMap<>();

    public enum CooldownType {
        LINK,
        UNLINK
    }

    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        ItemStack stack = pContext.getItemInHand();
        BlockPos clickedPos = pContext.getClickedPos();

        return transmit(level, player, stack, clickedPos, pContext.getHand());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(isLinked(pPlayer.getItemInHand(pUsedHand))) transmit(pLevel, pPlayer, pPlayer.getItemInHand(pUsedHand), null, pUsedHand);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack transmitter, @Nullable BlockPos clickedPos, @Nullable InteractionHand pUsedHand) {
        if(player.isCrouching()) {
            return handleLink(level, player, transmitter, clickedPos, pUsedHand);
        }

        if (level.isClientSide()) return InteractionResult.sidedSuccess(false);

        TransmitterData data = transmitter.get(DDDataComponents.TRANSMITTER_DATA);
        if (data == null) return InteractionResult.FAIL;

        Optional<GlobalPos> globalLinkedPos = data.linkedPos();

        if (globalLinkedPos.isEmpty()) return InteractionResult.FAIL;
        ServerLevel serverLevel = level.getServer().getLevel(globalLinkedPos.get().dimension());
        BlockPos linkedPos = globalLinkedPos.get().pos();

        if(!serverLevel.isLoaded(linkedPos)) {
            ChunkPos chunkPos = new ChunkPos(linkedPos);
            serverLevel.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
        }

        if(!canConnect(serverLevel, linkedPos)) {
            actionBarMessage(level, player, "not_found", DDSounds.TRANSMITTER_ERROR);
            formConnection(serverLevel, transmitter, null);
            return InteractionResult.FAIL;
        }

        serverLevel.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));

        serverLevel.getBlockState(linkedPos).useWithoutItem(serverLevel, player, new BlockHitResult(linkedPos.getCenter(), Direction.SOUTH, linkedPos, false));
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSoundPacket(new Holder.Direct<>(DDSounds.TRANSMITTER_OPEN), SoundSource.PLAYERS, player.getX(), player.getY(), player.getZ(), 1.0f, 1.0f, level.getRandom().nextLong()));
        }

        return InteractionResult.sidedSuccess(false);
    }

    protected static InteractionResult handleLink(Level level, Player player, ItemStack transmitter, @Nullable BlockPos clickedPos, @Nullable InteractionHand pUsedHand) {
        boolean connect = clickedPos != null && canConnect(level, clickedPos);

        if (!level.isClientSide()) return connect ? InteractionResult.SUCCESS : InteractionResult.FAIL;

        if (!isLinked(transmitter) && clickedPos != null && !canConnect(level, clickedPos)) {
            player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + ".not_transmittable"), true);
            player.playSound(DDSounds.TRANSMITTER_ERROR, 1.0f, 1.0f);
            return InteractionResult.FAIL;
        }

        int slot = getSlot(player, transmitter);
        int seconds = DeeperDarker.CONFIG.client.sculkTransmitterLinkCooldownSeconds();

        if (connect) {
            if (!isLinked(transmitter) || checkCooldown(transmitter, CooldownType.LINK, seconds)) {
                ClientPlayNetworking.send(new LinkTransmitterPayload(slot, clickedPos));
                COOLDOWNS.remove(transmitter);
            } else {
                player.displayClientMessage(Component.translatable(DDItems.SCULK_TRANSMITTER.getDescriptionId() + ".link_confirm", Minecraft.getInstance().options.keyUse.getTranslatedKeyMessage()), true);
                COOLDOWNS.put(transmitter, Pair.of(CooldownType.LINK, System.nanoTime()));
            }
            return InteractionResult.SUCCESS;
        }

        if (checkCooldown(transmitter, CooldownType.UNLINK, seconds)) {
            ClientPlayNetworking.send(new UnlinkTransmitterPayload(slot));
            COOLDOWNS.remove(transmitter);
        } else {
            player.displayClientMessage(Component.translatable(DDItems.SCULK_TRANSMITTER.getDescriptionId() + ".unlink_confirm", Minecraft.getInstance().options.keyUse.getTranslatedKeyMessage()), true);
            COOLDOWNS.put(transmitter, Pair.of(CooldownType.UNLINK, System.nanoTime()));
        }

        return InteractionResult.FAIL;
    }

    private static boolean checkCooldown(ItemStack stack, CooldownType cooldownType, int maxSeconds) {
        if (maxSeconds == 0) return true;
        if (!COOLDOWNS.containsKey(stack)) return false;
        Pair<CooldownType, Long> pair = COOLDOWNS.get(stack);
        return pair.getFirst() == cooldownType && System.nanoTime() - pair.getSecond() < maxSeconds * 1_000_000_000L;
    }

    private static int getSlot(Player player, ItemStack stack) {
        if (player.getOffhandItem() == stack) return player.getInventory().items.size() + player.getInventory().armor.size();
        for (int i = 0; i < player.getInventory().items.size(); i++) {
            if (player.getInventory().items.get(i) == stack) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isLinked(ItemStack stack) {
        return stack.has(DDDataComponents.TRANSMITTER_DATA) && stack.get(DDDataComponents.TRANSMITTER_DATA).linkedPos().isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void formConnection(Level level, ItemStack stack, BlockPos pos) {
        if(pos == null) {
            stack.remove(DDDataComponents.TRANSMITTER_DATA);
            return;
        }

        stack.set(DDDataComponents.TRANSMITTER_DATA, new TransmitterData(Optional.of(new GlobalPos(level.dimension(), pos)), level.getBlockState(pos).getBlock().getDescriptionId()));
    }

    public static void actionBarMessage(Level level, Player player, String key, SoundEvent sound) {
        if (level.isClientSide()) return;
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        if (player instanceof ServerPlayer serverPlayer && sound != null) {
            serverPlayer.connection.send(new ClientboundSoundPacket(new Holder.Direct<>(sound), SoundSource.PLAYERS, player.getX(), player.getY(), player.getZ(), 1.0f, 1.0f, level.getRandom().nextLong()));
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext context, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(isLinked(pStack)) {
            TransmitterData data = pStack.get(DDDataComponents.TRANSMITTER_DATA);
            GlobalPos pos = data.linkedPos().get();
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(data.savedBlock())).withStyle(ChatFormatting.GRAY));
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos.pos().getX(), pos.pos().getY(), pos.pos().getZ()).withStyle(ChatFormatting.GRAY));
            if (pIsAdvanced.isAdvanced()) {
                pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location_advanced", pos.dimension().location().toString()).withStyle(ChatFormatting.DARK_GRAY));
            }
        }
        else pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(pStack, context, pTooltipComponents, pIsAdvanced);
    }

    public static boolean stillValid(Player player, ServerLevel level, @Nullable BlockPos pos) {
        return player.getInventory().hasAnyMatching(stack -> {
            if (stack.isEmpty() || !(stack.getItem() instanceof SculkTransmitterItem) || !SculkTransmitterItem.isLinked(stack)) return false;
            TransmitterData data = stack.get(DDDataComponents.TRANSMITTER_DATA);
            String block = data.savedBlock();
            GlobalPos globalPos = data.linkedPos().get();

            // position needs to be checked roughly due to double chests and other large containers, but is still checked for security.
            // pos is null for anvils and smithing tables for technical reasons, we can't check that
            if (level.dimension().equals(globalPos.dimension()) && (pos == null || globalPos.pos().distSqr(pos) < 64.0) && level.getBlockState(globalPos.pos()).getBlock().getDescriptionId().equals(block)) {
                ChunkPos chunkPos = new ChunkPos(globalPos.pos());
                level.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
                return true;
            }
            return false;
        });
    }

    public static boolean stillValid(final Player player, ContainerLevelAccess containerLevelAccess) {
        return containerLevelAccess.evaluate((level, pos) -> {
            if (!(level instanceof ServerLevel serverLevel)) return false;
            return stillValid(player, serverLevel, pos);
        }, true);
    }

    // TODO turn into map
    public static Item fromColor(DyeColor color) {
        return switch (color) {
            case WHITE -> DDItems.WHITE_SCULK_TRANSMITTER;
            case ORANGE -> DDItems.ORANGE_SCULK_TRANSMITTER;
            case MAGENTA -> DDItems.MAGENTA_SCULK_TRANSMITTER;
            case LIGHT_BLUE -> DDItems.LIGHT_BLUE_SCULK_TRANSMITTER;
            case YELLOW -> DDItems.YELLOW_SCULK_TRANSMITTER;
            case LIME -> DDItems.LIME_SCULK_TRANSMITTER;
            case PINK -> DDItems.PINK_SCULK_TRANSMITTER;
            case GRAY -> DDItems.GRAY_SCULK_TRANSMITTER;
            case LIGHT_GRAY -> DDItems.LIGHT_GRAY_SCULK_TRANSMITTER;
            case CYAN -> DDItems.CYAN_SCULK_TRANSMITTER;
            case PURPLE -> DDItems.PURPLE_SCULK_TRANSMITTER;
            case BLUE -> DDItems.BLUE_SCULK_TRANSMITTER;
            case BROWN -> DDItems.BROWN_SCULK_TRANSMITTER;
            case GREEN -> DDItems.GREEN_SCULK_TRANSMITTER;
            case RED -> DDItems.RED_SCULK_TRANSMITTER;
            case BLACK -> DDItems.BLACK_SCULK_TRANSMITTER;
        };
    }
}
