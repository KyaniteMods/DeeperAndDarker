package com.nitro.deeperdarker.core.registry;

import com.mojang.datafixers.util.Pair;
import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDItems {
    public static final ItemSubRegistryHelper HELPER = DeeperAndDarker.REGISTRY_HELPER.getItemSubHelper();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);

    // Boats
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BONE_BOAT = HELPER.createBoatAndChestBoatItem("bone", DDBlocks.BONE_PLANKS);
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> SCULK_BONE_BOAT = HELPER.createBoatAndChestBoatItem("sculk_bone", DDBlocks.SCULK_BONE_PLANKS);

    // Sculk Reactor Core


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}