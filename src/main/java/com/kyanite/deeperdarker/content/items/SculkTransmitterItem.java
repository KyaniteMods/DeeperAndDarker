package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDDataAttachments;
import com.kyanite.deeperdarker.content.DDDataComponents;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.content.data.Transmitter;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.registries.DeferredHolder;

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

        if(isLinked(stack)) return transmit(level, player, stack, clickedPos);
        if(!canConnect(level, clickedPos)) {
            tryConnect(null, stack, player, null, "not_transmittable", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        tryConnect(Transmitter.empty(), stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(isLinked(stack)) {
            transmit(level, player, stack, null);
            return InteractionResult.SUCCESS;
        }
        return super.use(level, player, hand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack stack, BlockPos clickedPos) {
        Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
        if(transmitter.linkedPos().isEmpty()) {
            return InteractionResult.FAIL;
        }

        if(player.isCrouching()) {
            if(clickedPos != null && canConnect(level, clickedPos)) {
                tryConnect(transmitter, stack, player, clickedPos, "linked", DDSounds.TRANSMITTER_LINK);
                return InteractionResult.SUCCESS;
            }

            tryConnect(transmitter, stack, player, null, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            return InteractionResult.FAIL;
        }

        if(level.isClientSide()) return InteractionResult.SUCCESS_SERVER;
        ServerLevel linkedLevel = player.level().getServer().getLevel(transmitter.linkedPos().get().dimension());
        BlockPos linkedPos = transmitter.linkedPos().get().pos();

        if(!canConnect(linkedLevel, linkedPos)) {
            tryConnect(transmitter, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
            return InteractionResult.FAIL;
        }

        linkedLevel.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));
        if(linkedLevel.getBlockEntity(linkedPos) instanceof MenuProvider menu) {
            player.openMenu(menu);
        } else {
            linkedLevel.getBlockState(linkedPos).useWithoutItem(linkedLevel, player, new BlockHitResult(linkedPos.getCenter(), Direction.NORTH, linkedPos, false));
        }
        player.getData(DDDataAttachments.PLAYER_DATA).usingTransmitter = true;

        return InteractionResult.SUCCESS;
    }

    public static boolean isLinked(ItemStack stack) {
        return stack.is(DDTags.Items.TRANSMITTER) && stack.has(DDDataComponents.TRANSMITTER) && stack.get(DDDataComponents.TRANSMITTER).linkedPos().isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void tryConnect(Transmitter transmitter, ItemStack stack, Player player, BlockPos pos, String key, DeferredHolder<SoundEvent, SoundEvent> sound) {
        player.sendOverlayMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key));
        player.level().playSound(null, player.blockPosition(), sound.get(), SoundSource.NEUTRAL);

        if (transmitter != null) {
            transmitter = transmitter.newConnection(player.level(), pos);
            stack.set(DDDataComponents.TRANSMITTER, transmitter);
        }
    }

    public static ItemLike getItemByColor(DyeColor color) {
        if(color == null) return DDItems.SCULK_TRANSMITTER;
        return switch(color) {
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

    public static boolean stillValid(Player player) {
        if(!player.getData(DDDataAttachments.PLAYER_DATA).usingTransmitter) return false;

        ItemStack stack = player.getOffhandItem();
        if(!SculkTransmitterItem.isLinked(stack)) {
            for(ItemStack item : player.getInventory().getNonEquipmentItems()) {
                if(SculkTransmitterItem.isLinked(item)) {
                    stack = item;
                    break;
                }
            }
        }

        if(!SculkTransmitterItem.isLinked(stack)) return false;
        if(player.level().isClientSide()) return true;

        Transmitter transmitter = stack.get(DDDataComponents.TRANSMITTER);
        if(transmitter.linkedPos().isEmpty()) return false;
        Level linkedLevel = player.level().getServer().getLevel(transmitter.linkedPos().get().dimension());
        BlockPos linkedPos = transmitter.linkedPos().get().pos();
        String blockName = transmitter.savedBlock();

        if(linkedLevel.getBlockState(linkedPos).getBlock().getDescriptionId().equals(blockName)) return true;

        SculkTransmitterItem.tryConnect(transmitter, stack, player, null, "not_found", DDSounds.TRANSMITTER_ERROR);
        return false;
    }
}
