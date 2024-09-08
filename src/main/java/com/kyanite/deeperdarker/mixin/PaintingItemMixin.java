package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(HangingEntityItem.class)
public class PaintingItemMixin {
    @Unique
    private static TooltipFlag storedTooltipFlag;
    @Unique
    private static Holder storedHolder;

    @Inject(method = "appendHoverText", at = @At("HEAD"))
    private void deeperdarker$storeTooltipFlag(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag, CallbackInfo ci) {
        storedTooltipFlag = tooltipFlag;
    }

    @Inject(method = "method_48960", at = @At("HEAD"))
    private static void deeperdarker$storeHolder(List list, Holder holder, CallbackInfo ci) {
        storedHolder = holder;
    }

    @WrapOperation(method = "method_48959", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/MutableComponent;withStyle(Lnet/minecraft/ChatFormatting;)Lnet/minecraft/network/chat/MutableComponent;", ordinal = 1))
    private static MutableComponent deeperdarker$obfuscateAncientPaintingName(MutableComponent instance, ChatFormatting chatFormatting, Operation<MutableComponent> original) {
        MutableComponent component = original.call(instance, chatFormatting);
        if (storedHolder != null && storedHolder.is(DDTags.Paintings.ANCIENT) && storedTooltipFlag != null && !storedTooltipFlag.isCreative()) {
            component.withStyle(ChatFormatting.OBFUSCATED);
            storedTooltipFlag = null;
        }
        return component;
    }

    @WrapOperation(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V"))
    private void deeperdarker$decrementStackOnServer(ItemStack instance, int i, Operation<Void> original, @Local(ordinal = 0) Level level) {
        if (!level.isClientSide() || !DeeperDarker.CONFIG.client.paintingFix()) {
            original.call(instance, i);
        }
    }
}
