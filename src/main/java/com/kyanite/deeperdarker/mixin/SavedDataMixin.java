package com.kyanite.deeperdarker.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DimensionDataStorage.class)
public class SavedDataMixin {
    @WrapOperation(method = "readTagFromDisk", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/datafix/DataFixTypes;update(Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/nbt/CompoundTag;II)Lnet/minecraft/nbt/CompoundTag;"))
    private CompoundTag deeperdarker$dontFixData(DataFixTypes instance, DataFixer dataFixer, CompoundTag compoundTag, int i, int j, Operation<CompoundTag> original) {
        if (instance == null) return compoundTag;
        return original.call(instance, dataFixer, compoundTag, i, j);
    }
}
