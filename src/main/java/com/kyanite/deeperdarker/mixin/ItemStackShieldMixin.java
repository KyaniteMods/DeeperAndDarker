package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackShieldMixin {
    @Inject(method = "hurtAndBreak", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V"))
    private <T extends LivingEntity> void deeperdarker$onShieldBroken(int i, T livingEntity, Consumer<T> consumer, CallbackInfo ci) {
        if (!((ItemStack) (Object) this).is(ConventionalItemTags.SHIELDS)) return;
        livingEntity.level().addFreshEntity(new ItemEntity(livingEntity.level(), livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), DDUtil.getAugmentItem((ItemStack) (Object) this)));
    }
}
