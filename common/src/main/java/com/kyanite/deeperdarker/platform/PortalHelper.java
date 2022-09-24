package com.kyanite.deeperdarker.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class PortalHelper {
    @ExpectPlatform
    public static <T extends Block> Supplier<T> getPortalBlock() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> getHeartItem() {
        throw new AssertionError();
    }
}
