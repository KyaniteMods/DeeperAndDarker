package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.items.SoulItem;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class SoulItemEntityMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void deeperdarker$addSoulItemParticles(CallbackInfo ci) {
        ItemEntity entity = (ItemEntity) (Object) this;
        if (entity.getItem().getItem() instanceof SoulItem soulItem && entity.level().isClientSide() && entity.level().getRandom().nextFloat() < 0.05f) {
            entity.level().addParticle(soulItem.getParticle(), entity.getRandomX(0.5), entity.getRandomY() + 0.5, entity.getRandomZ(0.5), 0.0, 0.0, 0.0);
        }
    }
}
