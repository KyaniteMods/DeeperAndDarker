package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Mixin(HangingEntityItem.class)
public abstract class HangingEntityItemMixin {
    private static final Component TOOLTIP_RANDOM_VARIANT = Component.translatable("painting.random").withStyle(ChatFormatting.GRAY);
    @Shadow
    private EntityType<? extends HangingEntity> type;

    @Inject(method = "appendHoverText", at = @At("HEAD"), cancellable = true)
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltips, TooltipFlag tooltipFlag, CallbackInfo ci) {
        HolderLookup.Provider registries = context.registries();

        if(this.type == EntityType.PAINTING && registries != null) {
            CustomData data = stack.getOrDefault(DataComponents.ENTITY_DATA, CustomData.EMPTY);
            if(data.isEmpty()) return;
            Optional<Holder<PaintingVariant>> result = data.read(registries.createSerializationContext(NbtOps.INSTANCE), Painting.VARIANT_MAP_CODEC).result();
            if(result.isEmpty()) return;
            Holder<PaintingVariant> variant = result.get();

            if(variant.is(DDTags.Misc.ANCIENT_PAINTING)) {
                tooltips.add(Component.translatable(variant.getKey().location().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW));
                tooltips.add(Component.translatable(variant.getKey().location().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY, ChatFormatting.OBFUSCATED));
                tooltips.add(Component.translatable("painting.dimensions", variant.value().width(), variant.value().height()));

                ci.cancel();
            }
        }
    }
}
