package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DeadMansChestSavedData;
import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class DeadMansChestItemEntityMixin {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;discard()V", ordinal = 1))
    private void deeperdarker$addItemToDeadMansChestLootTable(CallbackInfo ci) {
        ItemEntity entity = (ItemEntity) (Object) this;
        if (entity.level() instanceof ServerLevel serverLevel && !entity.getItem().isEmpty() && !entity.getItem().is(DDTags.Items.CLUTTER_ITEMS)) {
            DeadMansChestSavedData data = serverLevel.getServer().overworld().getDataStorage().computeIfAbsent(DeadMansChestSavedData::load, DeadMansChestSavedData::new, DeadMansChestSavedData.ID);
            data.add(entity.getItem());
            data.setDirty();
        }
    }
}
