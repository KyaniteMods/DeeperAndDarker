package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.compat.create.DDCreateCompat;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.equipment.armor.DivingBootsItem;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class CreateBootsLavaSwimmingMixin extends Entity {
    private CreateBootsLavaSwimmingMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(method = "travel(Lnet/minecraft/world/phys/Vec3;)V", slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;isInLava()Z")), at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V", shift = At.Shift.AFTER, ordinal = 0))
    private void deeperdarker$onLavaTravel(Vec3 travelVector, CallbackInfo ci) {
        if (!FabricLoader.getInstance().isModLoaded("create")) return;
        ItemStack bootsStack = DivingBootsItem.getWornItem(this);
        if (DDCreateCompat.Items.WARDEN_DIVING_BOOTS.isIn(bootsStack))
            setDeltaMovement(getDeltaMovement().multiply(DivingBootsItem.getMovementMultiplier((LivingEntity) (Object) this)));
    }
}
