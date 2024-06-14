package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
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
            CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
            if(!tag.isEmpty() && tag.contains("EntityTag", 10)) {
                CompoundTag entityTag = tag.getCompound("EntityTag");
                Holder<PaintingVariant> paintingVariant = loadVariant(entityTag);
                if(paintingVariant.is(DDTags.Misc.ANCIENT_PAINTING)) {
                    tooltips.add(Component.translatable(paintingVariant.unwrapKey().get().location().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW));
                    tooltips.add(Component.translatable(paintingVariant.unwrapKey().get().location().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.OBFUSCATED));
                    tooltips.add(Component.translatable("painting.dimensions", Mth.positiveCeilDiv(paintingVariant.value().getWidth(), 16), Mth.positiveCeilDiv(paintingVariant.value().getHeight(), 16)));

                    ci.cancel();
                }
            } else if(isAdvanced.isCreative()) {
                tooltips.add(TOOLTIP_RANDOM_VARIANT);
            }
        }
    }

    private Holder<PaintingVariant> loadVariant(CompoundTag tag) {
        return Painting.VARIANT_CODEC.decode(NbtOps.INSTANCE, tag).getOrThrow().getFirst();
    }
}
