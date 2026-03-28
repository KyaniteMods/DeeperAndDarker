package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.fluids.EntityInAcid;
import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class AcidEntityMixin implements EntityInAcid {
    @Shadow
    protected boolean firstTick;

    @Shadow
    protected Object2DoubleMap<TagKey<Fluid>> fluidHeight;

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
}
