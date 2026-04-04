package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.blocks.Reinvokable;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackReinvokedMixin implements Reinvokable {
    @Override
    public boolean deeperdarker$isReinvoked() {
        ItemStack stack = (ItemStack) (Object) this;
        if (stack.hasTag()) {
            return stack.getTag().getBoolean("reinvoked");
        }
        return false;
    }

    @Override
    public void deeperdarker$setReinvoked(boolean value) {
        ItemStack stack = (ItemStack) (Object) this;
        stack.getOrCreateTag().putBoolean("reinvoked", value);
    }

    @Inject(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/TooltipFlag;isAdvanced()Z", ordinal = 0))
    private void deeperdarker$addReinvokedLine(@Nullable Player player, TooltipFlag tooltipFlag, CallbackInfoReturnable<List<Component>> cir, @Local(ordinal = 0) List<Component> list) {
        if (deeperdarker$isReinvoked()) {
            list.add(Component.translatable("tooltips." + DeeperDarker.MOD_ID + ".reinvoked").withStyle(ChatFormatting.AQUA));
        }
    }
}
