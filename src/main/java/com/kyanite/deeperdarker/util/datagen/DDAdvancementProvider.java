package com.kyanite.deeperdarker.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;

import java.util.function.Consumer;

public class DDAdvancementProvider extends FabricAdvancementProvider {
    public DDAdvancementProvider(FabricDataGenerator output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new DDAdvancements().accept(consumer);
    }
}
