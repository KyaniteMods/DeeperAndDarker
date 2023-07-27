package com.kyanite.deeperdarker.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;

import java.util.function.Consumer;

public class DDAdvancementProvider extends FabricAdvancementProvider {
    protected DDAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new DDAdvancements().accept(consumer);
    }
}
