package com.kyanite.deeperdarker.util;

import com.kyanite.deeperdarker.DeeperDarker;
import com.kyanite.deeperdarker.content.DDBlocks;
import com.kyanite.deeperdarker.content.DDItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DDCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeeperDarker.MOD_ID);
    public static final RegistryObject<CreativeModeTab> DEEPER_DARKER = CREATIVE_MODE_TABS.register("deeper_darker", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + DeeperDarker.MOD_ID)).icon(() -> new ItemStack(DDBlocks.ECHO_LOG.get())).build());

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == DEEPER_DARKER.get()) {
            event.accept(DDBlocks.ECHO_LOG);
            event.accept(DDBlocks.ECHO_WOOD);
            event.accept(DDBlocks.STRIPPED_ECHO_LOG);
            event.accept(DDBlocks.STRIPPED_ECHO_WOOD);
            event.accept(DDBlocks.ECHO_PLANKS);
            event.accept(DDBlocks.ECHO_STAIRS);
            event.accept(DDBlocks.ECHO_SLAB);
            event.accept(DDBlocks.ECHO_FENCE);
            event.accept(DDBlocks.ECHO_FENCE_GATE);
            event.accept(DDBlocks.ECHO_DOOR);
            event.accept(DDBlocks.ECHO_TRAPDOOR);
            event.accept(DDBlocks.ECHO_PRESSURE_PLATE);
            event.accept(DDBlocks.ECHO_BUTTON);

            event.accept(DDBlocks.SCULK_STONE);
            event.accept(DDBlocks.SCULK_STONE_STAIRS);
            event.accept(DDBlocks.SCULK_STONE_SLAB);
            event.accept(DDBlocks.SCULK_STONE_WALL);
            event.accept(DDBlocks.COBBLED_SCULK_STONE);
            event.accept(DDBlocks.COBBLED_SCULK_STONE_STAIRS);
            event.accept(DDBlocks.COBBLED_SCULK_STONE_SLAB);
            event.accept(DDBlocks.COBBLED_SCULK_STONE_WALL);
            event.accept(DDBlocks.POLISHED_SCULK_STONE);
            event.accept(DDBlocks.POLISHED_SCULK_STONE_STAIRS);
            event.accept(DDBlocks.POLISHED_SCULK_STONE_SLAB);
            event.accept(DDBlocks.POLISHED_SCULK_STONE_WALL);
            event.accept(DDBlocks.SCULK_STONE_BRICKS);
            event.accept(DDBlocks.SCULK_STONE_BRICK_STAIRS);
            event.accept(DDBlocks.SCULK_STONE_BRICK_SLAB);
            event.accept(DDBlocks.SCULK_STONE_BRICK_WALL);
            event.accept(DDBlocks.SCULK_STONE_TILES);
            event.accept(DDBlocks.SCULK_STONE_TILE_STAIRS);
            event.accept(DDBlocks.SCULK_STONE_TILE_SLAB);
            event.accept(DDBlocks.SCULK_STONE_TILE_WALL);
            event.accept(DDBlocks.SMOOTH_SCULK_STONE);
            event.accept(DDBlocks.SMOOTH_SCULK_STONE_STAIRS);
            event.accept(DDBlocks.SMOOTH_SCULK_STONE_SLAB);
            event.accept(DDBlocks.SMOOTH_SCULK_STONE_WALL);
            event.accept(DDBlocks.CUT_SCULK_STONE);
            event.accept(DDBlocks.CUT_SCULK_STONE_STAIRS);
            event.accept(DDBlocks.CUT_SCULK_STONE_SLAB);
            event.accept(DDBlocks.CUT_SCULK_STONE_WALL);
            event.accept(DDBlocks.CHISELED_SCULK_STONE);

            event.accept(DDBlocks.SCULK_GRIME);
            event.accept(DDBlocks.SCULK_GRIME_BRICKS);
            event.accept(DDBlocks.SCULK_GRIME_BRICK_STAIRS);
            event.accept(DDBlocks.SCULK_GRIME_BRICK_SLAB);
            event.accept(DDBlocks.SCULK_GRIME_BRICK_WALL);

            event.accept(DDBlocks.GLOOMSLATE);
            event.accept(DDBlocks.GLOOMSLATE_STAIRS);
            event.accept(DDBlocks.GLOOMSLATE_SLAB);
            event.accept(DDBlocks.GLOOMSLATE_WALL);
            event.accept(DDBlocks.COBBLED_GLOOMSLATE);
            event.accept(DDBlocks.COBBLED_GLOOMSLATE_STAIRS);
            event.accept(DDBlocks.COBBLED_GLOOMSLATE_SLAB);
            event.accept(DDBlocks.COBBLED_GLOOMSLATE_WALL);
            event.accept(DDBlocks.POLISHED_GLOOMSLATE);
            event.accept(DDBlocks.POLISHED_GLOOMSLATE_STAIRS);
            event.accept(DDBlocks.POLISHED_GLOOMSLATE_SLAB);
            event.accept(DDBlocks.POLISHED_GLOOMSLATE_WALL);
            event.accept(DDBlocks.GLOOMSLATE_BRICKS);
            event.accept(DDBlocks.GLOOMSLATE_BRICK_STAIRS);
            event.accept(DDBlocks.GLOOMSLATE_BRICK_SLAB);
            event.accept(DDBlocks.GLOOMSLATE_BRICK_WALL);
            event.accept(DDBlocks.GLOOMSLATE_TILES);
            event.accept(DDBlocks.GLOOMSLATE_TILE_STAIRS);
            event.accept(DDBlocks.GLOOMSLATE_TILE_SLAB);
            event.accept(DDBlocks.GLOOMSLATE_TILE_WALL);
            event.accept(DDBlocks.SMOOTH_GLOOMSLATE);
            event.accept(DDBlocks.SMOOTH_GLOOMSLATE_STAIRS);
            event.accept(DDBlocks.SMOOTH_GLOOMSLATE_SLAB);
            event.accept(DDBlocks.SMOOTH_GLOOMSLATE_WALL);
            event.accept(DDBlocks.CUT_GLOOMSLATE);
            event.accept(DDBlocks.CUT_GLOOMSLATE_STAIRS);
            event.accept(DDBlocks.CUT_GLOOMSLATE_SLAB);
            event.accept(DDBlocks.CUT_GLOOMSLATE_WALL);
            event.accept(DDBlocks.CHISELED_GLOOMSLATE);

            event.accept(DDBlocks.ECHO_SOIL);
            event.accept(DDBlocks.GLOOMY_SCULK);
            event.accept(DDBlocks.GLOOMY_GEYSER);
            event.accept(DDBlocks.CRYSTALLIZED_AMBER);
            event.accept(DDBlocks.SCULK_GLEAM);

            event.accept(DDBlocks.SCULK_STONE_COAL_ORE);
            event.accept(DDBlocks.SCULK_STONE_IRON_ORE);
            event.accept(DDBlocks.SCULK_STONE_COPPER_ORE);
            event.accept(DDBlocks.SCULK_STONE_GOLD_ORE);
            event.accept(DDBlocks.SCULK_STONE_REDSTONE_ORE);
            event.accept(DDBlocks.SCULK_STONE_EMERALD_ORE);
            event.accept(DDBlocks.SCULK_STONE_LAPIS_ORE);
            event.accept(DDBlocks.SCULK_STONE_DIAMOND_ORE);

            event.accept(DDBlocks.ECHO_LEAVES);
            event.accept(DDBlocks.GLOOMY_GRASS);
            event.accept(DDBlocks.GLOOMY_CACTUS);
            event.accept(DDBlocks.SCULK_TENDRILS);
            event.accept(DDBlocks.SCULK_VINES);

            event.accept(DDItems.ECHO_SIGN);
            event.accept(DDItems.ECHO_HANGING_SIGN);

            event.accept(DDBlocks.ANCIENT_VASE);
            event.accept(DDBlocks.INFESTED_SCULK);

            event.accept(DDItems.GRIME_BALL);
            event.accept(DDItems.GRIME_BRICK);

            event.accept(DDItems.SOUL_ELYTRA);
            event.accept(DDItems.ECHO_BOAT);
            event.accept(DDItems.ECHO_CHEST_BOAT);

            event.accept(DDItems.WARDEN_SHOVEL);
            event.accept(DDItems.WARDEN_PICKAXE);
            event.accept(DDItems.WARDEN_AXE);
            event.accept(DDItems.WARDEN_HOE);
            event.accept(DDItems.WARDEN_SWORD);
            event.accept(DDItems.WARDEN_HELMET);
            event.accept(DDItems.WARDEN_CHESTPLATE);
            event.accept(DDItems.WARDEN_LEGGINGS);
            event.accept(DDItems.WARDEN_BOOTS);

            event.accept(DDItems.SCULK_BONE);
            event.accept(DDItems.SOUL_DUST);
            event.accept(DDItems.SOUL_CRYSTAL);
            event.accept(DDItems.HEART_OF_THE_DEEP);
            event.accept(DDItems.WARDEN_CARAPACE);
            event.accept(DDItems.REINFORCED_ECHO_SHARD);

            event.accept(DDItems.SCULK_TRANSMITTER);
            event.accept(DDItems.WARDEN_UPGRADE_SMITHING_TEMPLATE);

            event.accept(DDItems.SCULK_LEECH_SPAWN_EGG);
            event.accept(DDItems.SCULK_SNAPPER_SPAWN_EGG);
            event.accept(DDItems.SHATTERED_SPAWN_EGG);
            event.accept(DDItems.SHRIEK_WORM_SPAWN_EGG);
        }
    }
}
