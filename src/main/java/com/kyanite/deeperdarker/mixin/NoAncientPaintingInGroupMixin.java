package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.world.item.CreativeModeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreativeModeTabs.class)
public class NoAncientPaintingInGroupMixin {
    @ModifyReturnValue(method = "method_51314", at = @At("RETURN"))
    private static boolean deeperdarker$noAncientPaintingInGroup(boolean original, @Local(ordinal = 0, argsOnly = true) Holder holder) {
        return original && !holder.is(DDTags.Paintings.ANCIENT);
    }
}
