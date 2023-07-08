package com.kyanite.deeperdarker.blocks;

import com.kyanite.deeperdarker.DeeperDarker;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class DeeperDarkerBlocks {
    public static final Block ECHO_LOG;
    public static final Block ECHO_WOOD;
    public static final Block STRIPPED_ECHO_LOG;
    public static final Block STRIPPED_ECHO_WOOD;

    static {
        ECHO_LOG = registerBlock("echo_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(state -> state.get(
                Properties.AXIS).isVertical() ? MapColor.LIGHT_GRAY : MapColor.PURPLE)));
        ECHO_WOOD = registerBlock("echo_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.PURPLE)));

        STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.LIGHT_GRAY)));
        STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.LIGHT_GRAY)));
    }

    private static Block registerBlock(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(DeeperDarker.MOD_ID, id), block);
    }

    public static void init() {
        DeeperDarker.LOGGER.debug("Registering Deeper and Darker blocks");
    }
}
