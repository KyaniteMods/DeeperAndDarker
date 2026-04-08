package com.kyanite.deeperdarker.mixin;

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
    @Unique
    private static final String TAG_ITEM = "item";

    @Inject(method = "overrideStackedOnOther", at = @At("HEAD"), cancellable = true)
    private void deeperdarker$overrideShieldStackedOnOther(ItemStack shield, Slot slot, ClickAction clickAction, Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!shield.is(ConventionalItemTags.SHIELDS) || !DDUtil.isAugmented(shield)) {
            return;
        }
        if (clickAction != ClickAction.SECONDARY) {
            return;
        }
        ItemStack previousStack = getStack(shield);
        ItemStack slotStack = slot.getItem();
        if (slotStack.isEmpty()) {
            this.playRemoveOneSound(player);
            removeStack(shield).ifPresent(itemStack2 -> addAugment(shield, slot.safeInsert(itemStack2)));
        } else if (ItemStack.isSameItemSameTags(previousStack, slotStack) && slotStack.getCount() < slotStack.getMaxStackSize()) {
            slotStack.grow(1);
            removeStack(shield);
        } else if (!slotStack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            return;
        } else if (slotStack.getItem().canFitInsideContainerItems()) {
            if (previousStack.isEmpty()) {
                int j = addAugment(shield, slot.safeTake(slotStack.getCount(), 1, player));
                if (j > 0) {
                    playInsertSound(player);
                }
            } else if (slotStack.getCount() == 1) {
                removeStack(shield);
                int j = addAugment(shield, slotStack);
                if (j > 0) {
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
                this.playRemoveOneSound(player);
                slotAccess.set(itemStack);
            });
            cir.setReturnValue(true);
        } else if (stack.is(DDTags.Items.SHIELD_AUGMENT_ITEMS)) {
            ItemStack previousStack = getStack(shield);
            if (previousStack.isEmpty()) {
                int j = addAugment(shield, stack);
                stack.shrink(1);
                if (j > 0) {
                    playInsertSound(player);
                }
                cir.setReturnValue(true);
            } else if (stack.getCount() == 1) {
                removeStack(shield);
                int j = addAugment(shield, stack);
                if (j > 0) {
                    slotAccess.set(previousStack);
                    playInsertSound(player);
                }
                cir.setReturnValue(true);
            }
        }
    }

    @Unique
    private static int addAugment(ItemStack shield, ItemStack stack) {
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

    @Unique
    private static Optional<ItemStack> removeStack(ItemStack shield) {
        CompoundTag compoundTag = shield.getOrCreateTag();
        if (!compoundTag.contains(TAG_ITEM, Tag.TAG_COMPOUND)) {
            return Optional.empty();
        }

        ItemStack stack = ItemStack.of(compoundTag.getCompound(TAG_ITEM));
        shield.removeTagKey(TAG_ITEM);

        return Optional.of(stack);
    }

    @Unique
    private static Stream<ItemStack> getStackAsStream(ItemStack shield) {
        ItemStack stack = getStack(shield);
        if (stack.isEmpty()) return Stream.empty();
        return Stream.of(stack);
    }

    @Unique
    private static ItemStack getStack(ItemStack shield) {
        CompoundTag compoundTag = shield.getTag();
        if (compoundTag == null || !compoundTag.contains(TAG_ITEM, Tag.TAG_COMPOUND)) {
            return ItemStack.EMPTY;
        }
        return ItemStack.of(compoundTag.getCompound(TAG_ITEM));
    }

    @ModifyReturnValue(method = "getTooltipImage", at = @At("RETURN"))
    public Optional<TooltipComponent> getTooltipImage(Optional<TooltipComponent> original, @Local(argsOnly = true) ItemStack shield) {
        if (!shield.is(ConventionalItemTags.SHIELDS)) return original;
        NonNullList<ItemStack> nonNullList = NonNullList.create();
        nonNullList.add(getStack(shield));
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
