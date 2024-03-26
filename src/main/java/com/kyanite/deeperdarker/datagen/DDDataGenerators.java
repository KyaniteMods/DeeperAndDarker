package com.kyanite.deeperdarker.datagen;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.datagen.assets.DDENLanguageProvider;
import com.kyanite.deeperdarker.datagen.assets.DDItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DDDataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = event.getGenerator().getPackOutput();
            ExistingFileHelper helper = event.getExistingFileHelper();

            generator.addProvider(true, new DDENLanguageProvider(output));
            generator.addProvider(true, new DDItemModelProvider(output, helper));

        }
        catch (RuntimeException exception) {
            DeeperDarker.logger.error("Failed to generate data", exception);
        }
    }
}
