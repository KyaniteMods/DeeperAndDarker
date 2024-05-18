package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(HangingEntityItem.class)
public abstract class HangingEntityItemMixin {
    private static final Component TOOLTIP_RANDOM_VARIANT = Component.translatable("painting.random").withStyle(ChatFormatting.GRAY);
    @Shadow
    private EntityType<? extends HangingEntity> type;

    @Inject(method = "appendHoverText", at = @At("HEAD"), cancellable = true)
    public void deeperdarker_appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag isAdvanced, CallbackInfo ci) {
        if(this.type == EntityType.PAINTING) {
            CompoundTag tag = stack.getTag();
            if(tag != null && tag.contains("EntityTag", 10)) {
                CompoundTag entityTag = tag.getCompound("EntityTag");
                if(Painting.loadVariant(entityTag).get().is(DDTags.Misc.ANCIENT_PAINTING)) {
                    Painting.loadVariant(entityTag).ifPresentOrElse((variantHolder) -> {

                        variantHolder.unwrapKey().ifPresent((variant) -> {
                            tooltips.add(Component.translatable(variant.location().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW));
                            tooltips.add(Component.translatable(variant.location().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.OBFUSCATED));
                        });
                        tooltips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(variantHolder.value().getWidth(), 16), Mth.positiveCeilDiv(variantHolder.value().getHeight(), 16)));
                    }, () -> tooltips.add(TOOLTIP_RANDOM_VARIANT));

                    ci.cancel();
                }
            } else if(isAdvanced.isCreative()) {
                tooltips.add(TOOLTIP_RANDOM_VARIANT);
            }
        }
    }
}
