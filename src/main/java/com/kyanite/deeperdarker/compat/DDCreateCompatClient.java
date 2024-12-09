package com.kyanite.deeperdarker.compat;

import com.kyanite.deeperdarker.DeeperDarker;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class DDCreateCompatClient {
    public static void init() {
        DeeperDarker.LOGGER.debug("Initializing Create compatibility (client)");

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                DDCreateCompat.Blocks.WARDEN_BACKTANK);
    }
}
