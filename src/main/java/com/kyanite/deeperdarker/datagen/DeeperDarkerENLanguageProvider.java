package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.blocks.DeeperDarkerBlocks;
import com.kyanite.deeperdarker.items.DeeperDarkerItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryKey;

public class DeeperDarkerENLanguageProvider extends FabricLanguageProvider {
    protected DeeperDarkerENLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.deeperdarker", "Deeper and Darker");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_LOG, "Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.ECHO_WOOD, "Echo Wood");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_LOG, "Stripped Echo Log");
        translationBuilder.add(DeeperDarkerBlocks.STRIPPED_ECHO_WOOD, "Stripped Echo Wood");
    }
}
