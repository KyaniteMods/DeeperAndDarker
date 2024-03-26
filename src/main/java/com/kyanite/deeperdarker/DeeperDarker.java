package com.kyanite.deeperdarker;

import com.kyanite.deeperdarker.content.blocks.DDBlocks;
import com.kyanite.deeperdarker.content.items.DDItems;
import com.kyanite.deeperdarker.datagen.DDDataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("deeperdarker")
public class DeeperDarker {
    public static final String MODID = "deeperdarker";
    public static Logger logger = LoggerFactory.getLogger(DeeperDarker.class);

    public DeeperDarker(IEventBus eventBus) {
        DDItems.CREATIVE_MODE_TABS.register(eventBus);
        DDBlocks.BLOCKS.register(eventBus);
        DDItems.ITEMS.register(eventBus);

        eventBus.addListener(DDDataGenerators::gatherData);

        eventBus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}
