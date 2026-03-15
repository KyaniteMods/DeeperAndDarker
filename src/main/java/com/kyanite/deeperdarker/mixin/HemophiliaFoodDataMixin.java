package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.content.DDEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FoodData.class)
public class HemophiliaFoodDataMixin {
    @WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/GameRules;getBoolean(Lnet/minecraft/world/level/GameRules$Key;)Z", ordinal = 0))
    private boolean deeperdarker$removeFoodNaturalRegeneration(GameRules instance, GameRules.Key<GameRules.BooleanValue> key, Operation<Boolean> original, @Local(argsOnly = true) Player player) {
        if (player.hasEffect(DDEffects.HEMOPHILIA)) return false;
        return original.call(instance, key);
    }
}
