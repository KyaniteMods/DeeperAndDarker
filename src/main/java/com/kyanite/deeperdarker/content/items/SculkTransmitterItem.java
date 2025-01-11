package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDSounds;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ChunkLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.CompassItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.gameevent.GameEvent;
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
        if(isLinked(pPlayer.getItemInHand(pUsedHand))) transmit(pLevel, pPlayer, pPlayer.getItemInHand(pUsedHand), null);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static InteractionResult transmit(Level level, Player player, ItemStack transmitter, BlockPos clickedPos) {
        if(player.isCrouching()) {
            if(clickedPos != null && canConnect(level, clickedPos)) {
                actionBarMessage(player, "linked", DDSounds.TRANSMITTER_LINK);
                formConnection(level, transmitter, clickedPos);
                return InteractionResult.sidedSuccess(false);
            }

            actionBarMessage(player, "unlinked", DDSounds.TRANSMITTER_UNLINK);
            formConnection(level, transmitter, null);
            return InteractionResult.FAIL;
        }

        if (level.isClientSide()) return InteractionResult.sidedSuccess(false);

        Optional<GlobalPos> globalLinkedPos = readGlobalPosition(transmitter.getOrCreateTag());
        if (globalLinkedPos.isEmpty()) return InteractionResult.FAIL;
        ServerLevel serverLevel = level.getServer().getLevel(globalLinkedPos.get().dimension());
        BlockPos linkedPos = globalLinkedPos.get().pos();

        if(!serverLevel.isLoaded(linkedPos)) {
            ChunkPos chunkPos = new ChunkPos(linkedPos);
            serverLevel.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
        }

        if(!canConnect(serverLevel, linkedPos)) {
            actionBarMessage(player, "not_found", DDSounds.TRANSMITTER_ERROR);
            formConnection(serverLevel, transmitter, null);
            return InteractionResult.FAIL;
        }

        serverLevel.gameEvent(GameEvent.ENTITY_INTERACT, player.blockPosition(), GameEvent.Context.of(player));

        MenuProvider menu = serverLevel.getBlockState(linkedPos).getMenuProvider(serverLevel, linkedPos);
        if(menu != null && !serverLevel.isClientSide()) {
            player.playSound(DDSounds.TRANSMITTER_OPEN, 1, 1);
            if(player instanceof ServerPlayer serverPlayer) {
                serverPlayer.openMenu(menu);
                AbstractContainerMenu containerMenu = serverPlayer.containerMenu;
                containerMenu.addSlotListener(new ContainerListener() {
                    @Override
                    public void slotChanged(AbstractContainerMenu abstractContainerMenu, int i, ItemStack itemStack) {
                        if (!serverLevel.isClientSide()) {
                            ChunkPos chunkPos = new ChunkPos(linkedPos);
                            serverLevel.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
                        }
                    }

                    @Override
                    public void dataChanged(AbstractContainerMenu abstractContainerMenu, int i, int j) {
                        if (!serverLevel.isClientSide()) {
                            ChunkPos chunkPos = new ChunkPos(linkedPos);
                            serverLevel.getChunkSource().addRegionTicket(TicketType.UNKNOWN, chunkPos, 1, chunkPos);
                        }
                    }
                });
            }
            if(level.getBlockEntity(linkedPos) instanceof ChestBlockEntity chest) chest.startOpen(player);
        }

        return InteractionResult.sidedSuccess(false);
    }

    public static boolean isLinked(ItemStack stack) {
        return readGlobalPosition(stack.getOrCreateTag()).isPresent();
    }

    private static boolean canConnect(Level level, BlockPos target) {
        return level.getBlockState(target).is(DDTags.Blocks.TRANSMITTABLE);
    }

    public static void formConnection(Level level, ItemStack stack, BlockPos pos) {
        CompoundTag tag = stack.getOrCreateTag();
        if(pos == null) {
            stack.removeTagKey("block");
            removeGlobalPosition(stack.getOrCreateTag());
            return;
        }

        tag.putString("block", level.getBlockState(pos).getBlock().getDescriptionId());
        writeGlobalPosition(tag, GlobalPos.of(level.dimension(), pos));
    }

    private static Optional<ResourceKey<Level>> getDimension(CompoundTag tag) {
        if (!tag.contains("dimension")) return Optional.empty();
        return Level.RESOURCE_KEY_CODEC.parse(NbtOps.INSTANCE, tag.get("dimension")).result();
    }

    public static Optional<GlobalPos> readGlobalPosition(CompoundTag tag) {
        Optional<ResourceKey<Level>> dimension = getDimension(tag);
        if (tag.contains("block_pos") && dimension.isPresent()) {
            BlockPos blockPos = NbtUtils.readBlockPos(tag.getCompound("block_pos"));
            return Optional.of(GlobalPos.of(dimension.get(), blockPos));
        }
        return Optional.empty();
    }

    public static void writeGlobalPosition(CompoundTag tag, GlobalPos pos) {
        tag.put("block_pos", NbtUtils.writeBlockPos(pos.pos()));
        Level.RESOURCE_KEY_CODEC.encodeStart(NbtOps.INSTANCE, pos.dimension()).resultOrPartial(DeeperDarker.LOGGER::error).ifPresent(dimensionTag -> tag.put("dimension", dimensionTag));
    }

    public static void removeGlobalPosition(CompoundTag tag) {
        tag.remove("block_pos");
        tag.remove("dimension");
    }

    public static void actionBarMessage(Player player, String key, SoundEvent sound) {
        player.displayClientMessage(Component.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
        player.playSound(sound);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(isLinked(pStack)) {
            GlobalPos pos = readGlobalPosition(pStack.getOrCreateTag()).get();
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", Component.translatable(pStack.getTag().getString("block"))).withStyle(ChatFormatting.GRAY));
            pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location", pos.pos().getX(), pos.pos().getY(), pos.pos().getZ()).withStyle(ChatFormatting.GRAY));
            if (pIsAdvanced.isAdvanced()) {
                pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.location_advanced", pos.dimension().location().toString()).withStyle(ChatFormatting.DARK_GRAY));
            }
        }
        else pTooltipComponents.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
