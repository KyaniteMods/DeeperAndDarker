package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public class ResonariumDamageReductionMixin {
    @ModifyArg(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V"), index = 1)
    private float deeperdarker$modifyDamage(float f, @Local(ordinal = 0, argsOnly = true) DamageSource source) {
        if(source.is(DamageTypeTags.BYPASSES_ARMOR)) return f;

        float incoming = f;
        float reduction = f / 4;

        for(ItemStack stack : ((LivingEntity)(Object) this).getArmorSlots()) {
            if(stack.getItem() instanceof ArmorItem armor && stack.is(DDTags.Items.RESONARIUM_ARMOR)) {
                incoming -= reduction;
                stack.hurtAndBreak((int) (f / 1.5f), ((LivingEntity)(Object) this), armor.getEquipmentSlot());
            }
        }

        return incoming;
    }
}
