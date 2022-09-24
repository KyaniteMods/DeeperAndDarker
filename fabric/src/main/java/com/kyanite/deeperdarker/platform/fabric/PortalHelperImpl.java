package com.kyanite.deeperdarker.platform.fabric;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.fabric.DeeperAndDarkerFabric;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class PortalHelperImpl {
    public static <T extends Block> Supplier<T> getPortalBlock() {
        return () -> (T) DeeperAndDarkerFabric.PORTAL_BLOCK;
    }

    public static <T extends Item> Supplier<T> getHeartItem() {
        return () -> (T) DeeperAndDarkerFabric.HEART;
    }
}
