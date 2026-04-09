package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.ShieldAugmentItem;
import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityShieldMixin {
    @ModifyExpressionValue(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isDamageSourceBlocked(Lnet/minecraft/world/damagesource/DamageSource;)Z"))
    private boolean shieldBlockEvent(boolean original, DamageSource source, float amount) {
        ItemStack shield = ((LivingEntity) (Object) this).getUseItem();
        if (original && DDUtil.isAugmentedShield(shield)) {
            ItemStack augmentStack = DDUtil.getAugmentItem(shield);
            if (!augmentStack.isEmpty() && augmentStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                augmentItem.onShieldDefended((LivingEntity) (Object) this, source, amount);
            }
        }
        return original;
    }
}
