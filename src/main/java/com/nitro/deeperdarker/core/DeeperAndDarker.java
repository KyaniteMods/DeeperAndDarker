package com.nitro.deeperdarker.core;

import com.mojang.logging.LogUtils;
import com.nitro.deeperdarker.core.registry.other.DDRenderLayers;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(DeeperAndDarker.MOD_ID)
public class DeeperAndDarker
{
    public static final String MOD_ID = "deeperdarker";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> {
        helper.putSubHelper(ForgeRegistries.ITEMS, new ItemSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.BLOCKS, new BlockSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ENTITIES, new EntitySubRegistryHelper(helper));
    });

    public DeeperAndDarker() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(modEventBus);


        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @OnlyIn(Dist.CLIENT)
    void setupClient(final FMLClientSetupEvent event) {
        DDRenderLayers.setupRenderLayers();
    }
}