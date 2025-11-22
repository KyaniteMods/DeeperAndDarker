package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.datacomponents.Transmitter;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

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

        if(isLinked(stack)) return transmit(level, player, stack, clickedPos, pContext.getHand());
        if(!canConnect(level, clickedPos)) {
            actionBarMessage(level, player, "not_transmittable", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        actionBarMessage(level, player, "linked", DDSounds.TRANSMITTER_LINK);
        formConnection(level, stack, clickedPos);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(isLinked(pPlayer.getItemInHand(pUsedHand))) transmit(pLevel, pPlayer, pPlayer.getItemInHand(pUsedHand), null, pUsedHand);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack transmitter, @Nullable BlockPos clickedPos, @Nullable InteractionHand pUsedHand) {
        if(player.isCrouching()) {
            if(clickedPos != null && canConnect(level, clickedPos)) {
                actionBarMessage(level, player, "linked", DDSounds.TRANSMITTER_LINK);
                formConnection(level, transmitter, clickedPos);
                return InteractionResult.SUCCESS;
            }

            actionBarMessage(level, player, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            formConnection(level, transmitter, null);
            return InteractionResult.FAIL;
        }

        if (level.isClientSide()) return InteractionResult.sidedSuccess(false);

        if (!transmitter.has(DDDataComponents.TRANSMITTER)) return InteractionResult.FAIL;

        Transmitter transmitter1 = transmitter.get(DDDataComponents.TRANSMITTER);
        Optional<GlobalPos> globalLinkedPos = transmitter1.linkedPos();

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

    public static boolean isLinked(ItemStack stack) {
        return stack.has(DDDataComponents.TRANSMITTER) && stack.get(DDDataComponents.TRANSMITTER).linkedPos().isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void formConnection(Level level, ItemStack stack, BlockPos pos) {
        Transmitter transmitter = new Transmitter(Optional.ofNullable(pos == null ? null : GlobalPos.of(level.dimension(), pos)), level.getBlockState(pos).getBlock().getDescriptionId());
        stack.set(DDDataComponents.TRANSMITTER, transmitter);
    }

    public static void actionBarMessage(Level level, Player player, String key, SoundEvent sound) {
        if (level.isClientSide()) return;
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSoundPacket(new Holder.Direct<>(sound), SoundSource.PLAYERS, player.getX(), player.getY(), player.getZ(), 1.0f, 1.0f, level.getRandom().nextLong()));
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

    public static boolean stillValid(Player player, ServerLevel level, @Nullable BlockPos pos) {
        return player.getInventory().hasAnyMatching(stack -> {
            if (stack.isEmpty() || !(stack.getItem() instanceof SculkTransmitterItem) || !SculkTransmitterItem.isLinked(stack)) return false;
            Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
            GlobalPos globalPos = transmitter.linkedPos().get();
            String block = transmitter.savedBlock();

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
