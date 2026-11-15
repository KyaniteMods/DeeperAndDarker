package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.DeeperDarker;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockEntity.class)
public class BlockEntityTypeFixMixin {
    @WrapOperation(method = "isValidBlockState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BlockEntityType;isValid(Lnet/minecraft/world/level/block/state/BlockState;)Z"))
    private boolean deeperdarker$blockEntityTypeFix(BlockEntityType instance, BlockState blockState, Operation<Boolean> original) {
        BlockEntity blockEntity = ((BlockEntity) (Object) this);
        if (BuiltInRegistries.BLOCK.getKey(blockState.getBlock()).getNamespace().equals(DeeperDarker.MOD_ID)) return blockEntity.getType().isValid(blockState);
        return original.call(instance, blockState);
    }
}
