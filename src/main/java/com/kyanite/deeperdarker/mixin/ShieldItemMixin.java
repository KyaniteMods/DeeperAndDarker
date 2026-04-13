package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.ShieldAugmentItem;
import com.kyanite.deeperdarker.util.DDTags;
import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.stream.Stream;

@Mixin(value = Item.class, priority = 500)
public abstract class ShieldItemMixin {
    @Inject(method = "overrideStackedOnOther", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$overrideShieldStackedOnOther(ItemStack shield, Slot slot, ClickAction clickAction, Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!shield.is(ConventionalItemTags.SHIELDS) || !DDUtil.isAugmented(shield)) {
            return;
        }
        if (clickAction != ClickAction.SECONDARY) {
            return;
        }
        ItemStack previousStack = DDUtil.getAugmentItem(shield);
        ItemStack slotStack = slot.getItem();
        if (slotStack.isEmpty()) {
            this.playRemoveOneSound(player);
            removeStack(shield).ifPresent(itemStack2 -> {
                if (itemStack2.getItem() instanceof ShieldAugmentItem augmentItem) {
                    augmentItem.onAugmentRemoved(shield, slot, player);
                }
                addAugment(shield, slot.safeInsert(itemStack2));
            });
        } else if (ItemStack.isSameItemSameTags(previousStack, slotStack) && slotStack.getCount() < slotStack.getMaxStackSize()) {
            slotStack.grow(1);
            removeStack(shield).ifPresent(itemStack2 -> {
                if (itemStack2.getItem() instanceof ShieldAugmentItem augmentItem) {
                    augmentItem.onAugmentRemoved(shield, slot, player);
                }
            });
        } else if (!slotStack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            return;
        } else if (slotStack.getItem().canFitInsideContainerItems()) {
            if (previousStack.isEmpty()) {
                ItemStack addedStack = slot.safeTake(slotStack.getCount(), 1, player);
                boolean added = addAugment(shield, addedStack);
                if (added) {
                    if (addedStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentAdded(shield, previousStack, slot, player);
                    }
                    playInsertSound(player);
                }
            } else if (slotStack.getCount() == 1) {
                removeStack(shield).ifPresent(itemStack -> {
                    if (itemStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentRemoved(shield, slot, player);
                    }
                });
                boolean added = addAugment(shield, slotStack);
                if (added) {
                    if (slotStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentAdded(shield, previousStack, slot, player);
                    }
                    slot.setByPlayer(previousStack);
                    playInsertSound(player);
                }
            }
        }
        cir.setReturnValue(true);
    }

    @Inject(method = "overrideOtherStackedOnMe", at = @At("HEAD"), cancellable = true)
    public void deeperdarker$overrideOtherStackedOnShield(ItemStack shield, ItemStack stack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess, CallbackInfoReturnable<Boolean> cir) {
        if (!shield.is(ConventionalItemTags.SHIELDS) || !DDUtil.isAugmented(shield)) {
            return;
        }
        if (clickAction != ClickAction.SECONDARY || !slot.allowModification(player)) {
            return;
        }
        if (stack.isEmpty()) {
            removeStack(shield).ifPresent(itemStack -> {
                if (itemStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                    augmentItem.onAugmentRemoved(shield, slot, player);
                }
                this.playRemoveOneSound(player);
                slotAccess.set(itemStack);
            });
            cir.setReturnValue(true);
        } else if (stack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            ItemStack previousStack = DDUtil.getAugmentItem(shield);
            if (previousStack.isEmpty()) {
                boolean added = addAugment(shield, stack);
                if (added) {
                    if (stack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentAdded(shield, previousStack, slot, player);
                    }
                    stack.shrink(1);
                    playInsertSound(player);
                }
                cir.setReturnValue(true);
            } else if (stack.getCount() == 1) {
                removeStack(shield).ifPresent(itemStack -> {
                    if (itemStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentRemoved(shield, slot, player);
                    }
                });
                boolean added = addAugment(shield, stack);
                if (added) {
                    if (stack.getItem() instanceof ShieldAugmentItem augmentItem) {
                        augmentItem.onAugmentAdded(shield, previousStack, slot, player);
                    }
                    slotAccess.set(previousStack);
                    playInsertSound(player);
                }
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void deeperdarker$tickShieldAugment(ItemStack stack, Level level, Entity entity, int index, boolean selected, CallbackInfo ci) {
        if (DDUtil.isAugmentedShield(stack)) {
            ItemStack augmentStack = DDUtil.getAugmentItem(stack);
            if (augmentStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                augmentItem.augmentTick(stack, level, entity, index, selected);
            }
        }
    }

    @Unique
    private static boolean addAugment(ItemStack shield, ItemStack stack) {
        if (stack.isEmpty() || !stack.getItem().canFitInsideContainerItems() || !stack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            return false;
        }
        CompoundTag compoundTag = shield.getOrCreateTag();
        if (compoundTag.contains(DDUtil.ITEM_TAG, Tag.TAG_COMPOUND)) {
            return false;
        }

        ItemStack itemStack4 = stack.copyWithCount(1);
        CompoundTag itemTag = new CompoundTag();
        itemStack4.save(itemTag);
        compoundTag.put(DDUtil.ITEM_TAG, itemTag);

        return true;
    }

    @Unique
    private static Optional<ItemStack> removeStack(ItemStack shield) {
        CompoundTag compoundTag = shield.getOrCreateTag();
        if (!compoundTag.contains(DDUtil.ITEM_TAG, Tag.TAG_COMPOUND)) {
            return Optional.empty();
        }

        ItemStack stack = ItemStack.of(compoundTag.getCompound(DDUtil.ITEM_TAG));
        shield.removeTagKey(DDUtil.ITEM_TAG);

        return Optional.of(stack);
    }

    @Unique
    private static Stream<ItemStack> getStackAsStream(ItemStack shield) {
        ItemStack stack = DDUtil.getAugmentItem(shield);
        if (stack.isEmpty()) return Stream.empty();
        return Stream.of(stack);
    }

    @ModifyReturnValue(method = "getTooltipImage", at = @At("RETURN"))
    public Optional<TooltipComponent> getTooltipImage(Optional<TooltipComponent> original, @Local(argsOnly = true) ItemStack shield) {
        if (!DDUtil.isAugmentedShield(shield)) return original;
        NonNullList<ItemStack> nonNullList = NonNullList.create();
        nonNullList.add(DDUtil.getAugmentItem(shield));
        return Optional.of(new BundleTooltip(nonNullList, 64));
    }

    @Inject(method = "onDestroyed", at = @At("HEAD"))
    public void deeperdarker$onShieldDestroyed(ItemEntity itemEntity, CallbackInfo ci) {
        if (!itemEntity.getItem().is(ConventionalItemTags.SHIELDS)) return;
        ItemUtils.onContainerDestroyed(itemEntity, getStackAsStream(itemEntity.getItem()));
    }

    @Unique
    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }

    @Unique
    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }
}
