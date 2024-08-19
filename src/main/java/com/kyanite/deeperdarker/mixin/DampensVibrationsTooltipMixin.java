package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDItems;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public class DampensVibrationsTooltipMixin {
    @Inject(method = "getTooltipLines", at = @At("RETURN"))
    private void deeperdarker$addDampensVibrationsLine(@Nullable Player player, TooltipFlag tooltipFlag, CallbackInfoReturnable<List<Component>> cir, @Local(ordinal = 0) List<Component> list) {
        List<Component> components = cir.getReturnValue();
        if(((ItemStack)(Object) this).is(DDTags.Items.DAMPENS_VIBRATIONS)) {
            int index = 0;
            for(Component component : components) {
                if (component.getContents() instanceof TranslatableContents translatableContents) {
                    if (translatableContents.getKey().equals("item.durability")) break;
                    if (translatableContents.getKey().equals("itemGroup.deeperdarker")) break;
                } else {
                    if (component.getString().equals(BuiltInRegistries.ITEM.getKey(((ItemStack)(Object) this).getItem()).toString())) break;
                }
                index++;
            }
            components.add(index, Component.translatable("item." + DeeperDarker.MOD_ID + ".perks.dampens_vibrations").withStyle(ChatFormatting.BLUE));
        }
    }
}
