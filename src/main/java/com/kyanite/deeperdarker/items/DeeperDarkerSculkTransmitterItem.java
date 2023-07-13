package com.kyanite.deeperdarker.items;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.tags.DeeperDarkerTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.ChiseledBookshelfBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DeeperDarkerSculkTransmitterItem extends Item {
    private BlockPos linkedPos;

    public DeeperDarkerSculkTransmitterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getStack().hasNbt() && context.getPlayer() != null && context.getStack().getNbt().getIntArray("blockPos") != null && context.getStack().getNbt().getIntArray("blockPos").length == 3) {
            return transmit(context.getWorld(), context.getPlayer(), context.getHand(), context.getBlockPos());
        }

        if (context.getPlayer() != null) {
            if (context.getWorld().getBlockState(context.getBlockPos()).isIn(DeeperDarkerTags.Blocks.NOT_TRANSMITTABLE) || !(context.getWorld().getBlockEntity(context.getBlockPos()) instanceof Inventory)) {
                context.getPlayer().sendMessage(Text.translatable("block." + DeeperDarker.MOD_ID + ".not_transmittable"), true);
                actionBarMessage(context.getPlayer(), "not_transmittable");
                return ActionResult.FAIL;
            }
        }

        actionBarMessage(context.getPlayer(), "linked");
        formConnection(context.getStack(), context.getBlockPos());
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.getMainHandStack().hasNbt() && player.getMainHandStack().getNbt().getIntArray("blockPos") != null && player.getMainHandStack().getNbt().getIntArray("blockPos").length == 3) {
            transmit(world, player, hand, null);
        }

        return super.use(world, player, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt()) tooltip.add(Text.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.linked", world.getBlockState(linkedPos).getBlock().getName()).formatted(Formatting.GRAY));
        else tooltip.add(Text.translatable("tooltips." + DeeperDarker.MOD_ID + ".sculk_transmitter.not_linked").formatted(Formatting.GRAY));

        super.appendTooltip(stack, world, tooltip, context);
    }

    private ActionResult transmit(World world, PlayerEntity player, Hand hand, BlockPos clickedPos) {
        int[] pos = player.getMainHandStack().getNbt().getIntArray("blockPos");
        BlockPos linkedBlockPos = new BlockPos(pos[0], pos[1], pos[2]);
        ItemStack transmitter = player.getStackInHand(hand);

        if (player.isSneaking()) {
            if (clickedPos != null && this.isTransmittable(world, clickedPos, player)) {
                actionBarMessage(player, "linked");
                formConnection(transmitter, clickedPos);
                return ActionResult.SUCCESS;
            }

            actionBarMessage(player, "unlinked");
            formConnection(transmitter, null);
            return ActionResult.FAIL;
        }

        if (!this.isTransmittable(world, linkedBlockPos, player)) {
            actionBarMessage(player, "not_found");
            formConnection(transmitter, null);
            return ActionResult.FAIL;
        }

        world.emitGameEvent(GameEvent.ENTITY_INTERACT, player.getBlockPos(), GameEvent.Emitter.of(player));

        NamedScreenHandlerFactory menu = world.getBlockState(linkedBlockPos).createScreenHandlerFactory(world, linkedBlockPos);
        if (menu != null) {
            player.openHandledScreen(menu);
            if (world.getBlockEntity(linkedBlockPos) instanceof ChestBlockEntity chestBlockEntity) chestBlockEntity.onOpen(player);
        }
        return ActionResult.SUCCESS;
    }

    private void formConnection(ItemStack stack, BlockPos pos) {
        NbtCompound nbt = new NbtCompound();
        linkedPos = pos;
        if (pos == null) {
            stack.removeSubNbt("blockPos");
            stack.removeSubNbt("linked");
            return;
        }

        nbt.putBoolean("linked", true);
        nbt.putIntArray("blockPos", List.of(pos.getX(), pos.getY(), pos.getZ()));
        stack.setNbt(nbt);
    }

    private void actionBarMessage(PlayerEntity player, String key) {
        player.sendMessage(Text.translatable("block." + DeeperDarker.MOD_ID + "." + key), true);
    }

    private boolean isTransmittable(World world, BlockPos pos, PlayerEntity player) {
        return !world.getBlockState(pos).isIn(DeeperDarkerTags.Blocks.NOT_TRANSMITTABLE) && world.getBlockEntity(pos) instanceof Inventory inventoryBlockEntity && inventoryBlockEntity.canPlayerUse(player);
    }
}
