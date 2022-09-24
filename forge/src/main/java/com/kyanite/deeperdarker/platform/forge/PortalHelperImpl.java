package com.kyanite.deeperdarker.platform.forge;

import com.kyanite.deeperdarker.forge.DeeperAndDarkerForge;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class PortalHelperImpl {
    public static <T extends Block> Supplier<T> getPortalBlock() {
        return () -> (T) DeeperAndDarkerForge.PORTAL_BLOCK;
    }

    public static <T extends Item> Supplier<T> getHeartItem() {
        return () -> (T) DeeperAndDarkerForge.HEART;
    }
}
