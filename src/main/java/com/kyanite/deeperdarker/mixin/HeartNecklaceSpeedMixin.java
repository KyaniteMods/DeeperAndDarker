package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDItems;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnchantmentHelper.class)
public class HeartNecklaceSpeedMixin {
    @WrapOperation(method = "getSneakingSpeedBonus", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/entity/LivingEntity;)I"))
    private static int deeperdarker$heartNecklaceIncreasesSneakingSpeed(Enchantment enchantment, LivingEntity livingEntity, Operation<Integer> original) {
        return original.call(enchantment, livingEntity) + (livingEntity.getItemBySlot(EquipmentSlot.CHEST).is(DDItems.HEART_NECKLACE) ? 1 : 0);
    }
}
