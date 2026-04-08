package com.kyanite.deeperdarker.content.items;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.*;

import java.util.Optional;
import java.util.stream.Stream;

public class AugmentedShieldItem extends ShieldItem {
    public static final String TAG_ITEM = "item";

    public AugmentedShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack itemStack, Slot slot, ClickAction clickAction, Player player) {
        if (clickAction != ClickAction.SECONDARY) {
            return false;
        }
        ItemStack previousStack = getStack(itemStack);
        ItemStack slotStack = slot.getItem();
        if (slotStack.isEmpty()) {
            this.playRemoveOneSound(player);
            removeStack(itemStack).ifPresent(itemStack2 -> add(itemStack, slot.safeInsert(itemStack2)));
        } else if (ItemStack.isSameItemSameTags(previousStack, slotStack) && slotStack.getCount() < slotStack.getMaxStackSize()) {
            slotStack.grow(1);
            removeStack(itemStack);
        } else if (!slotStack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            return false;
        } else if (slotStack.getItem().canFitInsideContainerItems()) {
            if (previousStack.isEmpty()) {
                int j = add(itemStack, slot.safeTake(slotStack.getCount(), 1, player));
                if (j > 0) {
                    playInsertSound(player);
                }
            } else if (slotStack.getCount() == 1) {
                removeStack(itemStack);
                int j = add(itemStack, slotStack);
                if (j > 0) {
                    slot.setByPlayer(previousStack);
                    playInsertSound(player);
                }
            }
        }
        return true;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack shield, ItemStack stack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        if (clickAction != ClickAction.SECONDARY || !slot.allowModification(player)) {
            return false;
        }
        if (stack.isEmpty()) {
            removeStack(shield).ifPresent(itemStack -> {
                this.playRemoveOneSound(player);
                slotAccess.set(itemStack);
            });
            return true;
        } else {
            ItemStack previousStack = getStack(shield);
            if (previousStack.isEmpty()) {
                int j = add(shield, stack);
                stack.shrink(1);
                if (j > 0) {
                    playInsertSound(player);
                }
                return true;
            } else if (stack.getCount() == 1) {
                removeStack(shield);
                int j = add(shield, stack);
                if (j > 0) {
                    slotAccess.set(previousStack);
                    playInsertSound(player);
                }
                return true;
            }
        }
        return false;
    }

    private static int add(ItemStack shield, ItemStack stack) {
        if (stack.isEmpty() || !stack.getItem().canFitInsideContainerItems() || !stack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            return 0;
        }
        CompoundTag compoundTag = shield.getOrCreateTag();
        if (compoundTag.contains(TAG_ITEM, Tag.TAG_COMPOUND)) {
            return 0;
        }

        ItemStack itemStack4 = stack.copyWithCount(1);
        CompoundTag itemTag = new CompoundTag();
        itemStack4.save(itemTag);
        compoundTag.put(TAG_ITEM, itemTag);

        return 1;
    }

    private static Optional<ItemStack> removeStack(ItemStack shield) {
        CompoundTag compoundTag = shield.getOrCreateTag();
        if (!compoundTag.contains(TAG_ITEM, Tag.TAG_COMPOUND)) {
            return Optional.empty();
        }

        ItemStack stack = ItemStack.of(compoundTag.getCompound(TAG_ITEM));
        shield.removeTagKey(TAG_ITEM);

        return Optional.of(stack);
    }

    private static Stream<ItemStack> getStackAsStream(ItemStack shield) {
        ItemStack stack = getStack(shield);
        if (stack.isEmpty()) return Stream.empty();
        return Stream.of(stack);
    }

    private static ItemStack getStack(ItemStack shield) {
        CompoundTag compoundTag = shield.getTag();
        if (compoundTag == null || !compoundTag.contains(TAG_ITEM, Tag.TAG_COMPOUND)) {
            return ItemStack.EMPTY;
        }
        return ItemStack.of(compoundTag.getCompound(TAG_ITEM));
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack shield) {
        NonNullList<ItemStack> nonNullList = NonNullList.create();
        nonNullList.add(getStack(shield));
        return Optional.of(new BundleTooltip(nonNullList, 64));
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        ItemUtils.onContainerDestroyed(itemEntity, getStackAsStream(itemEntity.getItem()));
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }
}
