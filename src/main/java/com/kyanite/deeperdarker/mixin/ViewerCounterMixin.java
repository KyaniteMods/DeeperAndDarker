package com.kyanite.deeperdarker.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;
import java.util.function.Predicate;

@Mixin(ContainerOpenersCounter.class)
public class ViewerCounterMixin {
    @WrapOperation(method = "getOpenCount", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getEntities(Lnet/minecraft/world/level/entity/EntityTypeTest;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"))
    private List deeperdarker$containerIncludeAllPlayers(Level instance, EntityTypeTest<Entity, ?> entityTypeTest, AABB aABB, Predicate predicate, Operation<List> original) {
        return instance.players().stream().filter(predicate).toList();
    }
}
