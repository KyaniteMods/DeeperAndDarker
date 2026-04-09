package com.kyanite.deeperdarker.mixin;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.items.ShieldAugmentItem;
import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;

@Mixin(ItemStack.class)
public class ShieldAttributeModifierMixin {
//    @ModifyReturnValue(method = "getAttributeModifiers", at = @At("RETURN"))
//    private Multimap<Attribute, AttributeModifier> deeperdarker$applyShieldAugmentAttributeModifiers(Multimap<Attribute, AttributeModifier> original, @Local(argsOnly = true) EquipmentSlot slot) {
//        ItemStack stack = ((ItemStack) (Object) this);
//        if (DDUtil.isAugmentedShield(stack)) {
//            ItemStack augmentStack = DDUtil.getAugmentItem(stack);
//            if (augmentStack.getItem() instanceof ShieldAugmentItem augmentItem) {
//                Optional<Multimap<Attribute, AttributeModifier>> modifiers = augmentItem.getAugmentAttributeModifiers(slot, ((LivingEntity) (Object) this).isUsingItem());
//                if (modifiers.isPresent()) {
//                    Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
//                    multimap.putAll(original);
//                    multimap.putAll(modifiers.get());
//                    return multimap;
//                }
//            }
//        }
//        return original;
//    }
}
