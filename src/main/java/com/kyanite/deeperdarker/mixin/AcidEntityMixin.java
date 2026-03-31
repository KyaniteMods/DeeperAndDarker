package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDDamageTypes;
import com.kyanite.deeperdarker.content.fluids.EntityInAcid;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class AcidEntityMixin implements EntityInAcid {
    @Shadow
    protected boolean firstTick;

    @Shadow
    protected Object2DoubleMap<TagKey<Fluid>> fluidHeight;

    @Shadow
    @Final
    private EntityType<?> type;

    @Override
    public boolean deeperdarker$isInAcid() {
        return !firstTick && fluidHeight.getDouble(DDTags.Fluids.ACID) > 0.0;
    }

    @ModifyReturnValue(method = "updateFluidHeightAndDoFluidPushing", at = @At("RETURN"))
    private boolean deeperdarker$doAcidPushing(boolean original, @Local(argsOnly = true) TagKey<Fluid> tagKey) {
        if (!original && tagKey == FluidTags.LAVA) {
            return ((Entity) (Object) this).updateFluidHeightAndDoFluidPushing(DDTags.Fluids.ACID, 0.014);
        }
        return original;
    }

    @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;checkBelowWorld()V"))
    private void deeperdarker$dealAcidDamage(CallbackInfo ci) {
        if (deeperdarker$isInAcid()) {
            deeperdarker$acidHurt();
            ((Entity) (Object) this).fallDistance *= 0.5f;
        }
    }

    @Override
    public void deeperdarker$acidHurt() {
        if (deeperdarker$acidImmune()) {
            return;
        }
        for(ItemStack stack : ((Entity) (Object) this).getArmorSlots()) {
            if (!stack.is(DDTags.Items.ACID_IMMUNE_ARMOR)) {
                break;
            }
            return;
        }
        ((Entity) (Object) this).hurt(((Entity) (Object) this).damageSources().source(DDDamageTypes.ACID), 5.0f);
    }

    @Override
    public boolean deeperdarker$acidImmune() {
        return this.type.is(DDTags.EntityTypes.ACID_IMMUNE);
    }
}
