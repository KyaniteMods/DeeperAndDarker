package com.kyanite.deeperdarker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;

import java.util.function.Consumer;

public class DeeperDarkerAdvancementProvider extends FabricAdvancementProvider {
    protected DeeperDarkerAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new DeeperDarkerAdvancements().accept(consumer);
    }
}
