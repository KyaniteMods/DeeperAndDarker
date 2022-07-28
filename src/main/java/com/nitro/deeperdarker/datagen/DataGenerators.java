package com.nitro.deeperdarker.datagen;

import com.nitro.deeperdarker.DeeperAndDarker;
import com.nitro.deeperdarker.datagen.models.DDBlockStateProvider;
import com.nitro.deeperdarker.datagen.models.DDItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new DDBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DDItemModelProvider(generator, fileHelper));
    }
}
