package com.kyanite.deeperdarker.platform.forge;

import com.kyanite.deeperdarker.forge.DeepHeartItem;
import com.kyanite.deeperdarker.forge.OthersidePortalBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class PortalHelperImpl {
    public static <T extends Block> Supplier<T> getPortalBlock() {
        return () -> (T) new OthersidePortalBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_PORTAL).lightLevel(state -> 5).noLootTable());
    }

    public static <T extends Item> Supplier<T> getHeartItem() {
        return () -> (T) new DeepHeartItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant());
    }
}
