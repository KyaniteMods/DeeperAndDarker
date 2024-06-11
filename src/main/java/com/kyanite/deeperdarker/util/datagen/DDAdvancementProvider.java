package com.kyanite.deeperdarker.util.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;

import java.util.function.Consumer;

public class DDAdvancementProvider extends FabricAdvancementProvider {
    public DDAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementHolder> consumer) {
        new DDAdvancements().accept(consumer);
    }
}
