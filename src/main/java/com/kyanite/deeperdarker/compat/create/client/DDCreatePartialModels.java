package com.kyanite.deeperdarker.compat.create.client;

import com.kyanite.deeperdarker.DeeperDarker;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;

public class DDCreatePartialModels {
    public static final PartialModel COGS_MODEL = PartialModel.of(DeeperDarker.id("block/warden_backtank/block_cogs"));
    public static final PartialModel SHAFT_MODEL = PartialModel.of(DeeperDarker.id("block/warden_backtank/block_shaft_input"));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering partial models (Create)");
    }
}
