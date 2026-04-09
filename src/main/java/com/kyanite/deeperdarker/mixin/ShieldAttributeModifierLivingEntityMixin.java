package com.kyanite.deeperdarker.mixin;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.content.items.ShieldAugmentItem;
import com.kyanite.deeperdarker.util.DDUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class ShieldAttributeModifierLivingEntityMixin {
//    @Unique
//    private boolean wasBlocking;

//    @ModifyReturnValue(method = "equipmentHasChanged", at = @At("RETURN"))
//    private boolean deeperdarker$updateShieldDefending(boolean original, @Local(argsOnly = true, ordinal = 0) ItemStack first, @Local(argsOnly = true, ordinal = 1) ItemStack second) {
//        boolean isBlocking = ((LivingEntity) (Object) this).isBlocking();
//        boolean wasBlocking = this.wasBlocking;
//        this.wasBlocking = isBlocking;
//        if (original) {
//            this.wasBlocking = false;
//            return original;
//        }
//        return isBlocking != wasBlocking && DDUtil.isAugmentedShield(first) && !DDUtil.getAugmentItem(first).isEmpty();
//    }

    @Shadow
    protected abstract ItemStack getLastHandItem(EquipmentSlot equipmentSlot);

    @Shadow
    public abstract boolean equipmentHasChanged(ItemStack itemStack, ItemStack itemStack2);

    @Unique
    private boolean wasBlocking = false;

    @Inject(method = "detectEquipmentUpdates", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;collectEquipmentChanges()Ljava/util/Map;"))
    private void deeperdarker$applyShieldUpdates(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!(entity instanceof Player)) return;
        boolean isBlocking = entity.isBlocking();
        for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}) {
            ItemStack lastStack = getLastHandItem(slot);
            ItemStack currentStack = entity.getItemBySlot(slot);
            if (isBlocking != wasBlocking || equipmentHasChanged(lastStack, currentStack)) {
                if (!lastStack.isEmpty()) {
                    entity.getAttributes().removeAttributeModifiers(getShieldAugmentAttributeModifiers(lastStack, slot, wasBlocking));
                }
                if (!currentStack.isEmpty()) {
                    entity.getAttributes().addTransientAttributeModifiers(getShieldAugmentAttributeModifiers(currentStack, slot, isBlocking));
                }
            }
        }
        wasBlocking = isBlocking;
    }

    @Unique
    private Multimap<Attribute, AttributeModifier> getShieldAugmentAttributeModifiers(ItemStack instance, EquipmentSlot slot, boolean isBlocking) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (DDUtil.isAugmentedShield(instance)) {
            ItemStack augmentStack = DDUtil.getAugmentItem(instance);
            if (augmentStack.getItem() instanceof ShieldAugmentItem augmentItem) {
                Optional<Multimap<Attribute, AttributeModifier>> modifiers = augmentItem.getAugmentAttributeModifiers(slot, isBlocking);
                if (modifiers.isPresent()) {
                    return modifiers.get();
                }
            }
        }
        return multimap;
    }
}
