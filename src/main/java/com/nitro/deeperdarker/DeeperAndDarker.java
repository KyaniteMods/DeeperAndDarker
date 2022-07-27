package com.nitro.deeperdarker;

import com.nitro.deeperdarker.registry.blocks.DDBlocks;
import com.nitro.deeperdarker.registry.items.DDItems;
import com.teamabnormals.blueprint.core.util.registry.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(DeeperAndDarker.MODID)
public class DeeperAndDarker {
    public static final String MODID = "deeperdarker";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MODID, helper -> {
        helper.putSubHelper(ForgeRegistries.SOUND_EVENTS, new SoundSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ITEMS, new ItemSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.BLOCKS, new BlockSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ENTITY_TYPES, new EntitySubRegistryHelper(helper));
    });

    public DeeperAndDarker() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DDBlocks.BLOCKS.register(eventBus);
        DDItems.register(eventBus);
        REGISTRY_HELPER.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
