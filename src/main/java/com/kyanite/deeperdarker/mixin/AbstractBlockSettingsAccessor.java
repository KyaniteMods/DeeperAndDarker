package com.kyanite.deeperdarker.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Function;

@Mixin(BlockBehaviour.Properties.class)
public interface AbstractBlockSettingsAccessor {
    @Accessor
    void setMaterialColor(Function<BlockState, MaterialColor> materialColor);
}
