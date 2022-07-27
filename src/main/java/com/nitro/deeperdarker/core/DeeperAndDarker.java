package com.nitro.deeperdarker.core;

import com.nitro.deeperdarker.core.registry.items.DDItems;
import com.teamabnormals.blueprint.core.util.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(DeeperAndDarker.MODID)
public class DeeperAndDarker
{
    public static final String MODID = "deeperdarker";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MODID, helper -> {
        helper.putSubHelper(ForgeRegistries.SOUND_EVENTS, new SoundSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ITEMS, new ItemSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.BLOCKS, new BlockSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ENTITY_TYPES, new EntitySubRegistryHelper(helper));
    });

    public DeeperAndDarker() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDItems.register(modEventBus);

        REGISTRY_HELPER.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    private void clientSetup(final FMLClientSetupEvent event) {}
}