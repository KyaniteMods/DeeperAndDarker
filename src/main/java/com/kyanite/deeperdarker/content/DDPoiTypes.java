package com.kyanite.deeperdarker.content;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;

public class DDPoiTypes {
    public static final PoiType NOISE_CANCELER = register("noise_canceler", 0, 32, DDBlocks.NOISE_CANCELER);

    public static PoiType register(String name, int ticketCount, int searchDistance, Block... blocks) {
        return PointOfInterestHelper.register(new ResourceLocation(DeeperDarker.MOD_ID, name), ticketCount, searchDistance, blocks);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering point of interest types");
    }
}
