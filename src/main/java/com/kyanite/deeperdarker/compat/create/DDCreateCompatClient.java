package com.kyanite.deeperdarker.compat.create;

import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.backend.instancing.InstancedRenderRegistry;
import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.compat.create.client.DDCreatePartialModels;
import com.kyanite.deeperdarker.compat.create.client.WardenBacktankRenderer;
import com.simibubi.create.content.equipment.armor.BacktankInstance;
import io.github.fabricators_of_create.porting_lib.client_events.event.client.RenderArmCallback;
import io.github.fabricators_of_create.porting_lib.event.client.InstanceRegistrationCallback;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class DDCreateCompatClient {
    public static void init() {
        DeeperDarker.LOGGER.debug("Initializing Create compatibility (client)");

        DDCreatePartialModels.init();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutoutMipped(),
                DDCreateCompat.Blocks.WARDEN_BACKTANK);

        RenderArmCallback.EVENT.register(WardenBacktankFirstPersonRenderer::onRenderPlayerHand);
        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            WardenBacktankFirstPersonRenderer.clientTick();
        });
    }
}
