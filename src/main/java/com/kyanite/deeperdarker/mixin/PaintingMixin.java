package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
@Mixin(Painting.class)
public abstract class PaintingMixin extends HangingEntity {
    protected PaintingMixin(EntityType<? extends HangingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Shadow
    public abstract Holder<PaintingVariant> getVariant();

    @Inject(method = "dropItem", at = @At("HEAD"), cancellable = true)
    public void deeperdarker_dropItem(Entity entity, CallbackInfo cir) {
        if(getVariant().is(DDTags.Misc.ANCIENT_PAINTING) && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            this.playSound(SoundEvents.PAINTING_BREAK, 1, 1);
            if(entity instanceof Player player && player.getAbilities().instabuild) return;

            ItemEntity itemEntity = this.spawnAtLocation(Items.PAINTING);
            CompoundTag tag = itemEntity.getItem().getOrCreateTagElement("EntityTag");
            Painting.storeVariant(tag, getVariant());
            cir.cancel();
        }
    }

    @Inject(method = "getPickResult", at = @At("RETURN"))
    public void deeperdarker_getPickResult(CallbackInfoReturnable<ItemStack> cir) {
        if(getVariant().is(DDTags.Misc.ANCIENT_PAINTING)) {
            CompoundTag tag = cir.getReturnValue().getOrCreateTagElement("EntityTag");
            Painting.storeVariant(tag, getVariant());
        }
    }
}
