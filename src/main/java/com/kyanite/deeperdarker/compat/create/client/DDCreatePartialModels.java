package com.kyanite.deeperdarker.compat.create.client;

import com.jozufozu.flywheel.core.PartialModel;
import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.resources.ResourceLocation;

public class DDCreatePartialModels {
    public static final PartialModel COGS_MODEL = new PartialModel(new ResourceLocation(DeeperDarker.MOD_ID, "block/warden_backtank/block_cogs"));
    public static final PartialModel SHAFT_MODEL = new PartialModel(new ResourceLocation(DeeperDarker.MOD_ID, "block/warden_backtank/block_shaft_input"));

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering partial models (Create)");
    }
}
