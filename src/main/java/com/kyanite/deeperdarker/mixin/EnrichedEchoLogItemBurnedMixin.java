package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class EnrichedEchoLogItemBurnedMixin {
    @Shadow public abstract ItemStack getItem();

    @Inject(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;onDestroyed(Lnet/minecraft/world/entity/item/ItemEntity;)V"))
    private void deeperdarker$dropKyanitePasteWhenEchoLogItemBurns(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource.is(DamageTypeTags.IS_FIRE) && this.getItem().is(DDBlocks.ENRICHED_ECHO_LOG.asItem())) {
            ((ItemEntity)(Object)this).level().addFreshEntity(new ItemEntity(((ItemEntity)(Object)this).level(), ((ItemEntity)(Object)this).getX(), ((ItemEntity)(Object)this).getY(), ((ItemEntity)(Object)this).getZ(), new ItemStack(DDItems.RESONARIUM, this.getItem().getCount())));
        }
    }
}
