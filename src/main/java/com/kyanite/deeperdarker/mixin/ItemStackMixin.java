package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract boolean is(TagKey<Item> tag);

    @Inject(method = "getTooltipLines", at = @At("RETURN"))
    public void getTooltipLines(Item.TooltipContext tooltipContext, @Nullable Player player, TooltipFlag tooltipFlag, CallbackInfoReturnable<List<Component>> cir) {
        List<Component> components = cir.getReturnValue();
        if(this.is(DDTags.Items.DAMPENS_VIBRATIONS)) components.add(Component.translatable("item." + DeeperDarker.MOD_ID + ".dampens_vibrations").withStyle(ChatFormatting.BLUE));
    }
}
