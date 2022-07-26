package com.nitro.deeperdarker.core.registry;

import com.mojang.datafixers.util.Pair;
import com.nitro.deeperdarker.core.DeeperAndDarker;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DeeperAndDarker.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DDItems {
    private static final ItemSubRegistryHelper HELPER = DeeperAndDarker.REGISTRY_HELPER.getItemSubHelper();
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MODID);

    // Boats
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> BONE_BOAT = HELPER.createBoatAndChestBoatItem("bone", DDBlocks.BONE_PLANKS);
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> SCULK_BONE_BOAT = HELPER.createBoatAndChestBoatItem("sculk_bone", DDBlocks.SCULK_BONE_PLANKS);

    // Warden Carapace and armor
    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_MATERIALS).rarity(Rarity.EPIC)));
    //public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet");

    // Sculk Reactor Core


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}