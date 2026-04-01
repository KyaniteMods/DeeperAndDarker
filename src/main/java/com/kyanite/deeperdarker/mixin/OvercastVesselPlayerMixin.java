package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.entities.overcastvessel.OvercastVesselPart;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public class OvercastVesselPlayerMixin {
    @Definition(id = "entity2", local = @Local(type = Entity.class, ordinal = 1))
    @Definition(id = "entity", local = @Local(type = Entity.class, ordinal = 0, argsOnly = true))
    @Expression("entity2 = @(entity)")
    @ModifyExpressionValue(method = "attack", at = @At("MIXINEXTRAS:EXPRESSION"))
    private Entity deeperdarker$playerAttackOvercastVesselPart(Entity original) {
        if (original instanceof OvercastVesselPart part) {
            return part.parent;
        }
        return original;
    }
}
