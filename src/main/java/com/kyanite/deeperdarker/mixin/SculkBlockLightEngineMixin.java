package com.kyanite.deeperdarker.mixin;

import com.kyanite.deeperdarker.util.DDUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LightChunkGetter;
import net.minecraft.world.level.lighting.BlockLightEngine;
import net.minecraft.world.level.lighting.BlockLightSectionStorage;
import net.minecraft.world.level.lighting.LightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockLightEngine.class)
public abstract class SculkBlockLightEngineMixin extends LightEngine<BlockLightSectionStorage.BlockDataLayerStorageMap, BlockLightSectionStorage> {
    protected SculkBlockLightEngineMixin(LightChunkGetter lightChunkGetter, BlockLightSectionStorage layerLightSectionStorage) {
        super(lightChunkGetter, layerLightSectionStorage);
    }

    @WrapOperation(method = "getEmission", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getLightEmission()I"))
    private int deeperdarker$sculkBlockLightEngineEmission(BlockState instance, Operation<Integer> original) {
        return DDUtil.getLightEmission(original.call(instance), instance, chunkSource.getLevel());
    }
}
