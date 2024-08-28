package com.kyanite.deeperdarker.mixin;

import net.minecraft.data.models.ItemModelGenerators;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ItemModelGenerators.class)
public interface ItemModelGeneratorAccessor {
    @Accessor("GENERATED_TRIM_MODELS")
    static List<ItemModelGenerators.TrimModelData> generatedTrimModels() {
        throw new IllegalStateException("Replaced by mixin");
    }
}
